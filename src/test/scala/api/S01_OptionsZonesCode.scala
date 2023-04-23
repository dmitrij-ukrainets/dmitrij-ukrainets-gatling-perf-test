package api

import config.BaseHelpers._
import io.gatling.core.Predef._
import io.gatling.core.structure._
import io.gatling.http.Predef._

object S01_OptionsZonesCode {

  def OptionsZonesCode(): ChainBuilder = {
    exec (
      http("S01_OptionsZonesCode")
        .options(apiShopizer + "cart/${cartID}/shipping")
    )
  }

}
