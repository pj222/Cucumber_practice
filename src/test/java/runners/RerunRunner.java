package runners;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="@target/failed_scenarios.txt",
		  glue = {"stepdefinitions", "hooks"})
public class RerunRunner {

}
