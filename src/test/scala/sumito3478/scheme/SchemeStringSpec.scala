package sumito3478.scheme

import org.specs2.mutable.Specification

class SchemeStringSpec extends Specification{
  "SchemeString#toString" should {
    trait context extends Scope{
      val orig : String = "Unicode Character 'PALM TREE' (U+1F334) : '\ud83c\udf34' (UTF-16: 0xd83c 0xdf34)"
      val s : SchemeString = orig
    }

    "return String equals to the original" in new context {
      s.toString() mustEqual orig
    }
  }
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

