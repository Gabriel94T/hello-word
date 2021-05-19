package StepDefinitions;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import Pages.PageHomeTitle;
import Pages.PageLogin;
import Utility.Constants;
import Utility.ExcelReader;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class LoginTest {

	WebDriver driver;
	PageLogin login;
	PageHomeTitle page;
	Common_Steps common_steps;



	@Given("browser is open")
	public void browser_is_open() {

		driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	@And("user is on example login page")
	public void user_is_on_google_login_page() {

		driver.get(Constants.URL_EXAMPLE_TEST_PROJECT);

	}

	@When("user enters {string} and {int}")
	public void user_enters(String Login, Integer RowNumber)
			throws InterruptedException, InvalidFormatException, IOException {

		ExcelReader reader = new ExcelReader();
		List<Map<String, String>> testData = reader
				.getData("C:\\Users\\santvina\\eclipse-workspace\\BDDFramework3.0\\automation.xlsx", Login);

		String dataUser = testData.get(RowNumber).get("username");
		String dataPassword = testData.get(RowNumber).get("password");

		login = new PageLogin(driver);
		login.navigateToForm();

		login.enterUsername(dataUser);
		login.enterPassword(dataPassword);

		System.out.println("User Name :" + dataUser);
		System.out.println("Password :" + dataPassword);

	}

	@And("user click on login button and fill out the form")
	public void user_click_on_login_button() throws InterruptedException, IOException, InvalidFormatException {

		login.clickLogin();

		driver.findElement(By.id("country")).sendKeys("Ireland");
		driver.findElement(By.id("address")).sendKeys("12 Rialto Dublin 8");
		driver.findElement(By.id("email")).sendKeys("greg@gmail.com");
		driver.findElement(By.id("phone")).sendKeys("0892467854");

		login.clickSave();
		login.clickLogout();

	}

	@Then("user is navigate to home page")
	public void user_is_navigate_to_home_page() {
		driver.close();
	}

}
