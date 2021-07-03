package prelude

// if/else
object ControlStructures {

  def ifElse(num: Int): String = {
    val count = 0
    var result = ""
    if (num <= 0 || num == 1) {
      result = "This num is not primes"
    } else {
      for (i <- 2 to num) {
        if (num % i == 0) {
          count + 1
        }
      }
      if (count == 0) {
        result = "This num is primes"
      }
      else {
        result = "This num is not primes"
      }
    }
    result
  }

  def forLoop(nums: Map[String, Double]): String = {
    var max_ratings = 0.0
    var results = ""
    nums.foreach {
      case (movie, rating) =>
        if(max_ratings <= rating){
          max_ratings = rating
          results = s"key: $movie, value: $rating"
        }
    }
    results
  }
}