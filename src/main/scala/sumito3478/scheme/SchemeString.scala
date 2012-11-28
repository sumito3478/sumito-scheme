package sumito3478.scheme

import scala.collection.mutable.ArrayBuffer
import RichString._

class SchemeString {
  val buffer = new ArrayBuffer[Int]

  override def equals(that : Any) : Boolean = that match {
    case s : SchemeString => buffer == s.buffer
    case _ => false
  }

  def toCharArray = buffer.toArray

  override def toString() : String = {
    val charArray = toCharArray
    new String(charArray, 0, charArray.length)
  }
  
  def ++=(xs: TraversableOnce[Int]) : SchemeString = {
    buffer ++= xs
    this
  }
  
  def toLowerCase : SchemeString = {
    new SchemeString ++= buffer.map {
      c =>
        Character.toLowerCase(c)
    }
  }
  
  def toUpperCase : SchemeString = {
    new SchemeString ++= buffer.map {
      c =>
        Character.toUpperCase(c)
    }
  }
  
  // string-length
  def length = buffer.length
  
  // string-ref
  def apply(idx: Int) = buffer(idx)
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


