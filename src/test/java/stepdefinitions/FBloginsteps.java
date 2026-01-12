package stepdefinitions;

import utils.Configreader;
import utils.DriverFactory;
import pages.FBlogin;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FBloginsteps {
	WebDriver driver;
    FBlogin f;
	
	@Given("user is on the FB login page")
	public void user_is_on_the_fb_login_page() throws IOException {
    
    driver=DriverFactory.getdriver();
    String env=Configreader.getkey("env");
    String url=Configreader.getkey(env+".url");
    f=new FBlogin(driver);
    driver.get(url);
    driver.manage().window().maximize();
	}

	@When("I put username")
	public void i_put_username() {
	    f.enteruser("hello");
	}

	@When("I put pwd")
	public void i_put_pwd() {
	   f.enterpwd("pall");
	}

	@When("click login button")
	public void click_login_button() {
	  f.clicklogin();  
	}

	@Then("FB home page opens")
	public void fb_home_page_opens() {
	    System.out.println("page opens");
	}

	@Then("correct username is dispalyed")
	public void correct_username_is_dispalyed() {
		 System.out.println("name displayed");
		// Assert.assertEquals(1, 0);
	}
	

@When("I put {string} and {string}")
public void i_put_and(String string, String string2) {
    // Write code here that turns the phrase above into concrete actions
	f.enteruser(string);
	f.enterpwd(string2);
	
}

@Then("Error appears")
public void error_appears() {
	f.geterrormsg();
   System.out.println("wrong user and pwd");
}

	



}


