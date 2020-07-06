package com.selenium.pages;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.*;
public class BasePage {

	public static WebDriver Driver;
	public Properties prop;
	public void invokeBrowser(String Browsername) {
try {
		if (Browsername.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "\\src\\Drivers\\chromedriver.exe");
			Driver = new ChromeDriver();

		} else {
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + "\\src\\Drivers\\geckodriver.exe");
			Driver = new FirefoxDriver();
		}
		
		Driver.manage().timeouts().implicitlyWait(260, TimeUnit.SECONDS);
		Driver.manage().timeouts().pageLoadTimeout(260, TimeUnit.SECONDS);
		Driver.manage().window().maximize();

		if (prop == null) {
			prop = new Properties();
			try {
				FileInputStream file = new FileInputStream(
						System.getProperty("user.dir") + "\\src\\propConfig.properties");
				prop.load(file);
			} catch (Exception e) {
				System.out.println("Error");

				e.printStackTrace();
			}	
		finally
        { 
            System.out.println("finally block executed"); 
        }
			}
		else {
            System.out.println("finally block executed"); 
		}}
		
		finally {
			System.out.println("BLOCK EXECUTED");
		}
}

	public void openURL(String websiteURLkey) {
		try {
		Driver.get(prop.getProperty(websiteURLkey));
		}
		catch (Exception e) {
			System.out.println("Error");
		}
	}

	public void tearDown() {
		Driver.close();

	}

	public void quitBrowser() {

		Driver.quit();
	}
}