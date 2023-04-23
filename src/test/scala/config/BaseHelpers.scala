package config

import io.gatling.core.Predef._
import io.gatling.core.structure._
import io.gatling.http.Predef._
import io.gatling.http.protocol._
import net.sf.saxon.om.SequenceIterator.Property

import java.lang
import scala.util.Properties


object BaseHelpers {

  val shopizer = "http://localhost/"
  val apiShopizer = "http://localhost:8080/api/v1/"

  def thinkTimer (Min :Int= 1, Max :Int = 3): ChainBuilder = {
    pause(Min, Max)
  }

  val httpProtocol: HttpProtocolBuilder = http
    .header(name = "Referer", value = shopizer)
    .acceptLanguageHeader("en-US,en;q=0.5")
    .originHeader(shopizer)
    .header(name = "Access-Control-Request-Headers", value = "authorization")
    .header(name = "Access-Control-Request-Method", value = "GET")
    .acceptEncodingHeader("gzip, deflate")
    .userAgentHeader("Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:109.0) Gecko/20100101 Firefox/111.0")
    .acceptHeader("*/*")
    .contentTypeHeader("application/json")
    .upgradeInsecureRequestsHeader("1")

  //val users: Integer = Integer.getInteger("rampUsers", 100)
  //val ramp: lang.Long = java.lang.Long.getLong("during", 60)

}
