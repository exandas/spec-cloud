package cloud.spec.api.core

import akka.actor._
import cloud.spec.api.core.actors._
import cloud.spec.api.persistence.mongo.MongoDataMappers.MongoTestDataMapper

trait CoreActors extends CoreActorRefs {
  this: Core =>

  override lazy val test: ActorRef = system.actorOf(Props(classOf[TestActor], new MongoTestDataMapper("test")), "TestActor")
  override lazy val events: ActorRef = system.actorOf(Props(classOf[EventPublisher]))

}