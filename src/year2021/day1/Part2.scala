package year2021.day1

object Part2 extends App {
  scala.util.Using(scala.io.Source.fromFile("src/year2021/day1/input.txt")) { reader =>
    val depthIncCount = reader
      .getLines()
      .flatMap(_.split("\\W+"))
      .map(_.toInt)
      .toList
      .sliding(3)
      .toList
      .collect { case List(a, b, c) => a + b + c }
      .sliding(2)
      .toList
      .collect { case List(a, b) => (a, b) }
      .count(pair => pair._2 > pair._1)
    println(depthIncCount)
  }
}