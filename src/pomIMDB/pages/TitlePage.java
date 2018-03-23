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
			System.out.println("El titulo de la pelicula tiene el titulo de " + sequelName + " y fue exhibida en el año " + movieYear);
		}

	}

	public void openCast() {
		// TODO Auto-generated method stub
		
	}

}
