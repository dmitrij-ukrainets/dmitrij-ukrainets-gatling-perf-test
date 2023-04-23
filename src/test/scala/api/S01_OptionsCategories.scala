package api

import config.BaseHelpers._
import io.gatling.core.Predef._
import io.gatling.core.structure._
import io.gatling.http.Predef._

object S01_OptionsCategories {

  def OptionsCategories(): ChainBuilder = {
    exec (
      http("S01_OptionsCategory")
        .options(apiShopizer + "category/?count=20&page=0&store=DEFAULT&lang=en")
    )
  }

}
