package api

import config.BaseHelpers._
import io.gatling.core.Predef._
import io.gatling.core.structure._
import io.gatling.http.Predef._

object S01_ST07_AddChair {
  def AddChair(): ChainBuilder = {
      exec(
        http("S01_ST07_OptionsCurrentCartDefault")
          .options(apiShopizer + "cart/${cartID}?store=DEFAULT")
      )
      .exec(
        http("S01_ST07_PutCurrentCart")
          .put(apiShopizer + "cart/${cartID}?store=DEFAULT")
          .body(StringBody("""{"attributes":[],"product":"${ChairName}","quantity":1}""")).asJson
      )
      .exec(api.S01_OptionsCurrentCart.OptionsCurrentCart())
        .exec(
          http("S01_ST04_GetCurrentCart")
            .get(apiShopizer + "cart/${cartID}")
            .queryParam("lang", "en")
            .check(
              jsonPath("$.quantity").saveAs("chairAdded"),
              jsonPath("$.quantity").is("2")
            )
        )
  }
}