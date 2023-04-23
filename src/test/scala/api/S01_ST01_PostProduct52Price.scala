package api

import config.BaseHelpers._
import io.gatling.core.Predef._
import io.gatling.core.structure._
import io.gatling.http.Predef._

object S01_ST01_PostProduct52Price {

  def PostProduct52Price(): ChainBuilder = {
    exec (
      http("S01_ST01_PostProduct52Price")
        .post(apiShopizer + "product/52/price/")
        .body(StringBody("""{"options":[]}""")).asJson
    )
  }

}
