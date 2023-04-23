package api

import config.BaseHelpers._
import io.gatling.core.Predef._
import io.gatling.core.structure._
import io.gatling.http.Predef._

object S01_ST01_PostProduct51Price {

  def PostProduct51Price(): ChainBuilder = {
    exec (
      http("S01_ST01_PostProduct51Price")
        .post(apiShopizer + "product/51/price/")
        .body(StringBody("""{"options":[]}""")).asJson
    )
  }

}
