package year2021.day2

object Part2 extends App {
  scala.util.Using(scala.io.Source.fromFile("src/year2021/day2/input.txt")) {
    reader => {
      var fwd = 0
      var depth = 0
      var aim = 0
      val commands: Unit = reader
        .getLines()
        .flatMap(_.split("\\n"))
        .toList
        .foreach(cmd => {
          val dir = cmd.split("\\s")(0)
          val step = cmd.split("\\s")(1).toInt
          dir match {
            case "down" => aim = aim + step
            case "up" => aim = aim - step
            case "forward" => {
              fwd = fwd + step
              depth = depth + (aim * step)
            }
          }
        })
      println(fwd * depth)
    }
  }
}