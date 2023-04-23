package api

import config.BaseHelpers._
import io.gatling.core.Predef._
import io.gatling.core.structure._
import io.gatling.http.Predef._

object S01_GetContentPages {

  def GetContentPages(): ChainBuilder = {
    exec (
      http("S01_GetContentPages")
        .get(apiShopizer + "content/pages/")
        .queryParam("page", "0")
        .queryParam("count", "20")
        .queryParam("store", "DEFAULT")
        .queryParam("lang", "en")
    )
  }

}
