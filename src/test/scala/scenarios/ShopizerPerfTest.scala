package scenarios

import config.BaseHelpers._
import io.gatling.core.Predef._
import io.gatling.core.structure._
import io.gatling.http.Predef._

object ShopizerPerfTest {

  def scnShopizerPerfTest: ScenarioBuilder = {
    scenario("Shopizer Performance Test")
       .exec(flushHttpCache)
          .exec(flushSessionCookies)
          .exec(flushCookieJar)
          .exitBlockOnFail(
            group("S01_ST01_OpenApp") {
              exec(api.S01_ST01_OpenApp.AppOpenSite())
                .exec(thinkTimer())
            }
              .group("S01_ST02_GoToTables") {
                exec(api.S01_ST02_GoToTables.GoToTables())
                  .exec(thinkTimer())
              }
              .group("S01_ST03_OpenTable") {
                exec(api.S01_ST03_OpenTable.OpenTable())
                  .exec(thinkTimer())
              }
              .group("S01_ST04_AddTable") {
                exec(api.S01_ST04_AddTable.AddTable())
                  .exec(thinkTimer())
              }
              .group("S01_Add_Chair_or_Proceed_to_Checkout_with_Table") {
                randomSwitch(
                  usersToAddChair -> exec(scenarios.AddChair.scnAddChair),
                  usersWithTableToCart -> doIfEquals("${tableAdded}", "1") {
                    exec(scenarios.OpenCartAndCheckout.scnOpenCartAndCheckout)
                  }
                )
              }
              .group("S01_OpenCart_And_Checkout_With_Chair") {
                randomSwitchOrElse(
                  usersWithChairToCart -> doIfEquals("${chairAdded}", "2") {
                    exec(scenarios.OpenCartAndCheckout.scnOpenCartAndCheckout)
                  }
                )(
                  exitHere
                )
              }
          )
  }
}
