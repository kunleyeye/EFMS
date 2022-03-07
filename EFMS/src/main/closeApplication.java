package main;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;

public class closeApplication {
	@Test
	public static void logoutUser() {
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(pC.driver)
			       .withTimeout(Duration.ofSeconds(30))
			       .pollingEvery(Duration.ofSeconds(5))
			       .ignoring(NoSuchElementException.class);
		
		// TODO Auto-generated method stub
		pC.driver.findElement(By.xpath("//div[@id='kt_quick_user_toggle']/div/span")).click();
		pC.driver.findElement(By.linkText("Log out")).click();
		pC.driver.findElement(By.id("redirectButton")).click();
		
		
		WebElement landingPageTest = wait.until(new Function<WebDriver, WebElement>() {
		     public WebElement apply(WebDriver driver) {
		    	 
		    	 if (driver.findElement(By.xpath("//label[contains(text(),'User name or email address')]")).isDisplayed()){
		    		 return driver.findElement(By.xpath("//label[contains(text(),'User name or email address')]"));
		    	 }else{
		    		 return null;
		    	 }
		    	 
		      
		     }
		   });
		
		
		landingPageTest.click();
		pC.driver.navigate().back();
		pC.driver.findElement(By.xpath("//label[contains(text(),'User name or email address')]")).click();
		   
}
		
	public static void closeBrowsers(){
		pC.driver.quit();
	}
}
