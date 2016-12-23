package cloud.spec.api.rest

import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Rejection
import cloud.spec.api.core._
import cloud.spec.api.rest.api.services._
import cloud.spec.api.rest.core._
import cloud.spec.api.rest.util.serialization.JsonSupport

import scala.concurrent.ExecutionContextExecutor

package object api {

  trait Api extends JsonSupport {

    this: Core with RestActorRefs =>

    implicit val executor: ExecutionContextExecutor

    import Directives._

    val routes = new KafkaService(events).route
//    val routes = logHeaders { ip =>
//      encodeResponse {
//        new TestService(test).route
//      }
//    }
//      logHeaders { ip =>
//        encodeResponse {
//          val actorRef = kafka
//          println(actorRef.toString())
//          new KafkaService(actorRef).route
//        }
//      }
  }

  case class AppRejection(error: AppError) extends Rejection

}
