package StepDefinitions;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.model.Test;

import Pages.PageHomeTitle;
import Pages.ReportHtml;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GitHub {

	public static WebDriver driver;
	PageHomeTitle page;
	ReportHtml report;

	@Before
	public void onSetup() {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\gbujnows\\git\\CucumberJavaTest\\Cucumber.Java\\src\\test\\resources\\Drivers\\chromedriver.exe");

		
	
	}

	@Given("check the Chrome browser is open")
	public void check_the_chrome_browser_is_open() {

		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		
	}

	@When("navigate to Wikipedia home page")
	public void navigate_to_git_hub_home_page() {

		driver.get("https://en.wikipedia.org/wiki/GitHub");
		
		
	}

	@Then("validate heading text")
	public void validate_heading_text() {

		System.out.print("validate heading text....");
		page = new PageHomeTitle(driver);
		page.navigatingToTextField();
		page.validateHeader();

		driver.close();
	}
	
	  @After public void tearDown() throws IOException {
	  
	  
	  report = new ReportHtml(driver); report.htmlReport("GitHub Test",
	  "Validate header");
	  
	  
	  
	  }
	  
	 

	
	
}
