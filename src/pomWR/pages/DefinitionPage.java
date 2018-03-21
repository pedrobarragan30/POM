package pomWR.pages;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DefinitionPage {
	WebDriver driver;
	WebDriverWait waitDefinitionPage;

	public DefinitionPage(WebDriver driver) {
		this.driver = driver;
		waitDefinitionPage = new WebDriverWait(driver,15);
	}

	public void search(String searchTerm2) {
		WebElement searchField = waitDefinitionPage.until(ExpectedConditions.presenceOfElementLocated(By.id("si")));
		searchField.clear();
		searchField.sendKeys(searchTerm2);
		
		
		WebElement submitButton = waitDefinitionPage.until(ExpectedConditions.presenceOfElementLocated(By.id("searchBtn")));
		submitButton = waitDefinitionPage.until(ExpectedConditions.elementToBeClickable(By.id("searchBtn")));
		submitButton.click();	
	}

	public void wrReverse() {
		WebElement tab = waitDefinitionPage.until(ExpectedConditions.presenceOfElementLocated((By.partialLinkText("WR Reverse"))));
		tab = waitDefinitionPage.until(ExpectedConditions.elementToBeClickable((By.partialLinkText("WR Reverse"))));
		
		tab.click();
	}

	public void SearchList(int numberOfElementToSearch) {
		WebElement linksTable = waitDefinitionPage.until(ExpectedConditions.presenceOfElementLocated((By.id("link"))));
		linksTable = waitDefinitionPage.until(ExpectedConditions.presenceOfElementLocated((By.id("link"))));
		List <WebElement> totalTerms = linksTable.findElements(By.xpath("//*[@id='link']/ul/li"));
		
		
		assertTrue(numberOfElementToSearch <= totalTerms.size());
		WebElement link = totalTerms.get(numberOfElementToSearch-1).findElement(By.tagName("a"));
		
		link = waitDefinitionPage.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText(link.getText())));
		link.click();
	}
}