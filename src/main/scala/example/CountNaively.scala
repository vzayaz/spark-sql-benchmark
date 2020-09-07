package example

import example.Utils._

object CountNaively {

  def main(args: Array[String]) {
    benchmark("Count naively") {
      var res: Long = 0L
      var i: Long  = 0L
      while (i < 1000L * 1000 * 1000) {
        if (i % 2 == 0)
          res += 1
        i += 1L
      }
      println(s"The result is $res")
    }
  }
}
