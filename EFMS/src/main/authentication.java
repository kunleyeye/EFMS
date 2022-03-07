package main;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class authentication {
	
	static String homexpath = "//div[@id='kt_content']/div/div/app-home/div/div/h1";
	
	public static void testThread(){
		for(int i=1;i<5;i++){   
			  // the thread will sleep for the 500 milli seconds   
			    try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}    
			    System.out.println(i);    
			  }    
	}
	
	//@Test (priority = -1)
	public static void loginWithInvalidCredentials() throws InterruptedException  {
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(pC.driver)
			       .withTimeout(Duration.ofSeconds(30))
			       .pollingEvery(Duration.ofSeconds(5))
			       .ignoring(NoSuchElementException.class);
		
		
		pC.driver.findElement(By.id("LoginInput_UserNameOrEmailAddress")).clear();
		pC.driver.findElement(By.id("LoginInput_UserNameOrEmailAddress")).sendKeys("adewale");
		pC.driver.findElement(By.xpath("//div[2]/div/div")).click();
		pC.driver.findElement(By.id("LoginInput_Password")).clear();
		pC.driver.findElement(By.id("LoginInput_Password")).sendKeys("Babalola@123");
		pC.driver.findElement(By.name("Action")).click();
	   
	    Thread.sleep(3000);
	   // String responseMessage = projectConfig.driver.findElement(By.xpath("//div[@id='AbpPageAlerts']/div")).getText();
	    		
	   // Assert.assertEquals(responseMessage, "Invalid username or password!\r\n"
	    	//	+ "×");
	    
	    
	    
	    WebElement methodValidator = wait.until(new Function<WebDriver, WebElement>() {
		     public WebElement apply(WebDriver driver) {
		    	 if (driver.findElement(By.xpath("//div[@id='AbpPageAlerts']/div")).isDisplayed()){
		    		 return driver.findElement(By.xpath("//div[@id='AbpPageAlerts']/div"));
		    	 }else{
		    		 return null;
		    	 }
		    	
		      
		     }
		   });
	    

	    methodValidator.click();
		   Thread.sleep(3000);
		   
		
	}
	
	@Test (priority = 0)
	public static void loginWithValidCredentials() throws InterruptedException {
		
		/*
		Wait<WebDriver> wait = new FluentWait<WebDriver>(projectConfig.driver)
			       .withTimeout(Duration.ofSeconds(30))
			       .pollingEvery(Duration.ofSeconds(5))
			       .ignoring(NoSuchElementException.class);
		*/
		
	//	static WebElement username projectConfig.driver.findElement(By.id("LoginInput_UserNameOrEmailAddress"));
		
		pC.driver.findElement(By.id("LoginInput_UserNameOrEmailAddress")).clear();
		pC. driver.findElement(By.id("LoginInput_UserNameOrEmailAddress")).sendKeys("adekunle");
		pC. driver.findElement(By.id("LoginInput_Password")).clear();
		pC. driver.findElement(By.id("LoginInput_Password")).sendKeys("Password@123");
		pC. driver.findElement(By.id("LoginInput_UserNameOrEmailAddress")).click();
		pC. driver.findElement(By.xpath("//div/div[2]/div")).click();
		pC. driver.findElement(By.xpath("//div[2]/div/div")).click();
		pC. driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Remember me'])[1]/following::div[1]")).click();
		pC. driver.findElement(By.name("Action")).click();
		
	
		 Thread.sleep(3000);
		 pC. driver.get("https://efmsstudiofront.azurewebsites.net/?code=QoNCb_pBRBETm38jjvu-2gwfCfZySau3O5MAhrrumXs&scope=openid%20Studio%20ConfigurationManager%20ListManagement%20RuleManagementService%20CaseManagement%20NotificationService%20ReportManagementService%20ContinuousMonitoringModule&state=VzhWaEhoQWJGZ29FSXRiUXFCanlidk9LenhQLnRoc0lIZktNbW5yZDJQV29P&session_state=iU_zpyK1lRABZKf04ze6nknMWvCixRODlFz1GXWINpg.W8o9uOeSh3FX6-1UQuN8Wg");
			pC. driver.get("https://efmsstudiofront.azurewebsites.net/");
			Thread.sleep(3000);
/*
		   WebElement homeMen = wait.until(new Function<WebDriver, WebElement>() {
			     public WebElement apply(WebDriver driver) {
			    	 if (driver.findElement(By.xpath(homexpath)).isDisplayed()){
			    		 return driver.findElement(By.xpath(homexpath));
			    	 }else{
			    		 return null;
			    	 }
			    	 
			      
			     }
			   });
		 
		   homeMen.click();
		   */
			
			WebElement homeMenu = pC.waitForMyElementXpath(homexpath);
			
			Assert.assertEquals(homeMenu.getText(), "Home");
			
		//	homeMenu.click();
			
		//	System.out.println(homeMenu.getText());
			
		//   Thread.sleep(3000);
		  // projectConfig.driver.get("https://efmsstudiofront.azurewebsites.net/dashboard");
		   //System.out.print(homeMenu);
		   
		   Thread.sleep(3000);
			
		  
	}
	
	
	}
	

