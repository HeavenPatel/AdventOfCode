package year2021.day2

object Part1 extends App {
  scala.util.Using(scala.io.Source.fromFile("src/year2021/day2/input.txt")) {
    reader => {
      val commands = reader
        .getLines()
        .flatMap(_.split("\\W+"))
        .toList
        .sliding(2, 2)
        .toList
        .collect { case List(a, b) => (a, b) }
        .groupBy(_._1)
        .map{case (k, v) => (k, v.map(_._2.toInt).sum)}
      val forward : Int = commands.getOrElse("forward", 0)
      val depth : Int = commands.getOrElse("down", 0) - commands.getOrElse("up", 0)
      println(forward * depth)
    }
  }
}