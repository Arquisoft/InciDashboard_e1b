package com.e1b;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import com.e1b.pageobjects.PO_HomeView;
import com.e1b.pageobjects.PO_LoginView;
import com.e1b.pageobjects.PO_View;
import com.e1b.util.SeleniumUtils;


public class InciDashboardApplicationTests {
	
//		static String PathFirefox = "C:\\Users\\Pablo\\Desktop\\Firefox46.win\\FirefoxPortable.exe";
//
//		static WebDriver driver = getDriver(PathFirefox);
//		static String URL = "http://localhost:8090";
//
//		public static WebDriver getDriver(String PathFirefox) {
//			System.setProperty("webdriver.firefox.bin", PathFirefox);
//			WebDriver driver = new FirefoxDriver();
//			return driver;
//		}
//
//		@Before
//		public void setUp() {
//			driver.navigate().to(URL);
//		}
	
	  private static WebDriver driver;
	  private String baseUrl;

	  @Before
	  public void setUp() throws Exception {
	    driver = new FirefoxDriver();
	    baseUrl = "http://localhost:8092";
	    driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
	  }

		@After
		public void tearDown() {
			driver.manage().deleteAllCookies();
		}

		@BeforeClass
		static public void begin() {
		}

		@AfterClass
		static public void end() {
			driver.quit();
		}

		/**
		 * Comprueba que permite iniciar sesion en la aplicacion
		 */
		@Test
		public void TestLogin() {
			driver.get(baseUrl + "/login");
			driver.findElement(By.id("username_input")).clear();
			driver.findElement(By.id("username_input")).sendKeys("o1");
			driver.findElement(By.id("password_input")).clear();
			driver.findElement(By.id("password_input")).sendKeys("123456");
			driver.findElement(By.id("login_btn")).click();
//			PO_LoginView.fillForm(driver, "o1", "123456");
//			PO_View.checkElement(driver, "text", "o1");
		}

		/**
		 * Comprueba que permite desconectarse de la aplicacion
		 */
		@Test
		public void TestLogout() {
			PO_HomeView.clickOption(driver, "login", "class", "btn btn-primary");
			driver.findElement(By.id("username_input")).clear();
			driver.findElement(By.id("username_input")).sendKeys("o1");
			driver.findElement(By.id("password_input")).clear();
			driver.findElement(By.id("password_input")).sendKeys("123456");
			driver.findElement(By.id("login_btn")).click();
			PO_View.checkElement(driver, "text", "o1");
			PO_HomeView.clickOption(driver, "logout", "class", "btn btn-primary");
			PO_View.checkElement(driver, "text", "Identificate");
		}
		
		/**
		 * Comprueba que se listan las incidencias que tiene asignadas el operario
		 */
		@Test
		public void TestListInci() {
			driver.navigate().to("http://localhost:8090/incidencias/list");
			driver.findElement(By.id("username_input")).clear();
			driver.findElement(By.id("username_input")).sendKeys("o1");
			driver.findElement(By.id("password_input")).clear();
			driver.findElement(By.id("password_input")).sendKeys("123456");
			driver.findElement(By.id("login_btn")).click();
			List<WebElement> elementos = SeleniumUtils.EsperaCargaPagina(driver, "free", "//tbody/tr",
					PO_View.getTimeout());
			assertTrue(elementos.size() == 3);
			PO_HomeView.clickOption(driver, "logout", "class", "btn btn-primary");
			PO_View.checkElement(driver, "text", "Identificate");
		}
		
//		@Test
//		  public void testUnioviTest3() throws Exception {
//		    driver.get("http://www.uniovi.es/");
//		    driver.findElement(By.id("cabecera_keywords")).clear();
//		    driver.findElement(By.id("cabecera_keywords")).sendKeys("rector");
//		    driver.findElement(By.id("cabecera_search")).click();
//		    assertEquals("Rector", driver.findElement(By.cssSelector("li.alt > div.resultado_contenido > span.titulo > span.highlight")).getText());
//		  }
}
