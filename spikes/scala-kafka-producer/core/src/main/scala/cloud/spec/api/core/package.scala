package cloud.spec.api

import akka.actor.{ActorRef, ActorSystem}

package object core {

  case object NoSuchItem

  trait Core {

    implicit val system: ActorSystem

  }

  trait CoreActorRefs {
    this: Core =>

    val test: ActorRef
    val events: ActorRef

  }

}
