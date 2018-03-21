package com.e1b;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.e1b.pageobjects.PO_LoginView;
import com.e1b.pageobjects.PO_NavView;
import com.e1b.pageobjects.PO_View;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InciDashboardApplicationTests {
	
	//En Windows (Debe ser la versiÃ³n 46.0 y desactivar las actualizacioens automÃ¡ticas)):
		static String PathFirefox = "C:\\Users\\mario\\Desktop\\universidad\\Tercero\\Segundo Semestre\\Sistemas Distribuidos e Internet\\Selenium\\Firefox46.win\\FirefoxPortable.exe";
		//En MACOSX (Debe ser la versiÃ³n 46.0 y desactivar las actualizaciones automÃ¡ticas):
		//static String PathFirefox = "/Applications/Firefox.app/Contents/MacOS/firefox-bin";
		//ComÃºn a Windows y a MACOSX
		static WebDriver driver = getDriver(PathFirefox);
		static String URL = "http://localhost:8090";
			
		public static WebDriver getDriver(String PathFirefox) {
			//Firefox (VersiÃ³n 46.0) sin geckodriver para Selenium 2.x.
			System.setProperty("webdriver.firefox.bin",PathFirefox);
			WebDriver driver = new FirefoxDriver();
			return driver;
		}

			
		//Antes de cada prueba se navega al URL home de la aplicaciÃ³nn
		@Before
		public void setUp(){
			driver.navigate().to(URL);
		}
			
		//DespuÃ©s de cada prueba se borran las cookies del navegador
		@After
		public void tearDown(){
			driver.manage().deleteAllCookies();
		}

//		Inicio de sesion
		@Test
		public void TestLogin() {
			driver.navigate().to(URL+"/login");
			//Rellenamos el formulario
			PO_LoginView.fillForm(driver, "o1" , "123456" );
			//COmprobamos que entramos en la lista de los usuarios de la aplicacion
			PO_View.checkElement(driver, "text", "Dashboard");
			PO_NavView.clickOption(driver, "logout", "class", "btn btn-primary");
		}

}
