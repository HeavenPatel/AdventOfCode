package year2021.day3

object Part1 extends App {
  def inverse(inp: String): String = {
    inp.map(c => if (c == '0') '1' else '0')
  }

  scala.util.Using(scala.io.Source.fromFile("src/year2021/day3/input.txt")) {
    reader => {
      val gamma = reader
        .getLines()
        .flatMap(_.split("\\W+"))
        .toList
        .transpose
        .map {
          _.groupBy(identity)
            .view.mapValues(_.length)
            .toMap
            .maxBy(_._2)
            ._1
        }
        .mkString("")
      val epsilon = inverse(gamma)
      println(Integer.parseInt(gamma, 2) * Integer.parseInt(epsilon, 2))
    }
  }
}
