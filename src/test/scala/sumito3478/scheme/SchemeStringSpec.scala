package sumito3478.scheme

import org.specs2.mutable.Specification

class SchemeStringSpec extends Specification{
  "SchemeString#toCharArray" should {
    trait context extends Scope {
      val buffer = Array[SchemeChar](0x1f334, 0x1f333)
      val s : SchemeString = "\ud83c\udf34\ud83c\udf33" // same as above buffer
    }

    "return Array of SchemeChar contained in the SchemeString" in new context{
      s.toCharArray mustEqual buffer
    }
  }
}

