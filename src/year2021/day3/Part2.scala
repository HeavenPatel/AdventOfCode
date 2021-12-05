package year2021.day3

import scala.annotation.tailrec

object Part2 extends App {
  def mostCommon(bits: List[Char]): Char = if bits.count(_ == '0') > bits.length / 2 then '0' else '1'

  def leastCommon(bits: List[Char]): Char = if mostCommon(bits) == '0' then '1' else '0'

  def recursiveCommonBit(input: List[String])(fn: (List[Char]) => Char): String = {
    @tailrec
    def recFunc(input: List[String], idx: Int): String = input match
      case h :: Nil => h
      case _ =>
        val c = input.transpose.map(fn)(idx)
        recFunc(input.filter(x => x(idx) == c), idx + 1)

    recFunc(input, 0)
  }

  scala.util.Using(scala.io.Source.fromFile("src/year2021/day3/input.txt")) {
    reader => {
      val input = reader.getLines().flatMap(_.split("\\W+")).toList
      val o2 = recursiveCommonBit(input)(mostCommon)
      val co2 = recursiveCommonBit(input)(leastCommon)
      println(Integer.parseInt(o2, 2) * Integer.parseInt(co2, 2))
    }
  }
}
