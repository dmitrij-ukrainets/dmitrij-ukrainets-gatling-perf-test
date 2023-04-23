package api

import config.BaseHelpers._
import io.gatling.core.Predef._
import io.gatling.core.structure._
import io.gatling.http.Predef._

object S01_OptionsProduct1Price {

  def OptionseProduct1Price(): ChainBuilder = {
    exec (
      http("S01_OptionsProduct1Price")
        .options(apiShopizer + "product/1/price/")
    )
  }

}
