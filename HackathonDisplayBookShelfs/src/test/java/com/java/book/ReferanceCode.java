package com.java.book;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class ReferanceCode {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		driver= new ChromeDriver();

				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

				driver.get("https://urbanladder.com/");	

				driver.manage().window().maximize();


		        JavascriptExecutor jse=(JavascriptExecutor) driver;

				WebElement element = driver.findElement(By.xpath("//*[@class=\"with-stroke module-heading\"]"));

				jse.executeScript("arguments[0].scrollIntoView();", element);

				WebElement bookSelf= driver.findElement(By.xpath("//a[@href='/bookshelf?src=explore_categories']"));

				bookSelf.click();


				driver.findElement(By.xpath("//*[@class='close-reveal-modal hide-mobile']")).click();//popup

//				Actions actions=new Actions(driver);

//				actions.moveToElement(price);
		 
				WebElement priceElement = driver.findElement(By.cssSelector("li[data-group = 'price'] div.dropdown-content"));

				jse.executeScript("arguments[0].style.display = 'block'", priceElement);

				Actions move=new Actions(driver);

				WebElement slider=driver.findElement(By.xpath("//*[@id=\"filters-form\"]/div[1]/div/div/ul/li[1]/div[2]/div/div/ul/li[1]/div/div[2]/div[2]/div/div[2]/div"));

				move.dragAndDropBy(slider, -274, 0).perform();

				System.out.println(slider.getLocation());

				jse.executeScript("arguments[0].style.display = 'none'", priceElement);

				Thread.sleep(4000);


				WebElement storage = driver.findElement(By.cssSelector("li[data-group='storage type'] div.dropdown-content"));

				jse.executeScript("arguments[0].style.display = 'block'", storage);

				Actions storageActions=new Actions(driver);

				WebElement type= driver.findElement(By.id("filters_storage_type_Open"));

				storageActions.click(type).perform();

				jse.executeScript("arguments[0].style.display = 'none'", storage);


				driver.findElement(By.id("filters_availability_In_Stock_Only")).click();


				List <String> L1=new ArrayList<String>();

				for(int i=1;i<4;i++)

				{

//					WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(50));

//					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='categories row']//li["+i+"]//a[@class=\"product-title-block\"]")));

					String n1=driver.findElement(By.xpath("//div[@class='categories row']//li["+i+"]//a[@class=\"product-title-block\"]")).getAttribute("title");

//					WebDriverWait wait1 = new WebDriverWait(driver,Duration.ofSeconds(50));

//					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='categories row']//li["+i+"]//a[@class=\"product-title-block\"]//meta[1]")));

					String p1=driver.findElement(By.xpath("//div[@class='categories row']//li["+i+"]//a[@class=\"product-title-block\"]//meta[1]")).getAttribute("content");

					L1.add(n1+" - "+p1);

					n1="";

					p1="";

				}

				for(String x:L1)

				{

					System.out.println(x);		

				}


				Thread.sleep(4000);

				jse.executeScript("window.scrollTo(0,0);");

				Thread.sleep(4000);

//				for(int i=1;i<=3;i++)

//				{

//				 driver.navigate().back();

////				 System.out.println("did back "+i);

//				}

//				Thread.sleep(10000);

//				WebElement scrollPage2 = driver.findElement(By.xpath("//*[@class=\"topnav bodytext\"]"));

//				jse.executeScript("arguments[0].scrollIntoView();", scrollPage2);

//				System.out.println(scrollPage2.getLocation());

//				jse.executeScript("window.scrollBy(136,196)");

				WebElement submenu=driver.findElement(By.xpath("//*[@class=\"topnav_item dealzoneunit\"]"));

				Actions moveCurser=new Actions(driver);

				moveCurser.moveToElement(submenu).perform();

				Thread.sleep(3000);

				jse.executeScript("arguments[0].style.display='block'", submenu);

				List<String>L2=new ArrayList<String>();

				for(int j=1;j<6;j++)

				{

					String x=driver.findElement(By.xpath("//*[@class=\"topnav_item dealzoneunit\"]//li["+j+"]//span[1]")).getText();

//					System.out.println(x);

					L2.add(x);

					x="";

				}

				for(String y:L2)

				{

					System.out.println(y);

				}

				jse.executeScript("arguments[0].style.display = 'block'", submenu);

				WebElement scrollPage2=driver.findElement(By.xpath("//*[@data-type=\"faq\"]"));

//				WebElement scrollPage2=driver.findElement(By.xpath("//*[@id=\"footer\"]/div[1]/div[1]/div[1]/div/span"));

				jse.executeScript("arguments[0].scrollIntoView();", scrollPage2);
		 
			

				driver.findElement(By.xpath("//a[@href='/gift-cards?src=g_footer']")).click();


				WebElement ele = driver.findElement(By.xpath("//*[@id=\"app-container\"]/div/main/section/section[1]/ul/li[3]"));

				  //Creating object of an Actions class

				  Actions action = new Actions(driver);

				  //Performing the mouse hover action on the target element.

				  action.moveToElement(ele).perform();

				  driver.findElement(By.xpath("//*[@id=\"app-container\"]/div/main/section/section[1]/ul/li[3]")).click();

				  driver.findElement(By.xpath("//*[@id=\"app-container\"]/div/main/section/section[2]/div/section[2]/div[1]/button[1]")).click();

				  driver.findElement(By.xpath("//*[@id=\"app-container\"]/div/main/section/section[2]/div/section[2]/button")).click();

				  driver.findElement(By.id("ip_4036288348")).sendKeys("dfhjd");

				  driver.findElement(By.id("ip_1082986083")).sendKeys("dfhjd");

				  driver.findElement(By.xpath("//*[@id=\"ip_137656023\"]")).sendKeys("meow@gmail");

				  driver.findElement(By.xpath("//*[@id=\"ip_4081352456\"]")).sendKeys("dfhjd");

				  driver.findElement(By.xpath("//*[@id=\"ip_3177473671\"]")).sendKeys("234241");

				  driver.findElement(By.xpath("//*[@id=\"ip_2121573464\"]")).sendKeys("12321412");

				  driver.findElement(By.xpath("//*[@id=\"ip_2194351474\"]")).sendKeys("kasnfkjn");

				  driver.findElement(By.xpath("//*[@id=\"ip_567727260\"]")).sendKeys("700051");

				  //driver.findElement(By.xpath("//*[@id=\"ip_1554905400\"]")).sendKeys("Kolkata");

				  Thread.sleep(2000);

				  driver.findElement(By.xpath("//*[@id=\"app-container\"]/div/main/section/section[3]/form/button")).click();

				  Thread.sleep(2000);

				  WebElement errorElement = driver.switchTo().activeElement();

				  String actualMsg = errorElement.getAttribute("validationMessage");

				  System.out.println(actualMsg);

				  String expectedMsg = "Please match the requested format.";

				  Assert.assertEquals(actualMsg, expectedMsg);

				  System.out.println(actualMsg);

		 
	}

}
