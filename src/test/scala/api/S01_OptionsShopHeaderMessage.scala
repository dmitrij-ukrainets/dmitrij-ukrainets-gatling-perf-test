package api

import config.BaseHelpers._
import io.gatling.core.Predef._
import io.gatling.core.structure._
import io.gatling.http.Predef._

object S01_OptionsShopHeaderMessage {

  def OptionsShopHeaderMessage(): ChainBuilder = {
    exec (
      http("S01_OptionsShopHeaderMessage")
        .options(apiShopizer + "content/boxes/headerMessage/?lang=en")
    )
  }

}
