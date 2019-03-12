package resources.nba

import config.Header
import io.gatling.core.Predef._
import io.gatling.core.structure.ChainBuilder
import io.gatling.http.Predef._

object JS {
  val min: ChainBuilder =
    exec(
      http("modernizr.js")
        .get("/core/assets/vendor/modernizr/modernizr.min.js")
        .headers(Header.header)
        .check(status.is(200))
    )
  val jquery: ChainBuilder =
    exec(
      http("jquery.js")
        .get("/core/assets/vendor/jquery/jquery.min.js?v=3.2.1")
        .headers(Header.header)
        .check(status.is(200))
    )
  val contingency: ChainBuilder =
    exec(
      http("contingency.js")
        .get("/assets/global/contingency.js")
        .headers(Header.header)
        .check(status.is(200))
    )
}
