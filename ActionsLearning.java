package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionsLearning {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://jqueryui.com/draggable");

		driver.switchTo().frame(0);

		WebElement draggable = driver.findElement(By.id("draggable"));

		Actions act = new Actions(driver);

		act.dragAndDropBy(draggable, 80, 30).perform();

		driver.switchTo().defaultContent();

		driver.get("https://jqueryui.com/droppable/");

		driver.switchTo().frame(0);

		WebElement drag = driver.findElement(By.id("draggable"));
		WebElement drop = driver.findElement(By.id("droppable"));

		act.dragAndDrop(drag, drop).perform();

		driver.switchTo().defaultContent();

		driver.get("https://jqueryui.com/resizable/");

		Thread.sleep(2000);

		driver.switchTo().frame(0);

		WebElement w1 = driver.findElement(
				By.xpath("//div[@class='ui-resizable-handle ui-resizable-se ui-icon ui-icon-gripsmall-diagonal-se']"));

		Actions builder = new Actions(driver);

		builder.clickAndHold(w1).dragAndDropBy(w1, -50, -50).perform();

		driver.switchTo().defaultContent();
		
		driver.get("https://jqueryui.com/selectable/");
		
		driver.switchTo().frame(0);

		WebElement item2 = driver.findElement(By.xpath("//ol[@id='selectable']//li[2]"));
		WebElement item3 = driver.findElement(By.xpath("//ol[@id='selectable']//li[3]"));
		
		builder.moveToElement(item2).click().keyDown(Keys.CONTROL).click(item3).keyUp(Keys.CONTROL).perform();		
		driver.switchTo().defaultContent();
		
		
		driver.get("https://jqueryui.com/sortable/");
		
		driver.switchTo().frame(0);
		
		WebElement items2 = driver.findElement(By.xpath("//ul[@id='sortable']/li[2]"));
		WebElement items5 = driver.findElement(By.xpath("//ul[@id='sortable']/li[5]"));
		
		Point location = items5.getLocation();
		
		int x=location.getX();
		int y=location.getY();
		
		builder.dragAndDropBy(items2, x, y).perform();
		

	}

}
