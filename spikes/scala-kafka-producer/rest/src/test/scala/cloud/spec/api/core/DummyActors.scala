package cloud.spec.api.core

import akka.actor._
import cloud.spec.api.core.actors._
import cloud.spec.api.persistence.dummy._
import cloud.spec.api.rest.core.RestActorRefs

trait DummyActors extends CoreActorRefs with RestActorRefs {
  this: Core =>

  override lazy val test: ActorRef = system.actorOf(Props(classOf[TestActor], new DummyTestMapper), "DummyTestActor")
//  override lazy val eventRemote: ActorSelection = system.actorSelection("akka.tcp://bengga-analytics-service@127.0.0.1:2552/user/EventActor")

}
