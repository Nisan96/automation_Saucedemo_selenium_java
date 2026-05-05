package com.mycompany.app.tests;

import com.mycompany.app.base.BaseTest;


import com.mycompany.app.pages.LoginPage;
import org.testng.annotations.BeforeMethod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.testng.annotations.Test;
import org.testng.Assert;

public class LoginTest extends BaseTest {
	
	private static final Logger log = LogManager.getLogger(LoginTest.class);
	
	@Test(priority = 1, groups = "validLogin", description = "Test Login with both valid credentials")
    public void login_both_valid() {
		String testName = "login_both_valid";
		
		// Create login page objects
        LoginPage login = new LoginPage(driver);
        login.navigateTo();
        
        // verify login page title
        try {
            Assert.assertEquals(login.getPageTitle(),"Swag Labs", "Login page Title mismatch");
        } 
        catch (AssertionError e) {
            // Custom failure handling
            takeScreenshot(testName);
            log.error("Assertion failed: {}", e.getMessage());
            throw e; // Re-throw to make test fail (optional)
        }
        
        // verify login page loaded
        try {
            Assert.assertEquals(login.logo_text(),"Swag Labs", "Login page Logo mismatch");
        } 
        catch (AssertionError e) {
            // Custom failure handling
        	takeScreenshot(testName);
            //System.out.println("Assertion failed: " + e.getMessage());
            log.error("Assertion failed: {}", e.getMessage());
            throw e; // Re-throw to make test fail (optional)
        }
        log.info("✓ Login page loaded");
        
        // enter credentials
        login.enterLoginKeys("standard_user","secret_sauce");
        login.clickbtn();
        
        // verify inventory page loaded
        try {
            Assert.assertEquals(login.logo_text1(),"Swag Labs", "inventory page Logo mismatch");
            takeScreenshot(testName);
        } 
        catch (AssertionError e) {
            // Custom failure handling
        	//takeScreenshot(testName);
            //System.out.println("Assertion failed: " + e.getMessage());
            log.error("Assertion failed: {}", e.getMessage());
            throw e; // Re-throw to make test fail (optional)
        }
        log.info("✓ inventory page loaded");
		
	}
	
	@Test(priority = 1, description = "Test Login with locked out username credentials")
    public void login_locked_user() {
		
	}
	
	@Test(priority = 1, description = "Test Login with username: problem_user")
    public void login_problem_user() {
		
	}
	
	@Test(priority = 1, description = "Test Login with performane glitch credentials")
    public void login_glitch_user() {
		
	}
	
	@Test(priority = 1, description = "Test Login with username: error_user")
    public void login_error_user() {
		
	}
	
	@Test(priority = 1, description = "Test Login with username: visual_user")
    public void login_visual_user() {
		
	}
	
	@Test(priority = 1, description = "Test Login with both invalid credentials")
    public void login_both_invalid() {
		
	}
	
	@Test(priority = 1, description = "Test Login with single invalid credentials")
    public void login_invalid_user() {
		
	}
	
	@Test(priority = 1, description = "Test Login with single invalid credentials")
    public void login_invalid_password() {
		
	}
	
}
