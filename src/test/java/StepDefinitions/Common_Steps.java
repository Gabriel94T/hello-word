package StepDefinitions;

import org.openqa.selenium.WebDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Common_Steps {

	public static WebDriver driver;

	@Before
	public void setUp() {

		WebDriverManager.chromedriver().setup();
		WebDriverManager.firefoxdriver().setup();

		System.out.println("Global Before Hook Executed");
	
	}

	@After
	public void tearDown() {

		driver.quit();

	}

	public WebDriver getDriver() {

		return driver;

	}

}
