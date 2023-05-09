package api

import config.BaseHelpers._
import io.gatling.core.Predef._
import io.gatling.core.structure._
import io.gatling.http.Predef._

object S01_ST01_OptionseProductPrice {

  def OptionseProductPrice(optionsproduct: String = "50", optionsRequestNumber: String = "01"): ChainBuilder = {
    exec (
      http(s"S01_ST$optionsRequestNumber _OptionseProduct$optionsproduct Price")
        .options(apiShopizer + s"product/$optionsproduct/price/")
    )
  }

}
