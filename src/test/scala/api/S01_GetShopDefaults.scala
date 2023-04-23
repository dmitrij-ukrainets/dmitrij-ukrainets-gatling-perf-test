package api

import config.BaseHelpers._
import io.gatling.core.Predef._
import io.gatling.core.structure._
import io.gatling.http.Predef._

object S01_GetShopDefaults {

  def GetShopDefaults(): ChainBuilder = {
    exec (
      http("S01_GetShopDefaults")
        .get(apiShopizer + "store/DEFAULT")
    )
  }

}
