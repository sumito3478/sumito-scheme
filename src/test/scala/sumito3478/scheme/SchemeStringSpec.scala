package sumito3478.scheme

import org.specs2.mutable.SpecificationWithJUnit
import org.specs2.specification.Scope

class SchemeStringSpec extends SpecificationWithJUnit {
  val palmString = "PALM TREE: '\ud83c\udf34'"
  val palmArray = Array[Int](
    0x50, 0x41, 0x4c, 0x4d, 0x20, 0x54, 0x52, 0x45, 0x45, 0x3a,
    0x20, 0x27, 0x1f334, 0x27)
  val palm = SchemeString(palmArray: _*) // equals to palmString
  val palm2 = SchemeString(palm)
  val deciduousString: SchemeString = "DECIDUOUS TREE: '\ud83c\udf33'"
  val deciduous = SchemeString(
    0x44, 0x45, 0x43, 0x49, 0x44, 0x55, 0x4f, 0x55, 0x53, 0x20,
    0x54, 0x52, 0x45, 0x45, 0x3a, 0x20, 0x27, 0x1f333, 0x27)
  // equals to deciduousString
  "SchemeString" should {
    "implicitly comverted from String" in {
      val converted: SchemeString = palmString
      converted.toString mustEqual palmString
    }

    "implicitly converted to String" in {
      val converted: String = palm
      converted mustEqual palmString
    }
  }

  "SchemeString#new(RichString)" should {
    "create SchemeString equal to the original" in {
      SchemeString(palmString) mustEqual palm
    }
  }

  "SchemeString#toString" should {
    "return String equals to the original" in {
      palm.toString() mustEqual palmString
    }
  }

  "SchemeString.fromString" should {
    "return SchemeString equals to the return value of new SchemeString(String)" in {
      SchemeString.convertFromString(palmString) mustEqual palm
    }
  }

  "SchemeString.toString" should {
    "return String equals to the return value of String#toString()" in {
      SchemeString.convertToString(palm) mustEqual palmString
    }
  }

  "SchemeString#equals" should {
    "return true if String is same" in {
      palm equals palm2 must beTrue
    }

    "reutrn false if String is different" in {
      palm equals deciduous must beFalse
    }
  }

  "SchemeString#==" should {
    // because Object#equals cannot be stubbed, describe the behavior of == itself.
    "return true if String is same" in {
      palm == palm2 must beTrue
    }

    "reutrn false if String is different" in {
      palm == deciduous must beFalse
    }
  }

  "SchemeString#toCharArray" should {
    "return Array of SchemeChar contained in the SchemeString" in {
      palm.toCharArray mustEqual palmArray
    }
  }
}

