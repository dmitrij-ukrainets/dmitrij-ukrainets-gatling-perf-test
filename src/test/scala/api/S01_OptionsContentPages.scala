package api

import config.BaseHelpers._
import io.gatling.core.Predef._
import io.gatling.core.structure._
import io.gatling.http.Predef._

object S01_OptionsContentPages {

  def OptionsContentPages(): ChainBuilder = {
    exec (
      http("S01_OptionsContentPages")
        .options(apiShopizer + "content/pages/?page=0&count=20&store=DEFAULT&lang=en")
    )
  }

}
