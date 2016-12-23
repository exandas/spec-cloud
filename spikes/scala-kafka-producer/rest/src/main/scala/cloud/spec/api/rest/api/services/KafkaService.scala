package cloud.spec.api.rest.api.services

import java.util.UUID

import akka.actor.ActorRef
import akka.http.scaladsl.model.ContentTypes
import akka.http.scaladsl.model.HttpEntity
import akka.http.scaladsl.server.Directives._
import akka.pattern.ask
import akka.util.Timeout
import cloud.spec.api.core.actors._
import cloud.spec.api.rest.util.serialization.JsonSupport

import scala.concurrent.ExecutionContext
import scala.concurrent.duration._
import scala.language.postfixOps

class KafkaService(brand: ActorRef)(implicit executionContext: ExecutionContext)
  extends JsonSupport {

  import EventPublisher._
  import cloud.spec.api.util.Imports._

  implicit val timeout = Timeout(3 seconds)

  val route =
    get {
      pathPrefix("executions") {
        path("create") {
          val executionId: UUID = UUID.randomUUID()
          brand ? Execution(executionId)
          complete(executionId.toString)
        }
      }
    }
}
