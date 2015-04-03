package kamon.test

import akka.actor.{ ActorSystem, Actor, Props }

object SimpleApp extends App {
  val system = ActorSystem("test-app")
  val testActor = system.actorOf(Props[TestActor], "test-actor")

  for(_ <- 1 to 10) {
    testActor ! "hello"
  }

}

class TestActor extends Actor {
  def receive = {
    case x => println(x)
  }
}
