package cloud.spec.api.rest

import akka.stream.Materializer
import cloud.spec.api.core._
import cloud.spec.api.rest.api.Api
import cloud.spec.api.rest.core._

package object web {

  trait Web {
    this: Api with Core with RestActorRefs =>

    implicit val materializer: Materializer

  }

}
