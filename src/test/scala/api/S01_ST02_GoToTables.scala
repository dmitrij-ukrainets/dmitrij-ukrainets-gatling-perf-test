package api

import config.BaseHelpers._
import io.gatling.core.Predef._
import io.gatling.core.structure._
import io.gatling.http.Predef._

object S01_ST02_GoToTables {
  def GoToTables(): ChainBuilder = {
    exec(api.S01_OptionsShopHeaderMessage.OptionsShopHeaderMessage())
      .exec(
        http("S01_ST02_OptionsProductsStore")
          .options(apiShopizer + "products/?&store=DEFAULT&lang=en&page=0&count=15&category=50")
      )
      .exec(
        http("S01_ST02_GetProducts")
        .get(apiShopizer + "products/")
        .queryParam("store", "DEFAULT")
        .queryParam("lang", "en")
        .queryParam("page", "0")
        .queryParam("count", "15")
        .queryParam("category", "50")
      )
      .exec(api.S01_OptionsShopDefault.OptionsShopDefault())
      .exec(api.S01_OptionsCategories.OptionsCategories())
      .exec(api.S01_OptionsContentPages.OptionsContentPages())
      .exec(api.S01_GetShopDefaults.GetShopDefaults())
      .exec(api.S01_GetCategories.GetCategories())
      .exec(api.S01_GetContentPages.GetContentPages())
      .exec(api.S01_ST01_OptionseProductPrice.OptionseProductPrice(optionsproduct = "1", optionsRequestNumber = "01"))
      .exec(
        http("S01_ST02_OptionsCategory50Store")
          .options(apiShopizer + "category/50?store=DEFAULT&lang=en")
      )
      .exec(
        http("S01_ST02_GetCategoryStore50")
          .get(apiShopizer + "category/50")
          .queryParam("store", "DEFAULT")
          .queryParam("lang", "en")
      )
      .exec(api.S01_ST01_PostProductPrice.PostProductPrice(postproduct = "1", postRequestNumber = "01"))
      .exec(
        http("S01_ST02_Options50Manufacturers")
          .options(apiShopizer + "category/50/manufacturers/?store=DEFAULT&lang=en")
      )
      .exec(
        http("S01_ST02_GetCategory50Manufacturers")
          .get(apiShopizer + "category/50/manufacturers/")
          .queryParam("store", "DEFAULT")
          .queryParam("lang", "en")
      )
      .exec(
        http("S01_ST02_OptionsCategory50Variants")
          .options(apiShopizer + "category/50/variants/?store=DEFAULT&lang=en")
      )
  }
}