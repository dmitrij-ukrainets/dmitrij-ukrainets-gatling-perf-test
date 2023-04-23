package api

import config.BaseHelpers._
import io.gatling.core.Predef._
import io.gatling.core.structure._
import io.gatling.http.Predef._

object S01_ST01_OptionseProduct51Price {

  def OptionseProduct51Price(): ChainBuilder = {
    exec (
      http("S01_ST01_OptionseProduct51Price")
        .options(apiShopizer + "product/51/price/")
    )
  }

}
