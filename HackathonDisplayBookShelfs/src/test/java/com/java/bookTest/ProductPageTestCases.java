package com.java.bookTest;

import org.testng.annotations.Test;

import com.java.book.HomePage;
import com.java.book.ProductPage;

import utilities.ScreenShot;
import utilities.reportGenerator;

import org.testng.annotations.BeforeTest;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

public class ProductPageTestCases extends reportGenerator {
	WebDriver driver;
	HomePage page;
	ProductPage page2;
	ScreenShot ss;
	int num =1;

	@Test(priority = 1)
	public void checkUrl() {
		test = extent.startTest("test1");
		String url = driver.getCurrentUrl();
		Assert.assertEquals(url, "https://www.urbanladder.com/");
	}

	@Test(priority = 2)
	public void clickBookShelfTest() {
		test = extent.startTest("test2");

		Boolean clickBook = driver.findElement(By.xpath("//a[@href='/bookshelf?src=explore_categories']")).isDisplayed();
		Assert.assertTrue(clickBook);
		page = new HomePage(driver);
		page.clickBookshelf();

	}

	@Test(priority = 3)
	public void popupTest() throws InterruptedException {
		test = extent.startTest("test3");
		page2 = new ProductPage(driver);
		page2.Popup();
		Boolean popup = driver.findElement(By.xpath("//*[@class='close-reveal-modal hide-mobile']")).isDisplayed();
		Assert.assertTrue(popup);

	}

	@Test(priority = 4)
	public void PriceSliderTest() throws InterruptedException {
		test = extent.startTest("test4");
		page2 = new ProductPage(driver);
		page2.PriceSlider();
		List<String>L1=new ArrayList<String>();
		for(int i=1;i<4;i++)
		{
			String price=driver.findElement(By.xpath("//div[@class='categories row']//li[" + i + "]//a[@class='product-title-block']//meta[1]")).getAttribute("content");
			L1.add(price);
			price="";
		}
		boolean  flag=true;
		for(String x:L1)
		{
		   if(Integer.parseInt(x)>15000)
		   {
			   flag=false;
		   }
		}
		Assert.assertTrue(flag);

	}

	@Test(priority = 5)
	public void StorageTypeTest() {
		page2 = new ProductPage(driver);
		page2.StorageType();
		Boolean flag= driver.findElement(By.id("filters_storage_type_Open")).isSelected();
		Assert.assertTrue(flag);
	}

	@Test(priority = 6)
	public void ExcludeOutOfStockTest() {
		test = extent.startTest("test5");
		page2 = new ProductPage(driver);
		page2.ExcludeOutOfStock();
		Boolean outOfStock = driver.findElement(By.id("filters_availability_In_Stock_Only")).isSelected();
		Assert.assertTrue(outOfStock);
	}

	@Test(priority = 7)
	public void listOfProductsTest() throws InterruptedException {
		test = extent.startTest("test6");
		page2 = new ProductPage(driver);
		Thread.sleep(2000);
		List<String> L2 =page2.listOfProducts();
		boolean flag = true;
		if(L2.isEmpty())
			flag=false;
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
	 @AfterMethod
	  public void takeScreenShot() throws Exception{
		  String name  = "GiftCardPageSS" + num++;
		  ss = new ScreenShot();
		  ss.takeScreenShot(driver, name);
	  }

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
