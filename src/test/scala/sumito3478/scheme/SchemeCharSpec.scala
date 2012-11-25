package sumito3478.scheme

import org.specs2.mutable.Specification

class SchemeCharSpec  extends Specification{

  "SchemeChar" should {
    "implicitly converted from Int" in {
      val schemeChar : SchemeChar = 0x20
      schemeChar.value mustEqual 0x20
    }
    "implicitly converted to Int" in {
      val schemeChar : SchemeChar = 0x20
      val int : Int = schemeChar
      int mustEqual 0x20
    }
  }
}
