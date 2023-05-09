package api

import config.BaseHelpers._
import io.gatling.core.Predef._
import io.gatling.core.structure._
import io.gatling.http.Predef._

object S01_ST01_OpenApp {

  def AppOpenSite(): ChainBuilder = {
    exec(
      http("S01_ST01_OpenSite")
        .get(shopizer)
        .check(regex("Imports from the world"))
    )
      .exec(
        http("S01_ST01_OptionsShopItems")
      .options(apiShopizer + "products/group/FEATURED_ITEM?store=&lang=en")
      )
      .exec(api.S01_OptionsShopHeaderMessage.OptionsShopHeaderMessage())
      .exec(api.S01_OptionsCategories.OptionsCategories())
      .exec(
        http("S01_ST01_OptionsShopContent")
          .options(apiShopizer + "content/pages/?page=0&count=20&store=&lang=en")
      )
      .exec(api.S01_OptionsShopDefault.OptionsShopDefault())
      .exec(
        http("S01_ST01_GetProductGroupsItems")
          .get(apiShopizer + "products/group/FEATURED_ITEM")
          .queryParam("store", "")
          .queryParam("lang","en")
      )
      .exec(
        http("S01_ST01_GetCategories")
          .get(apiShopizer + "category/")
          .queryParam("count", "20")
          .queryParam("page", "0")
          .queryParam("store", "")
          .queryParam("lang", "en")
      )
      .exec(
        http("S01_ST01_GetContentPages")
          .get(apiShopizer + "content/pages/")
          .queryParam("count", "20")
          .queryParam("page", "0")
          .queryParam("store", "")
          .queryParam("lang", "en")
      )
      .exec(api.S01_GetShopDefaults.GetShopDefaults())
      .exec(api.S01_ST01_OptionseProductPrice.OptionseProductPrice(optionsproduct = "50", optionsRequestNumber = "01"))
      .exec(api.S01_ST01_OptionseProductPrice.OptionseProductPrice(optionsproduct = "51", optionsRequestNumber = "01"))
      .exec(api.S01_ST01_OptionseProductPrice.OptionseProductPrice(optionsproduct = "52", optionsRequestNumber = "01"))
      .exec(api.S01_ST01_OptionseProductPrice.OptionseProductPrice(optionsproduct = "1", optionsRequestNumber = "01"))
      .exec(api.S01_ST01_OptionseProductPrice.OptionseProductPrice(optionsproduct = "51", optionsRequestNumber = "01"))
      .exec(api.S01_ST01_OptionseProductPrice.OptionseProductPrice(optionsproduct = "52", optionsRequestNumber = "01"))
      .exec(api.S01_ST01_OptionseProductPrice.OptionseProductPrice(optionsproduct = "50", optionsRequestNumber = "01"))
      .exec(api.S01_ST01_PostProductPrice.PostProductPrice(postproduct = "50", postRequestNumber = "01"))
      .exec(api.S01_ST01_OptionseProductPrice.OptionseProductPrice(optionsproduct = "1", optionsRequestNumber = "01"))
      .exec(api.S01_ST01_PostProductPrice.PostProductPrice(postproduct = "51", postRequestNumber = "01"))
      .exec(api.S01_ST01_PostProductPrice.PostProductPrice(postproduct = "1", postRequestNumber = "01"))
      .exec(api.S01_ST01_PostProductPrice.PostProductPrice(postproduct = "51", postRequestNumber = "01"))
      .exec(api.S01_ST01_PostProductPrice.PostProductPrice(postproduct = "52", postRequestNumber = "01"))
      .exec(api.S01_ST01_PostProductPrice.PostProductPrice(postproduct = "52", postRequestNumber = "01"))
      .exec(api.S01_ST01_PostProductPrice.PostProductPrice(postproduct = "50", postRequestNumber = "01"))
      .exec(api.S01_ST01_PostProductPrice.PostProductPrice(postproduct = "1", postRequestNumber = "01"))
  }

}
