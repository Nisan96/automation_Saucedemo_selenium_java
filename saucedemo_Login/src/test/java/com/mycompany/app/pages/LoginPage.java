package com.mycompany.app.pages;

import org.openqa.selenium.Keys;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginPage {
	protected WebDriver driver;
    protected WebDriverWait wait;
    
 // Locators using @FindBy annotation
    @FindBy(id = "user-name")
    private WebElement username_field;
    
    @FindBy(id = "password")
    private WebElement password_field;
	
	@FindBy(id = "login-button")
    private WebElement loginButton;
	
	@FindBy(xpath = "/html/body/div/div/div[2]/div[1]/div/div/form/div[3]")
	private WebElement errorMessage;
	
	@FindBy(xpath = "/html/body/div/div/div[2]/div[1]/div/div/form/div[3]")
	private WebElement lockedMessage;
	
	@FindBy(xpath = "/html/body/div/div/div/div[1]/div[1]/div[2]/div")
	private WebElement swaglabs_logo1;
	
	@FindBy(xpath = "/html/body/div/div/div[1]")
	private WebElement swaglabs_logo;
    
 // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }
    
 // Page methods
    public void navigateTo() {
        driver.get("https://www.saucedemo.com/");
        wait.until(ExpectedConditions.titleContains("Swag Labs"));
    }
    
    public String getPageTitle() {
        return driver.getTitle();
    }
    
    // enter username and password
    public void enterLoginKeys(String username, String Password) {
        wait.until(ExpectedConditions.elementToBeClickable(username_field));
        username_field.clear();
        username_field.sendKeys(username);
		wait.until(ExpectedConditions.elementToBeClickable(password_field));
		password_field.clear();
		password_field.sendKeys(Password);
        System.out.println("✓ Entered Login credentials: " + username + Password);
    }
    
 // click login button
    public void clickbtn() {
        loginButton.click();
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Welcome']");
    }
    
    public String logo_text() {
    	wait.until(ExpectedConditions.visibilityOf(swaglabs_logo));
    	return swaglabs_logo.getText();
    }
    
    public String logo_text1() {
    	wait.until(ExpectedConditions.visibilityOf(swaglabs_logo1));
    	return swaglabs_logo1.getText();
    }
    
    public String getLockedMessage() {
    	wait.until(ExpectedConditions.visibilityOf(lockedMessage));
    	return lockedMessage.getText();
    }
    
    public String getErrorMessage() {
    	wait.until(ExpectedConditions.visibilityOf(errorMessage));
    	return errorMessage.getText();
    }

}
