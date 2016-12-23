package cloud.spec.api.rest.web

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.stream.{ActorMaterializer, Materializer}
import cloud.spec.api.core.Core
import cloud.spec.api.rest.api.{Api, Implicits}
import cloud.spec.api.rest.core.RestActors
import cloud.spec.api.rest.util.serialization.JsonSupport


trait BootedWeb extends Web with Api with RestActors with Core with JsonSupport {

  import Implicits._


  override implicit lazy val executor = system.dispatcher

  override implicit lazy val system = ActorSystem("scala-kafka-producer")

  override implicit lazy val materializer: Materializer = ActorMaterializer()

  Http().bindAndHandle(routes, "localhost", 8080)

  sys.addShutdownHook(system.terminate())

}