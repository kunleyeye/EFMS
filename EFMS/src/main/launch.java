package main;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


@SuppressWarnings("unused")
public class launch {
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
	      //configure path of chromedriver.exe
	      System.setProperty("webdriver.chrome.driver", "chromedriver");
	      //ChromeDriver instance
	      WebDriver driver = new ChromeDriver();
	      //implicit wait
	      driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	      //url launch
	      driver.get
	      ("https://www.tutorialspoint.com/about/about_careers.htm");
	      System.out.println("Page title: "+ driver.getTitle());
	      //browser quit
	      driver.quit();
	   }
	
	/*
	public static void authentication(WebDriver driver){
	//TestAuthentication
	//	authentication.loginWithInvalidCredentials(driver);
		//authentication.loginWithValidCredentials(driver);
		//System.out.println("This is a test");
	}
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		projectConfig.launchbrowser();
		//projectConfig.driver.get("https://igrcs-identity.pwcng-rpa.com/Account/Login?ReturnUrl=%2Fconnect%2Fauthorize%2Fcallback%3Fresponse_type%3Dcode%26client_id%3DOrganizationManagement_App%26state%3DcFEwUmwwX1NmYkQyY1R3WVFYVlZ0VHpnTDFsYUJubi5RaWxWbW1QM0cxU1la%26redirect_uri%3Dhttps%253A%252F%252Figrcs-studio.pwcng-rpa.com%26scope%3Dopenid%2520offline_access%2520OrganizationManagement%2520PRCManagementService%2520EMService%2520TaskManagementService%2520RiskEventManagement%2520ContinuousMonitoringModule%2520CapitalModelling%2520AssuranceManagementService%2520ReportService%26code_challenge%3D0uzf-PNqGy_mfByijg0s-jVKacHOKTAM7TyBNkqbpxs%26code_challenge_method%3DS256%26nonce%3DcFEwUmwwX1NmYkQyY1R3WVFYVlZ0VHpnTDFsYUJubi5RaWxWbW1QM0cxU1la%26culture%3Den%26ui-culture%3Den");
		
		//TestAuthentication
		//authentication.loginWithInvalidCredentials(projectConfig.driver);
		//authentication.loginWithValidCredentials(projectConfig.driver);
		
		//Test Business Unit
		//businessUnit.viewBusinessUnit(projectConfig.driver,"TES");

		
		//authentication.logoutUser(projectConfig.driver);
	}
*/
}
