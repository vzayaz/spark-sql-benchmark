package example

import org.apache.spark.sql.SparkSession
import example.Utils._

object CountWithRDD {

  def main(args: Array[String]) {
    val spark =
      SparkSession.builder()
        .appName("RDD-Basic")
        .getOrCreate()

    benchmark("Count with RDD") {
          val res = spark.sparkContext
            .range(0L, 1000L * 1000 * 1000)
            .filter(_ % 2 == 0)
            .count()
          println(s"The count is $res")
        }
  }
}