package orgamanager.model.development.selenium.skp;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SkpTests {

	private WebDriver driver;
	private String baseUrl = "http://skp.jochen-bauer.net/";
	
	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		driver.get(baseUrl);
	}
	
	@Test
	public void testIndex(){ // done
		String cssSelectorString = "h1";
		WebElement contentH1 = driver.findElement(By.cssSelector(cssSelectorString));
		String act = contentH1.getText();
		String exp = "Willkommen bei der SKP Technik GmbH";
		assertEquals("SkpTests.testIndex()", exp, act);
	}
		
	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
	
}

