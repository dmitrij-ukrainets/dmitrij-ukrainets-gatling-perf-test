package api

import config.BaseHelpers._
import io.gatling.core.Predef._
import io.gatling.core.structure._
import io.gatling.http.Predef._

object S01_ST05_GoToChairs {
  def GoToChairs(): ChainBuilder = {
    exec(
      http("S01_ST05_OptionsProductsShop")
        .options(apiShopizer + "products/?&store=DEFAULT&lang=en&page=0&count=15&category=51")
    )
      .exec(api.S01_OptionsShopHeaderMessage.OptionsShopHeaderMessage())
      .exec(api.S01_OptionsContentPages.OptionsContentPages())
      .exec(
        http("S01_ST05_GetProducts")
          .get(apiShopizer + "products/")
          .queryParam("store", "DEFAULT")
          .queryParam("lang", "en")
          .queryParam("page", "0")
          .queryParam("count", "15")
          .queryParam("category", "51")
          .check(
            jsonPath("$.products[*].id").findRandom.saveAs("randomChairID")
          )
      )
      .exec(
        session => {
          val randomChair = session("randomChairID").asOption[String]
          println(randomChair.getOrElse("Chair ID not found"))
          session
        }
      )
      .exec(api.S01_OptionsShopDefault.OptionsShopDefault())
      .exec(api.S01_OptionsCategories.OptionsCategories())
      .exec(api.S01_GetContentPages.GetContentPages())
      .exec(api.S01_GetShopDefaults.GetShopDefaults())
      .exec(api.S01_GetCategories.GetCategories())
      .exec(api.S01_ST01_OptionseProductPrice.OptionseProductPrice(optionsproduct = "50", optionsRequestNumber = "01"))
      .exec(api.S01_ST01_OptionseProductPrice.OptionseProductPrice(optionsproduct = "51", optionsRequestNumber = "01"))
      .exec(api.S01_ST01_OptionseProductPrice.OptionseProductPrice(optionsproduct = "52", optionsRequestNumber = "01"))
      .exec(
        http("S01_ST05_OptionsChosenCategory")
          .options(apiShopizer + "category/51?store=DEFAULT&lang=en")
      )
      .exec(api.S01_ST01_PostProductPrice.PostProductPrice(postproduct = "52", postRequestNumber = "01"))
      .exec(
        http("S01_ST05_GetChosenCategory")
        .get(apiShopizer + "category/51")
          .queryParam("store", "DEFAULT")
          .queryParam("lang", "en")
      )
      .exec(api.S01_ST01_PostProductPrice.PostProductPrice(postproduct = "50", postRequestNumber = "01"))
      .exec(api.S01_ST01_PostProductPrice.PostProductPrice(postproduct = "51", postRequestNumber = "01"))
      .exec(
        http("S01_ST05_OptionsChosenCategoryManufacturers")
          .options(apiShopizer + "category/51/manufacturers/?store=DEFAULT&lang=en")
      )
      .exec(
        http("S01_ST05_GetChosenCategoryManufacturers")
          .get(apiShopizer + "category/51/manufacturers/")
          .queryParam("store", "DEFAULT")
          .queryParam("lang", "en")
      )
      .exec(
        http("S01_ST05_OptionsChosenCategoryVariants")
          .options(apiShopizer + "category/51/variants/?store=DEFAULT&lang=en")
      )
  }
}