package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageHomeTitle {

	WebDriver driver;

	By head_txt = By.id("History");

	public PageHomeTitle(WebDriver driver) {

		this.driver = driver;

	}

	public void getTitle() {

		String title = driver.getTitle();
		System.out.println("Title : " + title);

	}

	public void validateTitle() {

		String title = driver.getTitle();
		Assert.assertEquals(title, "HTML Tutorial");

	}

	public void navigatingToTextField() {

		WebElement textField = driver.findElement(head_txt);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", textField);

	}

	public void validateHeader() {

		System.out.println("Validate header.....");
		String head = driver.findElement(head_txt).getText().trim();
		Assert.assertEquals(head, "History");

	}

}
