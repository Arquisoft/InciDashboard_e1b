package com.e1b.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PO_LoginView {

	static public void fillForm(WebDriver driver, String username, String passwordp) {
		WebElement dni = driver.findElement(By.id("username"));
		dni.click();
		dni.clear();
		dni.sendKeys(username);
		WebElement password = driver.findElement(By.id("password"));
		password.click();
		password.clear();
		password.sendKeys(passwordp); 
		// Pulsar el boton de Alta.
		By boton = By.id("btn_login");
		driver.findElement(boton).click();
	}
}
