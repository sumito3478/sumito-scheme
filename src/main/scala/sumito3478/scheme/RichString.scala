package sumito3478.scheme

class RichString(val value : String) {

  override def toString() = value
}

object RichString {
  implicit def convertFromString(s : String) = new RichString(s)

  implicit def convertToString(s : RichString) = s.value
}
