package api

import config.BaseHelpers._
import io.gatling.core.Predef._
import io.gatling.core.structure._
import io.gatling.http.Predef._

object S01_ST06_OpenChair {
  def OpenChair(): ChainBuilder = {
    exec(api.S01_OptionsShopHeaderMessage.OptionsShopHeaderMessage())
      .exec(
        http("S01_ST06_OptionsChosenChairReviews")
          .options(apiShopizer + "products/${randomChairID}/reviews?store=DEFAULT")
      )
      .exec(
        http("S01_ST06_OptionsProductsChosenChair")
          .options(apiShopizer + "products/${randomChairID}?lang=en&store=DEFAULT")
      )
      .exec(
        http("S01_ST06_GetProductsChosenChair")
          .get(apiShopizer + "products/${randomChairID}")
          .queryParam("store", "DEFAULT")
          .queryParam("lang", "en")
          .check(
            jsonPath("$..sku").saveAs("ChairName")
          )
      )
      .exec(
        session => {
          val chosenChair = session("ChairName").asOption[String]
          println(chosenChair.getOrElse("Chosen chair name not found"))
          session
        }
      )
      .exec(api.S01_OptionsShopDefault.OptionsShopDefault())
      .exec(api.S01_OptionsCategories.OptionsCategories())
      .exec(
        http("S01_ST06_GetProductsChosenChairReviews")
          .get(apiShopizer + "products/${randomChairID}/reviews")
          .queryParam("store", "DEFAULT")
      )
      .exec(api.S01_OptionsContentPages.OptionsContentPages())
      .exec(api.S01_GetShopDefaults.GetShopDefaults())
      .exec(api.S01_GetCategories.GetCategories())
      .exec(api.S01_GetContentPages.GetContentPages())
      .exec(
        http("S01_ST06_OptionsProductChosenChairPrice")
          .options(apiShopizer + "product/${randomChairID}/price/")
      )
      .exec(
        http("S01_ST06_PostProductChosenChairPrice")
          .post(apiShopizer + "product/${randomChairID}/price/")
          .body(StringBody("""{"options":[]}""")).asJson
      )
  }
}