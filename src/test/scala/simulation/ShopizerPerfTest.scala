package simulation

import config.BaseHelpers._
import io.gatling.core.Predef._
import scenarios.ShopizerPerfTest.scnShopizerPerfTest

class ShopizerPerfTest extends Simulation {

  //to start simulation: mvn gatling:test
  //to start simulation and clear previous results: mvn clean gatling:test

  //to start simulation and clear previous results and pass parameter: mvn clean gatling:test -DUsers=20
  //setUp(
    //scnShopizerPerfTest.inject(atOnceUsers(System.getProperty("Users","1").toInt))
  //).protocols(httpProtocol)

  //to start simulation and clear previous results and pass both parameters: mvn clean gatling:test -Dusers=100 -Dramp=60
    setUp(
  scnShopizerPerfTest.inject(rampUsers(System.getProperty("users","1500").toInt).during(System.getProperty("ramp","300").toInt))
  ).protocols(httpProtocol)

  //to start simulation and clear previous results and use both parameters from BaseHelper: mvn clean gatling:test
  //setUp(
  //scnShopizerPerfTest.inject(constantConcurrentUsers(users).during(ramp))
  //).protocols(httpProtocol)

}
