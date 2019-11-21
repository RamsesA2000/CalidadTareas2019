package com.mayab.calidad.funcionales;

import static org.junit.Assert.*;

import java.util.regex.Pattern;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import com.mysql.cj.jdbc.Driver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class googleTestCase {
	
	private static String URL;
	private static WebDriver driver;

	  @Before
	  public void init(){
		  URL = "https://www.google.com/";
		  System.setProperty("webdriver.chrome.driver", "/home/cardinal/CHROMEDRIVER/chromedriver");
		  driver = new ChromeDriver();
	  }
	  
	  private void pause(long mils) {
		  try {
			  Thread.sleep(mils);
		  }catch(Exception e){
			  e.printStackTrace();
		  }
	  }

	  @Test
	  public void LoginTest() {
		  driver.get(URL);
		  
		  WebElement element = driver.findElement(By.name("q"));
		  
		  element.sendKeys("Hello");
		  
		  element.submit();
		  
		  pause(5000);
		  
		  driver.close();
	  }

	  @After
	  public void tearDown() {
	  }
	}