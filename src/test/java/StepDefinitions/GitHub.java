package StepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;
import com.aventstack.extentreports.gherkin.model.Feature;
import com.aventstack.extentreports.gherkin.model.Scenario;
import Listeners.ExtentReportListener;
import Pages.PageHomeTitle;
import Utility.Constants;
import Utility.Log;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class GitHub extends ExtentReportListener {

	WebDriver driver;
	PageHomeTitle page;
	Common_Steps common_Steps;

	@Test
	@Given("check the Chrome browser is open")
	public void check_the_chrome_browser_is_open() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();


		ExtentTest logInfo = null;
		try {

			test = extent.createTest(Feature.class, "GitHub Feature");
			test = test.createNode(Scenario.class, "Scenario GitHub");
			logInfo = test.createNode(new GherkinKeyword("Given"), "check the Chrome browser is open");
			logInfo.pass("Chrome was opened ...");
			
			Log.info("First step of test");

		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL", driver, logInfo, e);

		}

		
	}

	@Test
	@When("navigate to Wikipedia home page")
	public void navigate_to_git_hub_home_page() {

		ExtentTest logInfo = null;
		try {

			logInfo = test.createNode(new GherkinKeyword("When"), "navigate to Wikipedia home page");
			logInfo.pass("Navigate to Wikipedia ...");

		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL", driver, logInfo, e);

		}

		driver.get(Constants.URL_GIT_HUB);

	}

	@Test
	@Then("validate heading text")
	public void validate_heading_text() {

		ExtentTest logInfo = null;
		try {

			logInfo = test.createNode(new GherkinKeyword("Then"), "validate heading text");
			logInfo.pass("Validate the text...");

			System.out.print("validate heading text....");
			page = new PageHomeTitle(driver);
			page.navigatingToTextField();
			Thread.sleep(5000);
			page.validateHeader();
			Thread.sleep(5000);

		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL", driver, logInfo, e);

		}

		driver.close();
	}

}
//logInfo.fail("Failed Test Screenshot",
//MediaEntityBuilder.createScreenCaptureFromPath(captureScreenShot(driver)).build());

//logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
