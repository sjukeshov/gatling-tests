package resources.webperformance

import config.Header
import io.gatling.core.Predef._
import io.gatling.core.structure.ChainBuilder
import io.gatling.http.Predef._

object MainPage {
  val header: Map[String, String] = Map(
    "Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8",
    "Accept-Encoding" -> "gzip, deflate, br",
    "Accept-Language" -> "en,ru;q=0.9",
    "Pragma" -> "no-cache")

  val mainPage: ChainBuilder =
    exec(
      http("Main Page")
        .get("/")
        .headers(header)
        .check(status.is(200))
    )
}
