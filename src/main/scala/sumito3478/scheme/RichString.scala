package sumito3478.scheme

import collection.mutable.ArrayBuffer

class RichString(val value: String) {
  def toSchemeCharArrayBuffer: ArrayBuffer[Int] = {
    val count = value.codePointCount(0, value.length)
    val buffer = new ArrayBuffer[Int](count)
    var cpIndex = 0
    var charIndex = 0
    while (cpIndex < count) {
      val cp = value.codePointAt(charIndex)
      buffer += cp
      charIndex += Character.charCount(cp)
      cpIndex += 1
    }
    buffer
  }

  override def toString() = value
}

object RichString {
  implicit def convertFromString(s: String) = new RichString(s)

  implicit def convertToString(s: RichString) = s.value
}
