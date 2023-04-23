package api

import config.BaseHelpers._
import io.gatling.core.Predef._
import io.gatling.core.structure._
import io.gatling.http.Predef._

object S01_GetZones {

  def GetZones(): ChainBuilder = {
    exec (
      http("S01_GetZones")
        .get(apiShopizer + "zones/")
        .queryParam("code", "")
    )
  }

}
