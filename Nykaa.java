package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


import io.github.bonigarcia.wdm.WebDriverManager;

public class Nykaa {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get(" https://www.nykaa.com/");

		WebElement brand = driver.findElement(By.xpath("//a[text()='brands']"));

		Actions act = new Actions(driver);

		act.moveToElement(brand).perform();

		driver.findElement(By.id("brandSearchBox")).sendKeys("L'Oreal Paris");

		driver.findElement(By.linkText("L'Oreal Paris")).click();

		String title = driver.getTitle();

		System.out.println(title);
		
		Thread.sleep(2000);

		 driver.findElement(By.xpath("//span[@title='POPULARITY']")).click();

		driver.findElement(By.xpath("//span[text()='customer top rated']")).click();
		
		Thread.sleep(2000);

		WebElement hair = driver.findElement(By.xpath("//a[text()='hair'][1]"));

		act.moveToElement(hair).perform();

		driver.findElement(By.linkText("Shampoo")).click();

		Set<String> windowHandles = driver.getWindowHandles();

		List<String> l1 = new ArrayList<String>(windowHandles);

		driver.switchTo().window(l1.get(1));

		

		driver.findElement(By.xpath("//div[text()='Concern']")).click();

		driver.findElement(By.xpath("//label[@for='chk_Color Protection_10764']/div")).click();
		
		driver.findElement(By.id("SearchInputBox")).sendKeys("L'Oreal Paris Colour Protect Shampoo"+Keys.ENTER);
		
		driver.findElement(By.xpath("//h2")).click();
		
		Set<String> windowHandles1 = driver.getWindowHandles();

		List<String> l2 = new ArrayList<String>(windowHandles1);

		driver.switchTo().window(l2.get(2));
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//*[text()='ADD TO BAG'])[1]")).click();
		
	
		
		driver.findElement(By.xpath("//div[@class='AddBagIcon']")).click();
		
		String text = driver.findElement(By.xpath("(//div[@class='value'])[4]")).getText();
		
		System.out.println(text);
		
		driver.findElement(By.xpath("//span[text()='Proceed']")).click();
		
		driver.findElement(By.xpath("//button[text()='CONTINUE AS GUEST']")).click();
		
		String text2 = driver.findElement(By.xpath("(//div[@class='value'])[2]")).getText();
		
		if(text.equals(text2))
		{
			System.out.println("select item is correct");
		}
		else
		{
			System.out.println("select item is wrong");
		}
		

	}

}
