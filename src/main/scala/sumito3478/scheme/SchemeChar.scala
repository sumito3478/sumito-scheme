package sumito3478.scheme

class SchemeChar(val value : Int) extends AnyVal{

}

object SchemeChar {
  implicit def schemeCharToInt(c : SchemeChar) : Int = c.value
  implicit def intToSchemeChar(c : Int) : SchemeChar = new SchemeChar(c)
}
