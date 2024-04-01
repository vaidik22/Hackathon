package com.java.bookTest;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.java.book.HomePage;

import utilities.reportGenerator;

public class HomePageTestCases extends reportGenerator {
	HomePage home;
	WebDriver driver;

	@Test(priority = 1, groups= {"smoketest"})
	public void checkUrl() {
		test = extent.startTest("test8");
		String url = driver.getCurrentUrl();
		Assert.assertEquals(url, "https://www.urbanladder.com/");
	}
	
	@Test(priority = 2, groups= {"smoketest"})
	public void checkTitle() {
		test = extent.startTest("test9");
		String actTitle = driver.getTitle();
		Assert.assertEquals(actTitle, "Buy Furniture Online and Get up to 50% Off | Shop Now - Urban Ladder");
	}

	@Test(priority = 3)
	public void ExtractDeal() throws InterruptedException {
		test = extent.startTest("test10");
		home = new HomePage(driver);
		List<String>L2=home.extractDealsZone();
		List<String>L3=new ArrayList<String>();
		L3.add("Blockbuster Deals");
		L3.add("Clearance Sale");
		L3.add("All Products on Sale");
		L3.add("All Decor on Sale");
		L3.add("UL Assured Picks");
		Boolean flag=true;
		Thread.sleep(2000);
		if(!L2.containsAll(L3))
		{
			flag=false;
		}
		Assert.assertTrue(flag);
 
		
		
	}

	@BeforeTest
	public void beforeTest() throws InterruptedException {
		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://urbanladder.com/");

		driver.manage().window().maximize();
		Thread.sleep(2000);

	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
