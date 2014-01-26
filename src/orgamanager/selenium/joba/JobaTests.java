package orgamanager.selenium.joba;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.internal.seleniumemulation.WaitForPageToLoad;

public class JobaTests {

	// Selenium-Version 2.39
	private WebDriver driver;
	private String baseUrl = "http://devjoba.jochen-bauer.net/";

	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.get(baseUrl);
	}

	@Test
	public void testIndex() { // done
		String cssSelectorString = "h1";
		WebElement contentH1 = driver.findElement(By.cssSelector(cssSelectorString));
		String act = contentH1.getText();
		String exp = "Index";
		assertEquals("JobaTests.testIndex()", exp, act);
	}
	
	@Test
	public void testLogin(){ // TODO
		fail("Not yet implemented!");
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

}

