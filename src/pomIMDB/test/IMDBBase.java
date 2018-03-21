package pomIMDB.test;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import pomIMDB.pages.CastPage;
import pomIMDB.pages.FindPage;
import pomIMDB.pages.HomePage;
import pomIMDB.pages.TitlePage;
import pomWR.pages.DefinitionPage;


public class IMDBBase {
	
	protected WebDriver driver;
	protected HomePage imdbHomePage;
	protected FindPage imdbFindPage;
	protected TitlePage imdbTitlePage;
	protected CastPage imdbCastPage;
	
	@Before
	public void setUp(String urlToOpen, String browserToUse) throws Exception {
		switch(browserToUse) {
		case "chrome":
			//System.setProperty("webdriver.chrome.driver", "C:\\test_automation\\drivers\\chromedriver.exe");
			
			ChromeOptions options = new ChromeOptions();
			options.addArguments("disable-infobars");
			options.addArguments("-disable-notifications");
			options.addArguments("--start-maximized");
			
			driver = new ChromeDriver(options);
			break;
		case "firefox":
			//System.setProperty("webdriver.gecko.driver", "C:\\test_automation\\drivers\\geckodriver.exe");
			
			driver = new FirefoxDriver();
			break;
		case "edge":
			//System.setProperty("webdriver.edge.driver, "C:\\test_automation\\drivers\\geckodriver.exe");
			
			driver = new EdgeDriver();
			break;
		//case "IE":
			//System.setProperty("webdriver.ie.driver", "C:\\test_automation\\drivers\\geckodriver.exe");
		//	
		//	  driver = new InternetExplorerDriver();
		//	  break;
		default:
			System.out.println("The Browser " + browserToUse + " is NOT supported");
		}
		
		driver.get(urlToOpen);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		


	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
}
