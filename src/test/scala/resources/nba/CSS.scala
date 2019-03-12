package resources.nba

import config.Header
import io.gatling.core.Predef._
import io.gatling.core.structure.ChainBuilder
import io.gatling.http.Predef._

object CSS {
  val cvp: ChainBuilder =
    exec(
      http("nba cvp")
        .get("/modules/custom/nba_cvp/css/cvp.css")
        .headers(Header.header)
        .check(status.is(200))
    )
  val slick: ChainBuilder =
    exec(
      http("slick")
        .get("/libraries/slick/slick/slick.css?5")
        .headers(Header.header)
        .check(status.is(200))
    )
  val contingency: ChainBuilder =
    exec(
      http("contingency")
        .get("/assets/global/contingency.css")
        .headers(Header.header)
        .check(status.is(200))
    )
}
