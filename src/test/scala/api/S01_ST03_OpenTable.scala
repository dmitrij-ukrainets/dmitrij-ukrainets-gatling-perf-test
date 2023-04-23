package api

import config.BaseHelpers._
import io.gatling.core.Predef._
import io.gatling.core.structure._
import io.gatling.http.Predef._

object S01_ST03_OpenTable {
  def OpenTable(): ChainBuilder = {
    exec(api.S01_OptionsShopHeaderMessage.OptionsShopHeaderMessage())
      .exec(
        http("S01_ST03_OptionsProducts1")
          .options(apiShopizer + "products/1?lang=en&store=DEFAULT")
      )
      .exec(
        http("S01_ST03_OptionsProducts1Reviews")
        .options(apiShopizer + "products/1/reviews?store=DEFAULT")
      )
      .exec(
        http("S01_ST03_GetProducts1")
          .get(apiShopizer + "products/1")
          .queryParam("store", "DEFAULT")
          .queryParam("lang", "en")
      )
      .exec(api.S01_OptionsShopDefault.OptionsShopDefault())
      .exec(api.S01_OptionsCategories.OptionsCategories())
      .exec(
        http("S01_ST03_GetProducts1Reviews")
          .get(apiShopizer + "products/1/reviews")
          .queryParam("store", "DEFAULT")
      )
      .exec(api.S01_GetShopDefaults.GetShopDefaults())
      .exec(api.S01_GetCategories.GetCategories())
      .exec(api.S01_OptionsContentPages.OptionsContentPages())
      .exec(api.S01_OptionsProduct1Price.OptionseProduct1Price())
      .exec(api.S01_GetContentPages.GetContentPages())
      .exec(api.S01_PostProduct1Price.PostProduct1Price())
  }
}