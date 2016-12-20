package cloud.spec.api.rest
package api
package services

import akka.actor.ActorRef
import akka.http.scaladsl.server.Directives._
import akka.pattern.ask
import akka.util.Timeout
import cloud.spec.api.core._
import cloud.spec.api.core.actors._
import cloud.spec.api.domain.models._
import cloud.spec.api.rest.api.models._
import cloud.spec.api.rest.core.NoSuchItemAppError
import cloud.spec.api.rest.util.serialization.JsonSupport

import scala.concurrent.ExecutionContext
import scala.concurrent.duration._
import scala.language.postfixOps

class TestService(brand: ActorRef)(implicit executionContext: ExecutionContext)
  extends JsonSupport {

  import TestActor._
  import api.serialization.Imports._
  import models.mapping.ViewModelMappers._

  implicit val timeout = Timeout(3 seconds)

  val route =
    get {
      pathPrefix("test") {
        path("top" / IntNumber / IntNumber) { (start, limit) =>
          onSuccess {
            (brand ? GetTop(start, limit)).mapTo[Iterable[Test]]
          } { result =>
            complete(result.map(mapper[Test, TestView]))
          }
        } ~
        path(Base64UUID) { id =>
          onSuccess {
            brand ? Get(id)
          } {
            case f: Test =>
              complete(mapper[Test, TestView].apply(f))
            case NoSuchItem =>
              reject(AppRejection(NoSuchItemAppError))
          }
        }
      }
    }
}
