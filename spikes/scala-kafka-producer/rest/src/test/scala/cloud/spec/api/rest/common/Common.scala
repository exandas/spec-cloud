package cloud.spec.api.rest.common

import cloud.spec.api.rest.core._

trait Common {

  val noSuchItemException = AppException(NoSuchItemAppError.message)
}
