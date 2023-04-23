package api

import config.BaseHelpers._
import io.gatling.core.Predef._
import io.gatling.core.structure._
import io.gatling.http.Predef._

object S01_OpenCart_OptionsCurrentCartDefault {

  def OpenCart_OptionsCurrentCartDefault(): ChainBuilder = {
    exec (
      http("S01_OpenCart_OptionsCurrentCartDefault")
        .options(apiShopizer + "cart/${cartID}?store=DEFAULT")
    )
  }

}
