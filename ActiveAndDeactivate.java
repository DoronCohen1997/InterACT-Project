import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

class ActiveAndDeactivate {
	
	//this test create 5 policies and activate \ deactivate in loops
	@Test
	void test() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:\\Automation\\Drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String ExpectedResultAfterSelection = "5 selected";
        String ExpectedResultAfterDeselection = "5 selected";

		
		driver.get("http://10.128.42.252/web/#/recording");
		Thread.sleep(4000);
		driver.findElement(By.id("username")).sendKeys("nice");
		driver.findElement(By.id("password")).sendKeys("nicecti1!");
		driver.findElement(By.xpath("//*[@id='kc-login']")).click();
		Thread.sleep(5000);
		for(int i=1; i<=5; i++){
		Thread.sleep(2000);	
		driver.findElement(By.xpath("//*[text()='New Policy']")).click();
		driver.findElement(By.id("name")).sendKeys("FusionebJ7"+i+"");
		driver.findElement(By.xpath("//*[@class='voice-record-input ng-untouched ng-pristine ng-invalid']")).sendKeys(""+i+"");
		driver.findElement(By.xpath("/html/body/portal-root/portal-home-layout/div[3]/div[2]/lib-recording-policy-create-policy/div/form/div[1]/div[3]/div/div[1]/lib-recording-policy-checkbox/div")).click();
		driver.findElement(By.xpath("/html/body/portal-root/portal-home-layout/div[3]/div[2]/lib-recording-policy-create-policy/div/form/div[1]/div[3]/div/div[2]/lib-recording-policy-checkbox")).click();
		driver.findElement(By.xpath("//*[@id='main-page-button-save']")).click();
		}
		Thread.sleep(1000);
		for(int j=1; j<=2; j++){
			
		for(int i=1; i<=5; i++){
		
		if ( !driver.findElement(By.xpath("/html/body/portal-root/portal-home-layout/div[3]/div[2]/lib-recording-policy-start/div/div[2]/div/mcr-grid/div/ag-grid-angular/div/div[1]/div/div[3]/div[2]/div/div/div["+i+"]/div[1]/div/span[1]/span[2]")).isSelected() )
		{
		     driver.findElement(By.xpath("/html/body/portal-root/portal-home-layout/div[3]/div[2]/lib-recording-policy-start/div/div[2]/div/mcr-grid/div/ag-grid-angular/div/div[1]/div/div[3]/div[2]/div/div/div["+i+"]/div[1]/div/span[1]/span[2]")).click();
		}
		
		}
		Thread.sleep(5000);
		String After5Selection = driver.findElement(By.xpath("//*[@class='selected']")).getText();
		
		if (After5Selection.contentEquals(ExpectedResultAfterSelection)){
			Assert.assertEquals(After5Selection, ExpectedResultAfterSelection);
			System.out.println("Test Passed!");
			driver.findElement(By.xpath("//*[text()='Deactivate']")).click();
            driver.findElement(By.xpath("//*[@class='btn-medium btn-primary']")).click();
        } else {
            System.out.println("Test Failed");
        }
		Thread.sleep(1000);
		for(int i=1; i<=5; i++){
			
			if ( !driver.findElement(By.xpath("/html/body/portal-root/portal-home-layout/div[3]/div[2]/lib-recording-policy-start/div/div[2]/div/mcr-grid/div/ag-grid-angular/div/div[1]/div/div[3]/div[2]/div/div/div["+i+"]/div[1]/div/span[1]/span[2]")).isSelected() )
			{
			     driver.findElement(By.xpath("/html/body/portal-root/portal-home-layout/div[3]/div[2]/lib-recording-policy-start/div/div[2]/div/mcr-grid/div/ag-grid-angular/div/div[1]/div/div[3]/div[2]/div/div/div["+i+"]/div[1]/div/span[1]/span[2]")).click();
			}
			
			}
		
		Thread.sleep(5000);
		String After5Deselected = driver.findElement(By.xpath("//*[@class='selected']")).getText();
		Thread.sleep(1000);
		if (After5Deselected.contentEquals(ExpectedResultAfterDeselection)){
			Assert.assertEquals(After5Deselected, ExpectedResultAfterDeselection);
            System.out.println("Test Passed!");
            driver.findElement(By.xpath("//*[text()='Activate']")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@class='btn-medium btn-primary']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[text()='Dismiss']")).click();
			Thread.sleep(2000);

        } else {
            System.out.println("Test Failed");
        }
		
		}
		driver.close();

	}
	
	//this test for 2 Users that exist (gin, bili & levi, fani) in loops
	@Test
	void test1() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Automation\\Drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String FirstSearch = "gin, bili";
        String SecondSearch = "levi, fani";
		driver.get("http://10.128.42.252/web/#/users");
		Thread.sleep(4000);
		driver.findElement(By.id("username")).sendKeys("nice");
		driver.findElement(By.id("password")).sendKeys("nicecti1!");
		driver.findElement(By.xpath("//*[@id='kc-login']")).click();
		Thread.sleep(5000);
		for(int i=1; i<=1; i++){	
			driver.findElement(By.xpath("//*[@id='quickFilterInput']")).sendKeys("gin");
			Thread.sleep(2000);
			String ResultLastName = driver.findElement(By.xpath("//*[contains(@title, 'gin, bili')]")).getText();
			Thread.sleep(1000);
			if (ResultLastName.contentEquals(FirstSearch)){
				Assert.assertEquals(ResultLastName, FirstSearch);
				System.out.println("Test Passed!");
				driver.findElement(By.xpath("//*[@class='close-x ng-star-inserted']")).click();
				Thread.sleep(2000);
	        } else {
	            System.out.println("Test Failed");
	        }
			
			
			driver.findElement(By.xpath("//*[@id='quickFilterInput']")).sendKeys("fani");
			Thread.sleep(2000);
			String ResultFirstName = driver.findElement(By.xpath("//*[contains(@title, 'levi, fani')]")).getText();
			Thread.sleep(1000);
			if (ResultFirstName.contentEquals(SecondSearch)){
				Assert.assertEquals(ResultFirstName, SecondSearch);
				System.out.println("Test Passed!");
				driver.findElement(By.xpath("//*[@class='close-x ng-star-inserted']")).click();
				Thread.sleep(2000);
	        } else {
	            System.out.println("Test Failed");
	        }

			}
		driver.close();
	}
	
	//this test for Assign / Unassign User (nice) from group that exist (doron cohen) in loops
	@Test
	void test2() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Automation\\Drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
		driver.get("http://10.128.58.7/web/#/users");
		Thread.sleep(4000);
		driver.findElement(By.id("username")).sendKeys("nice");
		driver.findElement(By.id("password")).sendKeys("nicecti1!");
		driver.findElement(By.xpath("//*[@id='kc-login']")).click();
		Thread.sleep(5000);
			
		driver.findElement(By.xpath("//*[text()='Groups']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()=' Default Group ']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@class='svg-arrow-right-dims']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[text()=' Doron Cohen ']")).click();
		Thread.sleep(2000);
		for(int i=1; i<=5; i++){
			driver.findElement(By.xpath("//*[@class='svg-user-dims']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@class='svg-supervisor-dims']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[text()='Yes']")).click();
			Thread.sleep(2000);

		}
		driver.close();
	}
	
	//this test for Add / Remove User (nice) from group that exist (Default Group) in loops
	@Test
	void test3() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Automation\\Drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
		driver.get("http://10.128.58.7/web/#/users");
		Thread.sleep(4000);
		driver.findElement(By.id("username")).sendKeys("nice");
		driver.findElement(By.id("password")).sendKeys("nicecti1!");
		driver.findElement(By.xpath("//*[@id='kc-login']")).click();
		Thread.sleep(5000);
			
		driver.findElement(By.xpath("//*[text()='Groups']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()=' Default Group ']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@class='input-field ng-untouched ng-pristine ng-valid mcr-input']")).sendKeys("nice"); 
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='nice']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='Add']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@class='ui-icons-close']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='Yes']")).click();
		Thread.sleep(2000);
			for(int i=1; i<=5; i++){
				driver.findElement(By.xpath("//*[@class='input-field ng-valid mcr-input ng-dirty ng-touched']")).sendKeys("nice"); 
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[text()='nice']")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[text()='Add']")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@class='ui-icons-close']")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[text()='Yes']")).click();
				Thread.sleep(2000);
			
			}
		driver.close();
	}
	
	//this test for cancel to new profile in loops
	@Test
	void test4() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Automation\\Drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
		driver.get("http://10.128.58.7/web/#/profiles");
		Thread.sleep(4000);
		driver.findElement(By.id("username")).sendKeys("nice");
		driver.findElement(By.id("password")).sendKeys("nicecti1!");
		driver.findElement(By.xpath("//*[@id='kc-login']")).click();
		Thread.sleep(5000);
			
		driver.findElement(By.xpath("//*[text()='New Profile']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/portal-root/portal-home-layout/div[3]/div[2]/profile-create/div/div[2]/profile-info/div/div[1]/mcr-input-text/div/div/input")).sendKeys("doron");
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/portal-root/portal-home-layout/div[3]/div[2]/profile-create/div/div[2]/profile-info/div/div[2]/mcr-input-text/div/div/input")).sendKeys("cohen");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[text()='Cancel']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='Stay']")).click();
		Thread.sleep(2000);
		if(!driver.findElements(By.xpath("//*[text()=' New Profile ']")).isEmpty()){
			System.out.println("Test Passed");
	    }else{
	    	System.out.println("Test Failed");
	    }
		driver.findElement(By.xpath("//*[text()='Cancel']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='Leave']")).click();
		Thread.sleep(2000);
		if(!driver.findElements(By.xpath("/html/body/portal-root/portal-home-layout/div[3]/div[2]/lib-user-profiles-grid/div/div[1]/div[1]/div")).isEmpty()){
			System.out.println("Test Passed");
	    }else{
	    	System.out.println("Test Failed");
	    }
		driver.findElement(By.xpath("//*[text()='New Profile']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/portal-root/portal-home-layout/div[3]/div[2]/profile-create/div/div[2]/profile-info/div/div[1]/mcr-input-text/div/div/input")).sendKeys("doron");
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/portal-root/portal-home-layout/div[3]/div[2]/profile-create/div/div[2]/profile-info/div/div[2]/mcr-input-text/div/div/input")).sendKeys("cohen");
		Thread.sleep(2000);
		 ///////////////////////////////////////////
		driver.findElement(By.xpath("/html/body/portal-root/portal-home-layout/div[3]/div[2]/profile-create/div/div[1]/div[1]/div[1]/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='Stay']")).click();
		Thread.sleep(2000);
		if(!driver.findElements(By.xpath("//*[text()=' New Profile ']")).isEmpty()){
			System.out.println("Test Passed");
	    }else{
	    	System.out.println("Test Failed");
	    }
		driver.findElement(By.xpath("/html/body/portal-root/portal-home-layout/div[3]/div[2]/profile-create/div/div[1]/div[1]/div[1]/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='Leave']")).click();
		Thread.sleep(2000);
		if(!driver.findElements(By.xpath("/html/body/portal-root/portal-home-layout/div[3]/div[2]/lib-user-profiles-grid/div/div[1]/div[1]/div")).isEmpty()){
			System.out.println("Test Passed");
	    }else{
	    	System.out.println("Test Failed");
	    }
		
			driver.close();
		}
	
	//this test Add\Update\Delete Recording Account to new user (Nice) in loops
	@Test
	void test5() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Automation\\Drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
		driver.get("http://10.128.42.252/web/#/users");
		Thread.sleep(4000);
		driver.findElement(By.id("username")).sendKeys("nice");
		driver.findElement(By.id("password")).sendKeys("nicecti1!");
		driver.findElement(By.xpath("//*[@id='kc-login']")).click();
		Thread.sleep(5000);
		for(int i=1; i<=2; i++){
		driver.findElement(By.xpath("//*[text()='NICE_user, NICE_user ']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='Add Account']")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("/html/body/portal-root/portal-home-layout/div[3]/div[2]/edit-user/div/div[2]/tabset/div/tab/user-general/div/div/div/div[3]/recording-account/div/div[2]/mcr-drop-down/div/div/button")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='cisco']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("/html/body/portal-root/portal-home-layout/div[3]/div[2]/edit-user/div/div[2]/tabset/div/tab/user-general/div/div/div/div[3]/recording-account/div/div[3]/mcr-drop-down/div/div/button")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='Extension']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("/html/body/portal-root/portal-home-layout/div[3]/div[2]/edit-user/div/div[2]/tabset/div/tab/user-general/div/div/div/div[3]/recording-account/div/div[4]/input")).sendKeys("1234");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[text()='Save']")).click();
		Thread.sleep(2000);
		 ///////////////////////////////////////////
		driver.findElement(By.xpath("//*[text()='NICE_user, NICE_user ']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/portal-root/portal-home-layout/div[3]/div[2]/edit-user/div/div[2]/tabset/div/tab/user-general/div/div/div/div[3]/recording-account/div/div[4]/input")).sendKeys("6789");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='Save']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/portal-root/portal-home-layout/div[3]/div[2]/edit-user/div/div[1]/div/div[2]/popover-container/div[2]/mcr-confirmation-popover/div/div[2]/mcr-button[2]/div/button/span")).click();
		Thread.sleep(2000);
		//////////////////////////////////////
		driver.findElement(By.xpath("//*[text()='NICE_user, NICE_user ']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@class='svg-delete-dims']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='Delete']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='Save']")).click();
		Thread.sleep(2000);
		 }
			driver.close();
		}
	
	//this test for Group search feature in RP Section (100 doron 100 fusion doron & Cohen Doron & Doron) in loops
	@Test
	void test6() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Automation\\Drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
		driver.get("http://10.128.42.252/web/#/recording");
		Thread.sleep(4000);
		driver.findElement(By.id("username")).sendKeys("nice");
		driver.findElement(By.id("password")).sendKeys("nicecti1!");
		driver.findElement(By.xpath("//*[@id='kc-login']")).click();
		Thread.sleep(5000);
		for(int i=1; i<=2; i++){
		driver.findElement(By.xpath("//*[text()='FusionebJ71']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='Groups']")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//*[text()='Select groups']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/portal-root/portal-home-layout/div[3]/div[2]/lib-recording-policy-edit-policy/div/form/div[2]/div[2]/div[2]/lib-recording-policy-groups-filter-window/div/div[2]/div/mcr-advanced-drop-down/div/div[2]/mcr-search-box/div/mcr-input-text/div/input")).sendKeys("doron");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("/html/body/portal-root/portal-home-layout/div[3]/div[2]/lib-recording-policy-edit-policy/div/form/div[2]/div[2]/div[2]/lib-recording-policy-groups-filter-window/div/div[2]/div/mcr-advanced-drop-down/div/div[2]/div/div/div/div[1]/mcr-single-or-multiple-item/div/div[1]/mcr-check-box/div/label")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/portal-root/portal-home-layout/div[3]/div[2]/lib-recording-policy-edit-policy/div/form/div[2]/div[2]/div[2]/lib-recording-policy-groups-filter-window/div/div[2]/div/mcr-advanced-drop-down/div/div[2]/div/div/div/div[1]/mcr-single-or-multiple-item/div/div[2]/mcr-check-box/div/label")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/portal-root/portal-home-layout/div[3]/div[2]/lib-recording-policy-edit-policy/div/form/div[2]/div[2]/div[2]/lib-recording-policy-groups-filter-window/div/div[2]/div/mcr-advanced-drop-down/div/div[2]/div/div/div/div[1]/mcr-single-or-multiple-item/div/div[3]/mcr-check-box/div/label")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/portal-root/portal-home-layout/div[3]/div[2]/lib-recording-policy-edit-policy/div/form/div[2]/div[2]/div[2]/lib-recording-policy-groups-filter-window/div/div[2]/div/mcr-advanced-drop-down/div/div[2]/div/div/div/div[1]/mcr-single-or-multiple-item/div/div[4]/mcr-check-box/div/label")).click();
		Thread.sleep(3000);
		if(!driver.findElements(By.xpath("//*[text()='Groups (4)']")).isEmpty()){
			System.out.println("Test Passed");
	    }else{
	    	System.out.println("Test Failed");
	    }
		driver.findElement(By.xpath("//*[text()='Save']")).click();
		Thread.sleep(10000);
		////////////////////////////////////////////////////

		driver.findElement(By.xpath("//*[text()='FusionebJ71']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[contains(@title, 'Doron')]//*[@class='clear-icon ui-icons-close']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[contains(@title, 'Doron')]//*[@class='clear-icon ui-icons-close']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[contains(@title, '100 doron 100 fusion doron')]//*[@class='clear-icon ui-icons-close']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[contains(@title, 'Doron')]//*[@class='clear-icon ui-icons-close']")).click();
		Thread.sleep(3000);
		if(!driver.findElements(By.xpath("//*[text()='No groups selected']")).isEmpty()){
			System.out.println("Test Passed");
	    }else{
	    	System.out.println("Test Failed");
	    }
		
		//////////////////////////////////////
		driver.findElement(By.xpath("//*[@class='svg-Close-dims']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[text()='Save']")).click();
		Thread.sleep(5000);

		 }
			driver.close();
		}
	
	//this test Update Recording Policy that exist in loops
	@Test
	void test7() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Automation\\Drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
		driver.get("http://10.128.42.252/web/#/recording");
		Thread.sleep(4000);
		driver.findElement(By.id("username")).sendKeys("nice");
		driver.findElement(By.id("password")).sendKeys("nicecti1!");
		driver.findElement(By.xpath("//*[@id='kc-login']")).click();
		Thread.sleep(5000);
		for(int i=3; i<=5; i++){
		driver.findElement(By.xpath("//*[text()='FusionebJ71']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@class='voice-record-input ng-untouched ng-pristine ng-valid']")).sendKeys(""+i+"");
		Thread.sleep(2000);

		driver.findElement(By.xpath("/html/body/portal-root/portal-home-layout/div[3]/div[2]/lib-recording-policy-edit-policy/div/form/div[1]/div[3]/div/div[1]/lib-recording-policy-checkbox/div/label")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/portal-root/portal-home-layout/div[3]/div[2]/lib-recording-policy-edit-policy/div/form/div[1]/div[3]/div/div[2]/lib-recording-policy-checkbox/div/label")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='main-page-button-save']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='Recording Policies']")).click();
		Thread.sleep(2000);

		 }
			driver.close();
		}
	
	//this test Search Profiles that exist (Doron * 10 & Test * 100) in loops
	@Test
	void test8() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Automation\\Drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String ProfileSearch = "10 profiles found";
        String ProfileSearchBigAmount = "Showing 100 profiles";
		driver.get("http://10.128.58.7/web/#/profiles");
		Thread.sleep(4000);
		driver.findElement(By.id("username")).sendKeys("nice");
		driver.findElement(By.id("password")).sendKeys("nicecti1!");
		driver.findElement(By.xpath("//*[@id='kc-login']")).click();
		Thread.sleep(5000);
					
		driver.findElement(By.xpath("//*[@class='ng-untouched ng-pristine ng-valid mcr-input']")).sendKeys("doron");
		Thread.sleep(1000);
		String ResultProfileName = driver.findElement(By.xpath("//*[text()='10 profiles found']")).getText();
		Thread.sleep(1000);
		if (ResultProfileName.contentEquals(ProfileSearch)){
			Assert.assertEquals(ResultProfileName, ProfileSearch);
			System.out.println("Test Passed!");
			driver.findElement(By.xpath("//*[@class='icon ui-icons-close']")).click();
			Thread.sleep(2000);
        } else {
            System.out.println("Test Failed");
        }
		
		/////////////////////////////////////////////////////
		driver.findElement(By.xpath("//*[@class='ng-valid mcr-input ng-dirty ng-touched']")).sendKeys("test");
		Thread.sleep(5000);
		String ResultProfileBigAmount = driver.findElement(By.xpath("//*[text()='Showing 100 profiles']")).getText();
		Thread.sleep(1000);
		if (ResultProfileBigAmount.contentEquals(ProfileSearchBigAmount)){
			Assert.assertEquals(ResultProfileBigAmount, ProfileSearchBigAmount);
			System.out.println("Test Passed!");
			driver.findElement(By.xpath("//*[@class='icon ui-icons-close']")).click();
			Thread.sleep(2000);
        } else {
            System.out.println("Test Failed");
        }
		
			driver.close();
		}
	
	//this Test Create 1000 Groups.
	@Test
	void test9() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Automation\\Drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
		driver.get("http://10.128.58.7/web/#/users");
		Thread.sleep(4000);
		driver.findElement(By.id("username")).sendKeys("nice");
		driver.findElement(By.id("password")).sendKeys("nicecti1!");
		driver.findElement(By.xpath("//*[@id='kc-login']")).click();
		Thread.sleep(5000);
					
		driver.findElement(By.xpath("//*[text()='Groups']")).click();
		Thread.sleep(1000);
		
		for(int i=1; i<=1000; i++){
		driver.findElement(By.xpath("//*[text()=' Default Group ']")).click();
		Thread.sleep(1000);
		
		/////////////////////////////////////////////////////
		
		Actions actions = new Actions(driver);
		WebElement elementLocator = driver.findElement(By.xpath("//*[text()=' Default Group ']"));
		actions.contextClick(elementLocator).perform();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[text()='Add subgroup']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/portal-root/portal-home-layout/div[3]/div[2]/groups/div/lib-user-overview/div/div[2]/lib-user-groups-tree/div/div[2]/mat-tree/mat-tree-node[2]/lib-group-node/div/lib-user-add-group/div/div/form/input")).sendKeys("ronit"+i+"");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[text()='Create']")).click();
		Thread.sleep(2000);
		}
		
			driver.close();
		}
	//this Test Save New Profile & check if the new profile exist.
	@Test
	void test10() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Automation\\Drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String ProfileSearch10 = "1 profile found";
		driver.get("http://10.128.58.7/web/#/profiles");
		Thread.sleep(4000);
		driver.findElement(By.id("username")).sendKeys("nice");
		driver.findElement(By.id("password")).sendKeys("nicecti1!");
		driver.findElement(By.xpath("//*[@id='kc-login']")).click();
		Thread.sleep(5000);
			
		driver.findElement(By.xpath("//*[text()='New Profile']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/portal-root/portal-home-layout/div[3]/div[2]/profile-create/div/div[2]/profile-info/div/div[1]/mcr-input-text/div/div/input")).sendKeys("Bibi");
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/portal-root/portal-home-layout/div[3]/div[2]/profile-create/div/div[2]/profile-info/div/div[2]/mcr-input-text/div/div/input")).sendKeys("Cohen");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='Save']")).click();
		Thread.sleep(2000);
	
		driver.findElement(By.xpath("//*[@class='ng-untouched ng-pristine ng-valid mcr-input']")).sendKeys("Bibi");
		Thread.sleep(1000);
		String ResultProfileName10 = driver.findElement(By.xpath("//*[text()='1 profile found']")).getText();
		Thread.sleep(1000);
		
		if (ResultProfileName10.contentEquals(ProfileSearch10)){
			Assert.assertEquals(ResultProfileName10, ProfileSearch10);
			System.out.println("Test Passed!");
			driver.findElement(By.xpath("//*[@class='icon ui-icons-close']")).click();
			Thread.sleep(2000);
        } else {
            System.out.println("Test Failed");
        }
		///////////////////////////////////////////////////////////////////
		
		
			driver.close();
		}
	
	//this Test Create 1000 Profiles.
		@Test
		void test11() throws Exception {
			System.setProperty("webdriver.chrome.driver", "C:\\Automation\\Drivers\\chromedriver.exe");
	        WebDriver driver = new ChromeDriver();
	        driver.manage().window().maximize();
			driver.get("http://10.128.58.7/web/#/users");
			Thread.sleep(4000);
			driver.findElement(By.id("username")).sendKeys("nice");
			driver.findElement(By.id("password")).sendKeys("nicecti1!");
			driver.findElement(By.xpath("//*[@id='kc-login']")).click();
			Thread.sleep(5000);
						
			driver.findElement(By.xpath("//*[text()='Profiles']")).click();
			Thread.sleep(1000);
			
			for(int i=1; i<=1000; i++){
				driver.findElement(By.xpath("//*[text()='New Profile']")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("/html/body/portal-root/portal-home-layout/div[3]/div[2]/profile-create/div/div[2]/profile-info/div/div[1]/mcr-input-text/div/div/input")).sendKeys("Gila"+i+"");
				Thread.sleep(2000);
				driver.findElement(By.xpath("/html/body/portal-root/portal-home-layout/div[3]/div[2]/profile-create/div/div[2]/profile-info/div/div[2]/mcr-input-text/div/div/input")).sendKeys("Cohen");
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[text()='Save']")).click();
				Thread.sleep(2000);
		
			}
			
				driver.close();
			}
	
	}
	
	
	


