package resources.webperformance

import config.Header
import io.gatling.core.Predef._
import io.gatling.core.structure.ChainBuilder
import io.gatling.http.Predef._

object CSS {
  val shim: ChainBuilder =
    exec(
      http("shim.css")
        .get("/vendor/webshim-1.14.1/shims/styles/shim.css")
        .headers(Header.header)
        .check(status.is(200))
    )
}
