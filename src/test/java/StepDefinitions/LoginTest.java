package StepDefinitions;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.aventstack.extentreports.ExtentTest;
import Pages.PageHomeTitle;
import Pages.PageLogin;
import Pages.ReportHtml;
import Utility.ExcelReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginTest {

	public static WebDriver driver;
	PageLogin login;
	PageHomeTitle page;
	ReportHtml report;

	@Before
	public void onSetup() {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\gbujnows\\git\\CucumberJavaTest\\Cucumber.Java\\src\\test\\resources\\Drivers\\chromedriver.exe");

	}

	@Given("browser is open")
	public void browser_is_open() {

		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	@And("user is on example login page")
	public void user_is_on_google_login_page() {

		driver.get("https://example.testproject.io/web/");

	}

	@When("user enters {string} and {int}")
	public void user_enters(String sheetName, Integer RowNumber)
			throws InterruptedException, InvalidFormatException, IOException {

		ExcelReader reader = new ExcelReader();
		List<Map<String, String>> testData = reader
				.getData("C:\\Users\\gbujnows\\eclipse-workspace\\Cucumber.Java3\\automation.xlsx", sheetName);

		String dataUser = testData.get(RowNumber).get("username");
		String dataPassword = testData.get(RowNumber).get("password");

		login = new PageLogin(driver);
		login.navigateToForm();
		login.enterUsername(dataUser);
		login.enterPassword(dataPassword);

		Thread.sleep(50);

	}

	@And("user click on login button and fill out the form")
	public void user_click_on_login_button() throws InterruptedException {

		login.clickLogin();

		driver.findElement(By.id("country")).sendKeys("Ireland");
		driver.findElement(By.id("address")).sendKeys("12 Rialto Street Dublin");
		driver.findElement(By.id("email")).sendKeys("greg@gmail.com");
		driver.findElement(By.id("phone")).sendKeys("0987556428");

		login.clickSave();
		login.clickLogout();
		Thread.sleep(50);

	}

	@Then("user is navigate to home page")
	public void user_is_navigate_to_home_page() {
		driver.close();
	}
	
	
	  @After public void tearDown() throws IOException {
	  
	  
	  report = new ReportHtml(driver);
	  report.htmlReport("Login Test",
	  "functionality test"); 
	
	  
	  
	  }
	  
	 

}
