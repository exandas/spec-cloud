package cloud.spec.api.domain.models

import cloud.spec.api.util.Imports._
import org.joda.time.DateTime
import org.scalatest._

class TestSpec extends FlatSpec with Matchers {

  "Test" should "not accept a blank name" in {

    an [IllegalArgumentException] should be thrownBy Test(
      generateId,
      ""
    )
  }
}
