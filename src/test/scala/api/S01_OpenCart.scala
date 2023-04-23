package api

import config.BaseHelpers._
import io.gatling.core.Predef._
import io.gatling.core.structure._
import io.gatling.http.Predef._

object S01_OpenCart {
  def OpenCart(): ChainBuilder = {
      exec(api.S01_OptionsShopHeaderMessage.OptionsShopHeaderMessage())
        .exec(api.S01_OpenCart_OptionsCurrentCartDefault.OpenCart_OptionsCurrentCartDefault())
        .exec(api.S01_OpenCart_OptionsCurrentCartDefault.OpenCart_OptionsCurrentCartDefault())
        .exec(api.S01_OptionsShopDefault.OptionsShopDefault())
        .exec(api.S01_OptionsContentPages.OptionsContentPages())
        .exec(api.S01_OptionsCategories.OptionsCategories())
        .exec(
          http("GetCurrentCart")
            .get(apiShopizer + "cart/${cartID}")
            .queryParam("store","DEFAULT")
        )
        .exec(
          http("GetCurrentCart")
            .get(apiShopizer + "cart/${cartID}")
            .queryParam("store", "DEFAULT")
        )
        .exec(api.S01_GetShopDefaults.GetShopDefaults())
        .exec(api.S01_GetContentPages.GetContentPages())
        .exec(api.S01_GetCategories.GetCategories())

  }
}