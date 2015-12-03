package day2a

import scala.io.Source

object Program {
  def materialNeeded(size: (Int,Int,Int)) = {
    def surfaceArea(length: Int, width: Int, height: Int) = {
      (2 * length * width) + (2 * width * height) + (2 * height * length)
    }
    def areaSmallestSize(length: Int, width: Int, height: Int) = {
      val smallest = List(length,width,height).sorted.take(2)
      smallest(0) * smallest(1)
    }
    val r1 = surfaceArea(size._1,size._2,size._3)
    val r2 = areaSmallestSize(size._1,size._2,size._3)
    r1 + r2
  }
  def exercise() = {
    def tokeniseLine(line : String) = {
      val regex = "([0-9]+)x([0-9]+)x([0-9]+)".r
      val regex(length,width,height) = line
      (length.toInt,width.toInt,height.toInt)
    }
    val source = Source.fromFile("input/quiz2.txt")
    source.getLines()
          .map(tokeniseLine)
          .map(materialNeeded)
          .sum
  }
  def main(args: Array[String]) {
    println(exercise())
  }
}
