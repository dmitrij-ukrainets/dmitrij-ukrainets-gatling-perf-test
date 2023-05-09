package scenarios

import config.BaseHelpers._
import io.gatling.core.Predef._
import io.gatling.core.structure._

object AddChair {

  def scnAddChair: ScenarioBuilder = {
    scenario("Add Chair to cart")
      .exitBlockOnFail(
        group("S01_ST05_GoToChairs") {
          exec(api.S01_ST05_GoToChairs.GoToChairs())
            .exec(thinkTimer())
        }
          .group("S01_ST06_OpenChair") {
            exec(api.S01_ST06_OpenChair.OpenChair())
              .exec(thinkTimer())
          }
          .group("S01_ST07_AddChair") {
            exec(api.S01_ST07_AddChair.AddChair())
              .exec(thinkTimer())
          }
      )
  }
}
