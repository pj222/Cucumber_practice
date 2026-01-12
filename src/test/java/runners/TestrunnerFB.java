package runners;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import retry.RetryListener;

		@CucumberOptions(
		features="src/test/resources/Features",
		glue= {"stepdefinitions","utils","hooks"},
		plugin={"pretty","html:target/cucmber.html",
				"rerun:target/failed_scenarios.txt"
		},
		monochrome=true
		)
		@Listeners(RetryListener.class)
public class TestrunnerFB extends AbstractTestNGCucumberTests {
	
	  @Override
	    @DataProvider(parallel = true)
	    public Object[][] scenarios() {
	        return super.scenarios();
	    }
}
