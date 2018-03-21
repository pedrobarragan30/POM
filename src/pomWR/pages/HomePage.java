package pomWR.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	WebDriver driver;
	WebDriverWait waitHomePage;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		waitHomePage = new WebDriverWait(driver,15);
	}

	public void search(String searchTerm1) {		
		WebElement searchField = waitHomePage.until(ExpectedConditions.presenceOfElementLocated(By.className("ac-input")));
		searchField.clear();
		searchField.sendKeys(searchTerm1);

		WebElement submitButton = waitHomePage.until(ExpectedConditions.presenceOfElementLocated(By.className("submit-button")));
		waitHomePage.until(ExpectedConditions.elementToBeClickable(By.className("submit-button")));
		submitButton.click();	
	}
}