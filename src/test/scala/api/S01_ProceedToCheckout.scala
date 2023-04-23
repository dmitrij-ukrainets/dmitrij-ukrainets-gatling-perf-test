package api

import config.BaseHelpers._
import io.gatling.core.Predef._
import io.gatling.core.structure._
import io.gatling.http.Predef._

object S01_ProceedToCheckout {
  def ProceedToCheckout(): ChainBuilder = {
      exec(api.S01_OptionsShopHeaderMessage.OptionsShopHeaderMessage())
        .exec(
        http("ProceedToCheckout_OptionsShippingCountry")
          .options(apiShopizer + "shipping/country?store=DEFAULT&lang=en")
        )
        .exec(
          http("ProceedToCheckout_OptionsCurrentCartDefault")
            .options(apiShopizer + "cart/${cartID}?store=DEFAULT")
        )
        .exec(api.S01_OptionsZonesCode.OptionsZonesCode())
        .exec(
          http("ProceedToCheckout_OptionsCurrentCartShipping")
            .options(apiShopizer + "cart/${cartID}/shipping")
        )
        .exec(api.S01_OptionsZonesCode.OptionsZonesCode())
        .exec(
          http("ProceedToCheckout_OptionsConfig")
            .options(apiShopizer + "config/")
        )
        .exec(
          http("ProceedToCheckout_OptionsCurrentCartTotal")
            .options(apiShopizer + "cart/${cartID}/total/")
        )
        .exec(api.S01_OptionsShopDefault.OptionsShopDefault())
        .exec(api.S01_GetZones.GetZones())
        .exec(api.S01_GetZones.GetZones())
        .exec(api.S01_OptionsContentPages.OptionsContentPages())
        .exec(api.S01_OptionsCategories.OptionsCategories())
        .exec(
          http("GetShippingCountry")
            .get(apiShopizer + "shipping/country")
            .queryParam("store", "DEFAULT")
            .queryParam("lang", "en")
        )
        .exec(
          http("GetCurrentCart")
            .get(apiShopizer + "cart/${cartID}")
            .queryParam("store", "DEFAULT")
        )
        .exec(
          http("GetConfig")
            .get(apiShopizer + "config/")
        )
        .exec(api.S01_GetShopDefaults.GetShopDefaults())
        .exec(api.S01_GetContentPages.GetContentPages())
        .exec(api.S01_GetCategories.GetCategories())
        .exec(
          http("GetCurrentCartTotal")
            .get(apiShopizer + "cart/${cartID}/total/")
        )
  }
}