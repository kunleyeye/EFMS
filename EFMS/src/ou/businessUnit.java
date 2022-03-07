package ou;

import org.openqa.selenium.By;
import main.pC;
public class businessUnit {
	public static void viewBusinessUnit() {
		// TODO Auto-generated method stub
		pC.driver.findElement(By.linkText("Home")).click();
		pC.driver.findElement(By.xpath("//div[@id='kt_header_menu']/ul/li[2]/a/span[2]")).click();
		pC.driver.findElement(By.xpath("//div[@id='kt_header_menu']/ul/li[2]/div/ul/li/a/span[2]")).click();
		pC.driver.findElement(By.name("Name")).click();
		pC.driver.findElement(By.name("Name")).clear();
		pC.driver.findElement(By.name("Name")).sendKeys("TEST");
		pC.driver.findElement(By.xpath("//div[@id='kt_content']/div/div[2]/app-business-units/div/div/div/div[2]/div/div/div[2]/button/i")).click();
		pC.driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/abp-dynamic-layout[1]/app-mapplicationlayout[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/app-business-units[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/button[1]")).click();
		 //driver.findElement(By.xpath("//button[@type='button']")).click();
		pC.driver.findElement(By.xpath("//a[contains(text(),'People')]")).click();
		pC.driver.findElement(By.linkText("Process")).click();
		pC.driver.findElement(By.linkText("Issues")).click();
		pC.driver.findElement(By.linkText("Engagements")).click();
		pC.driver.findElement(By.linkText("Reviews")).click();
		pC.driver.findElement(By.linkText("Hierarchy")).click();
		pC.driver.findElement(By.xpath("//div[@id='kt_content']/div/div[2]/app-view-business-unit/div/div[2]/div/div/div/div/p-organizationchart/div/table/tbody/tr/td/div/div")).click();
		pC.driver.findElement(By.xpath("//div[@id='kt_content']/div/div[2]/app-view-business-unit/app-view-business-unit-summary-overlay/p-sidebar/div/div/div[2]/div[6]/div/button")).click();
		/* rsc.driver.findElement(By.xpath("//div[@id='kt_content']/div/div[2]/app-view-business-unit/div/div/div/div/div/div/span[2]")).click();
		 rsc.driver.findElement(By.xpath("//div[@id='kt_content']/div/div[2]/app-view-business-unit/div/div/div/div/div/div/span[2]")).click();
		 rsc.driver.findElement(By.xpath("//div[@id='kt_content']/div/div[2]/app-view-business-unit/div/div/div/div/div/div/span[2]")).click();
		 rsc.driver.findElement(By.xpath("//div[@id='kt_content']/div/div[2]/app-view-business-unit/app-sub-header/div/div/div/div/div/div/button")).click();
		 */
		  
		 }

}
