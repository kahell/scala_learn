package prelude

import org.scalatest.{FunSuite, Matchers}

class ControlStructuresTest extends FunSuite with Matchers {
  test("If/else test for read prime") {
    val num = 4
    val expected = "This num is primes"
    val actual = ControlStructures.ifElse(num)
    actual shouldEqual expected
  }

  test("Map test for read from value"){
    val ratings = Map(
      "Nanatsu No Taizai"  -> 5.0,
      "Attack on Titan"  -> 4.0,
      "One Piece" -> 2.0
    )

    val actual = ControlStructures.forLoop(ratings)
    val expected = "key: Nanatsu No Taizai, value: 5.0"
    actual shouldEqual expected
  }
}