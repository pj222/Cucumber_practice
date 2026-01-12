package hooks;

import java.io.IOException;

import com.aventstack.extentreports.ExtentTest;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.DriverFactory;
import utils.ExtentManager;
import utils.Screenshot;


public class Hooks {
	
public static ExtentTest test;
@Before
public void setup(Scenario scenario) throws IOException {
	DriverFactory.getdriver();
	test=ExtentManager.GetExtentReports().createTest(scenario.getName());
}
@After
public void teardown(Scenario scenario) throws IOException
{
	if(scenario.isFailed())
	{String screenshotpath=Screenshot.takescreenshot(scenario.getName());
		test.fail("scenario failed").addScreenCaptureFromPath(screenshotpath);}
		else {
			test.pass("scenario passed");
	}
	DriverFactory.quitdriver();
	ExtentManager.GetExtentReports().flush();
}
}
