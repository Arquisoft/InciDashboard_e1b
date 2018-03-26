package com.e1b;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.*;

import com.e1b.pageobjects.PO_HomeView;
import com.e1b.pageobjects.PO_LoginView;
import com.e1b.pageobjects.PO_NavView;
import com.e1b.pageobjects.PO_View;
import com.e1b.util.SeleniumUtils;


public class InciDashboardApplicationTests {
	
		static String PathFirefox = "C:\\Users\\Pablo\\Desktop\\Firefox46.win\\FirefoxPortable.exe";

		static WebDriver driver = getDriver(PathFirefox);
		static String URL = "http://localhost:8090";

		public static WebDriver getDriver(String PathFirefox) {
			System.setProperty("webdriver.firefox.bin", PathFirefox);
			WebDriver driver = new FirefoxDriver();
			return driver;
		}

		@Before
		public void setUp() {
			driver.navigate().to(URL);
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
			PO_HomeView.clickOption(driver, "login", "class", "btn btn-primary");
			PO_LoginView.fillForm(driver, "o1", "123456");
			PO_View.checkElement(driver, "text", "o1");
		}

		/**
		 * Comprueba que permite desconectarse de la aplicacion
		 */
		@Test
		public void TestLogout() {
			PO_HomeView.clickOption(driver, "login", "class", "btn btn-primary");
			PO_LoginView.fillForm(driver, "o1", "123456");
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
			PO_LoginView.fillForm(driver, "o1", "123456");
			List<WebElement> elementos = SeleniumUtils.EsperaCargaPagina(driver, "free", "//tbody/tr",
					PO_View.getTimeout());
			assertTrue(elementos.size() == 3);
			PO_HomeView.clickOption(driver, "logout", "class", "btn btn-primary");
			PO_View.checkElement(driver, "text", "Identificate");
		}
}
