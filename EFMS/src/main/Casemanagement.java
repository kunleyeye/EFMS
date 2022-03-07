package main;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Casemanagement {
		
	  
		 @Test
		  public void testCaseDashboard() throws Exception {
		    //pC.driver.get("https://efmsstudiofront.azurewebsites.net/");
			 // Thread.sleep(5000);
			  pC.waitForMyElementXpath("//*[@id=\"kt_aside\"]/div[1]/div[1]/div/ul/li[3]");
		    pC.driver.findElement(By.xpath("//*[@id=\"kt_aside\"]/div[1]/div[1]/div/ul/li[3]")).click();
		    pC.waitForMyElementXpath("//div[@id='kt_content']/div/div/app-cases/div[2]/div/div[2]/ngx-datatable/div/datatable-body/datatable-selection/datatable-scroller/datatable-row-wrapper/datatable-body-row/div[2]/datatable-body-cell[2]/div");
		    pC.driver.findElement(By.xpath("//div[@id='kt_content']/div/div/app-cases/div[2]/div/div[2]/ngx-datatable/div/datatable-body/datatable-selection/datatable-scroller/datatable-row-wrapper/datatable-body-row/div[2]/datatable-body-cell[2]/div")).click();
		   
		    pC.driver.findElement(By.xpath("//div[@id='kt_content']/div/div/app-cases/div[2]/div/div/div/div[2]/button[2]/i")).click();
		    pC.waitForMyElementXpath("//div[@id='kt_content']/div/div/app-cases/div[2]/div/div[2]/ngx-datatable/div/datatable-body/datatable-selection/datatable-scroller/datatable-row-wrapper/datatable-body-row/div[2]/datatable-body-cell[2]/div");
		    pC.driver.findElement(By.xpath("//div[@id='kt_content']/div/div/app-cases/div[2]/div/div[2]/ngx-datatable/div/datatable-body/datatable-selection/datatable-scroller/datatable-row-wrapper/datatable-body-row/div[2]/datatable-body-cell[2]/div")).click();
		   
		    pC.driver.findElement(By.xpath("//div[@id='kt_content']/div/div/app-cases/div[2]/div/div/div/div[2]/button/i")).click();
		    pC.waitForMyElementXpath("//div[@id='kt_content']/div/div/app-cases/div[3]/div/div/div[2]/ngx-datatable/div/datatable-body/datatable-selection/datatable-scroller/datatable-row-wrapper/datatable-body-row/div[2]/datatable-body-cell/div/div/div/div[2]/span[3]");
		    pC.driver.findElement(By.xpath("//div[@id='kt_content']/div/div/app-cases/div[3]/div/div/div[2]/ngx-datatable/div/datatable-body/datatable-selection/datatable-scroller/datatable-row-wrapper/datatable-body-row/div[2]/datatable-body-cell/div/div/div/div[2]/span[3]")).click();
		    
		    //pC.driver.findElement(By.id("kt_datatable_search_status")).click();
		    new Select(pC.driver.findElement(By.id("kt_datatable_search_status"))).selectByVisibleText("Pending");
		    pC.driver.findElement(By.xpath("//div[@id='kt_content']/div/div/app-cases/div[2]/div/div/div/div/div/div[3]/button")).click();
		    pC.waitForMyElementXpath("//div[@id='kt_content']/div/div/app-cases/div[3]/div/div/div[2]/ngx-datatable/div/datatable-body/datatable-selection/datatable-scroller/datatable-row-wrapper/datatable-body-row/div[2]/datatable-body-cell/div/div/div/div[2]/span");
		    pC.driver.findElement(By.xpath("//div[@id='kt_content']/div/div/app-cases/div[3]/div/div/div[2]/ngx-datatable/div/datatable-body/datatable-selection/datatable-scroller/datatable-row-wrapper/datatable-body-row/div[2]/datatable-body-cell/div/div/div/div[2]/span")).click();
		   
		    // pC.driver.findElement(By.id("kt_datatable_search_status")).click();
		    new Select(pC.driver.findElement(By.id("kt_datatable_search_status"))).selectByVisibleText("Closed");
		    pC.driver.findElement(By.xpath("//div[@id='kt_content']/div/div/app-cases/div[2]/div/div/div/div/div/div[3]/button")).click();
		    pC.waitForMyElementXpath("//div[@id='kt_content']/div/div/app-cases/div[3]/div/div/div[2]/ngx-datatable/div/datatable-body/datatable-selection/datatable-scroller/datatable-row-wrapper/datatable-body-row/div[2]/datatable-body-cell/div/div/div/div[2]/span");
		    pC.driver.findElement(By.xpath("//div[@id='kt_content']/div/div/app-cases/div[3]/div/div/div[2]/ngx-datatable/div/datatable-body/datatable-selection/datatable-scroller/datatable-row-wrapper/datatable-body-row/div[2]/datatable-body-cell/div/div/div/div[2]/span")).click();
		   
		    //pC.driver.findElement(By.id("kt_datatable_search_status")).click();
		    new Select(pC.driver.findElement(By.id("kt_datatable_search_status"))).selectByVisibleText("In-Progress");
		    pC.driver.findElement(By.xpath("//div[@id='kt_content']/div/div/app-cases/div[2]/div/div/div/div/div/div[3]/button")).click();
		    pC.waitForMyElementXpath("//div[@id='kt_content']/div/div/app-cases/div[3]/div/div/div[2]/ngx-datatable/div/datatable-body/datatable-selection/datatable-scroller/datatable-row-wrapper/datatable-body-row/div[2]/datatable-body-cell/div/div/div/div[2]/span");
		    pC.driver.findElement(By.xpath("//div[@id='kt_content']/div/div/app-cases/div[3]/div/div/div[2]/ngx-datatable/div/datatable-body/datatable-selection/datatable-scroller/datatable-row-wrapper/datatable-body-row/div[2]/datatable-body-cell/div/div/div/div[2]/span")).click();
		    pC.driver.findElement(By.xpath("//div[@id='kt_content']/div/div/app-cases/div[2]/div/div/div/div[2]/button[3]/i")).click();
		  
		  }
		  
		  

		  @Test
		  public void NewTask_Case() throws Exception {
		
			
				//for (int k=1; k <=10; k++) {
			  
			 
			int random_int = (int)Math.floor(Math.random()*(50-1+1)+1);
			 String taskTitle = "TaskTitle-Auto "+random_int;
			 String taskDecription = "TaskDescription - Auto " + random_int;

		    pC.driver.get("https://efmsstudiofront.azurewebsites.net/cases");
		    pC.waitForMyElementXpath("//div[@id='kt_content']/div/div/app-cases/div[2]/div/div[2]/ngx-datatable/div/datatable-body/datatable-selection/datatable-scroller/datatable-row-wrapper[1]/datatable-body-row/div[2]/datatable-body-cell/div/div/div/button");
		    pC.driver.findElement(By.xpath("//div[@id='kt_content']/div/div/app-cases/div[2]/div/div[2]/ngx-datatable/div/datatable-body/datatable-selection/datatable-scroller/datatable-row-wrapper[1]/datatable-body-row/div[2]/datatable-body-cell/div/div/div/button")).click();
		    pC.driver.findElement(By.xpath("//body[@id='kt_body']/div/div/button")).click();
		    
		    pC.driver.findElement(By.id("task-title")).click();
		    pC.driver.findElement(By.id("task-title")).clear();
		    pC.driver.findElement(By.id("task-title")).sendKeys(taskTitle);
		    pC.driver.findElement(By.id("task-description")).click();
		    pC.driver.findElement(By.id("task-description")).clear();
		    pC.driver.findElement(By.id("task-description")).sendKeys(taskDecription);
		    
		    pC.driver.findElement(By.xpath("//div[@id='abp-modal-body']/form/div/div[3]/div/label[3]/span")).click();
		    
		    
		    pC.driver.findElement(By.xpath("//p-calendar[@id='task-dueDate']/span/input")).click();
		    
		    pC.driver.findElement(By.xpath(pickdatexpath(pC.todaydate()))).click();
		    
		  
		    pC.driver.findElement(By.id("task-assignedToUserId")).click();
		    new Select(pC.driver.findElement(By.id("task-assignedToUserId"))).selectByVisibleText("Adekunle Adeyeye(adekunle.adeyeye@pwc.com)");
		    pC.driver.findElement(By.xpath("//button[@id='']")).click();

		   
		    pC.waitForMyElementXpath("//body[@id='kt_body']/abp-toast-container/div/abp-toast/div/div[2]/div");
		    pC.driver.findElement(By.xpath("//body[@id='kt_body']/abp-toast-container/div/abp-toast/div/div[2]/div")).click();
			
				//}
				
		    closeTask("Task");
		    
		}
		
		public static String pickdatexpath(String todaydate) throws InterruptedException {
		//MM/DD/YYYY
		//03/04/2022
			String todaydatearr[] = todaydate.split("/");
			String todaymonth = todaydatearr[0];
			String todayday = todaydatearr[1];
			String todayyear = todaydatearr[2];
			String xpathdueday = "";
			int k = 0;
			int j = 0;
					
			outerloop:
			for(k=1; k<=5; k++) {
				
				for(j=1; j<=7; j++) {
				//System.out.println("Current day " + pC.getXpathtext("//*[@id=\"task-dueDate\"]/span/div/div/div/div[2]/table/tbody/tr[" + k + "]/td[" + j + "]/span"));
				
				String dy = pC.getXpathtext("//*[@id=\"task-dueDate\"]/span/div/div/div/div[2]/table/tbody/tr[" + k + "]/td[" + j + "]/span");
				System.out.println("Today -> " + todayday + "  || Calendar day -> "+ dy);
				if (todayday.equals(dy)) {
					int m=j+1;
					System.out.println("Day selected " + pC.getXpathtext("//*[@id=\"task-dueDate\"]/span/div/div/div/div[2]/table/tbody/tr[" + k + "]/td[" + m + "]/span"));
					xpathdueday = "//*[@id=\"task-dueDate\"]/span/div/div/div/div[2]/table/tbody/tr[" + k + "]/td[" + m + "]/span";
					
				break outerloop;
				}
					}
				
			}
			return xpathdueday;

		}

		public void closeTask(String taskToClose) throws Exception{

			pC.driver.get("https://efmsstudiofront.azurewebsites.net");
		    //Thread.sleep(10000);
		    
		    pC.waitForMyElementXpath("//*[@id=\"kt_content\"]/div/div/app-home/div[2]/div[2]/div/div[2]/div/div[1]");
		    
		    int  k = pC.driver.findElements(By.xpath("//*[@id=\"kt_content\"]/div/div/app-home/div[2]/div[1]/div[3]/div[1]/div/div[2]/div/div/a")).size();
	    	
		    System.out.println("There are "+k+ " tasks pending User's Action");

		    for (int u = 1; u<=k; u++) {

		    String taskdisplayed = pC.getXpathtext("//*[@id=\"kt_content\"]/div/div/app-home/div[2]/div[1]/div[3]/div[1]/div/div[2]/div[" + u + "]/div/a");
		    System.out.println(taskToClose + " <--To Close  =  Expected--> "+taskdisplayed);
		   
		   if (taskdisplayed.contains(taskToClose)){
		    	System.out.println(taskToClose + " <--To Close  =  Expected--> "+taskdisplayed);
			 String selecttasktoclose = "//*[@id=\"kt_content\"]/div/div/app-home/div[2]/div[1]/div[3]/div[1]/div/div[2]/div[" + u + "]/button/span";
			   pC.waitForMyElementXpath(selecttasktoclose);
			  pC.clickbutton(selecttasktoclose);
			  pC.clickbutton("//*[@id=\"taskComment\"]");
			    pC.driver.findElement(By.xpath("//*[@id=\"taskComment\"]")).clear();
			    pC.sendtext("//*[@id=\"taskComment\"]", "TaskCloseComment - AutoClose");
			    pC.clickbutton("//*[@id=\"abp-modal-footer\"]/abp-button");
			  Thread.sleep(7000);
			 break;
			   
		   }
		    
		    }
		    
		   
		    
		}
		  
		  
	}

	

