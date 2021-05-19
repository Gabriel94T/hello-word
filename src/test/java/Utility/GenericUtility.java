package Utility;

import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//import com.sun.org.apache.bcel.internal.generic.Select;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class GenericUtility {
	
	public WebDriver driver;
	
	public GenericUtility(WebDriver webDriver) {
		//WebDriverManager.chromedriver().setup();
		//driver = new ChromeDriver()
		this.driver = webDriver;
	}
	
	public GenericUtility() {
		
	}

	public void goToUrl(String url) {
		
		driver.get(url);
		
	}
	
	
	public String getTitileOfPage() {
		return driver.getTitle();
	}
	
	public String getElementText(By element) {
		return driver.findElement(element).getText();
		
	}
	public void LoginFunctionality(){
		
	}
	public void ClickingonCheckboxesInThePage() {
		
	}
	public void DropdownFunctionalityOfThePage() {
		
	}
	public void NavigateToNextPage () {
		
		
	//***************************************	
		
	}
	public void setText(By element ,String text) {
		driver.findElement(element).sendKeys(text);
		
		
	}
	public void clearText(By element){
	driver.findElement(element).clear();
	}
	//public void verifyElementPresent() {
		
	
	
	protected boolean isElementPresent(By by){
        try{
            driver.findElement(by);
            return true;
        }
        catch(NoSuchElementException e){
            return false;
        }
    }
		
	//}
public void verifyDropDownContent(By locator,int index) {
	
//Select select = new Select(getElement(locator));
//select.selectByIndex(index);
}
public void ElementVisible(){
	if( driver.findElement(By.cssSelector("a > font")).isDisplayed()){
		System.out.println("Element is Visible");
		}else{
		System.out.println("Element is InVisible");
		}
	
}
public void dynamicWait() {
	
	
}
public void  bringFocusToElement() {
	
}
public void takeScreenshot() throws IOException {
	File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	String currentDir = System.getProperty("user.dir");
	FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
}
public void quite() {
	driver.quit();
}
public void FolderCreation() {
	
}
public void cleanup() {
	
	
}
}
