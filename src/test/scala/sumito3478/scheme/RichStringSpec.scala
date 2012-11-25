package sumito3478.scheme

import org.specs2.mutable.Specification
import org.specs2.specification.Scope
import collection.mutable.ArrayBuffer
import RichString._

class RichStringSpec extends Specification{
  "RichString#toSchemeCharArrayBuffer" should {
    trait context extends Scope {
      val buffer = new ArrayBuffer[SchemeChar]()
      buffer += 0x1f334
      buffer += 0x1f333
      val s = new String(Array[Int](0x1f334, 0x1f333), 0, 2)
    }
    "return ArrayBuffer of SchemeChar" in new context {
      s.toSchemeCharArrayBuffer mustEqual buffer
    }
  }
}
