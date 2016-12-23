package cloud.spec.api.core.actors

import java.util.UUID

import akka.actor.Actor
import cakesolutions.kafka.KafkaProducerRecord
import cloud.spec.api.core.actors.EventPublisher.Execution
import com.typesafe.config.ConfigFactory
import org.apache.kafka.common.serialization.StringSerializer

/**
  * Created by kostas on 21/12/2016.
  */
object EventPublisher {
  case class Execution(id: UUID)
}

class EventPublisher extends Actor{



  import cakesolutions.kafka.KafkaProducer
  import cakesolutions.kafka.KafkaProducer.Conf



  val producer = KafkaProducer(
    Conf(new StringSerializer(), new StringSerializer(), acks = "all").withConf(ConfigFactory.parseString(
      s"""
         | bootstrap.servers = "localhost:32768"
  """.stripMargin))
  )

  override def receive: Receive = {
    case Execution(id) => {
      println(s"Creating execution with id $id")
      val record = KafkaProducerRecord("executions", Some(id.toString), "running")
      producer.send(record)
    }
  }
}
