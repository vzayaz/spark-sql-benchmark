package example

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._
import example.Utils._

object CountWithDatasets {

  def main(args: Array[String]) {
    val spark =
      SparkSession.builder()
        .appName("Dataset-Basic")
        .getOrCreate()


    benchmark("Count with datasets") {
      val res = spark.range(1000L * 1000 * 1000)
        .filter(col("id") % 2 === 0)
        .select(count(col("id")))
        .first().getAs[Long](0)
      println(s"The count is $res")
    }
  }
}
