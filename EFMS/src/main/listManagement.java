package main;

import java.text.SimpleDateFormat;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class listManagement {
	static String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
	
	static String listName  = "listNameTest";
	static String listNameDescription = "ListDescriptionTest";
	
//	static String listName  = "AutoListName"+timeStamp;
//	static String listNameDescription = "AutoListDescription"+timeStamp;
	
	static String listMenu = "//*[@id=\"kt_aside\"]/div[1]/div[1]/div/ul/li[4]";
	static String listPageAssetText = "//*[@id=\"kt_content\"]/div/div/app-list-type/div[2]/div[1]/div/div[1]/div[1]/h3/span"; //List Types
	static String createListButton = "//*[@id=\"kt_content\"]/div/div/app-list-type/div[2]/div[1]/div/div[1]/div[2]";
	static String duplicatelistCheck = "//*[@id=\"kt_body\"]/abp-confirmation/div/div[2]/div[2]/p";
	static String duplicatelistScreen = "//*[@id=\"kt_body\"]/abp-confirmation/div/div[2]/div[2]/h1";
	static String closeErrorModal = "//*[@id=\"confirm\"]";
	static String closeNewListModal = "//*[contains(text(),'Cancel')]";
	
	public static void testThread(int k){
		for(int i=1;i<k;i++){   
			  // the thread will sleep for the 500 milli seconds   
			    try{Thread.sleep(1000);}catch(InterruptedException e){System.out.println(e);}    
			    System.out.println(i);    
			  }    
	}
	
	//duplicatelistCheck
	
	//@Test
	public static void createList() throws InterruptedException  {	
		Thread.sleep(3000);
		pC.waitForMyElementXpath(listMenu).click();
		pC.waitForMyElementXpath("//*[@id=\"kt_content\"]/div/div/app-list-type/div[2]/div[1]/div/div[2]/div/div[1]/div");

		
		Assert.assertEquals(pC.getXpathtext(listPageAssetText), "List Types");
		
		pC.driver.findElement(By.xpath(createListButton)).click();
	    pC.driver.findElement(By.id("list-type-name")).click();
	    pC.driver.findElement(By.id("list-type-name")).clear();
	    pC.driver.findElement(By.id("list-type-name")).sendKeys(listName);
	    pC.driver.findElement(By.id("list-type-description")).click();
	    pC.driver.findElement(By.id("list-type-description")).clear();
	    pC.driver.findElement(By.id("list-type-description")).sendKeys(listNameDescription);
	    pC.driver.findElement(By.xpath("//*[@id=\"abp-modal-footer\"]/abp-button")).click();
	    
	    Thread.sleep(6000);
	    
	    int countelement = pC.driver.findElements(By.xpath(duplicatelistScreen)).size();
	    System.out.println ("Xpath duplicate check count - " + countelement);
	    
	    if(countelement > 0) {
	    	String expected = "A list with same name already exists!";	    	
	    	handleDuplicateRecordScreen(expected);
	  Assert.assertEquals(pC.getXpathtext(listPageAssetText), "List Types");
	    	
	    }else {
	    	
	    	Thread.sleep(4000);
	    	String newListName  = "";
			
			String newListNameValue = "";
			
			String checkexistinglist = "//*[@id=\"kt_content\"]/div/div/app-list-type/div[2]/div[1]/div/div[2]/div/div";
			int numberoflistavailable = pC.driver.findElements(By.xpath(checkexistinglist)).size();
			
	    	for(int k=2; k<=numberoflistavailable; k++) {
	    		
			//	pC.driver.findElement(By.xpath("//*[@id=\"kt_content\"]/div/div/app-list-type/div[2]/div[1]/div/div[2]/div/div["+ k +"]/div")).click();
			newListName = "//*[@id=\"kt_content\"]/div/div/app-list-type/div[2]/div[1]/div/div[2]/div/div[" + k + "]/div/div[2]/h4";
			newListNameValue = pC.getXpathtext(newListName).trim();
			
			
			if (newListNameValue.equals(listName)) {

				pC.driver.findElement(By.xpath("//*[@id=\"kt_content\"]/div/div/app-list-type/div[2]/div[1]/div/div[2]/div/div["+ k +"]/div")).click();
				
					String listitemtitle = pC.getXpathtext("//*[@id=\"kt_content\"]/div/div/app-list-type/div[2]/div[2]/div/div/app-list-item/div/div[1]/div[1]/h3/span");
					Assert.assertEquals(listName, listitemtitle);
					System.out.println("List Created Successfully");
					//	System.out.println("List Item Title "+listitemtitle);
				break;
			}
			
			}
			
	    	
	    	
	    }
		
	  Thread.sleep(3000);

	}
	
	

	//@Test
	public static void viewCreatedLists() throws InterruptedException {
		
		//createList();
		Thread.sleep(3000);
		pC.waitForMyElementXpath(listMenu).click();
		pC.waitForMyElementXpath("//*[@id=\"kt_content\"]/div/div/app-list-type/div[2]/div[1]/div/div[2]/div/div[1]/div");
		
		
		
		//check if there are no existing list items, create one before creating list item
		String checkexistinglist = "//*[@id=\"kt_content\"]/div/div/app-list-type/div[2]/div[1]/div/div[2]/div/div";
		int numberoflistavailable = pC.driver.findElements(By.xpath(checkexistinglist)).size();
		if (numberoflistavailable < 2 ) {
			createList();
		}
		int k = 2;
		//for(int k=2; k<=numberoflistavailable; k++) {
			Thread.sleep(3000);
		
			
		//	int listrowfound = pC.driver.findElements(By.xpath("//*[@id=\"kt_content\"]/div/div/app-list-type/div[2]/div[1]/div/div[2]/div/div["+ k +"]/div")).size();
			
		//	if (listrowfound > 0) {
			pC.driver.findElement(By.xpath("//*[@id=\"kt_content\"]/div/div/app-list-type/div[2]/div[1]/div/div[2]/div/div["+ k +"]/div")).click();
			String newListName  = "";	
			String newListNameValue = "";
			newListName = "//*[@id=\"kt_content\"]/div/div/app-list-type/div[2]/div[1]/div/div[2]/div/div[" + k + "]/div/div[2]/h4";
			newListNameValue = pC.getXpathtext(newListName).trim();
				
			String listitemtitle = pC.getXpathtext("//*[@id=\"kt_content\"]/div/div/app-list-type/div[2]/div[2]/div/div/app-list-item/div/div[1]/div[1]/h3/span");
			System.out.println(listitemtitle + " <=> " + newListNameValue);
			Assert.assertEquals(newListNameValue, listitemtitle);
				
	/*	}else
		{
			break;
		}
		
		*/
	//}
	}

	//@Test
public static void editCreatedLists() throws InterruptedException {
		
		String dropdownicon = "//*[@id=\"kt_content\"]/div/div/app-list-type/div[2]/div[1]/div/div[2]/div/div[2]/div/div[1]/button";
		String editbutton = "//*[@id=\"kt_body\"]/div/div/button[1]";
		String headertitle = "//*[@id=\"abp-modal-header\"]/h3";
		String elistname = "//*[@id=\"list-type-name\"]";
		String elistdescription = "//*[@id=\"list-type-description\"]";
		String cancelbutton = "//*[@id=\"abp-modal-footer\"]/button";
		String savebutton = "//*[@id=\"abp-modal-footer\"]/abp-button";
		
		
		//TestData
		 String elistnameValue  = "AutoEdittedListName"+timeStamp;
		 String elistdescriptionValue = "AutoEdittedListDescription"+timeStamp;
		
		pC.waitForMyElementXpath(listMenu).click();
		pC.waitForMyElementXpath("//*[@id=\"kt_content\"]/div/div/app-list-type/div[2]/div[1]/div/div[2]/div/div[1]/div");
		
		//String newListName  = "";
		
		//String newListNameValue = "";
		
		//check if there are no existing list items, create one before creating list item
		String checkexistinglist = "//*[@id=\"kt_content\"]/div/div/app-list-type/div[2]/div[1]/div/div[2]/div/div";
		int numberoflistavailable = pC.driver.findElements(By.xpath(checkexistinglist)).size();
		if (numberoflistavailable < 2 ) {
			createList();
		}
		
		//pC.driver.findElement(By.xpath("//*[@id=\"kt_content\"]/div/div/app-list-type/div[2]/div[1]/div/div[2]/div/div[2]/div")).click();
		
		//Close Edit Modal
		pC.driver.findElement(By.xpath(dropdownicon)).click();
		pC.driver.findElement(By.xpath(editbutton)).click();
		pC.waitForMyElementsXpath(headertitle);
		pC.driver.findElement(By.xpath(cancelbutton)).click();
		
		//Launch Edit Modal, provide new details and save
		pC.driver.findElement(By.xpath(dropdownicon)).click();
		pC.driver.findElement(By.xpath(editbutton)).click();
		pC.waitForMyElementsXpath(headertitle);
		pC.driver.findElement(By.xpath(elistname)).clear();
		pC.driver.findElement(By.xpath(elistname)).sendKeys(elistnameValue);
		pC.driver.findElement(By.xpath(elistdescription)).clear();
		pC.driver.findElement(By.xpath(elistdescription)).sendKeys(elistdescriptionValue);
		pC.driver.findElement(By.xpath(savebutton)).click();
		
Thread.sleep(6000);
	    
	    int countelement = pC.driver.findElements(By.xpath(duplicatelistScreen)).size();
	    System.out.println ("Xpath duplicate check count - " + countelement);
	    
	    if(countelement > 0) {
	    	String expected = "A list with same name already exists!";	    	
	    	handleDuplicateRecordScreen(expected);
	  Assert.assertEquals(pC.getXpathtext(listPageAssetText), "List Types");
	    	
	    }else {
	    
		pC.waitForMyElementsXpath("//*[@id=\"kt_content\"]/div/div/app-list-type/div[2]/div[1]/div/div[2]/div/div[2]/div");
		pC.driver.findElement(By.xpath("//*[@id=\"kt_content\"]/div/div/app-list-type/div[2]/div[1]/div/div[2]/div/div[2]/div")).click();
		
		String listitemtitle = pC.getXpathtext("//*[@id=\"kt_content\"]/div/div/app-list-type/div[2]/div[2]/div/div/app-list-item/div/div[1]/div[1]/h3/span");
		Assert.assertEquals(listitemtitle, elistnameValue);
		
	    }	
		/*
		for(int k=2; k<=numberoflistavailable; k++) {
			int listrowfound = pC.driver.findElements(By.xpath("//*[@id=\"kt_content\"]/div/div/app-list-type/div[2]/div[1]/div/div[2]/div/div["+ k +"]/div")).size();
			
		if (listrowfound > 0) {
			
			newListName = "//*[@id=\"kt_content\"]/div/div/app-list-type/div[2]/div[1]/div/div[2]/div/div[" + k + "]/div/div[2]/h4";
			newListNameValue = pC.getXpathtext(newListName).trim();
			
	pC.driver.findElement(By.xpath("//*[@id=\"kt_content\"]/div/div/app-list-type/div[2]/div[1]/div/div[2]/div/div[2]/div")).click();
		
			
				String listitemtitle = pC.getXpathtext("//*[@id=\"kt_content\"]/div/div/app-list-type/div[2]/div[2]/div/div/app-list-item/div/div[1]/div[1]/h3/span");
				Assert.assertEquals(listitemtitle, newListNameValue);
Thread.sleep(3000);

			
		}else
		{
			break;
		}
		
		
	}
		*/
	}
	
	
	
	@Test
	public static void activateNdeactivateCreatedLists() throws InterruptedException {
			
			String dropdownicon = "//*[@id=\"kt_content\"]/div/div/app-list-type/div[2]/div[1]/div/div[2]/div/div[2]/div/div[1]/button";
			String activatebutton = "//*[@id=\"kt_body\"]/div/div/button[2]";
			String confirmAlert = "//*[@id=\"kt_body\"]/abp-confirmation/div/div[2]/div[2]/h1";
		//	String confirmAMessage = "//*[@id=\"kt_body\"]/abp-confirmation/div/div[2]/div[2]/p";
			String confirmAYes = "//*[@id=\"confirm\"]";
			String cancelAbutton = "//*[@id=\"cancel\"]";
			String confirmItemMessage = "//*[@id=\"kt_body\"]/abp-confirmation/div/div[2]/div[2]/p";
			String confirmItemYes = "//*[@id=\"confirm\"]";
			String cancelItemButton = "//*[@id=\"cancel\"]";
		//	String savebutton = "//*[@id=\"abp-modal-footer\"]/abp-button";
	
			
			pC.waitForMyElementXpath(listMenu).click();
			pC.waitForMyElementXpath("//*[@id=\"kt_content\"]/div/div/app-list-type/div[2]/div[1]/div/div[2]/div/div[1]/div");

			//check if there are no existing list items, create one before creating list item
			String checkexistinglist = "//*[@id=\"kt_content\"]/div/div/app-list-type/div[2]/div[1]/div/div[2]/div/div";
			int numberoflistavailable = pC.driver.findElements(By.xpath(checkexistinglist)).size();
			if (numberoflistavailable < 2 ) {
				createList();
			}
			
			//pC.driver.findElement(By.xpath("//*[@id=\"kt_content\"]/div/div/app-list-type/div[2]/div[1]/div/div[2]/div/div[2]/div")).click();
			
			//Close Edit Modal
			pC.driver.findElement(By.xpath(dropdownicon)).click();
			String actiontext = pC.getXpathtext(activatebutton).trim();
			if(actiontext.equals("Activate")) {
				
				System.out.println("Before activation "+actiontext);
				pC.driver.findElement(By.xpath(activatebutton)).click();
				pC.driver.findElement(By.xpath(cancelAbutton)).click();
				
				pC.driver.findElement(By.xpath(dropdownicon)).click();
				pC.driver.findElement(By.xpath(activatebutton)).click();
				pC.waitForMyElementsXpath(confirmAlert);
				pC.driver.findElement(By.xpath(confirmAYes)).click();
				pC.waitForMyElementsXpath(confirmItemMessage);
				pC.driver.findElement(By.xpath(cancelItemButton)).click();
				
				pC.driver.findElement(By.xpath(dropdownicon)).click();
				pC.driver.findElement(By.xpath(activatebutton)).click();
				pC.waitForMyElementsXpath(confirmAlert);
				pC.driver.findElement(By.xpath(confirmAYes)).click();
				pC.waitForMyElementsXpath(confirmItemMessage);
				pC.driver.findElement(By.xpath(confirmItemYes)).click();
				Thread.sleep(6000);
				
				pC.driver.findElement(By.xpath(dropdownicon)).click();
				actiontext = pC.getXpathtext(activatebutton).trim();
				System.out.println("After activation "+ actiontext);
				
				Assert.assertEquals(actiontext, "Deactivate");
				
				actiontext = "";
				
				
			}else if(actiontext.equals("Deactivate")) {
				
				System.out.println("Before deactivation "+actiontext);
				pC.driver.findElement(By.xpath(activatebutton)).click();
				pC.driver.findElement(By.xpath(cancelAbutton)).click();
				
				pC.driver.findElement(By.xpath(dropdownicon)).click();
				pC.driver.findElement(By.xpath(activatebutton)).click();
				pC.waitForMyElementsXpath(confirmAlert);
				pC.driver.findElement(By.xpath(confirmAYes)).click();
				
				
				Thread.sleep(6000);
				
				pC.driver.findElement(By.xpath(dropdownicon)).click();
				actiontext = pC.getXpathtext(activatebutton).trim();
				System.out.println("After deactivation "+actiontext);
				
				Assert.assertEquals(actiontext, "Activate");
			
			//	Verify.verify(true, confirmItemMessage, confirmItemYes, cancelItemButton, checkexistinglist, actiontext);
				actiontext = "";
				
			}else {
				Assert.assertEquals("There is no button to activate", "There is no button to deactivate");
			}

		}
	
	
	
	//@Test
public static void createNewListItem() throws InterruptedException  {		
	String newListItembutton = "//*[@id=\"kt_content\"]/div/div/app-list-type/div[2]/div[2]/div/div/app-list-item/div/div[1]/div[2]/button[2]";
	String listTypeName = "//*[@id=\"abp-modal-body\"]/form/div/div[1]/input[1]";
	String dataTypePoint = "//select[@id='list-item-dataPointType']";
	String dataValue = "//input[@id='list-item-data-value']";
	String expiresIn = "//input[@id='list-item-expiryInterval']";
	String expiresInPeriod = "//select[@id='list-item-expiryType']";
	String listItemComment = "//textarea[@id='list-item-comment']";
	String uploadFile = "//input[@id='list-item-fileUpload']";
	String saveButton = "//*[@id=\"abp-modal-footer\"]/abp-button";
	//String cancelButton = "//*[@id=\"abp-modal-footer\"]/button";
	//String confirmSaveAction = "//*[@id=\"kt_content\"]/div/div/app-list-type/div[2]/div[2]/div/div/app-list-item/div/div[2]/ngx-datatable/div/datatable-body/datatable-selection/datatable-scroller/datatable-row-wrapper[1]/datatable-body-row/div[2]/datatable-body-cell[3]/div";
	                            //*[@id=\"kt_content\"]/div/div/app-list-type/div[2]/div[2]/div/div/app-list-item/div/div[2]/ngx-datatable/div/datatable-body/datatable-selection/datatable-scroller/datatable-row-wrapper[1]/datatable-body-row/div[2]/datatable-body-cell[3]/div
	//Test Data
	String dataType_Point = "Comment";
	String data_Value = "TEST DATA VALUE 5";
	String expires_In = "10";
	String expiresIn_Period = "Never";
	String listItem_Comment = "List Item Comment";
	
	Thread.sleep(4000);
	pC.waitForMyElementXpath(listMenu).click();
	pC.waitForMyElementXpath("//*[@id=\"kt_content\"]/div/div/app-list-type/div[2]/div[1]/div/div[2]/div/div[1]/div");

	
	
	//check if there are no existing list items, create one before creating list item
	String checkexistinglist = "//*[@id=\"kt_content\"]/div/div/app-list-type/div[2]/div[1]/div/div[2]/div/div";
	int numberoflistavailable = pC.driver.findElements(By.xpath(checkexistinglist)).size();
	if (numberoflistavailable < 2 ) {
		createList();
	}
	
	
	//String newListName  = "";
	
//	String newListNameValue = "";
	
		pC.driver.findElement(By.xpath("//*[@id=\"kt_content\"]/div/div/app-list-type/div[2]/div[1]/div/div[2]/div/div[2]/div")).click();
		
		//newListName = "//*[@id=\"kt_content\"]/div/div/app-list-type/div[2]/div[1]/div/div[2]/div/div[2]/div/div[2]/h4";
		//newListNameValue = pC.getXpathtext(newListName).trim();
		
		String listitemtitle = pC.getXpathtext("//*[@id=\"kt_content\"]/div/div/app-list-type/div[2]/div[2]/div/div/app-list-item/div/div[1]/div[1]/h3/span");
		
		
	
	pC.driver.findElement(By.xpath(newListItembutton)).click();
	
	String returnedlistTypeName = pC.driver.findElement(By.xpath(listTypeName)).getAttribute("value");
	
	Assert.assertEquals(returnedlistTypeName, listitemtitle);
	
	pC.driver.findElement(By.xpath(dataTypePoint)).sendKeys(dataType_Point);
	
	pC.driver.findElement(By.xpath(dataValue)).sendKeys(data_Value);
	pC.driver.findElement(By.xpath(expiresIn)).clear();
	pC.driver.findElement(By.xpath(expiresIn)).sendKeys(expires_In);
	pC.driver.findElement(By.xpath(expiresInPeriod)).sendKeys(expiresIn_Period);
	pC.driver.findElement(By.xpath(listItemComment)).sendKeys(listItem_Comment);
	pC.driver.findElement(By.xpath(uploadFile)).clear();
	
	
	
	pC.driver.findElement(By.xpath(uploadFile)).sendKeys(pC.filetoUpload);
	
	pC.driver.findElement(By.xpath(saveButton)).click();
	
	Thread.sleep(9000);
	int countelement = pC.driver.findElements(By.xpath(duplicatelistScreen)).size();
    
    if(countelement > 0) {
    	
    	System.out.println(pC.getXpathtext(duplicatelistCheck));
    	
    	String expected = "An item with this value already exists !";
    	
    	handleDuplicateRecordScreen(expected);
    	
    	/*
    	
    //	pC.checkforduplicate(expected);
    	Assert.assertEquals(pC.getXpathtext(duplicatelistCheck), expected);
    	
    	//System.out.println("Record Already Exist");
    	
    	Thread.sleep(3000);
    	
    	pC.driver.findElement(By.xpath(closeErrorModal)).click();
    	pC.driver.findElement(By.xpath(closeNewListModal)).click();
    	
  Assert.assertEquals(pC.getXpathtext(duplicatelistScreen), "Are you sure?");
  pC.driver.findElement(By.xpath("//button[@id='confirm']")).click();
  */
    	
  Assert.assertEquals(pC.getXpathtext(listPageAssetText), "List Types");
    	
    }else {
    	
    	System.out.println("Record saved successfully");
    	Thread.sleep(5000);
    	int numberofrecord = pC.driver.findElements(By.xpath("//*[@id=\"kt_content\"]/div/div/app-list-type/div[2]/div[2]/div/div/app-list-item/div/div[2]/ngx-datatable/div/datatable-body/datatable-selection/datatable-scroller/datatable-row-wrapper/datatable-body-row/div[2]/datatable-body-cell[3]/div")).size();
    	
    	System.out.println("Number of Record = " + numberofrecord);
    	
    	String newListItem = "";
    	
    	for(int k=1; k<=numberofrecord; k++) {
    		 newListItem = pC.getXpathtext("//*[@id=\"kt_content\"]/div/div/app-list-type/div[2]/div[2]/div/div/app-list-item/div/div[2]/ngx-datatable/div/datatable-body/datatable-selection/datatable-scroller/datatable-row-wrapper["+ k +"]/datatable-body-row/div[2]/datatable-body-cell[3]/div");
			
    		//int listrowfound = pC.driver.findElements(By.xpath("//*[@id=\"kt_content\"]/div/div/app-list-type/div[2]/div[1]/div/div[2]/div/div["+ k +"]/div")).size();
		
    		 System.out.println(newListItem);
		
		if (newListItem.equals(data_Value)) {
			
			System.out.println("Item on Grid = " + newListItem);
			System.out.println("Item Saved = " + data_Value);
			break;
			/*
			
			newListName = "//*[@id=\"kt_content\"]/div/div/app-list-type/div[2]/div[1]/div/div[2]/div/div[" + k + "]/div/div[2]/h4";
			newListNameValue = pC.getXpathtext(newListName).trim();
			
	
			pC.driver.findElement(By.xpath("//*[@id=\"kt_content\"]/div/div/app-list-type/div[2]/div[1]/div/div[2]/div/div["+ k +"]/div")).click();
		
				String listitemtitle = pC.getXpathtext("//*[@id=\"kt_content\"]/div/div/app-list-type/div[2]/div[2]/div/div/app-list-item/div/div[1]/div[1]/h3/span");
				Assert.assertEquals(listitemtitle, newListNameValue);
Thread.sleep(3000);
*/
			
		}
		
		
	}
    	
    	
    	
    	Assert.assertEquals(newListItem, data_Value);
    	
    }
    
	
	
	
   
    
	//Users//adekunleadeyeye//eclipse-workspace//EFMS
		
		@SuppressWarnings("unused")
		Wait<WebDriver> wait = new FluentWait<WebDriver>(pC.driver)
			       .withTimeout(Duration.ofSeconds(30))
			       .pollingEvery(Duration.ofSeconds(5))
			       .ignoring(NoSuchElementException.class);
		



		

		//projectConfig.driver.findElement(By.cssSelector("path")).click();
	//	Thread.sleep(3000);
		//projectConfig.driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)=\"Rule Management\"])[1]/preceding::*[name()=\"svg\"][1]")).click();
		//projectConfig.driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)=\"List Management\"])[1]/preceding::*[name()=\"svg\"][1]")).click();
	//	pC.driver.get("https://efmsstudiofront.azurewebsites.net/list");
	//	pC.driver.findElement(By.xpath("//h4[contains(text(),\"MyNewListName22022.01.28.13.44.58\")]")).click();
	//	pC.driver.findElement(By.xpath("//span[contains(text(),\"New List Item\")]")).click();
		
		/*
		projectConfig.driver.findElement(By.xpath("//div[@id=\"kt_content\"]/div/div/app-list-type/div[2]/div/div/div/div[2]/button/span")).click();
	     Thread.sleep(3000);
	    projectConfig.driver.findElement(By.id("list-type-name")).click();
	    projectConfig.driver.findElement(By.id("list-type-name")).clear();
	    projectConfig.driver.findElement(By.id("list-type-name")).sendKeys(listName);
	    projectConfig.driver.findElement(By.id("list-type-description")).click();
	    projectConfig.driver.findElement(By.id("list-type-description")).clear();
	    projectConfig.driver.findElement(By.id("list-type-description")).sendKeys(listNameDescription);
	    projectConfig.driver.findElement(By.xpath("//div[@id=\"abp-modal-footer\"]/abp-button/button/i")).click();
	    
	    Thread.sleep(3000);
		*/
	  //h4[contains(text(),'MyNewListName22022.01.28.13.44.58')]

	}
	
	
	public static void UploadListItem() throws InterruptedException  {
		
		pC.waitForMyElementXpath(listMenu).click();
		pC.waitForMyElementXpath("//*[@id=\"kt_content\"]/div/div/app-list-type/div[2]/div[1]/div/div[2]/div/div[1]/div");
		
		
		String uploadfileButton = "//*[@id=\"kt_content\"]/div/div/app-list-type/div[2]/div[2]/div/div/app-list-item/div/div[1]/div[2]/button[1]";
		String cancelButton = "//*[@id=\"abp-modal-footer\"]/button";
		String downloadlink = "//*[@id=\"abp-modal-body\"]/form/div/div[2]/span";
		String uploadfile = "//*[@id=\"list-item-fileUpload\"]";
		String comment = "//*[@id=\"list-item-comment\"]";
		String saveButton = "//*[@id=\"abp-modal-footer\"]/abp-button";
		
		pC.waitForMyElementXpath(listMenu).click();
		pC.waitForMyElementXpath("//*[@id=\"kt_content\"]/div/div/app-list-type/div[2]/div[1]/div/div[2]/div/div[1]/div");
		
		pC.driver.findElement(By.xpath("//*[@id=\"kt_content\"]/div/div/app-list-type/div[2]/div[1]/div/div[2]/div/div[2]/div")).click();
		
		
		pC.driver.findElement(By.xpath(uploadfileButton)).click();
		
		pC.driver.findElement(By.xpath(downloadlink)).click();
		
		pC.driver.findElement(By.xpath(cancelButton)).click();
		
		pC.driver.findElement(By.xpath(uploadfile)).sendKeys(pC.filetoUpload);
		pC.driver.findElement(By.xpath(comment)).sendKeys("Upload Comment");
		
		pC.driver.findElement(By.xpath(saveButton)).click();
		 
    	
    }
	//@Test
	public static void viewListItem() throws InterruptedException  {
		
					pC.waitForMyElementXpath(listMenu).click();
					
					//Thread.sleep(5000);
					pC.waitForMyElementXpath("//*[@id=\"kt_content\"]/div/div/app-list-type/div[2]/div[1]/div/div[2]/div/div[2]/div");
					
		
		//check if there are no existing list, create one before creating list item
					String checkexistinglist = "//*[@id=\"kt_content\"]/div/div/app-list-type/div[2]/div[1]/div/div[2]/div/div";
					int numberoflistavailable = pC.driver.findElements(By.xpath(checkexistinglist)).size();
					System.out.println("Number of List Record = " + numberoflistavailable);
					
		if (numberoflistavailable < 2 ) {
			createList();
		}
			
					pC.driver.findElement(By.xpath("//*[@id=\"kt_content\"]/div/div/app-list-type/div[2]/div[1]/div/div[2]/div/div[2]/div")).click();
			    	
					Thread.sleep(5000);
					int numberofrecord = pC.driver.findElements(By.xpath("//*[@id=\"kt_content\"]/div/div/app-list-type/div[2]/div[2]/div/div/app-list-item/div/div[2]/ngx-datatable/div/datatable-body/datatable-selection/datatable-scroller/datatable-row-wrapper/datatable-body-row/div[2]/datatable-body-cell[3]/div")).size();
					
					
					System.out.println("Number of List Item Record = " + numberofrecord);
					
					if (numberofrecord < 1 ) {
	    		createNewListItem();	
	    }
	    
	    	String newListItemRow = "";
	    	//String listitemdatavalue = "";
	    	String listitemcloseview = "";
	    	String confirmview = "//*[@id=\"kt_view_list_item\"]/div[2]/div[2]";
	    	
	    for(int k=1; k<=numberofrecord; k++) {
	    	//listitemdatavalue = pC.getXpathtext("//*[@id=\"kt_content\"]/div/div/app-list-type/div[2]/div[2]/div/div/app-list-item/div/div[2]/ngx-datatable/div/datatable-body/datatable-selection/datatable-scroller/datatable-row-wrapper["+ k +"]/datatable-body-row/div[2]/datatable-body-cell[3]/div");
			newListItemRow = "//*[@id=\"kt_content\"]/div/div/app-list-type/div[2]/div[2]/div/div/app-list-item/div/div[2]/ngx-datatable/div/datatable-body/datatable-selection/datatable-scroller/datatable-row-wrapper[" + k + "]/datatable-body-row/div[2]/datatable-body-cell[1]/div/div";
			
			
			listitemcloseview = "//a[@id='kt_view_list_item_close']";
			
			pC.driver.findElement(By.xpath(newListItemRow)).click();
			pC.waitForMyElementXpath(confirmview);
			
			pC.driver.findElement(By.xpath(listitemcloseview)).click();
			//String listitemviewconfirm = "//*[@id=\"kt_view_list_item\"]/div[1]/h3";
			
			
			
			//pC.driver.findElement(By.xpath(newListItemRow)).click();
   		
   		//Thread.sleep(3000);
			
			//int listrowfound = pC.driver.findElements(By.xpath("//*[@id=\"kt_content\"]/div/div/app-list-type/div[2]/div[1]/div/div[2]/div/div["+ k +"]/div")).size();
		
   		 //System.out.println(listitemdatavalue);
	    }
		 
    	
    }
	
	
	
	
	
	
	private static void handleDuplicateRecordScreen(String expected) throws InterruptedException {
	//	String expected = "A list with same name already exists!";
    	
    	Assert.assertEquals(pC.getXpathtext(duplicatelistCheck), expected);
    	
    	System.out.println (pC.getXpathtext(duplicatelistCheck));
    	
    	Thread.sleep(3000);
    	pC.driver.findElement(By.xpath(closeErrorModal)).click();
    	pC.driver.findElement(By.xpath(closeNewListModal)).click();
    	
  Assert.assertEquals(pC.getXpathtext(duplicatelistScreen), "Are you sure?");
  pC.driver.findElement(By.xpath("//button[@id='confirm']")).click();
    	
  Assert.assertEquals(pC.getXpathtext(listPageAssetText), "List Types");
		
	}
	
	
	
}
	
	
	

