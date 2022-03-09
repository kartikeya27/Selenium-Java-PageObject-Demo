package com.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class LoginPage extends TestBase {

	// Page Factory -OR
	@FindBy(xpath = "//button[contains(text(),'Log In')]")
	WebElement loginLnk;

	@FindBy(id = "logEmailInput")
	WebElement emailInput;
	
	@FindBy(id = "password")
	WebElement passwordInput;
	
	@FindBy(css = "#AvasWidgetLoginSubmit")
	WebElement loginBtn;

	// Initializing the Page Objects:
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions:
	public void enterEmailAddress(String email) {
		emailInput.clear();
		emailInput.sendKeys(email);
	}

	public void enterPassword(String pwd) {
		passwordInput.clear();
		passwordInput.sendKeys(pwd);
	}
	
	public int verifyRows() {
		List<WebElement> rows = driver.findElements(By.xpath("//tbody//tr"));
		return rows.size();
	}

	public HomePage tapLogin(String email, String password) {
		enterEmailAddress(email);
		enterPassword(password);
		loginBtn.click();
		return new HomePage();
	}
}
