package api

import config.BaseHelpers._
import io.gatling.core.Predef._
import io.gatling.core.structure._
import io.gatling.http.Predef._

object S01_ST04_AddTable {
  def AddTable(): ChainBuilder = {
      exec(
        http("S01_ST04_OptionsCartShop")
          .options(apiShopizer + "cart/?store=DEFAULT")
      )
      .exec(
        http("S01_ST04_PostCartShop")
          .post(apiShopizer + "cart/?store=DEFAULT")
          .body(StringBody("""{"attributes":[],"product":"table1","quantity":1}""")).asJson
          .check(
            jsonPath(("$.code")).saveAs("cartID")
          )
      )
        .exec(
          session => {
            val activeCart = session("cartID").asOption[String]
            println(activeCart.getOrElse("Cart ID not found"))
            session
          }
        )
      .exec(api.S01_OptionsCurrentCart.OptionsCurrentCart())
      .exec(
        http("S01_ST04_GetCurrentCart")
          .get(apiShopizer + "cart/${cartID}")
          .queryParam("lang","en")
          .check(
            jsonPath("$.quantity").saveAs("tableAdded"),
            jsonPath("$.quantity").is("1")
          )
      )
  }
}