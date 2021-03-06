package pomIMDB.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TitlePage {
	WebDriver driver;
	WebDriverWait waitTitlePage;
	

	public TitlePage(WebDriver driver) {
		this.driver = driver;
		waitTitlePage = new WebDriverWait(driver,15);
	}

	public void validateTitle(String sequelName, String movieYear) {
		WebElement pageTitle = waitTitlePage.until(ExpectedConditions.presenceOfElementLocated(By.className("title_wrapper")));
		
		if(pageTitle.getText().contains(sequelName) && pageTitle.getText().contains(movieYear)) {
			System.out.println("TITLE PAGE: El titulo de la pelicula es " + sequelName + " y fue exhibida en el a�o " + movieYear);
		}
	}

	public void openCast(String fullCastLink) {
		WebElement fullCast = waitTitlePage.until(ExpectedConditions.presenceOfElementLocated(By.linkText(fullCastLink)));
		waitTitlePage.until(ExpectedConditions.elementToBeClickable(By.linkText(fullCastLink)));
		
		fullCast.click();
	}
}