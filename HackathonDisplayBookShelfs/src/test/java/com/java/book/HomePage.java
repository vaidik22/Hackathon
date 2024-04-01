package com.java.book;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HomePage extends basePage{
	//By element = By.xpath("//*[@id=\"home\"]/div[1]/div[4]/div[3]/div[1]");
	By bookShelf = By.xpath("//a[@href='/bookshelf?src=explore_categories']");
	By giftCard = By.xpath("//*[@id=\"header\"]/section/div/ul[2]/li[3]/a");
	By dealzone = By.xpath("//li[@class='topnav_item dealzoneunit']");
	int j;
	By dealZoneData = By.xpath("//li[@class='topnav_item dealzoneunit']//li["+ j +"]//span[1]");

	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	public void clickBookshelf() {

		WebElement scroll = driver.findElement(By.xpath("//*[@class=\"with-stroke module-heading\"]"));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView();", scroll);

		WebElement clickBookShelfs = driver.findElement(bookShelf);

		clickBookShelfs.click();
	}

	public void clickGiftCard() {
		WebElement clickGiftCard = driver.findElement(giftCard);
		clickGiftCard.click();
	}

	public List<String> extractDealsZone() throws InterruptedException {
		WebElement submenu = driver.findElement(dealzone);
		Actions moveCurser = new Actions(driver);

		moveCurser.moveToElement(submenu).perform();
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].style.display='block'", submenu);
		Thread.sleep(4000);

		List<String> L2 = new ArrayList<String>();

		for (j = 1; j < 6; j++)

		{

			String x = driver.findElement(By.xpath("//li[@class='topnav_item dealzoneunit']//li["+ j +"]//span[1]")).getText();

//			System.out.println(x);

			L2.add(x);

			x = "";

		}

		for (String y : L2)

		{

			System.out.println(y);

		}

		jse.executeScript("arguments[0].style.display = 'block'", submenu);
		return L2;
	}

}
