package main;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class home {
	
	static String selectedItemValue = "";
	static String homexpath = "//*[@id=\"kt_aside\"]/div[1]/div[1]/div/ul/li[2]";
			//body/app-root[1]/abp-dynamic-layout[1]/app-efms-application-layout[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[1]/a[1]";
	static String notXpath = "//*[@id=\"kt_content\"]/div/div/app-home/div[2]/div[1]/div[1]/div/div/a/span[1]";
	static String apprXpath = "//*[@id=\"kt_content\"]/div/div/app-home/div[2]/div[1]/div[3]/div[2]/div/div[1]/div/button";
	                           //*[@id="kt_content"]/div/div/app-home/div[2]/div[1]/div[3]/div[2]/div/div[1]/div/button
	//static String selectapprovalxpath = "body.aside-minimize.abp-application-layout.lp-body-fixed.lp-opened-sidebar.header-mobile-fixed.subheader-enabled.aside-enabled.aside-fixed.aside-secondary-enabled.page-loaded:nth-child(4) app-efms-application-layout.ng-star-inserted div.d-flex.flex-column.flex-root.ng-star-inserted div.d-flex.flex-row.flex-column-fluid.page div.d-flex.flex-column.flex-row-fluid.wrapper div.content.d-flex.flex-column.flex-column-fluid div.d-flex.flex-column-fluid div.container-fluid app-home.ng-star-inserted:nth-child(2) div.row.ng-star-inserted:nth-child(2) div.col-xl-9 div.row:nth-child(3) div.col-md-6:nth-child(2) div.card.card-custom.card-stretch.gutter-b div.card-body.py-0.workspace-widgets.simple-scrollbar div.d-flex.flex-wrap.align-items-center.pb-5.mt-5.border-bottom.ng-star-inserted:nth-child(1) div.d-flex.flex-column.flex-grow-1.my-lg-0.my-2.pr-3:nth-child(1) > a.text-dark-75.text-hover-primary.font-size-lg";
	//static String selectapprovalxpath = "#kt_content > div > div > app-home > div.row.ng-star-inserted > div.col-xl-9 > div:nth-child(3) > div:nth-child(2) > div > div.card-body.py-0.workspace-widgets.simple-scrollbar > div:nth-child(4) > div.d-flex.flex-column.flex-grow-1.my-lg-0.my-2.pr-3 > a";

	static String selectapprovalxpath = "//body/app-root[1]/abp-dynamic-layout[1]/app-efms-application-layout[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/app-home[1]/div[2]/div[1]/div[3]/div[2]/div[1]/div[2]/div[5]/div[1]/a[1]";
	static String selectapprovalxpath1 = "//body/app-root[1]/abp-dynamic-layout[1]/app-efms-application-layout[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/app-home[1]/div[2]/div[1]/div[3]/div[2]/div[1]/div[2]/div[";
	static String selectapprovalxpath2 = "]/div[1]/a[1]";
	static String selectapprovalxpath3 = "";
	/*static String selectapprovalxpath1 = "body.aside-minimize.abp-application-layout.lp-body-fixed.lp-opened-sidebar.header-mobile-fixed.subheader-enabled.aside-enabled.aside-fixed.aside-secondary-enabled.page-loaded:nth-child(4) app-efms-application-layout.ng-star-inserted div.d-flex.flex-column.flex-root.ng-star-inserted div.d-flex.flex-row.flex-column-fluid.page div.d-flex.flex-column.flex-row-fluid.wrapper div.content.d-flex.flex-column.flex-column-fluid div.d-flex.flex-column-fluid div.container-fluid app-home.ng-star-inserted:nth-child(2) div.row.ng-star-inserted:nth-child(2) div.col-xl-9 div.row:nth-child(3) div.col-md-6:nth-child(2) div.card.card-custom.card-stretch.gutter-b div.card-body.py-0.workspace-widgets.simple-scrollbar div.d-flex.flex-wrap.align-items-center.pb-5.mt-5.border-bottom.ng-star-inserted:nth-child(";
	static String selectapprovalxpath2 = ") div.d-flex.flex-column.flex-grow-1.my-lg-0.my-2.pr-3:nth-child(1) > a.text-dark-75.text-hover-primary.font-size-lg\";
	static String selectapprovalxpath3 = "";
	*/
	static String selectapprovalPagexpath = "//*[@id=\"kt_content\"]/div/div/app-view-channel/div[2]/div/div/h3";
	static String eventdatapointTab = "//*[@id=\"kt_content\"]/div/div/app-view-channel/div[3]/div[1]/div/ul/li[1]/a";
	static String rulesTab = "//*[@id=\"kt_content\"]/div/div/app-view-channel/div[3]/div[1]/div/ul/li[2]/a";
	static String caseTab = "//*[@id=\"kt_content\"]/div/div/app-view-channel/div[3]/div[1]/div/ul/li[3]/a";
	
	
	@Test
	public static void homeLanding() throws InterruptedException  {
		pC.driver.get("https://efmsstudiofront.azurewebsites.net/");
		
	
	String asserttask = pC.getXpathtext("//span[contains(text(),'Tasks')]");
	Assert.assertEquals(asserttask, "Tasks");
	
	String assertaprooval = pC.getXpathtext("//span[contains(text(),'Approvals')]");
	Assert.assertEquals(assertaprooval, "Approvals");
	
	String assertfeeds = pC.getXpathtext("//span[contains(text(),'Feeds')]");
	Assert.assertEquals(assertfeeds, "Feeds");
	Thread.sleep(3000);

	
	}
	
	@Test
	public static void ApprovalFromHome() throws InterruptedException {
		
		pC.driver.get("https://efmsstudiofront.azurewebsites.net/");
		

		for(int i=1; i<=10; i++) {

			selectapprovalxpath3 = selectapprovalxpath1 + i + selectapprovalxpath2;

			WebElement seletedItem = pC.waitForMyElementXpath(selectapprovalxpath3);
			selectedItemValue = seletedItem.getText();
			System.out.println("Selected Item - " + selectedItemValue);

			
			if(selectedItemValue.isEmpty()) {	
				
				if(i == 10) {
					
				}
					
			}else {
				seletedItem.click();
				break;	
			}
			
		}
		
			
		Thread.sleep(3000);
		
	}
	
	@Test
	public static void mailNotification() throws InterruptedException  {
		
		 pC.driver.get("https://efmsstudiofront.azurewebsites.net/");
		
			 WebElement notificationIcon = pC.waitForMyElementXpath(notXpath);
			notificationIcon.click();
			
		String assertinbox = pC.getXpathtext("//h1[contains(text(),'Inbox')]");
	Assert.assertEquals(assertinbox, "Inbox");
	Thread.sleep(3000);
	
	}

	@Test
	public static void ApprovalFromApprovalPage() throws InterruptedException  {
		
		 pC.driver.get("https://efmsstudiofront.azurewebsites.net/");
		 
			 WebElement approvalList =  pC.waitForMyElementXpath(apprXpath);
			 approvalList.click();
			 String assertapprovlist = pC.getXpathtext("//h1[contains(text(),'Approval Lists')]");
				Assert.assertEquals(assertapprovlist, "Approval Lists");
				
				
				Thread.sleep(3000);
			
	}
	
	
	
	

	/*
	@Test
	public static void dashboardDayRange() throws InterruptedException  {

	}
	*/
	
}