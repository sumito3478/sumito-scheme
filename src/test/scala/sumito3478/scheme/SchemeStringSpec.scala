package sumito3478.scheme

import org.specs2.mutable.Specification

class SchemeStringSpec extends Specification{
  "SchemeString#new(RichString)" should {
    trait context extends Scope{
      val orig : SchemeString = "Unicode Character 'PALM TREE' (U+1F334) : '\ud83c\udf34' (UTF-16: 0xd83c 0xdf34)"
      val s : String = orig
    }

    "create SchemeString equal to the original" in new context{
      new SchemeString(s) mustEqual orig
    }
  }

  "SchemeString#toString" should {
    trait context extends Scope{
      val orig : String = "Unicode Character 'PALM TREE' (U+1F334) : '\ud83c\udf34' (UTF-16: 0xd83c 0xdf34)"
      val s : SchemeString = orig
    }

    "return String equals to the original" in new context {
      s.toString() mustEqual orig
    }
  }

  "SchemeString.fromString" should {
    trait context extends Scope{
      val s : String = "Unicode Character 'PALM TREE' (U+1F334) : '\ud83c\udf34' (UTF-16: 0xd83c 0xdf34)"
    }

    "return SchemeString equals to the return value of new SchemeString(String)" in new context {
      SchemeString.fromString(s) mustEqual(new SchemeString(s))
    }
  }

  "SchemeString#equals" should {
    trait context extends Scope {
      val s : SchemeString = "Unicode Character 'PALM TREE' (U+1F334) : '\ud83c\udf34' (UTF-16: 0xd83c 0xdf34)"
      val same : SchemeString = "Unicode Character 'PALM TREE' (U+1F334) : '\ud83c\udf34' (UTF-16: 0xd83c 0xdf34)"
      val different : SchemeString =
        "Unicode Character 'DECIDUOUS TREE' (U+1F333) : '\ud83c\udf33' (UTF-16: 0xd83c 0xdf33)"
    }

    "return true if String is same" in new context {
      s equals same must beTrue
    }

    "reutrn false if String is different" in new context {
      s equals different must beFalse
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

