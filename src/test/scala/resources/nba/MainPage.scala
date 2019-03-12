package resources.nba

import config.Header
import io.gatling.core.Predef._
import io.gatling.core.structure.ChainBuilder
import io.gatling.http.Predef._

object MainPage {
  val redirectPath: ChainBuilder =
    exec(
      http("Promo page")
        .get("/gr/reflectIntl.html?gr=promouw&page=www&dur=1")
        .headers(Header.header)
        .check(status.is(200))
    )
  val rootPath: ChainBuilder =
    exec(
      http("Main Page")
        .get("/")
        .headers(Header.header)
        .check(status.is(200))
    )
}
