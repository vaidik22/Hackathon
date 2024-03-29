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

public class HomePageTestCases {
	HomePage home;
	WebDriver driver;

	@Test(priority = 1)
	public void checkUrl() {
		String url = driver.getCurrentUrl();
		Assert.assertEquals(url, "https://www.urbanladder.com/");
	}

	@Test(priority = 2)
	public void ExtractDeal() throws InterruptedException {
		home = new HomePage(driver);
		List<String>L2=home.extractDealsZone();
		List<String>L3=new ArrayList<String>();
		L3.add("Blockbuster Deals");
		L3.add("Clearance Sale");
		L3.add("All Products on Sale");
		L3.add("All Decor on Sale");
		L3.add("UL Assured Picks");
		Boolean flag=true;
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
		Thread.sleep(4000);

	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
