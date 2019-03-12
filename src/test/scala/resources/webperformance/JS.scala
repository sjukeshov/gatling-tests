package resources.webperformance

import config.Header
import io.gatling.core.Predef._
import io.gatling.core.structure.ChainBuilder
import io.gatling.http.Predef._

object JS {
  val modernizr: ChainBuilder =
    exec(
      http("modernizr.js")
        .get("/vendor/webshim-1.14.1/extras/modernizr-custom.js")
        .headers(Header.header)
        .check(status.is(200))
    )
  val jquery: ChainBuilder =
    exec(
      http("jquery-1.11.1.min.js")
        .get("/vendor/jquery-1.11.1.min.js")
        .headers(Header.header)
        .check(status.is(200))
    )
  val polyfiller: ChainBuilder =
    exec(
      http("polyfiller.js")
        .get("/vendor/webshim-1.14.1/polyfiller.js")
        .headers(Header.header)
        .check(status.is(200))
    )

  val common: ChainBuilder =
    exec(
      http("common.js")
        .get("/js/common.js")
        .headers(Header.header)
        .check(status.is(200))
    )

  val home: ChainBuilder =
    exec(
      http("home.js")
        .get("/js/home.js")
        .headers(Header.header)
        .check(status.is(200))
    )

  val core: ChainBuilder =
    exec(
      http("form-core.js")
        .get("/vendor/webshim-1.14.1/shims/form-core.js")
        .headers(Header.header)
        .check(status.is(200))
    )

  val validation: ChainBuilder =
    exec(
      http("form-validation.js")
        .get("/vendor/webshim-1.14.1/shims/form-validation.js")
        .headers(Header.header)
        .check(status.is(200))
    )
}
