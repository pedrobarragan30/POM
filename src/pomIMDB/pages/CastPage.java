package pomIMDB.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CastPage {
	WebDriver driver;
	WebDriverWait waitCastPage;

	public CastPage(WebDriver driver) {
		this.driver = driver;
		waitCastPage = new WebDriverWait(driver,15);
	}
	
	public void validateTitle(String sequelName, String movieYear) {
		WebElement pageTitle = waitCastPage.until(ExpectedConditions.presenceOfElementLocated(By.className("parent")));
		
		if(pageTitle.getText().contains(sequelName) && pageTitle.getText().contains(movieYear)) {
			System.out.println("CAST PAGE: El titulo de la pelicula es " + sequelName + " y fue exhibida en el año " + movieYear);
		}
	}
		
	public void validateActor_Role(String roleActor_1, String roleName_1, String roleActor_2, String roleName_2, String roleActor_3, String roleName_3) {
		String actor = null;
		String role = null;
		
		WebElement castListTable = waitCastPage.until(ExpectedConditions.presenceOfElementLocated(By.className("cast_list")));
		
		List <WebElement> totalRowCount = castListTable.findElements(By.xpath("//*[@class='cast_list']/tbody/tr"));

		int rowCounter = 1;
		for(WebElement currentRow:totalRowCount)
		{
		      List <WebElement> totalColCount = currentRow.findElements(By.xpath("td"));
		      int columnCounter = 1;
		      for(WebElement currentCol:totalColCount)
		      {
		    	  if(columnCounter == 2) {
		    		  actor = currentCol.getText();
		    	  }
		    	  
		    	  if(columnCounter == 4) {
		    		  role = currentCol.getText();
		    	  }
		    	  
		    	  if(columnCounter == 4) {
		    		  if((new String(actor).equals(roleActor_1)) && (new String(role).equals(roleName_1)))
		    		     System.out.println("Row: " + rowCounter + "     Actor: " + actor + "    Role: " + role);
		    		  if((new String(actor).equals(roleActor_2)) && (new String(role).equals(roleName_2)))
			    		     System.out.println("Row: " + rowCounter + "     Actor: " + actor + "    Role: " + role);
		    		  if((new String(actor).equals(roleActor_3)) && (new String(role).equals(roleName_3)))
			    		     System.out.println("Row: " + rowCounter + "     Actor: " + actor + "    Role: " + role);
			    	  actor = null;
			    	  role = null;
		    	  }
		    	  columnCounter = columnCounter + 1;
		       }
		      rowCounter = rowCounter + 1;
		 }		
	}
}