package utils;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
private static ThreadLocal<WebDriver> driver=new ThreadLocal<>();
	
	/*public static void initdriver()
	{
		WebDriverManager.chromedriver().setup();
		  driver=new ChromeDriver();
	}*/
	public static WebDriver getdriver() throws IOException
	{
		if(driver.get()==null) {
			String browser=Configreader.getkey("browser");
			if(browser.equalsIgnoreCase("chrome"))
			{
			WebDriverManager.chromedriver().setup();
			   ChromeOptions options = new ChromeOptions();
			// 🔹 Enable headless in CI
	            if (isHeadless()) {
	                options.addArguments("--headless=new");
	                options.addArguments("--no-sandbox");
	                options.addArguments("--disable-dev-shm-usage");
	            }
		driver.set(new ChromeDriver(options));
		driver.get().manage().window().maximize();
		driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));}}
		return driver.get();
	}
	 private static boolean isHeadless() {
	        return Boolean.parseBoolean(
	                System.getProperty("headless", "false")
	        );
	    }
	public static void quitdriver()
	{
		driver.get().quit();
		driver.remove();
		
	}
}

