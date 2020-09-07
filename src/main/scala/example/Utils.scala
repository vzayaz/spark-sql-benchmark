package example

object Utils {

  def mean(seq: Seq[Double]): Double = seq.sum / seq.length
  def std(seq: Seq[Double]): Double = {
    val m = mean(seq)
    seq.map(x => math.pow(x - m, 2)).sum / (seq.length-1)
  }
  val z = 1.96

  def benchmark(name: String, n: Int=20)(f: => Unit) {
    val list = scala.collection.mutable.ListBuffer.empty[Double]
    var i = 0
    while (i < n){
      val startTime = System.nanoTime
      f
      val endTime = System.nanoTime
      val time = (endTime - startTime).toDouble / 1000000000
      println(s"Iteration $i time taken: $time seconds")
      list.append(time)
      i += 1
    }

    val hot = list.slice(10, list.length)
    println(s"All times $list")
    println(s"Benchmark $name time is ${mean(hot)} +- ${z*std(hot)}")
  }

}
