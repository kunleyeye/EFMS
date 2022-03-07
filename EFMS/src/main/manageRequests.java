package main;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class manageRequests {
	
	static String testXpath = "//span[contains(text(),'Tasks')]";

	
	static String requestTitle = "//*[@id=\"kt_content\"]/div/div/app-home/div[2]/div[1]/div[3]/div[2]/div/div[2]/div[1]/div[1]/a";
	static String requestType = "//*[@id=\"kt_content\"]/div/div/app-home/div[2]/div[1]/div[3]/div[2]/div/div[2]/div[1]/div[1]/span";
	static String cPageTitle = "//*[@id=\"kt_content\"]/div/div/app-view-channel/div[1]/div[1]/h1";
	static String cRequestTitle = "//*[@id=\"kt_content\"]/div/div/app-view-channel/div[2]/div/div/h3";
	static String cRequestStatus = "//*[@id=\"kt_content\"]/div/div/app-view-channel/div[2]/div/div/div/span";
	static String cApproveButton = "//*[@id=\"kt_content\"]/div/div/app-view-channel/div[1]/div[3]/div/button[1]";
	static String cRejectButton =  "//*[@id=\"kt_content\"]/div/div/app-view-channel/div[1]/div[3]/div/button[2]";
	static String cBackButton = "//*[@id=\"kt_content\"]/div/div/app-view-channel/div[1]/div[3]/div/button[3]";
	static String cEventDataPointTab = "//*[@id=\"kt_content\"]/div/div/app-view-channel/div[3]/div[1]/div/ul/li[1]/a";
	static String cRulesTab = "//*[@id=\"kt_content\"]/div/div/app-view-channel/div[3]/div[1]/div/ul/li[2]/a";
	static String cCasesTab = "//*[@id=\"kt_content\"]/div/div/app-view-channel/div[3]/div[1]/div/ul/li[3]/a";
	static String cCaseFilterByEvent  = "//select[@id='kt_datatable_search_eventTypeCode']";
	
	//New Event Xpaths
	static String cNewEventButton ="//*[@id=\"kt_content\"]/div/div/app-view-channel/div[3]/div[2]/div/div[1]/div/div[1]/div";
	static String cNewEventTitle = "//*[@id=\"kt_content\"]/div/div/app-new-eventtype/div[1]/div[1]/h1";
	static String cNewEventCode = "//*[@id=\"kt_form\"]/div[1]/div[1]/div/div/input";
	static String cNewEventName = "//*[@id=\"kt_form\"]/div[1]/div[2]/div[1]/input";
	static String cNewGlobalEvent = "//*[@id=\"kt_form\"]/div[1]/div[2]/div[2]/abp-lookup-select/select";
	static String cNewEventDescription = "//*[@id=\"kt_form\"]/div[1]/div[3]/textarea";
	static String cNewEventIsTransaction = "//*[@id=\"kt_form\"]/div[1]/div[4]/div[1]/div/span/label/span";
	static String cNewEventIsTransaction_Debit = "//*[@id=\"kt_form\"]/div[1]/div[4]/div[3]/div/label[1]";
	static String cNewEventIsTransaction_Credit = "//*[@id=\"kt_form\"]/div[1]/div[4]/div[3]/div/label[2]";
	static String cNewEventIsSelfService = "//*[@id=\"kt_form\"]/div[1]/div[4]/div[2]/div/span/label/span";
	static String cNewEventRiskImpactSlider = "//body/app-root[1]/abp-dynamic-layout[1]/app-efms-application-layout[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/app-new-eventtype[1]/div[2]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/div[5]/div[1]/input[1]";
	
	//If limit is active, 
	//Limit Amount must be supplied
	//Customer Account Number must be part of the payload propertie
	//Beneficiary Account Number must be part of the payload properties
	static String cNewEventHasLimit = "//*[@id=\"kt_form\"]/div[1]/div[6]/div/div/span/label/span";
	static String cNewEventHasLimit_Value = "//*[@id=\"kt_form\"]/div[1]/div[6]/div[2]/input";
	
	//if AutoCalibrate is disable , 
	static String cNewEventAutoCalibrate = "//*[@id=\"kt_form\"]/div[1]/div[7]/div/span/label/span";
	static String cNewEventAutoCalibrate_Escalate = "//body[1]/app-root[1]/abp-dynamic-layout[1]/app-efms-application-layout[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/app-new-eventtype[1]/div[2]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/div[8]/div[1]/select[1]";
	static String cNewEventAutoCalibrate_Hold = "//body/app-root[1]/abp-dynamic-layout[1]/app-efms-application-layout[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/app-new-eventtype[1]/div[2]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/div[8]/div[2]/select[1]";
	static String cNewEventAutoCalibrate_Block = "//body/app-root[1]/abp-dynamic-layout[1]/app-efms-application-layout[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/app-new-eventtype[1]/div[2]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/div[8]/div[3]/select[1]";
	static String cNewEventNextPage = "//*[@id=\"kt_form\"]/div[4]/div[2]/button[3]";
	
	//New Event  - DataPoint Properties Xpath
	static String cNewEventNewPayLoadPropertyButton = "//*[@id=\"kt_form\"]/div[2]/button";
	static String cNewEventPayloadDataPointCode = "//input[@id='data-point-code']";
	static String cNewEventPayloadDataPointName = "//input[@id='data-point-name']";
	static String cNewEventPayloadDescription = "//input[@id='data-point-name']";
	static String cNewEventPayloadDataType = "//select[@id='data-point-data-type']";
	static String cNewEventPayloadGlobalDataPoint = "//select[@id='globalDataPointId']";
	static String cNewEventAddDataPointButton = "//*[@id=\"abp-modal-footer\"]/abp-button";
	static String cNewEventPayloadGrid_Name = "//*[@id=\"kt_form\"]/div[2]/div/table/tbody/tr/td[1]/a";
	static String cNewEventPayloadGrid_Delete = "//tbody/tr[1]/td[3]/button[1]/span[1]/*[1]";
	static String cNewEventPayloadNextPage = "//*[@id=\"kt_form\"]/div[4]/div[2]/button[3]";
	
	//Validation
	static String cNewEventCustomerAccountNumberValidator = "//body/abp-toast-container[1]/div[1]/abp-toast[1]/div[1]"; //Customer Account Number
	static String cNewEventBeneficiaryAccountNumberValidator = "//body/abp-toast-container[1]/div[1]/abp-toast[2]/div[1]"; //Beneficiary Account Number 
	
	static String cNewEventSubmit = "//*[@id=\"kt_form\"]/div[4]/div[2]/button[2]";
	
	
	//View Approval List
	static String alrows = "//datatable-body-row";
	/*
	static String cNewEvent = 
	
	
	static String cNewEvent = "";
	static String cNewEvent = "";
	static String cNewEvent = "";
	static String cNewEvent = "";
	static String cNewEvent = "";
	static String cNewEvent = "";
	static String cNewEvent = "";
	static String cNewEvent = "";
	static String cNewEvent = "";
	static String cNewEvent = "";
	static String cNewEvent = "";
	*/
	
	@Test
	public static void testOutput() throws InterruptedException  {
		if (pC.waitForMyElementsXpath(testXpath)>0) {
			System.out.println(pC.waitForMyElementsXpath(testXpath));
		}else {
System.out.println(pC.waitForMyElementsXpath(testXpath));
		}
	//System.out.println(pC.getXpathtext(cApproveButton));
	}
	
	/*
	
	public static void viewRequest() throws InterruptedException  {
		
		String requestTypeText = pC.getXpathtext(requestType);
		
		if (requestTypeText.contains("Channel")) {
			//view Channel Request
			
		}else if (requestTypeText.contains("List Item")) {
			//view List Item Request
			
		}else if (requestTypeText.contains("Event")) {
			//view Event Request
			
		}else if (requestTypeText.contains("Fraud")) {
			//view Fraud Request
			
		}else if (requestTypeText.contains("Case")) {
			//view Case Request
			
		}
		
	//	Assert.assertEquals(pC.getXpathtext(casePageTitle), "View Case");
	//	pC.driver.findElement(By.xpath(casePageTitle)).getText();
	
	String asserttask = pC.getXpathtext("//span[contains(text(),'Tasks')]");
	Assert.assertEquals(asserttask, "Tasks");
	
	String assertaprooval = pC.getXpathtext("//span[contains(text(),'Approvals')]");
	Assert.assertEquals(assertaprooval, "Approvals");
	
	String assertfeeds = pC.getXpathtext("//span[contains(text(),'Feeds')]");
	Assert.assertEquals(assertfeeds, "Feeds");
	

	
	}
	*/
	
}
