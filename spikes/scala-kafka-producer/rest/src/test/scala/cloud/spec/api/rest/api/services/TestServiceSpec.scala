package cloud.spec.api.rest.api
package services

import akka.http.scaladsl.model.StatusCodes
import akka.http.scaladsl.server.Route
//import akka.http.scaladsl.testkit.ScalatestRouteTest
import cloud.spec.api.core._
import cloud.spec.api.rest.api.models._
import cloud.spec.api.rest.api._
import cloud.spec.api.rest.common.TestCommon
import cloud.spec.api.rest.core._
import org.scalatest._

abstract class TestServiceSpec
  extends FlatSpec
  with Matchers
//  with ScalatestRouteTest
  with Api
  with DummyActors
  with Core
  with TestCommon {

  import Implicits._
  import cloud.spec.api.persistence.dummy.DummyTestMapper._
  import cloud.spec.api.util.Imports._

  override implicit val executor = system.dispatcher

  "TestService" should "return a list of top items for /test/top" in {
//    Get(s"/test/top/0/6") ~> routes ~> check {
//      responseAs[List[TestView]] should be(topItemsView)
//    }
  }

  it should "return a list of top items honoring the start and limit parameter for /test/top" in {
//    Get(s"/test/top/1/2") ~> routes ~> check {
//      responseAs[List[TestView]] should be(topItemsViewTail)
//    }
  }

  it should "reject with NoSuchItemAppError for an invalid id for /test/<id>" in {
//    Get(s"/test/${generateId.toUrlSafeBase64}") ~> routes ~> check {
//      rejection should be(AppRejection(NoSuchItemAppError))
//    }
  }

  it should "return a 404 for an invalid id for /test/<id>" in {
//    Get(s"/test/${generateId.toUrlSafeBase64}") ~> Route.seal(routes) ~> check {
//      status should be(StatusCodes.NotFound)
//      responseAs[AppException] should be(noSuchItemException)
//    }
  }

}