package com.git.qa.test.methods;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
//import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Sleeper;

import com.git.qa.common.Timeouts;
import com.git.qa.common.WebDriverWrappers;
import com.git.qa.test.locators.Locators;
import com.sun.glass.events.KeyEvent;
import java.awt.Robot;

public class CommonMethods extends Timeouts {


	WebDriverWrappers wrapper = new WebDriverWrappers();
	
	public boolean unsuccessfullLoginToGit(WebDriver driver, Logger logger, String email, String invalidPwd) throws Exception{
		boolean catFlag = false;
		Thread.sleep(SMALL_SLEEP*3);
		catFlag = wrapper.waitUntilDisplayed(driver, Locators.GIT_LOGIN, MEDIUM_SLEEP_SECONDS);
		wrapper.click(driver, Locators.GIT_LOGIN);
		catFlag = wrapper.waitUntilDisplayed(driver, Locators.GIT_SEND_MAIL, MEDIUM_SLEEP_SECONDS);
		wrapper.type(driver, Locators.GIT_SEND_MAIL, email);
		Thread.sleep(SMALL_SLEEP*3);
		catFlag = wrapper.waitUntilDisplayed(driver, Locators.GIT_SEND_PWD, MEDIUM_SLEEP_SECONDS);
		wrapper.type(driver, Locators.GIT_SEND_PWD, invalidPwd);
		Thread.sleep(SMALL_SLEEP*3);
		catFlag = wrapper.waitUntilDisplayed(driver, Locators.GIT_SIGN, MEDIUM_SLEEP_SECONDS);
		wrapper.click(driver, Locators.GIT_SIGN);
		Thread.sleep(SMALL_SLEEP*3);
		catFlag = wrapper.waitUntilDisplayed(driver, Locators.LOGIN_UNSUCCESS_MESSAGE, MEDIUM_SLEEP_SECONDS);
		String errorMessage = wrapper.getText(driver, Locators.LOGIN_UNSUCCESS_MESSAGE);
		Thread.sleep(SMALL_SLEEP*3);
		catFlag = errorMessage.contains(errorMessage);
		if(!catFlag){
			logger.info("Failed to login to GIT Hub due to invalid credentials");
			return catFlag;
		} 
		logger.info("'Failed to Login:" + errorMessage);
		Thread.sleep(SMALL_SLEEP*4);
		
		return catFlag;

	}
	public boolean successfullLoginToGit(WebDriver driver, Logger logger, String email, String pwd) throws Exception{
		boolean catFlag = false;
		catFlag = wrapper.waitUntilDisplayed(driver, Locators.GIT_SEND_PWD, MEDIUM_SLEEP_SECONDS);
		wrapper.type(driver, Locators.GIT_SEND_PWD, pwd);
		catFlag = wrapper.waitUntilDisplayed(driver, Locators.GIT_SIGN, MEDIUM_SLEEP_SECONDS);
		wrapper.click(driver, Locators.GIT_SIGN);
		Thread.sleep(MEDIUM_SLEEP*3);
		
		return catFlag;

	}

	public boolean closeBrowser(WebDriver driver, Logger logger) throws Exception{
		boolean catFlag = true;
		logger.info("Closing Browser for Test Suite");
		driver.close();
		Thread.sleep(SMALL_SLEEP);
		//driver.quit();
		Thread.sleep(SMALL_SLEEP);
		return catFlag;
		
	}
}