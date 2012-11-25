package sumito3478.scheme

import scala.collection.mutable.ArrayBuffer

class SchemeString(private val buffer : ArrayBuffer[SchemeChar] = new ArrayBuffer[SchemeChar]) {
  def toCharArray = buffer.toArray

  override def toString() : String = {
    val charArray = toCharArray
    new String(charArray.map(_.value), 0, charArray.length)
  }
}

object SchemeString{
  implicit def fromString(s : String) : SchemeString = {
    throw new NotImplementedError()
  }

  implicit def toString(s : SchemeString) = {
    throw new NotImplementedError()
  }
}


