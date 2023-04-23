package api

import config.BaseHelpers._
import io.gatling.core.Predef._
import io.gatling.core.structure._
import io.gatling.http.Predef._

object S01_OptionsShopDefault {

  def OptionsShopDefault(): ChainBuilder = {
    exec (
      http("S01_OptionsShopDefault")
        .options(apiShopizer + "store/DEFAULT")
    )
  }

}
