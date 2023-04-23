package scenarios

import config.BaseHelpers._
import io.gatling.core.Predef._
import io.gatling.core.structure._

object OpenCartAndCheckout {

  def scnOpenCartAndCheckout: ScenarioBuilder = {
    scenario("Open Cart And Checkout")
        .exitBlockOnFail(
        group("S01_OpenCart") {
          exec(api.S01_OpenCart.OpenCart())
            .exec(thinkTimer())
        }
      )
      .exitBlockOnFail(
        group("S01_ProceedToCheckout"){
          exec(api.S01_ProceedToCheckout.ProceedToCheckout())
            .exec(thinkTimer())
        }
      )
  }

}
