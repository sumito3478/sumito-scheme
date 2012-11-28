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
  
  // string-set!
  def update(idx: Int, elem: Int) = buffer(idx) = elem
  
  def =? (string2 : SchemeString) = buffer == string2.buffer
  
  def `ci=?` (string2 : SchemeString) = 
    toLowerCase.buffer == string2.toLowerCase.buffer
  
  def `<?` (string2 : SchemeString) =
    throw new NotImplementedError
  
  def `>?` (string2 : SchemeString) = throw new NotImplementedError
  
  def substring(start : Int, end : Int) =
    SchemeString(buffer.view(start, end))
}

object SchemeString{
  implicit def convertFromString(s : String) : SchemeString = apply(s)

  implicit def convertToString(s : SchemeString) = s.toString()
  
  
  
  def apply(xs: Int*) : SchemeString = apply(xs)
}


