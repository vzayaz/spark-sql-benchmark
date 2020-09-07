package example

import example.Utils._
import org.apache.spark.sql.SparkSession

object CountWithDatasetsSlowClassic {

  def main(args: Array[String]) {
    val spark =
      SparkSession.builder()
        .appName("Dataset-Slow-Classic")
        .getOrCreate()


    benchmark("Count with datasets slow") {
      val res = spark.range(1000L * 1000 * 1000)
          .rdd
          .filter(_ %2 == 0)
          .count()
      println(s"The count is $res")
    }
  }
}