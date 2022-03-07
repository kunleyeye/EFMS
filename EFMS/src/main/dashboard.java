package main;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class dashboard {
	//static WebElement caseTab = (WebElement) projectConfig.driver.findElements(By.xpath("");
	//String fraudTabXpath = "//div[@id='kt_content']/div/div/app-dashboard/app-tenant-dashboard/div[3]/div/div/div/div/ul/li[2]/a/span";
	//WebElement fraudTab = projectConfig.driver.findElement(By.xpath(fraudTabXpath));

	static String fraudTabXpath = "//div[@id='kt_content']/div/div/app-dashboard/app-tenant-dashboard/div[3]/div/div/div/div/ul/li[2]/a/span";
	static String CasesTabXpath = "//div[@id='kt_content']/div/div/app-dashboard/app-tenant-dashboard/div[3]/div/div/div/div/ul/li/a/span";
	static String caseTabinsideXpath = "//*[@id=\"kt_content\"]/div/div/app-dashboard/app-tenant-dashboard/div[3]/div/div/div[2]/div/div/div/div[1]/div/div[1]/div[1]/div/h3/span";
	static String fraudTabinsideXpath = "//div[@id='kt_content']/div/div/app-dashboard/app-tenant-dashboard/div[3]/div/div/div[2]/div/div/div/div[2]/div/div/div/div/h3/span";
	
	
	public static void dashboardLanding() throws InterruptedException  {
		pC.driver.get("https://efmsstudiofront.azurewebsites.net/dashboard");
		
		//WebElement login = projectConfig.driver.findElement(By.id("SubmitLogin"));
		
	}
	
	
	@Test 
	public static void dashboardCases() throws InterruptedException  {
		pC.driver.get("https://efmsstudiofront.azurewebsites.net/dashboard");
		
	
		pC.clickElement(fraudTabXpath);
		pC.clickElement(CasesTabXpath);
		//Assert.assertEquals(projectConfig.getXpathtext(caseTabinsideXpath), "Status");
		//projectConfig.driver.findElement(By.xpath("//div[@id='kt_content']/div/div/app-dashboard/app-tenant-dashboard/div[3]/div/div/div[2]/div/div/div/div/div/div/div/div/h3/span")).click();
		
		Thread.sleep(3000);
		pC.driver.findElement(By.xpath("//select[@id=\"timeline\"]")).click();
		pC.driver.findElement(By.xpath("//option[contains(text(),\"Last 7 days\")]")).click();
		
		Thread.sleep(3000);
		pC.driver.findElement(By.xpath("//select[@id=\"timeline\"]")).click();
		pC.driver.findElement(By.xpath("//option[contains(text(),\"Last 30 days\")]")).click();
		
		Thread.sleep(3000);
		pC.driver.findElement(By.xpath("//select[@id=\"timeline\"]")).click();
		pC.driver.findElement(By.xpath("//option[contains(text(),\"Last 60 days\")]")).click();
		
		Thread.sleep(3000);
		pC.driver.findElement(By.xpath("//select[@id=\"timeline\"]")).click();
		pC.driver.findElement(By.xpath("//option[contains(text(),\"Last 90 days\")]")).click();
		Thread.sleep(3000);
		
	}

	@Test
	public static void dashboardFraud() throws InterruptedException  {
		pC.driver.get("https://efmsstudiofront.azurewebsites.net/dashboard");
		
		
		pC.clickElement(fraudTabXpath);
		//projectConfig.driver.findElement(By.xpath("//div[@id='kt_content']/div/div/app-dashboard/app-tenant-dashboard/div[3]/div/div/div/div/ul/li[2]/a/span")).click();
		//projectConfig.driver.findElement(By.xpath("")).click();

		Thread.sleep(3000);
		pC.driver.findElement(By.xpath("//select[@id=\"timeline\"]")).click();
		pC.driver.findElement(By.xpath("//option[contains(text(),\"Last 7 days\")]")).click();
		
		Thread.sleep(3000);
		pC.driver.findElement(By.xpath("//select[@id=\"timeline\"]")).click();
		pC.driver.findElement(By.xpath("//option[contains(text(),\"Last 30 days\")]")).click();
		
		Thread.sleep(3000);
		pC.driver.findElement(By.xpath("//select[@id=\"timeline\"]")).click();
		pC.driver.findElement(By.xpath("//option[contains(text(),\"Last 60 days\")]")).click();
		
		Thread.sleep(3000);
		pC.driver.findElement(By.xpath("//select[@id=\"timeline\"]")).click();
		pC.driver.findElement(By.xpath("//option[contains(text(),\"Last 90 days\")]")).click();
		Thread.sleep(3000);
		
	}
	
	
}