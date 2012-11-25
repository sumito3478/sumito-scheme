package sumito3478.scheme

import scala.collection.mutable.ArrayBuffer
import RichString._

class SchemeString(private val buffer : ArrayBuffer[SchemeChar] = new ArrayBuffer[SchemeChar]) {
  def this(s : RichString) = this(s.toSchemeCharArrayBuffer)

  override def equals(that : Any) : Boolean = that match {
    case s : SchemeString => buffer == s.buffer
    case _ => false
  }

  def toCharArray = buffer.toArray

  override def toString() : String = {
    val charArray = toCharArray
    new String(charArray.map(_.value), 0, charArray.length)
  }
}

object SchemeString{
  implicit def fromString(s : String) : SchemeString = {
    new SchemeString(s)
  }

  implicit def toString(s : SchemeString) = s.toString()
}


