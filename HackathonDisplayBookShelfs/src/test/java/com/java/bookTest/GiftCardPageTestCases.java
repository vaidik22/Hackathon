package com.java.bookTest;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.java.book.GiftCardPage;
import com.java.book.HomePage;

import utilities.ApachePOI;
import utilities.ScreenShot;
import utilities.reportGenerator;

public class GiftCardPageTestCases extends reportGenerator {
	WebDriver driver;
	HomePage home;
	GiftCardPage giftCardPage;
	ScreenShot ss;
	int num =1;
	@Test(priority = 1)
	public void checkUrlTest() {
		test = extent.startTest("test10");
		String url = driver.getCurrentUrl();
		Assert.assertEquals(url, "https://www.urbanladder.com/");
	}
	@Test(priority=2)
	public void checkClickGiftCardTest() {
		test = extent.startTest("test11");

		Boolean clickBook = driver.findElement(By.xpath("//a[@href='/gift-cards?src=g_footer']")).isDisplayed();
		Assert.assertTrue(clickBook);
		home = new HomePage(driver);
		home.clickGiftCard();
	}

	@Test(priority=3)
	public void OccasionHandleTest() {
		test = extent.startTest("test12");
		giftCardPage = new GiftCardPage(driver);
		giftCardPage.scrollHandleToHeading1();
		giftCardPage.birthdayCardHover();
		Boolean occasion = driver.findElement(By.xpath("//*[@class=\"_11b4v\"][3]")).isDisplayed();
		Assert.assertTrue(occasion);
		giftCardPage.clickOccasionHandle();
	}
	
	@Test(priority=4)
	public void AmountHandlerTest() {
		test = extent.startTest("test13");

		giftCardPage = new GiftCardPage(driver);
		Boolean amount = driver.findElement(By.xpath("//*[@class=\"HuPJS\"][1]")).isDisplayed();
		Assert.assertTrue(amount);
		giftCardPage = new GiftCardPage(driver);
		giftCardPage.AmountHandler();
	}
	
	@Test(priority=5)
	public void DropDownHandlerTest() {
		test = extent.startTest("test14");
		
		giftCardPage = new GiftCardPage(driver);
		giftCardPage.DropDownHandler(2,2);
		List<Boolean>L1=new ArrayList<Boolean>();
		for(int i=1;i<3;i++)
		{
		    Boolean select = driver.findElement(By.xpath("//*[@class=\"Upz18 _1hLiD UJU2v\"]["+i+"]")).isDisplayed();
		    L1.add(select);
		}
		Boolean flag=true;
		if(L1.contains(false))
		{
			flag=false;
		}
		Assert.assertTrue(flag);
	}
	@Test(priority=6)
	public void ButtonHandleTest() {
		test = extent.startTest("test15");
		Boolean select = driver.findElement(By.xpath("//*[contains(text(),\"Next\")][@type=\"button\"]")).isEnabled();
		Assert.assertTrue(select);
		giftCardPage = new GiftCardPage(driver);
		giftCardPage.ButtonHandle();
	}
	@Test(priority = 7,dataProvider = "enterFormDetailsTest")
	public void enterFormDetailsTest(String rname,String remail,String rmobile,String yname,String yemail,String ymobile,String yaddress,String pincode ) throws Exception {
		test = extent.startTest("test17");
		giftCardPage = new GiftCardPage(driver);
	    double d1 = Double.parseDouble(rmobile);
	    Long n1 = (long)d1;
	    String sm = n1.toString();
	    double d3 = Double.parseDouble(ymobile);
	    Long n3 = (long)d3;
	    String sym = n3.toString();
	    double d2 = Double.parseDouble(pincode);
	    Integer n2 = (int)d2;
	    String sp = n2.toString();
		giftCardPage.enterFormDetails(rname,remail,sm,yname, yemail, sym,yaddress, sp);
		Thread.sleep(2000);
		giftCardPage.clickConfirmButtonHandler();
		WebElement errorElement = driver.switchTo().activeElement();
		String actualMsg = errorElement.getAttribute("validationMessage");
        Boolean flag=true;
        if(actualMsg.isEmpty())
        {
        	flag=false;
        }
        Assert.assertTrue(flag);
 
		System.out.println(actualMsg);
 
	}
	@DataProvider(name="enterFormDetailsTest")
	public Object[][] dataProvider() throws Exception
	{
		ApachePOI ap = new ApachePOI();
		Object[][] testData = ap.getData("C:\\Users\\2320033\\git\\repository\\HackathonDisplayBookShelfs\\src\\test\\resources\\ExcelFiles\\", "TestData1", "Sheet2");
		return testData;
	}
	
  @BeforeTest
  @Parameters("browser")
	public void beforeTest(String browser) throws InterruptedException {
		
	  if(browser.equalsIgnoreCase("chrome")) {
	  driver = new ChromeDriver();
	  }
	  else if(browser.equalsIgnoreCase("edge")){
		  driver = new EdgeDriver();
	  }

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
