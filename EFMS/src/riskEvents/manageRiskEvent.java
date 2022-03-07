package riskEvents;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;

import main.pC;

public class manageRiskEvent {
	@SuppressWarnings("unused")
	private void waitForElement(){
		Wait<WebDriver> wait = new FluentWait<WebDriver>(pC.driver)
			       .withTimeout(Duration.ofSeconds(30))
			       .pollingEvery(Duration.ofSeconds(5))
			       .ignoring(NoSuchElementException.class);
	}

	
	  public void testCreateRiskEvent() throws Exception {
		 pC.driver.get("https://igrcs-exception-ui.pwcng-rpa.com/");
		    pC.driver.findElement(By.linkText("Risk Events")).click();
		    pC.driver.findElement(By.xpath("//div[@id='kt_content']/div/div/app-exception/div/div/div/div/div/button/i")).click();
		 //   projectConfig.driver.findElement(By.name("exceptionTypeName")).click();
		    pC.driver.findElement(By.name("exceptionTypeName")).click();
		    pC.driver.findElement(By.name("exceptionTypeName")).clear();
		    pC.driver.findElement(By.name("exceptionTypeName")).sendKeys("Staff Approve Loan without collateral");
		    pC.driver.findElement(By.xpath("//*[@id=\"kt_form\"]/div/div[1]/div/div/div[1]/div[2]/fieldset/div/div[1]/div/div/div")).click();
		    Thread.sleep(3000);
		    pC.driver.findElement(By.xpath("//*[@id=\"abp-modal-body\"]/app-sub-business-unit-tree/div/div/p-tree/div/div[2]/ul/p-treenode[1]/li/div/div/div")).click();
		     pC.driver.findElement(By.name("dateOfDiscovery")).click();
		    
		    System.out.println(pC.driver.findElement(By.xpath("//body[@id='kt_body']/div/div/div/div[2]/table/tbody/tr/td[6]/span")).getText());
		    
		    pC.driver.findElement(By.xpath("//body[@id='kt_body']/div/div/div/div[2]/table/tbody/tr/td[6]/span")).click();
		    pC.driver.findElement(By.name("IssueStatement")).click();
		    Thread.sleep(3000);
		    new Select(pC.driver.findElement(By.name("IssueStatement"))).selectByVisibleText("Customers contract do not align with system records");
		   pC.driver.findElement(By.xpath("//label[contains(text(),'Issue Statement')]")).click();
		   WebElement issueType = pC.driver.findElement(By.xpath("//label[contains(text(),'Issue Type')]"));
		   
		   pC.scrollToSpecificDiv(issueType);
		   
	 
		   pC.driver.findElement(By.xpath("//*[@id=\"kt_form\"]/div/div[1]/div/div/div[2]/div/fieldset/div/div[2]/div/div/div/button")).click();
		   Thread.sleep(3000);
		    pC.driver.findElement(By.xpath("//body[1]/ngb-modal-window[1]/div[1]/div[1]/div[2]/div[1]/div[1]/ngx-datatable[1]/div[1]/datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper[1]/datatable-body-row[1]/div[2]/datatable-body-cell[1]/div[1]/button[1]")).click();
		    pC.driver.findElement(By.xpath("//*[@id=\"kt_form\"]/div/div[1]/div/div/div[2]/div/fieldset/div/div[3]/div/div/div/button")).click();
		    Thread.sleep(3000);
		    pC.driver.findElement(By.xpath("//*[@id=\"abp-modal-body\"]/div/div/ngx-datatable/div/datatable-body/datatable-selection/datatable-scroller/datatable-row-wrapper[1]/datatable-body-row/div[2]/datatable-body-cell[1]/div/label/input")).click();
		    pC.driver.findElement(By.xpath("//*[@id=\"abp-modal-body\"]/div/div/ngx-datatable/div/datatable-body/datatable-selection/datatable-scroller/datatable-row-wrapper[2]/datatable-body-row/div[2]/datatable-body-cell[1]/div/label/input")).click();
		    pC.driver.findElement(By.xpath("//*[@id=\"abp-modal-body\"]/div/div/ngx-datatable/div/datatable-body/datatable-selection/datatable-scroller/datatable-row-wrapper[3]/datatable-body-row/div[2]/datatable-body-cell[1]/div/label/input")).click();
		    pC.driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		    WebElement OccurrenceDate = pC.driver.findElement(By.xpath("//label[normalize-space()='Occurrence Date']"));
		    pC.scrollToSpecificDiv(OccurrenceDate);
		    
		    WebElement causedByStaff = pC.driver.findElement(By.xpath("//body/app-root[1]/abp-dynamic-layout[1]/app-mapplicationlayout[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/app-create-edit-exception[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/fieldset[1]/div[1]/div[7]/div[1]/div[2]/button[1]"));
		   
		    if (causedByStaff.isDisplayed()){
		    //	System.out.println("Caused By Element button is visible");
		    	causedByStaff.click();
		    	Thread.sleep(3000);
		    	
		    	pC.driver.findElement(By.xpath("//body[1]/ngb-modal-window[1]/div[1]/div[1]/div[2]/ngx-datatable[1]/div[1]/datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper[1]/datatable-body-row[1]/div[2]/datatable-body-cell[1]/div[1]/button[1]")).click();
		    }
		    
		   pC.driver.findElement(By.name("dateOfOccurence")).click();
		    pC.driver.findElement(By.xpath("//body[@id='kt_body']/div/div/div/div[2]/table/tbody/tr/td[6]/span")).click();
		    
		   
		     pC.driver.findElement(By.xpath("//div[@id='kt_form']/div/div/div/div/div[2]/div/fieldset/div/div[8]/p-multiselect/div/div[2]/div")).click();
		    pC.driver.findElement(By.xpath("//div[@id='kt_form']/div/div/div/div/div[2]/div/fieldset/div/div[8]/p-multiselect/div/div[4]/div[2]/ul/p-multiselectitem/li/div/div")).click();
		    pC.driver.findElement(By.xpath("//div[@id='kt_form']/div/div/div/div/div[2]/div/fieldset/div/div[8]")).click();
		    pC.driver.findElement(By.xpath("//div[@class='input-group form-group']//button[@class='btn btn-secondary']")).click();
		    Thread.sleep(3000);
		    pC.driver.findElement(By.xpath("//div[@id='abp-modal-body']/div/div/input")).click();
		    pC.driver.findElement(By.xpath("//div[@id='abp-modal-body']/div/div/input")).clear();
		    pC.driver.findElement(By.xpath("//div[@id='abp-modal-body']/div/div/input")).sendKeys("uni");
		    pC.driver.findElement(By.xpath("//div[@id='abp-modal-body']/ngx-datatable/div/datatable-body/datatable-selection/datatable-scroller/datatable-row-wrapper[1]/datatable-body-row/div[2]/datatable-body-cell/div/button")).click();
		    WebElement file_up = pC.driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/abp-dynamic-layout[1]/app-mapplicationlayout[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/app-create-edit-exception[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[4]/div[1]/div[1]/input[1]"));
		    if (file_up.isDisplayed()){
		    	System.out.println("Upload element displayed");
		    	file_up.click();
			    file_up.sendKeys("C:\\Users\\Adekunle\\Documents\\Test data\\Test PDF File.pdf");
		    }else{
		    	System.out.println("Upload element NOT displayed");
		    }
		  
		    WebElement cctvID = pC.driver.findElement(By.xpath("//*[@id=\"kt_form\"]/div/div[1]/div/div/div[2]/div/fieldset/div/div[9]/fieldset/div/div/div/input"));
		    cctvID.sendKeys("CCTV12345");
		    pC.driver.findElement(By.xpath("//div[@id='kt_wizard_v2']/div[2]/div/div/div[2]/div[2]/button[4]")).click();
		    pC.driver.findElement(By.xpath("//div[@id='kt_wizard_v2']/div[2]/div/div/div[2]/div[2]/button[4]")).click();
		    pC.driver.findElement(By.xpath("//div[@id='kt_wizard_v2']/div[2]/div/div/div[2]/div[2]/button[2]")).click();
		  String toastMessage =   pC.driver.findElement(By.xpath("//body[@id='kt_body']/abp-toast-container/div/abp-toast/div/div[2]/div")).getText();
		 
		  System.out.println(toastMessage); 
		/*
	    projectConfig.driver.get("https://igrcs-exception-ui.pwcng-rpa.com/");
	    projectConfig.driver.findElement(By.linkText("Risk Events")).click();
	    projectConfig.driver.findElement(By.xpath("//div[@id='kt_content']/div/div/app-exception/div/div/div/div/div/button/i")).click();
	    projectConfig.driver.findElement(By.name("exceptionTypeName")).click();
	    projectConfig.driver.findElement(By.name("exceptionTypeName")).click();
	    projectConfig.driver.findElement(By.name("exceptionTypeName")).clear();
	    projectConfig.driver.findElement(By.name("exceptionTypeName")).sendKeys("Customers fighting in the banking hall");
	    projectConfig.driver.findElement(By.xpath("//button[@type='button']")).click();
	    projectConfig.driver.findElement(By.xpath("//div[@id='abp-modal-body']/app-sub-business-unit-tree/div/div/p-tree/div/div[2]/ul/p-treenode/li/div/div/div")).click();
	    projectConfig.driver.findElement(By.name("dateOfDiscovery")).click();
	    projectConfig.driver.findElement(By.xpath("//body[@id='kt_body']/div/div/div/div[2]/table/tbody/tr/td[6]/span")).click();
	    projectConfig.driver.findElement(By.name("IssueStatement")).click();
	    Thread.sleep(3000);
	    new Select(projectConfig.driver.findElement(By.name("IssueStatement"))).selectByVisibleText("Customers contract do not align with system records");
	   projectConfig.driver.findElement(By.xpath("//label[contains(text(),'Issue Statement')]")).click();
	   
	   WebElement we = projectConfig.driver.findElement(By.xpath("//*[@id=\"kt_wizard_v2\"]/div[2]"));
	   we.sendKeys(Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ARROW_DOWN,
	   Keys.ARROW_DOWN,Keys.ARROW_DOWN);
	   
	   
	   projectConfig.driver.findElement(By.xpath("//div[@id='kt_form']/div/div/div/div/div[2]/div/fieldset/div/div[2]/div/div/div/button/i")).click();
	    Thread.sleep(3000);
	    projectConfig.driver.findElement(By.xpath("//div[@id='abp-modal-body']/div/div/ngx-datatable/div/datatable-body/datatable-selection/datatable-scroller/datatable-row-wrapper[2]/datatable-body-row/div[2]/datatable-body-cell/div/button")).click();
	    projectConfig.driver.findElement(By.xpath("//div[@id='kt_form']/div/div/div/div/div[2]/div/fieldset/div/div[3]/div/div/div/button/i")).click();
	    Thread.sleep(3000);
	    projectConfig.driver.findElement(By.xpath("//div[@id='abp-modal-body']/div/div/div/div/div/div/input")).click();
	    projectConfig.driver.findElement(By.xpath("//div[@id='abp-modal-body']/div/div/div/div/div/div/input")).clear();
	    projectConfig.driver.findElement(By.xpath("//div[@id='abp-modal-body']/div/div/div/div/div/div/input")).sendKeys("yaba");
	    projectConfig.driver.findElement(By.xpath("//div[@id='abp-modal-body']/div/div/div/div/div/div/span/i")).click();
	    projectConfig.driver.findElement(By.xpath("//div[@id='abp-modal-body']/div/div/div/div/div/div")).click();
	    projectConfig.driver.findElement(By.xpath("//div[@id='abp-modal-body']/div/div/div/div/div/div/input")).clear();
	    projectConfig.driver.findElement(By.xpath("//div[@id='abp-modal-body']/div/div/div/div/div/div/input")).sendKeys("");
	    projectConfig.driver.findElement(By.xpath("//div[@id='abp-modal-body']/div/div/ngx-datatable/div/datatable-body/datatable-selection/datatable-scroller/datatable-row-wrapper[6]/datatable-body-row/div[2]/datatable-body-cell/div/label/input")).click();
	    projectConfig.driver.findElement(By.xpath("//div[@id='abp-modal-footer']/abp-button/button/i")).click();
	    projectConfig.driver.findElement(By.name("dateOfOccurence")).click();
	    projectConfig.driver.findElement(By.xpath("//body[@id='kt_body']/div/div/div/div[2]/table/tbody/tr/td[6]/span")).click();
	    projectConfig.driver.findElement(By.xpath("//div[@id='kt_form']/div/div/div/div/div[2]/div/fieldset/div/div[7]/div/div[2]/button/i")).click();
	    projectConfig.driver.findElement(By.xpath("//div[@id='abp-modal-body']/ngx-datatable/div/datatable-body/datatable-selection/datatable-scroller/datatable-row-wrapper/datatable-body-row/div[2]/datatable-body-cell/div/button")).click();
	    projectConfig.driver.findElement(By.xpath("//div[@id='kt_form']/div/div/div/div/div[2]/div/fieldset/div/div[8]/p-multiselect/div/div[2]/div")).click();
	    projectConfig.driver.findElement(By.xpath("//div[@id='kt_form']/div/div/div/div/div[2]/div/fieldset/div/div[8]/p-multiselect/div/div[4]/div[2]/ul/p-multiselectitem/li/div/div")).click();
	    projectConfig.driver.findElement(By.xpath("//div[@id='kt_form']/div/div/div/div/div[2]/div/fieldset/div/div[8]")).click();
	    projectConfig.driver.findElement(By.xpath("//div[@id='kt_form']/div/div/div/div/div[3]/div/fieldset/div/div/div/div[2]/button/i")).click();
	    projectConfig.driver.findElement(By.xpath("//div[@id='abp-modal-body']/div/div/input")).click();
	    projectConfig.driver.findElement(By.xpath("//div[@id='abp-modal-body']/div/div/input")).clear();
	    projectConfig.driver.findElement(By.xpath("//div[@id='abp-modal-body']/div/div/input")).sendKeys("uni");
	    projectConfig.driver.findElement(By.xpath("//div[@id='abp-modal-body']/ngx-datatable/div/datatable-body/datatable-selection/datatable-scroller/datatable-row-wrapper[2]/datatable-body-row/div[2]/datatable-body-cell/div/button")).click();
	    projectConfig.driver.findElement(By.id("fileUpload")).click();
	    projectConfig.driver.findElement(By.id("fileUpload")).clear();
	    projectConfig.driver.findElement(By.id("fileUpload")).sendKeys("C:\\Users\\Adekunle\\Documents\\Test data\\Test PDF File.pdf");
	    projectConfig.driver.findElement(By.xpath("//div[@id='kt_wizard_v2']/div[2]/div/div/div[2]/div[2]/button[4]")).click();
	    projectConfig.driver.findElement(By.xpath("//div[@id='kt_wizard_v2']/div[2]/div/div/div[2]/div[2]/button[4]")).click();
	    projectConfig.driver.findElement(By.xpath("//div[@id='kt_wizard_v2']/div[2]/div/div/div[2]/div[2]/button[2]")).click();
	    projectConfig.driver.findElement(By.xpath("//body[@id='kt_body']/abp-toast-container/div/abp-toast/div/div[2]/div")).click();
	*/ 
	}
/*
	  @AfterClass(alwaysRun = true)
	  public void tearDown() throws Exception {
	    projectConfig.driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
	  }

	  private boolean isElementPresent(By by) {
	    try {
	      projectConfig.driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }

	  private boolean isAlertPresent() {
	    try {
	      projectConfig.driver.switchTo().alert();
	      return true;
	    } catch (NoAlertPresentException e) {
	      return false;
	    }
	  }

	  private String closeAlertAndGetItsText() {
	    try {
	      Alert alert = projectConfig.driver.switchTo().alert();
	      String alertText = alert.getText();
	      if (acceptNextAlert) {
	        alert.accept();
	      } else {
	        alert.dismiss();
	      }
	      return alertText;
	    } finally {
	      acceptNextAlert = true;
	    }
	  }
	*/
}
