package sumito3478.scheme

import scala.collection.mutable.ArrayBuffer
import RichString._

class SchemeString(
    private val buffer : ArrayBuffer[Int] = new ArrayBuffer[Int]) {
  def this(s : RichString) = this(s.toSchemeCharArrayBuffer)

  override def equals(that : Any) : Boolean = that match {
    case s : SchemeString => buffer == s.buffer
    case _ => false
  }

  def toCharArray = buffer.toArray

  override def toString() : String = {
    val charArray = toCharArray
    new String(charArray, 0, charArray.length)
  }
}

object SchemeString{
  implicit def convertFromString(s : String) : SchemeString = {
    new SchemeString(s)
  }

  implicit def convertToString(s : SchemeString) = s.toString()
  
  def apply(chars : Int*) = 
    new SchemeString(new ArrayBuffer[Int] ++ chars)
  
  def apply(string : SchemeString) =
    new SchemeString(new ArrayBuffer[Int] ++ string.buffer)
}


