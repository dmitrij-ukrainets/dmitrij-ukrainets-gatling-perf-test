package api

import config.BaseHelpers._
import io.gatling.core.Predef._
import io.gatling.core.structure._
import io.gatling.http.Predef._

object S01_PostProduct1Price {

  def PostProduct1Price(): ChainBuilder = {
    exec (
      http("S01_PostProduct1Price")
        .post(apiShopizer + "product/1/price/")
        .body(StringBody("""{"options":[]}""")).asJson
    )
  }

}
