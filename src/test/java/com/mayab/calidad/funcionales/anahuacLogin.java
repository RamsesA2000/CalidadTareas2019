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

public class anahuacLogin 
{

	private static String URL;
	private static WebDriver driver;

	  @Before
	  public void init()
	  {
		  URL = "https://anahuac.blackboard.com/webapps/login/";
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
	  public void LoginTest() 
	  {
		  driver.get(URL);
		  WebElement element = driver.findElement(By.id("user_id"));
		  element.sendKeys("00321716");
		  element = driver.findElement(By.id("password"));
		  element.sendKeys("00321716");
		  element = driver.findElement(By.id("entry-login"));
		  element.submit();
		  element = driver.findElement(By.xpath("/html/body/div[3]/div[2]/a"));
		  element.click();		  
		  WebElement element2 = driver.findElement(By.id("global-nav-link"));
		  String cadena = element2.getText();
		  assertEquals("Ramses Martinez Gonzalez", cadena);
	  }
	  
	  @Test
	  public void errorTest()
	  {
		  driver.get(URL);
		  WebElement element = driver.findElement(By.id("user_id"));
		  element.sendKeys("00321715");
		  element = driver.findElement(By.id("password"));
		  element.sendKeys("00321716");
		  element = driver.findElement(By.id("entry-login"));
		  element.submit();
		  WebElement element2 = driver.findElement(By.id("loginErrorMessage"));
		  String cadena = element2.getText();
		  assertEquals("El nombre de usuario o contraseña"
		  		+ " que ha introducido no son correctos. "
		  		+ "Inténtelo de nuevo. Si aún no puede iniciar "
		  		+ "sesión, comuníquese con su administrador del sistema.", cadena);
		  
	  }
	  
	  @Test
	  public void camposVaciosTest()
	  {
		  driver.get(URL);
		  WebElement element = driver.findElement(By.id("user_id"));
		  element.sendKeys("");
		  element = driver.findElement(By.id("password"));
		  element.sendKeys("");
		  element.submit();
		  String cadena = driver.switchTo().alert().getText();	
		  assertEquals("Introduzca un nombre de usuario y una contraseña.", cadena);
	  }

	  @After
	  public void tearDown() 
	  {
	  }

}
