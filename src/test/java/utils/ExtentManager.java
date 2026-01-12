package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
 public static ExtentReports extent;
  public static ExtentReports GetExtentReports() {
	  if(extent==null) {
		  
	  
		  ExtentSparkReporter spark=new ExtentSparkReporter("target/extentreport.html");
	  
	  extent=new ExtentReports();
	  extent.attachReporter(spark);}
	  return extent;
	  }
  }
