package main;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ruleManagement {
	
	//Test Data
	static String ruleNameText = "RuleNameAuto"+pC.randomnumber();
	
	
	static String ruleMenu = "//*[@id=\"kt_aside\"]/div[1]/div[1]/div/ul/li[5]";
	static String rulelist = "//*[@id=\"kt_content\"]/div/div/app-rule-management/div[3]/ngx-datatable/div/datatable-body/datatable-selection/datatable-scroller/datatable-row-wrapper/datatable-body-row/div[2]/datatable-body-cell[1]/div/div";
	static String createRuleButton = "//*[@id=\"kt_content\"]/div/div/app-rule-management/div[1]/div[3]/div/button";
	static String countotalRules = "//*[@id=\"kt_content\"]/div/div/app-rule-management/div[3]/ngx-datatable/div/datatable-footer/div/div";
	static String rulelistnextPage = "//*[@id=\"kt_content\"]/div/div/app-rule-management/div[3]/ngx-datatable/div/datatable-footer/div/datatable-pager/ul/li[6]/a";
	
	static String newrulePageTitle ="//*[@id=\"kt_content\"]/div/div/app-new-rule/div[1]/div[1]/h1";
	static String ruleName = "//*[@id=\"kt_form\"]/div[1]/div/div/div[1]/div[1]/div/input";
	static String ruleCategory = "//*[@id=\"kt_form\"]/div[1]/div/div/div[1]/div[2]/div/select";
	static String addCategoryButton = "//*[@id=\"kt_form\"]/div[1]/div/div/div[1]/div[2]/div/div";
	static String categoryName = "//*[@id=\"rules-category-name\"]";
	static String categoryDescription = "//*[@id=\"rules-category-description\"]";
	static String saveCategoryButton = "//*[@id=\"abp-modal-footer\"]/abp-button";
	static String cancelCategoryButton = "//*[@id=\"abp-modal-footer\"]/button";
	static String ruleDescripton = "//*[@id=\"kt_form\"]/div[1]/div/div/div[2]/textarea";
	static String ruleSeverity = "//*[@id=\"kt_form\"]/div[1]/div/div/div[3]/div[1]/div/select"; //Medium, High, Low
	static String isTransactional = "//*[@id=\"kt_form\"]/div[1]/div/div/div[3]/div[2]/div/span/label/span";
	static String channelName = "//*[@id=\"kt_form\"]/div[1]/div/div/div[4]/div[1]/div/select";
	static String eventType = "//*[@id=\"kt_form\"]/div[1]/div/div/div[4]/div[2]/div/select";
	static String failAction = "//*[@id=\"kt_form\"]/div[1]/div/div/div[5]/div/div/div/select";  //Stop/Block, Hold, Pass & Notify
	static String holdDuration = "//*[@id=\"kt_form\"]/div[1]/div/div/div[5]/div/div/div/div/select";
	static String nextButtonPg1 = "//*[@id=\"kt_form\"]/div[5]/div[2]/div[3]";
	static String saveAsDraftButtonPg1 = "//*[@id=\"kt_form\"]/div[5]/div[2]/div[1]";
	
	static String  newGroupButton = "//*[@id=\"kt_form\"]/div[2]/div/div/div[1]/div[3]/div/button";
	static String  addDataPointIcon = "//*[@id=\"kt_form\"]/div[2]/div/div/div[2]/div/div/div/div[3]/button";
	static String  searchDataPoint = "//*[@id=\"kt_form\"]/div[2]/div/div/div[2]/div/div/div/div[2]/table[1]/tbody/tr/td[1]/div/div/div";
	static String  selectDataPointList = "//*[@id=\"abp-modal-body\"]/ngx-datatable/div/datatable-body/datatable-selection/datatable-scroller/datatable-row-wrapper/datatable-body-row/div[2]/datatable-body-cell[1]/div/button";
	static String  selectDataPointButton = "//*[@id=\"abp-modal-body\"]/ngx-datatable/div/datatable-body/datatable-selection/datatable-scroller/datatable-row-wrapper[1]/datatable-body-row/div[2]/datatable-body-cell[1]/div/button";
	static String  selectDataPointValue = "//*[@id=\"abp-modal-body\"]/ngx-datatable/div/datatable-body/datatable-selection/datatable-scroller/datatable-row-wrapper[1]/datatable-body-row/div[2]/datatable-body-cell[2]/div";
	static String  dataPointPage2= "//*[@id=\"abp-modal-body\"]/ngx-datatable/div/datatable-footer/div/datatable-pager/ul/li[4]/a";
	static String  datapointtotalcount = "//*[@id=\"abp-modal-body\"]/ngx-datatable/div/datatable-footer/div/div";
	static String  groupOperator= "//*[@id=\"RuleConfiguration_Operator\"]";
	static String  groupValue = "//*[@id=\"kt_form\"]/div[2]/div/div/div[2]/div/div/div/div[2]/table[1]/tbody/tr/td[3]/div/div";
	static String  saveGroupIcon = "//*[@id=\"kt_form\"]/div[2]/div/div/div[2]/div/div/div/div[2]/table[1]/tbody/tr/td[4]/button";
	static String  previousButtonPg2 = "//*[@id=\"kt_form\"]/div[5]/div[1]";
	static String  saveAsDraftButtonPg2= "//*[@id=\"kt_form\"]/div[5]/div[2]/div[1]";
	static String  nextButtonPg2= "//*[@id=\"kt_form\"]/div[5]/div[2]/div[3]";
	
	static String  addUserButton= "//*[@id=\"kt_form\"]/div[3]/div/div/div/div[2]/div/button";
	static String  selectUserValue = "//*[@id=\"abp-modal-body\"]/ngx-datatable/div/datatable-body/datatable-selection/datatable-scroller/datatable-row-wrapper[1]/datatable-body-row/div[2]/datatable-body-cell[2]/div";
	static String  selectUserbUtton = "//*[@id=\"abp-modal-body\"]/ngx-datatable/div/datatable-body/datatable-selection/datatable-scroller/datatable-row-wrapper[1]/datatable-body-row/div[2]/datatable-body-cell[1]/div/button";
	static String  userlisttotalCount= "//*[@id=\"abp-modal-body\"]/ngx-datatable/div/datatable-footer/div/div";
	
	static String userlistPage2 = "//*[@id=\"abp-modal-body\"]/ngx-datatable/div/datatable-footer/div/datatable-pager/ul/li[4]/a";
	static String  previousButtonPg3= "//*[@id=\"kt_form\"]/div[5]/div[1]/div";
	static String  saveAsDraftPg3= "//*[@id=\"kt_form\"]/div[5]/div[2]/div[1]";
	static String  nextButtonPg3= "//*[@id=\"kt_form\"]/div[5]/div[2]/div[3]";
	
	static String previousButtonPg4  = "//*[@id=\"kt_form\"]/div[5]/div[1]/div";
	static String saveAsDraftPg4 = "//*[@id=\"kt_form\"]/div[5]/div[2]/div[1]";
	static String submitButtonPg4 = "//*[@id=\"kt_form\"]/div[5]/div[2]/div[2]";
	
	/*
	static String  = "";
	static String  = "";
	static String  = "";
	static String  = "";
	static String  = "";
	static String  = "";
	static String  = "";
	static String  = "";
	static String  = "";
	static String  = "";
	static String  = "";
	static String  = "";
	static String  = "";
	static String  = "";
	static String  = "";
	static String  = "";
	*/
	
	//@Test
	  public void testCreateRule() throws Exception {
	    pC.driver.get("https://efmsstudiofront.azurewebsites.net/rules");
	    pC.wait(7);
	    
	//    int noofrule = pC.driver.findElements(By.xpath(rulelist)).size();
	    pC.clickbutton("//*[@id=\"kt_content\"]/div/div/app-rule-management/div[1]/div[3]/div/button/i");
	    pC.waitForMyElementsXpath("//*[@id=\"kt_content\"]/div/div/app-new-rule/div[1]/div[1]/h1");
	    
	    //Page 1
	    pC.driver.findElement(By.name("name")).click();
	    pC.driver.findElement(By.name("name")).clear();
	    pC.driver.findElement(By.name("name")).sendKeys(ruleNameText);
	    pC.clickElement("//*[@id=\"kt_form\"]/div[1]/div/div/div[1]/div[2]/div/div");
	    pC.sendtext("//*[@id=\"rules-category-name\"]", "TestCat"+pC.randomnumber());
	    pC.sendtext("//*[@id=\"rules-category-description\"]", "TestCat Description"+pC.randomnumber());
	    pC.clickElement("//*[@id=\"abp-modal-footer\"]/abp-button");
	    pC.wait(5);
	   // pC.driver.findElement(By.xpath("//*[@id=\"kt_form\"]/div[1]/div/div/div[1]/div[2]/div/select")).sendKeys("Transactional");
	    
	    pC.driver.findElement(By.name("description")).click();
	    pC.driver.findElement(By.name("description")).clear();
	    pC.driver.findElement(By.name("description")).sendKeys("Rule Description2");
	    pC.driver.findElement(By.name("ruleSeverity")).click();
	    new Select(pC.driver.findElement(By.name("ruleSeverity"))).selectByVisibleText("High");
	    pC.driver.findElement(By.xpath("//form[@id='kt_form']/div/div/div/div[3]/div[2]/div/span/label/span")).click();
	   // pC.driver.findElement(By.name("channelName")).click();
	    //new Select(pC.driver.findElement(By.name("channelName"))).selectByVisibleText("INTBANK INTERNET BANKING");
	    pC.driver.findElement(By.name("Action")).click();
	    new Select(pC.driver.findElement(By.name("Action"))).selectByVisibleText("Pass & Notify");
	    pC.driver.findElement(By.xpath("//form[@id='kt_form']/div[5]/div[2]/div[3]")).click();
	    
	    //Page 2
	    pC.driver.findElement(By.xpath("//form[@id='kt_form']/div[2]/div/div/div/div[3]/div/button")).click();
	    pC.driver.findElement(By.xpath("//form[@id='kt_form']/div[2]/div/div/div[2]/div/div/div/div[3]/button/i")).click();
	  
	    pC.driver.findElement(By.xpath("//*[@id=\"kt_form\"]/div[2]/div/div/div[2]/div/div/div/div[2]/table[1]/tbody/tr/td[1]/div/div/div")).click();
	    pC.waitForMyElementsXpath("//*[@id=\"abp-modal-body\"]/ngx-datatable/div/datatable-body/datatable-selection/datatable-scroller/datatable-row-wrapper[1]/datatable-body-row/div[2]/datatable-body-cell[1]/div/button");
	    pC.driver.findElement(By.xpath("//*[@id=\"abp-modal-body\"]/ngx-datatable/div/datatable-body/datatable-selection/datatable-scroller/datatable-row-wrapper[1]/datatable-body-row/div[2]/datatable-body-cell[1]/div/button")).click();
	    
	    pC.driver.findElement(By.id("RuleConfiguration_Operator")).click();
	    new Select(pC.driver.findElement(By.id("RuleConfiguration_Operator"))).selectByVisibleText("Equals");
	    pC.driver.findElement(By.name("Value")).click();
	    pC.driver.findElement(By.name("Value")).clear();
	    pC.driver.findElement(By.name("Value")).sendKeys("Test Account Name2");
	    pC.driver.findElement(By.xpath("//form[@id='kt_form']/div[2]/div/div/div[2]/div/div/div/div[2]/table/tbody/tr/td[4]/button/i")).click();
	    pC.driver.findElement(By.xpath("//form[@id='kt_form']/div[5]/div[2]/div[3]")).click();
	    
	    //Page 3
	    pC.driver.findElement(By.xpath("//form[@id='kt_form']/div[3]/div/div/div/div[2]/div/button")).click();
	    pC.wait(5);
	    pC.driver.findElement(By.xpath("//div[@id='abp-modal-body']/ngx-datatable/div/datatable-body/datatable-selection/datatable-scroller/datatable-row-wrapper/datatable-body-row/div[2]/datatable-body-cell/div/button")).click();
	    pC.driver.findElement(By.xpath("//form[@id='kt_form']/div[5]/div[2]/div[3]/i")).click();
	    
	    
	    pC.driver.findElement(By.xpath("//form[@id='kt_form']/div[5]/div[2]/div[2]")).click();
	   // pC.waitForMyElementXpath("//body[@id='kt_body']/abp-toast-container/div/abp-toast/div/div[2]");
	  //  pC.driver.findElement(By.xpath("//body[@id='kt_body']/abp-toast-container/div/abp-toast/div/div[2]")).click();
	    /*
	    pC.wait(5);
	     
	    
	    
	 */
	  }
	  //@Test
	  public static void searchrule() throws InterruptedException {
		  String gridcellxpath = "//*[@id=\"kt_content\"]/div/div/app-rule-management/div[3]/ngx-datatable/div/datatable-body/datatable-selection/datatable-scroller/datatable-row-wrapper[1]/datatable-body-row/div[2]/datatable-body-cell[2]/div";
		  pC.driver.get("https://efmsstudiofront.azurewebsites.net/rules");
		    pC.wait(7);
		    pC.waitForMyElementXpath(gridcellxpath);
		    String firstrowtext = pC.getXpathtext(gridcellxpath).trim();
		    System.out.print(firstrowtext);
		    firstrowtext = "";
		    
		    pC.driver.findElement(By.xpath("//input[@type='search']")).clear();
		    pC.driver.findElement(By.xpath("//input[@type='search']")).sendKeys("RuleNameAuto");
		    pC.driver.findElement(By.xpath("//*[@id=\"kt_content\"]/div/div/app-rule-management/div[3]/div/div/div[2]/div/div/div")).click();
		    pC.driver.findElement(By.xpath("//*[@id=\"kt_content\"]/div/div/app-rule-management/div[3]/div/div/div[2]/div/div/div")).click();
		    pC.driver.findElement(By.xpath("//*[@id=\"kt_content\"]/div/div/app-rule-management/div[3]/div/div/div[2]/div/div/div")).click();
		    pC.wait(7);
		   // pC.waitForMyElementXpath(gridcellxpath);
		   // String firstrowxpath = "//*[@id=\"kt_content\"]/div/div/app-rule-management/div[3]/ngx-datatable/div/datatable-body/datatable-selection/datatable-scroller/datatable-row-wrapper[1]/datatable-body-row/div[2]/datatable-body-cell[2]/div";
		     firstrowtext = pC.getXpathtext(gridcellxpath).trim();
		     System.out.print(firstrowtext);
		    if (firstrowtext.contains("RuleNameAuto")) { pC.logvalue("Test Pass"); } else Assert.fail();
		   // pC.driver.findElement(By.xpath(firstrowxpath)).click();
	  }
	  
	  @Test
	  public void ViewRule() throws Exception {
	    pC.driver.get("https://efmsstudiofront.azurewebsites.net/rules");
	    pC.waitForMyElementXpath("//div[@id='kt_content']/div/div/app-rule-management/div[3]/ngx-datatable/div/datatable-body/datatable-selection/datatable-scroller/datatable-row-wrapper/datatable-body-row/div[2]/datatable-body-cell/div/div/button");
	    
	    String gridcellxpath = "//*[@id=\"kt_content\"]/div/div/app-rule-management/div[3]/ngx-datatable/div/datatable-body/datatable-selection/datatable-scroller/datatable-row-wrapper[1]/datatable-body-row/div[2]/datatable-body-cell[2]/div";
		  String gridcellvalue = pC.getXpathtext(gridcellxpath).trim();
	   pC.driver.findElement(By.xpath("//div[@id='kt_content']/div/div/app-rule-management/div[3]/ngx-datatable/div/datatable-body/datatable-selection/datatable-scroller/datatable-row-wrapper/datatable-body-row/div[2]/datatable-body-cell/div/div/button")).click();
	    pC.driver.findElement(By.xpath("//body[@id='kt_body']/div/div/button")).click();
	    String displayvalue = pC.driver.findElement(By.name("code")).getAttribute("value").trim();
	    if (gridcellvalue.equals(displayvalue)){ 
	    	System.out.println (gridcellvalue + "<--CellValue    CellDisplay-->" + displayvalue);
	    	pC.driver.findElement(By.xpath("//form[@id='kt_form']/div[4]/div[2]/div")).click();
	    	 pC.driver.findElement(By.xpath("//form[@id='kt_form']/div[4]/div[2]/div")).click();
	 	    pC.driver.findElement(By.xpath("//button[@type='button']")).click();
	    }else {
	    	System.out.println (gridcellvalue + "<--CellValue    CellDisplay-->" + displayvalue);
	    	System.out.println ("Data mismatch");
	    	Assert.fail();
	    }
	   
	  }
}
	
	
	

