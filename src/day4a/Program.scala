package day4a

import java.security.MessageDigest
import javax.xml.bind.annotation.adapters.HexBinaryAdapter

object Program {
  def main(args: Array[String]) {
    def md5(input: String) = {
      val digester = MessageDigest.getInstance("MD5")
      val adapter = new HexBinaryAdapter

      adapter.marshal(digester.digest(input.getBytes))
    }
    def exercise(input: String) : String = {
      var count = 0
      var result : String = null
      var stillLooking = true

      while(stillLooking) {
        val newGuess = input + count
        if(md5(newGuess).startsWith("00000")) {
          result = newGuess
          stillLooking = false
        }
        count += 1
      }
      result
    }
    println(md5("abcdef609043"))
    println(md5("pqrstuv1048970"))
    println(exercise("abcdef"))
    println(exercise("pqrstuv"))
    println(exercise("ckczppom"))
  }
}
