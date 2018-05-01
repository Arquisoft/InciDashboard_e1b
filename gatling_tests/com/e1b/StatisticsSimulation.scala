
import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class StatisticsSimulation extends Simulation {

	val httpProtocol = http
		.baseURL("http://localhost:8092")
		.inferHtmlResources()
		.acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
		.acceptEncodingHeader("gzip, deflate")
		.acceptLanguageHeader("es-AR,es;q=0.8,en-US;q=0.5,en;q=0.3")
		.userAgentHeader("Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:46.0) Gecko/20100101 Firefox/46.0")

	val headers_1 = Map("Accept" -> "text/css,*/*;q=0.1")



	val scn = scenario("StatisticsSimulation")
		.exec(http("request_0")
			.post("/login")
			.formParam("username", "entidad2")
			.formParam("password", "123456")
			.formParam("${_csrf.parameterName}", "${_csrf.token}")
			.resources(http("request_1")
			.get("/css/custom.css")
			.headers(headers_1)))
		.pause(1)
		.exec(http("request_2")
			.get("/favicon.ico")
			.resources(http("request_3")
			.get("/incidencias/statistics"),
            http("request_4")
			.get("/css/custom.css")
			.headers(headers_1)))
		.pause(1)
		.exec(http("request_5")
			.get("/favicon.ico"))
		.pause(1)
		.exec(http("request_6")
			.get("/logout")
			.resources(http("request_7")
			.get("/css/custom.css")
			.headers(headers_1),
            http("request_8")
			.get("/favicon.ico")))

	setUp(scn.inject(rampUsers(10) over(5 seconds))).protocols(httpProtocol)
}