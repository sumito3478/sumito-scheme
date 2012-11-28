package sumito3478.scheme

import scala.collection.mutable.ArrayBuffer
import RichString._
import scala.collection.immutable.WrappedString

class SchemeString {
  val buffer = new ArrayBuffer[Int]

  override def equals(that: Any): Boolean = that match {
    case s: SchemeString => buffer == s.buffer
    case _ => false
  }

  def toCharArray = buffer.toArray

  override def toString(): String = {
    val charArray = toCharArray
    new String(charArray, 0, charArray.length)
  }

  def ++=(xs: TraversableOnce[Int]): SchemeString = {
    buffer ++= xs
    this
  }

  def toLowerCase: SchemeString = {
    new SchemeString ++= buffer.map {
      c =>
        Character.toLowerCase(c)
    }
  }

  def toUpperCase: SchemeString = {
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

  def =?(string2: SchemeString) = buffer == string2.buffer

  def `ci=?`(string2: SchemeString) =
    toLowerCase.buffer == string2.toLowerCase.buffer

  def `<?`(string2: SchemeString) =
    throw new NotImplementedError

  def `>?`(string2: SchemeString) = throw new NotImplementedError

  def substring(start: Int, end: Int) =
    SchemeString(buffer.view(start, end))
}

object SchemeString {
  implicit def convertFromString(s: String): SchemeString = apply(s)

  implicit def convertToString(s: SchemeString) = s.toString()

  def apply(xs: RichString): SchemeString = apply(xs.toSchemeCharArrayBuffer)

  def apply(xs: TraversableOnce[Int]): SchemeString =
    new SchemeString ++= xs

  def fromChar(xs: TraversableOnce[Char]): SchemeString = {
    val source = xs.toIterator.buffered
    val buffer = new ArrayBuffer[Int]
    while (source.hasNext) {
      val char = source.next
      buffer += (
        if (source.hasNext && Character.isSurrogatePair(char, source.head))
          Character.toCodePoint(char, source.next)
        else
          char)
    }
    new SchemeString ++= buffer
  }

  def apply(xs: String): SchemeString = fromChar(new WrappedString(xs))

  def apply(xs: Int*): SchemeString = apply(xs)

  def make(k: Int, char: Int = 0): SchemeString =
    apply(Array.fill(k) { char })

  def string(chars: Int*): SchemeString =
    apply(chars)
}


