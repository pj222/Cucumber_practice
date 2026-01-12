package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.testng.Assert;

public class FBlogin {
 WebDriver driver;
	
	
	public FBlogin(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(id="email")
	WebElement username;
	
	@FindBy(name="pass")
	WebElement psd;
	
	@FindBy(name="login")
	WebElement loginbtn;
	
	@FindBy(xpath="//*[@class='_9ay7']")
	WebElement err;
	
	public void enteruser(String user) {
		username.sendKeys(user);
	}
	public void enterpwd(String pwd) {
		psd.sendKeys(pwd);
	}
	
	public void clicklogin() {
		loginbtn.click();
	}
	public void login(String user,String pass)
	{
		username.sendKeys(user);
		psd.sendKeys(pass);
		loginbtn.click();
	}
	public void geterrormsg()
	{
		String errormsg=err.getText();
		System.out.println(errormsg);
		Assert.assertEquals("test", errormsg);

		
	}


}
