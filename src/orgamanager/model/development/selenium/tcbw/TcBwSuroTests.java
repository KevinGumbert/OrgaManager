package orgamanager.model.development.selenium.tcbw;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TcBwSuroTests {

	private WebDriver driver;
	private String baseUrl = "http://www.tc-blauweiss-suro.de/";
	
	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		driver.get(baseUrl);
	}
	
	@Test
	public void testIndex(){
		String cssSelectorString = "div#content h1";
		WebElement contentH1 = driver.findElement(By.cssSelector(cssSelectorString));
		String act = contentH1.getText();
		String exp = "Herzlich Willkommen";
		assertEquals("TcBwSuroTests.testIndex()", exp, act);
	}
		
	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
	
}
