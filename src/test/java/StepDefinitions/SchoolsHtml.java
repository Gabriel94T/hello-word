package StepDefinitions;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import Pages.PageHomeTitle;
import Pages.ReportHtml;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SchoolsHtml {

	public static WebDriver driver;
	PageHomeTitle page;
	ReportHtml report;

	@Before
	public void onSetup() {

		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\gbujnows\\git\\CucumberJavaTest\\Cucumber.Java\\src\\test\\resources\\Drivers\\geckodriver.exe");

		
		
		}

	@Given("check the Firefox browser is open")
	public void check_the_firefox_browser_is_open() {

		driver = new FirefoxDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	

	}

	@When("navigate to 3schools home page")
	public void navigate_to_3schools_home_page() {

		driver.get("https://www.w3schools.com/html/default.asp");

	}

	@Then("validate title text")
	public void validate_title_text() {

		
		page = new PageHomeTitle(driver);
		System.out.println("Getting the title...");
		page.getTitle();
		System.out.println("Validating title......");
		page.validateTitle();

		
		driver.close();

		

	}
	
	  @After public void tearDown() throws IOException {
	  
	  
	  report = new ReportHtml(driver); report.htmlReport("Schools",
	  "Validate Title");
	  
	  
	  
	  }
	 

	

	
	
	

}
