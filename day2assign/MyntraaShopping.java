package week4.day2assign;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class MyntraaShopping {

	public static void main(String[] args) throws IOException, InterruptedException {
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		option.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.get("https://www.myntra.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement mouseover = driver.findElement(By.xpath("//div[@class='desktop-navLink']/a[text()='Men']"));
		Actions mouseoverto = new Actions(driver);
		mouseoverto.moveToElement(mouseover).perform();
		driver.findElement(By.xpath("(//a[text()='Jackets'])[1]")).click();
		WebElement scrolltobrand = driver.findElement(By.xpath("//div[@class='vertical-filters-filters brand-container']/span"));
		Actions scrollto = new Actions(driver);
		scrollto.scrollToElement(scrolltobrand).perform();
		driver.findElement(By.xpath("//div[@class='brand-more']")).click();
		driver.findElement(By.xpath("//input[@class='FilterDirectory-searchInput']")).sendKeys("duke");
		//String dukename = driver.findElement(By.xpath("//input[@value='Duke']")).getText();
		driver.findElement(By.xpath("(//input[@value='Duke'])/following-sibling::div")).click();
		driver.findElement(By.xpath("//span[contains(@class,'-close sprites-remove')]")).click();
		 List<WebElement> listofduke= driver.findElements(By.xpath("//div[@class='product-productMetaInfo']/h3"));
		 listofduke.addAll(listofduke);
		 System.out.println("the total duke brand list are-- "+listofduke.size());
		 Thread.sleep(2000);
		 WebElement movetosort = driver.findElement(By.xpath("//span[contains(@class,'myntraweb-sprite sort-')]"));
		 Actions movediscount = new Actions(driver);
		 movediscount.moveToElement(movetosort).perform();
		 driver.findElement(By.xpath("//ul[@class='sort-list']/li[4]/label")).click();
		
		 String lowprice = driver.findElement(By.xpath("(//div[@class='product-price']//span)[1]")).getText();
		 System.out.println("the lowest price is-- "+lowprice);
		 driver.findElement(By.xpath("(//div[@class='product-imageSliderContainer'])[1]//picture")).click();
		 Set<String> windname = driver.getWindowHandles();
		 List<String> newwindowlist = new ArrayList<String>(windname);
		 driver.switchTo().window(newwindowlist.get(1));
		 driver.findElement(By.xpath("(//div[@class='image-grid-imageContainer'])[1]"));
		 File screenshotAs = driver.getScreenshotAs(OutputType.FILE);
			File destination= new File("./snap/img1.png");
			FileUtils.copyFile(screenshotAs, destination);
			System.out.println("ScreenShot img-- "+destination);
			
			driver.findElement(By.xpath("//span[contains(@class,'-sprite pdp-notWishlistedIcon sprites-')]")).click();
			Thread.sleep(5000);
			driver.quit();
			
		}

}
