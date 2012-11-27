package sumito3478.scheme

import org.specs2.mutable.Specification
import org.specs2.specification.Scope
import org.junit.runner.RunWith
import org.specs2.runner.JUnitRunner

@RunWith(classOf[JUnitRunner])
class SchemeCharSpec  extends Specification{
  trait context extends Scope {
    val v = 0x1f334 // PALM TREE
  }
}
