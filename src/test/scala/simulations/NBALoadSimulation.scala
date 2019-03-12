package simulations

import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder
import io.gatling.http.Predef._
import io.gatling.http.protocol.HttpProtocolBuilder

import scala.concurrent.duration._
import scala.language.postfixOps

import resources.nba._

/**
  * This simulation runs load test with 1000 concurrent users during 15 seconds for NBA.com website main page
  */
class NBALoadSimulation extends Simulation {

  val httpProtocol: HttpProtocolBuilder = http
    .baseUrl("https://nba.com")
    .acceptEncodingHeader("gzip, deflate")
    .acceptLanguageHeader("ru-RU,ru;q=0.8,en-US;q=0.5,en;q=0.3")
    .userAgentHeader("Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.102 Safari/537.36")

  val scn: ScenarioBuilder = scenario("opening main page with resources").
    exec(MainPage.rootPath,
      CSS.cvp, CSS.slick,CSS.contingency,
      JS.min,JS.jquery,JS.contingency,
      Images.background, Images.calendar,
      Fonts.ttf)

  setUp(scn.inject(constantUsersPerSec(1000) during (15 seconds)).protocols(httpProtocol))
    .assertions(global.responseTime.max.lt(6000))
    .assertions(forAll.failedRequests.percent.lte(10))
}
