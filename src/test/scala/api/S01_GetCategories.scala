package api

import config.BaseHelpers._
import io.gatling.core.Predef._
import io.gatling.core.structure._
import io.gatling.http.Predef._

object S01_GetCategories {

  def GetCategories(): ChainBuilder = {
    exec (
      http("S01_GetCategories")
        .get(apiShopizer + "category/")
        .queryParam("count", "20")
        .queryParam("page", "0")
        .queryParam ("store", "DEFAULT")
        .queryParam("lang", "en")
    )
  }

}
