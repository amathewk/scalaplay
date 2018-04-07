package net.am.play.scala

import org.scalatest._

import scala.collection.mutable.Stack

class CalculatorSpec extends FlatSpec with Matchers {

  "calculator" should "add integers" in {
    Calculator.add(1, 2) should be (3)
  }

  it should "add zero" in {
    Calculator.add(1, 0) should be (1)
  }

}