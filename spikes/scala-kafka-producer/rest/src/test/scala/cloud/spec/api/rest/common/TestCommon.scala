package cloud.spec.api.rest.common

import cloud.spec.api.domain.models._
import cloud.spec.api.persistence.dummy._
import cloud.spec.api.rest.api.models._
import cloud.spec.api.rest.api.models.mapping.ViewModelMappers._

trait TestCommon extends Common {

  import DummyTestMapper._

  val testData1View = mapper[Test, TestView].apply(testData1)
  val testData2View = mapper[Test, TestView].apply(testData2)
  val testData3View = mapper[Test, TestView].apply(testData3)

  val topItemsView = topItems.map(mapper[Test, TestView])
  val topItemsViewTail = topItems.tail.map(mapper[Test, TestView])

}
