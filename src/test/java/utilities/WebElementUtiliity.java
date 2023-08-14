package utilities;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import tests.BaseClass;

public class WebElementUtiliity {
	
	static WebDriver driver = BaseClass.driver;

	public static void clickOnElement(WebElement elementToClick) {
		JavascriptExecutor js = (JavascriptExecutor) driver ;
		try {
			WebElementUtiliity.isElementLoaded(elementToClick).click();
		} catch(Exception e) {
			js.executeScript("argument[0].click", elementToClick);
		}
	}
	
	public static void enterTextInTB(WebElement testBoxToSet, String text) {
		JavascriptExecutor js = (JavascriptExecutor) driver ;
		try {
			WebElementUtiliity.isElementLoaded(testBoxToSet).clear();
			testBoxToSet.sendKeys(text);
		} catch(Exception e) {
			js.executeScript("argument[0].value='"+text+"';", testBoxToSet);
		}
	}
	
	public static WebElement isElementLoaded(WebElement elementToLoaded) {
		Wait<WebDriver> wait = new FluentWait<>(driver)
				.withTimeout(Duration.ofSeconds(20))
				.pollingEvery(Duration.ofMillis(5))
				.ignoring(ElementNotInteractableException.class)
				.ignoring(NoSuchElementException.class)
				.ignoring(TimeoutException.class)
				.ignoring(ElementClickInterceptedException.class)
				.ignoring(StaleElementReferenceException.class);
		wait.until(ExpectedConditions.visibilityOf(elementToLoaded));
		return elementToLoaded;
	}
}
