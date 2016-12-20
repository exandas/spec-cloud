package cloud.spec.api.rest.api.models.mapping

import cloud.spec.api.domain.models._
import cloud.spec.api.rest.api.models._
import org.scalatest._

class ViewModelMapperSpec extends FlatSpec with Matchers {

  import ViewModelMappers._
  import cloud.spec.api.persistence.dummy.DummyTestMapper._

  "ViewModelMappers" should "be able to map a Test to a TestView" in {

    val mapped = mapper[Test, TestView].apply(testData1)

    mapped should be (TestView(
      testData1.id,
      testData1.name
    ))
  }
}
