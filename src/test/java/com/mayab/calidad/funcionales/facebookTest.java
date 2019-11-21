package com.mayab.calidad.funcionales;

import static org.junit.Assert.*;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class facebookTest {

	private static String URL;
	private static WebDriver driver;

	  @Before
	  public void init()
	  {
		  URL = "https://www.facebook.com/login/";
		  System.setProperty("webdriver.chrome.driver", "/home/cardinal/CHROMEDRIVER/chromedriver");
		  driver = new ChromeDriver();
		  driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
	  }
	  
	  private void pause(long mils) 
	  {
		  try {
			  Thread.sleep(mils);
		  }catch(Exception e){
			  e.printStackTrace();
		  }
	  }

	  @Test
	  public void LoginTestFailEmail() 
	  {
		  driver.get(URL);
		  WebElement element = driver.findElement(By.name("email"));
		  element.sendKeys("rammgaga@gmail.com");
		  element = driver.findElement(By.name("pass"));
		  element.sendKeys("RAMG2000"); 
		  element = driver.findElement(By.name("login"));
		  element.click();
		  
		  WebElement element2 = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[3]/div/div/div"));
		  String cadena = element2.getText();
		  assertEquals("The email you’ve entered doesn’t match any account. Sign up for an account.", cadena);
	  }
	  
	  @Test
	  public void LoginTestFailPassword() 
	  {
		  driver.get(URL);
		  WebElement element = driver.findElement(By.name("email"));
		  element.sendKeys("ramsesmtzgzz@gmail.com");
		  element = driver.findElement(By.name("pass"));
		  element.sendKeys("null");
		  element = driver.findElement(By.name("login"));
		  element.click();
		  
		  WebElement element2 = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[3]/div/div/div"));
		  String cadena = element2.getText();
		  assertEquals("The password you’ve entered is incorrect. Forgot Password?", cadena);
	  }
}