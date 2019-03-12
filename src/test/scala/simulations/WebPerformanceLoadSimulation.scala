package simulations

import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder
import io.gatling.http.Predef._
import io.gatling.http.protocol.HttpProtocolBuilder

import scala.concurrent.duration._
import scala.language.postfixOps

import resources.webperformance._
/**
	* This simulation runs load test with 1000 concurrent users during 15 seconds for webperformance.com website main page
	*/
class WebPerformanceLoadSimulation extends Simulation {

	val httpProtocol: HttpProtocolBuilder = http
		.baseUrl("https://www.webperformance.com")
		.inferHtmlResources()
		.userAgentHeader("Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.109 Safari/537.36")

	val scn: ScenarioBuilder = scenario("opening main page with resources").
		exec(MainPage.mainPage,
			JS.modernizr,JS.jquery,JS.polyfiller,JS.common,JS.home,JS.core,JS.validation,
			Images.tel, Images.email,Images.svg,
			CSS.shim)

	setUp(scn.inject(constantUsersPerSec(1000) during (15 seconds)).protocols(httpProtocol))
		.assertions(global.responseTime.max.lt(6000))
		.assertions(forAll.failedRequests.percent.lte(10))
}