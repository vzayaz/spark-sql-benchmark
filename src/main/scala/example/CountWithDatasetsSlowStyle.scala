package example

import example.Utils._
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.{col, count}

object CountWithDatasetsSlowStyle {

  def main(args: Array[String]) {
    val spark =
      SparkSession.builder()
        .appName("Dataset-Slow-Classic")
        .getOrCreate()


    benchmark("Count with datasets slow with style") {
      val res = spark
        .range(1000L * 1000 * 1000)
        .filter(x => x % 2 == 0)
        .select(count(col("id")))
        .first()
        .getAs[Long](0)
      println(s"The count is $res")
    }
  }
}