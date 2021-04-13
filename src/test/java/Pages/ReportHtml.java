package Pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

class ReportHtml {

	WebDriver driver;
	ExtentTest test;

	public ReportHtml(WebDriver driver) {

		this.driver = driver;

	}
	
	 public ReportHtml(ExtentTest test) {
	
		 this.test = test;
		 
	}

	public void htmlReport(String testName, String testDescription) throws IOException {
		String path = "C:/Users/gbujnows/eclipse-workspace/Cucumber.Java3/target/htmlreport.html";
		ExtentHtmlReporter htmlreporter = new ExtentHtmlReporter(path);
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(htmlreporter);
		ExtentTest test = extent.createTest(testName, testDescription);
		test.log(Status.INFO, testDescription);
		test.log(Status.PASS, "Test Passed");
		test.pass(testName, null);
		extent.flush();

	}

	public void testPass() {

		test.pass("Test Passed", null);

	}

	public void testFailed() throws IOException {

		test.fail("Test Failed ", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());

	}
	
	public void testInfo(String info) {
		
		test.log(Status.INFO, info);
		
		
	}

}
