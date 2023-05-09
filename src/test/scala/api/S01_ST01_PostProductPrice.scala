package api

import config.BaseHelpers._
import io.gatling.core.Predef._
import io.gatling.core.structure._
import io.gatling.http.Predef._

object S01_ST01_PostProductPrice {

  def PostProductPrice(postproduct: String = "50", postRequestNumber: String = "01"): ChainBuilder = {
    exec (
      http(s"S01_ST$postRequestNumber _PostProduct$postproduct Price")
        .post(apiShopizer + s"product/$postproduct/price/")
        .body(StringBody("""{"options":[]}""")).asJson
    )
  }

}
