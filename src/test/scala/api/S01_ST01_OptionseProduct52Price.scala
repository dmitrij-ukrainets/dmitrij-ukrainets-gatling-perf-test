package api

import config.BaseHelpers._
import io.gatling.core.Predef._
import io.gatling.core.structure._
import io.gatling.http.Predef._

object S01_ST01_OptionseProduct52Price {

  def OptionseProduct52Price(): ChainBuilder = {
    exec (
      http("S01_ST01_OptionseProduct52Price")
        .options(apiShopizer + "product/52/price/")
    )
  }

}
