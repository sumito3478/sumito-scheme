package sumito3478.scheme

import scala.collection.mutable.ArrayBuffer

class SchemeString(private val buffer : ArrayBuffer[SchemeChar] = new ArrayBuffer[SchemeChar]) {
}

object SchemeString{
  implicit def fromString(s : String) : SchemeString = {
    throw new NotImplementedError()
  }

}


