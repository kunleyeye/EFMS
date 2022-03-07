package main;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;

@SuppressWarnings("unused")
public class pC {
public static ChromeDriver driver;	
	
	static Properties prop = new Properties();
	//static String rawfilepath = "C:\\Users\\aadeyeye\\Documents\\SeleniumProjects\\genesysrnz\\src\\genesysrnz\\testdata.properties";
	static String duplicatelistCheck = "//*[@id=\"kt_body\"]/abp-confirmation/div/div[2]/div[2]/p";
	static String duplicatelistScreen = "//*[@id=\"kt_body\"]/abp-confirmation/div/div[2]/div[2]/h1";
	static String closeErrorModal = "//*[@id=\"confirm\"]";
	static String closeNewListModal = "//*[contains(text(),'Cancel')]";
	
	
	
	//File Upload
	static File classpathRoot = new File(System.getProperty("user.dir"));
    static File TestFileDir = new File(classpathRoot, "/TestFiles");
    static File filepath = new File(TestFileDir, "TestData.xlsx");
    static String filetoUpload = filepath.getAbsolutePath();
    
    
    		
		 			@BeforeTest
					public static void launchbrowser() throws IOException{
		 				
		 				
							
		 				//String browserPath = "/Users/adekunleadeyeye/eclipse-workspace/EFMS/";
		 			//	System.setProperty("webdriver.chrome.driver", "chromedriver");
		 			      System.setProperty("webdriver.chrome.driver", "chromedriver");
					
					ChromeOptions options = new ChromeOptions();

			    	// Disable extensions and hide infobars
			    	options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
					options.setExperimentalOption("useAutomationExtension", false);

			    	Map<String, Object> prefs = new HashMap<>();

			    	// Enable Flash
			    	prefs.put("profile.default_content_setting_values.plugins", 1);
			    	prefs.put("profile.content_settings.plugin_whitelist.adobe-flash-player", 1);
			    	prefs.put("profile.content_settings.exceptions.plugins.*,*.per_resource.adobe-flash-player", 1);

			    	// Hide save credentials prompt
			    	prefs.put("credentials_enable_service", false);
			    	prefs.put("profile.password_manager_enabled", false);
			    	options.setExperimentalOption("prefs", prefs);
			    	
			    	//Launch Browser
			     driver = new ChromeDriver(options);


					driver.manage().window().maximize();
				//	driver.get("https://igrcs-identity.pwcng-rpa.com/Account/Login?ReturnUrl=%2Fconnect%2Fauthorize%2Fcallback%3Fresponse_type%3Dcode%26client_id%3DOrganizationManagement_App%26state%3DcFEwUmwwX1NmYkQyY1R3WVFYVlZ0VHpnTDFsYUJubi5RaWxWbW1QM0cxU1la%26redirect_uri%3Dhttps%253A%252F%252Figrcs-studio.pwcng-rpa.com%26scope%3Dopenid%2520offline_access%2520OrganizationManagement%2520PRCManagementService%2520EMService%2520TaskManagementService%2520RiskEventManagement%2520ContinuousMonitoringModule%2520CapitalModelling%2520AssuranceManagementService%2520ReportService%26code_challenge%3D0uzf-PNqGy_mfByijg0s-jVKacHOKTAM7TyBNkqbpxs%26code_challenge_method%3DS256%26nonce%3DcFEwUmwwX1NmYkQyY1R3WVFYVlZ0VHpnTDFsYUJubi5RaWxWbW1QM0cxU1la%26culture%3Den%26ui-culture%3Den");
					driver.get("https://efmsidentityservice.azurewebsites.net/Account/Login?ReturnUrl=%2Fconnect%2Fauthorize%2Fcallback%3Fresponse_type%3Dcode%26client_id%3DStudio_App%26state%3DVzhWaEhoQWJGZ29FSXRiUXFCanlidk9LenhQLnRoc0lIZktNbW5yZDJQV29P%26redirect_uri%3Dhttps%253A%252F%252Fefmsstudiofront.azurewebsites.net%26scope%3Dopenid%2520Studio%2520ConfigurationManager%2520ListManagement%2520RuleManagementService%2520CaseManagement%2520NotificationService%2520ReportManagementService%2520ContinuousMonitoringModule%26code_challenge%3Dfa1e1GxEr2bJjkTwPgDxcUd77CAf48VcbE8dU3h5Qms%26code_challenge_method%3DS256%26nonce%3DVzhWaEhoQWJGZ29FSXRiUXFCanlidk9LenhQLnRoc0lIZktNbW5yZDJQV29P");
}
				
				public static void scrollMyPage(WebElement elementinView){
					WebElement element = elementinView;
					Actions actions = new Actions(driver);
					actions.moveToElement(element);
					actions.perform();
				}
				public static void scrollToSpecificDiv(WebElement scrollArea) {
		 			    JavascriptExecutor js = ((JavascriptExecutor) pC.driver);
		 			   // js.executeScript(".scrollDown += 100");
		 			  //  js.executeScript("arguments[0].scrollTo(0, arguments[0].scrollHeight)", scrollArea);
		 			    js.executeScript("arguments[0].scrollIntoView();", scrollArea);
		 			}
				
				
				public static void clickbutton(String xpathString) {
	 			    driver.findElement(By.xpath(xpathString)).click();
	 			}
				
				public static void sendtext(String xpathString, String textString) {
	 			    driver.findElement(By.xpath(xpathString)).sendKeys(textString);
	 			}
				
				public static int countrecord(String xpathString) {
	 			  return driver.findElements(By.xpath(xpathString)).size();
	 			
	 			}
				
				public static void logvalue(String stringValue) {
		 			   System.out.println(stringValue);
		 			
		 			}
			
				
				
				 /*
				public static void browserSetup(String webDriverPath, String driverName, String URL){
					//String browserPath = "C:/eclipse/dependencies/WebDrivers/";
					//System.setProperty("webdriver.chrome.driver", webDriverPath+"chromedriver.exe");
					System.setProperty("webdriver.chrome.driver", webDriverPath+driverName+".exe");
					ChromeOptions options = new ChromeOptions();
					driver = new ChromeDriver(options);
					driver.manage().window().maximize();
					//driver.get("file:///C:/Users/Adekunle/Desktop/Personal%20Docs/Efe/devskiller-code-U7RA-QQXD-XH-S0F/src/test/resources/__files/index.html");
					driver.get(URL);
				}
				*/
				 
				
				public static WebElement waitForMyElementXpath(String elementToFind) throws InterruptedException {
					Wait<WebDriver> wait = new FluentWait<WebDriver>(pC.driver)
						       .withTimeout(Duration.ofSeconds(30))
						       .pollingEvery(Duration.ofSeconds(5))
						       .ignoring(NoSuchElementException.class)
						       .withMessage("Element Not Found after several trial");
					
					 WebElement foundElement = wait.until(new Function<WebDriver, WebElement>() {
					     public WebElement apply(WebDriver driver) {
					    	 if (driver.findElement(By.xpath(elementToFind)).isDisplayed()){
					    		 return driver.findElement(By.xpath(elementToFind));
					    	 }else{
					    		 return null;
					    	 }
					    	 
					      
					     }
					   });
					 
					return foundElement;
					
				}
				
				public static int waitForMyElementsXpath(String elementToFind) throws InterruptedException {
					
					Wait<WebDriver> wait = new FluentWait<WebDriver>(pC.driver)
						       .withTimeout(Duration.ofSeconds(30))
						       .pollingEvery(Duration.ofSeconds(5))
						       .ignoring(NoSuchElementException.class)
						       .withMessage("Element Not Found after several trial");
					
					 WebElement foundElement = wait.until(new Function<WebDriver, WebElement>() {
					     public WebElement apply(WebDriver driver) {
					    	 if (driver.findElements(By.xpath(elementToFind)).size()>0){
					    		 return driver.findElement(By.xpath(elementToFind));
					    	 }else{
					    		 return null;
					    	 }
					    	 
					      
					     }
					   });
					 
					return driver.findElements(By.xpath(elementToFind)).size();
					
				}
				
				
				public static WebElement waitForMyElementCss(String elementToFind) throws InterruptedException {
					
					
					
					Wait<WebDriver> wait = new FluentWait<WebDriver>(pC.driver)
						       .withTimeout(Duration.ofSeconds(30))
						       .pollingEvery(Duration.ofSeconds(5))
						       .ignoring(NoSuchElementException.class);
					
					 WebElement foundElement = wait.until(new Function<WebDriver, WebElement>() {
					     public WebElement apply(WebDriver driver) {
					    	 if (driver.findElement(By.cssSelector(elementToFind)).isDisplayed()){
					    		 return driver.findElement(By.xpath(elementToFind));
					    	 }else{
					    		 return null;
					    	 }
					    	 
					      
					     }
					   });
					 
					return foundElement;
					
				}
				
		
				  /*
				
				 static String selectFromList(String xpathleft, String xpathright) throws InterruptedException {
					String xpathcomplete = "";
					String selectedItemValue = "";
					
						WebElement awaitingapproval = waitForMyElementXpath(xpathcomplete);
						 String awaitingapprovalname = awaitingapproval.getText();
						awaitingapproval.click();
						
						//return awaitingapprovalname;
						
						for(int i=1; i<=10; i++) {

							xpathcomplete = xpathleft + i + xpathright;

							WebElement seletedItem = projectConfig.waitForMyElementXpath(xpathcomplete);
							selectedItemValue = seletedItem.getText();
							System.out.println("Selected Item - " + selectedItemValue);

							
							if(selectedItemValue.isEmpty()) {	
								
								if(i == 10) {
									//return no record found
								}
									
							}else {
								seletedItem.click();
								break;	
							}
							
						}
						
						
						
						
					
				}
				  */
				
				public static String getXpathtext(String xpathtolookup) throws InterruptedException {
					// WebElement homeIcon = projectConfig.driver.findElement(By.xpath(homexpath));
					//homeIcon.click();
						WebElement xpathWebelement = waitForMyElementXpath(xpathtolookup);
						 String xpathValue = xpathWebelement.getText();
						
						
						return xpathValue;
						
					
				}
				
				public static String todaydate() throws InterruptedException {
					LocalDateTime today = LocalDateTime.now();
				    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("MM/d/yyyy");
				    String formattedDatetoday = today.format(myFormatObj);
				    return formattedDatetoday;
				}
			    
			    public static String tomorrowdate() throws InterruptedException{
					LocalDateTime today = LocalDateTime.now();
					LocalDateTime tomorrow = today.plusDays(1);
				    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("MM/dd/yyyy");
				    String formattedDatetomorrow = tomorrow.format(myFormatObj);   
				    return formattedDatetomorrow;
				}
					
				
				public static void clickElement(String xpathtolookup) throws InterruptedException {
					// WebElement homeIcon = projectConfig.driver.findElement(By.xpath(homexpath));
					//homeIcon.click();
						WebElement xpathWebelement = waitForMyElementXpath(xpathtolookup);
						 //String xpathValue = xpathWebelement.getText();
						
						xpathWebelement.click();
						
						
					
				}
				
				public static void checkforduplicate(String expected) throws InterruptedException{
					
			    	
			    	Assert.assertEquals(pC.getXpathtext(duplicatelistCheck), expected);
			    	
			    	//System.out.println("Record Already Exist");
			    	
			    	Thread.sleep(3000);
			    	
			    	pC.driver.findElement(By.xpath(closeErrorModal)).click();
			    	pC.driver.findElement(By.xpath(closeNewListModal)).click();
			    	
			  Assert.assertEquals(pC.getXpathtext(duplicatelistScreen), "Are you sure?");
			  pC.driver.findElement(By.xpath("//button[@id='confirm']")).click();
			  
				}
}
