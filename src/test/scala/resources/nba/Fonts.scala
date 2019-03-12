package resources.nba

import config.Header
import io.gatling.core.Predef._
import io.gatling.core.structure.ChainBuilder
import io.gatling.http.Predef._

object Fonts {
  val ttf: ChainBuilder =
    exec(
      http("Flama-Medium.ttf")
        .get("/themes/custom/league/assets/fonts/Flama-Medium.ttf")
        .headers(Header.header)
        .check(status.is(200))
    )
}
