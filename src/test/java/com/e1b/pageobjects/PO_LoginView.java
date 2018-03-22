package com.e1b.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PO_LoginView {
	
	public static void fillForm(WebDriver driver, String string, String string2) {
		WebElement dni = driver.findElement(By.name("username"));
		dni.click();
		dni.clear();
		dni.sendKeys(string);
		WebElement password = driver.findElement(By.name("password"));
		password.click();
		password.clear();
		password.sendKeys(string2);
		//Pulsar el boton de Alta.
		By boton = By.className("btn");
		driver.findElement(boton).click();
}

}
