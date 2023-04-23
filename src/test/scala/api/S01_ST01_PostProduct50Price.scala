package api

import config.BaseHelpers._
import io.gatling.core.Predef._
import io.gatling.core.structure._
import io.gatling.http.Predef._

object S01_ST01_PostProduct50Price {

  def PostProduct50Price(): ChainBuilder = {
    exec (
      http("S01_ST01_PostProduct50Price")
        .post(apiShopizer + "product/50/price/")
        .body(StringBody("""{"options":[]}""")).asJson
    )
  }

}
