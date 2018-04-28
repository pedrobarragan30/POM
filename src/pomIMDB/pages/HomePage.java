package pomIMDB.pages;

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

	public void searchMovie(String movieName) {
		WebElement searchInput = waitHomePage.until(ExpectedConditions.presenceOfElementLocated(By.id("navbar-query")));
		searchInput.clear();
		searchInput.sendKeys(movieName);
		
		WebElement searchButton = waitHomePage.until(ExpectedConditions.presenceOfElementLocated(By.id("navbar-submit-button")));
		searchButton = waitHomePage.until(ExpectedConditions.elementToBeClickable(By.id("navbar-submit-button")));
		searchButton.click();
	}
}