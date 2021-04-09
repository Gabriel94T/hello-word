package Pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ReportHtml {
	
	WebDriver driver;
	ExtentTest test;
		
	
	public ReportHtml(WebDriver driver) {
		
		this.driver = driver;
		
	}
	
	
		
	public void htmlReport(String testName, String testDescription) throws IOException {
		
		
		ExtentHtmlReporter htmlreporter = new ExtentHtmlReporter("C:/Users/gbujnows/eclipse-workspace/Cucumber.Java3/target/htmlreport.html");		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(htmlreporter);
		ExtentTest test = extent.createTest(testName, testDescription);
		test.fail("Test Failed ",MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
		test.log(Status.INFO, testDescription);
		test.log(Status.PASS, "Test Passed");
		test.pass(testName, null);
		extent.flush();
		
		
		;
		
		
	}



	

	
	
	
	

}
