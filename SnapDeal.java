package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SnapDeal {
	
	public static boolean test=false;

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://www.snapdeal.com/");
		
		driver.findElement(By.id("pushAllow")).click();
		
		driver.findElement(By.xpath("(//span[@class='catText'])[6]")).click();
		
		driver.findElement(By.linkText("Sports Shoes")).click();
		
		String text = driver.findElement(By.xpath("(//a[@class='child-cat-node dp-widget-link hashAdded']/div[2])[2]")).getText();
		
		System.out.println(text);
		
		driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();
		
		driver.findElement(By.xpath("//div[@class='sort-selected']")).click();
		driver.findElement(By.xpath("//ul[@class='sort-value']//li[@data-index='1']")).click();		
	Thread.sleep(2000);
		int temp=0;
		List<WebElement> list = driver.findElements(By.xpath("//span[@class='lfloat product-price']"));
		
		for (WebElement webElement : list) {
			int i=0;
		String price =  webElement.getAttribute("display-price");
		
		
		
		 i=Integer.parseInt(price);
		 
		 if(temp>i && temp!=0 )
		 {
			 System.out.println("Not sorted correctly");
			 test=true;
			 break;
		 }
	
		
		temp=i;
	
			
		}
		
		if ( test=true)
		{
			System.out.println("Sorted correctly");
		}
		
		driver.findElement(By.name("fromVal")).clear();
		driver.findElement(By.name("fromVal")).sendKeys("500");
		driver.findElement(By.name("toVal")).clear();
		driver.findElement(By.name("toVal")).sendKeys("1200");
		
		driver.findElement(By.xpath("//div[@class='price-go-arrow btn btn-line btn-theme-secondary']")).click();
		
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//label[@for='Color_s-Navy']")).click();
		
		Thread.sleep(1000);
		Actions act=new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//img[@title='Columbus Navy Training Shoes']"))).perform();
		
		
		driver.findElement(By.xpath("(//div[@class='center quick-view-bar  btn btn-theme-secondary  '])[1]")).click();
		
		String price = driver.findElement(By.xpath("//span[@class='payBlkBig']")).getText();
		
		String offer = driver.findElement(By.xpath("//span[@class='percent-desc ']")).getText();
		
		System.out.println("price of shoes:  "+price);
		System.out.println("price of shoes:  "+offer);
		
	File scr1=driver.getScreenshotAs(OutputType.FILE);
	
	File dst=new File ("./snaps/shoe.png");
	
	FileUtils.copyFile(scr1, dst);
	
	driver.close();

	}

}
