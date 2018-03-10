package pom.pages;

import org.openqa.selenium.WebDriver;

public class HomePage {
	WebDriver driver;

	public HomePage(WebDriver driver) {
			this.driver = driver;
		// TODO Auto-generated constructor stub
		System.out.println("HomePage Constructor");
	}

	public void search(String searchTerm1) {
		// TODO Auto-generated method stub
		System.out.println("HomePage Search");
	}

}
