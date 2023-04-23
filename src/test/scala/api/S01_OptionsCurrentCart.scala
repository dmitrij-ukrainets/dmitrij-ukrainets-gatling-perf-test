package api

import config.BaseHelpers._
import io.gatling.core.Predef._
import io.gatling.core.structure._
import io.gatling.http.Predef._

object S01_OptionsCurrentCart {

  def OptionsCurrentCart(): ChainBuilder = {
    exec (
      http("S01_OptionsCurrentCart")
        .options(apiShopizer + "cart/${cartID}?lang=en")
    )
  }

}
