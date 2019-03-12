package resources.webperformance

import config.Header
import io.gatling.core.Predef._
import io.gatling.core.structure.ChainBuilder
import io.gatling.http.Predef._

object Images {
    val tel: ChainBuilder =
      exec(
        http("co-tel.png")
          .get("/images/common/co-tel.png")
          .headers(Header.header)
          .check(status.is(200))
      )
    val email: ChainBuilder =
      exec(
        http("co-email.png")
          .get("/images/common/co-email.png")
          .headers(Header.header)
          .check(status.is(200))
      )
    val svg: ChainBuilder =
      exec(
      http("icon-menu.svg")
        .get("/images/common/icon-menu.svg")
        .headers(Header.header)
        .check(status.is(200))
    )
  }
