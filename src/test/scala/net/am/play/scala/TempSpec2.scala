package net.am.play.scala

import org.specs2.mutable.Specification

import scala.concurrent.{Await, Future}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._


object FutureCombinators {

  def sumOfThreeNumbersSequentialForComprehension(): Future[Int] = {

    def oneFuture: Future[Int] = Future {
      Thread.sleep(1000)
      1
    }

    val twoFuture: Future[Int] = Future {
      Thread.sleep(2000)
      2
    }

    def threeFuture: Future[Int] = Future {
      Thread.sleep(3000)
      3
    }

    for {
      localOne <- oneFuture
      localTwo <- twoFuture
      localThree <- threeFuture
    } yield localOne + localTwo + localThree
  }
}

trait ConcurrentUtils {
  def timed[T](block: => T): T = {
    val start = System.currentTimeMillis()
    val result = block
    val duration = System.currentTimeMillis() - start
    println(s"Time taken : $duration")
    result
  }
}

class TempSpec2 extends Specification with ConcurrentUtils {

//  "Replace regex tests".txt

  "future test" >> {

    val result = timed(Await.result(FutureCombinators.sumOfThreeNumbersSequentialForComprehension(), 7 seconds))
    result === 6

    true
  }



}

