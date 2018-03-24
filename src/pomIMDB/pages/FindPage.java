package pomIMDB.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FindPage {
	WebDriver driver;
	WebDriverWait waitFindPage;

	public FindPage(WebDriver driver) {
		this.driver = driver;
		waitFindPage = new WebDriverWait(driver,15);
	}

	public void moreMatches(String moreMatchesLink) {
		WebElement linkToClick = waitFindPage.until(ExpectedConditions.presenceOfElementLocated(By.linkText(moreMatchesLink)));
		linkToClick.click();
	}

	public void locateAndOpen(String sequelName, String movieYear) {
		waitFindPage.until(ExpectedConditions.presenceOfElementLocated(By.className("findHeader")));
		
		List <WebElement> moviesList = waitFindPage.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("findResult")));
		
		WebElement correctElement = null;

		
		for(WebElement currentElem: moviesList) {
			if(currentElem.getText().contains(sequelName) && currentElem.getText().contains(movieYear)) {
				correctElement = currentElem;
				break;
			}
		}
		WebElement correctLink = correctElement.findElement(By.partialLinkText(sequelName));
		
		correctLink.click();		
	}
}