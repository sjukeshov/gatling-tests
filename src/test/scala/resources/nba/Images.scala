package resources.nba

import config.Header
import io.gatling.core.Predef._
import io.gatling.core.structure.ChainBuilder
import io.gatling.http.Predef._

object Images {
    val background: ChainBuilder =
      exec(
        http("Background image")
          .get("/themes/custom/league/assets/images/mynba/background.png")
          .headers(Header.header)
          .check(status.is(200))
      )
    val calendar: ChainBuilder =
      exec(
        http("calendar image")
          .get("/themes/custom/league/assets/images/calendar_lsaquo_light.png")
          .headers(Header.header)
          .check(status.is(200))
      )
  }
