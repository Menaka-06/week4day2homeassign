package week4.day2assign;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class AmazonOnePlus {

	public static void main(String[] args) throws IOException, InterruptedException {
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		option.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//div[@class='nav-search-field ']/input")).sendKeys("oneplus 9 pro",Keys.ENTER);
		String mobprice = driver.findElement(By.xpath("//span[text()='46,699']")).getText();
		System.out.println("the price of OnePlus Mobile is:  "+mobprice);
		  WebElement rating = driver.findElement(By.xpath("(//span[text()='1.0 out of 5 stars'])[1]"));
		  Actions custrating = new Actions(driver);
		  custrating.moveToElement(rating).click().perform();
		 String starrate = driver.findElement(By.xpath("//div[@class='a-icon-row a-spacing-small a-padding-none']/span")).getText();
		System.out.println("the star rating is -- "+starrate);
		String percent = driver.findElement(By.xpath("(//td[@class='a-text-right a-nowrap'])[5]")).getText();
		System.out.println("the percentage of the rating is -- "+percent);
		String firsttext = driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")).getText();
		System.out.println("the first text link -- "+firsttext);
		driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> newwindowlist = new ArrayList<String>(windowHandles);
		driver.switchTo().window(newwindowlist.get(1));
		System.out.println("window name-- "+newwindowlist.get(1));
		WebElement newpop = driver.findElement(By.xpath("//div[@id='imgTagWrapperId']/img"));
		// WebElement  = driver.findElement(By.xpath("//div[@id='ivLargeImage']/img"));
		Actions capturing = new Actions(driver);
		capturing.scrollToElement(newpop).perform();
		File screenshotAs = driver.getScreenshotAs(OutputType.FILE);
		File destination= new File("./snap/img1.png");
		FileUtils.copyFile(screenshotAs, destination);
		System.out.println("ScreenShot img-- "+screenshotAs);
		driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
		String priceitem = driver.findElement(By.xpath("//span[@class='a-size-base-plus a-color-base']//b")).getText();
		System.out.println("the item to buy-- "+priceitem);
		String price = driver.findElement(By.xpath("//span[@id='attach-accessory-cart-subtotal']")).getText();
		System.out.println("the price of the mobile is-- "+price);
		
		if(price.contains(mobprice))
		{
			System.out.println("the mobile price is equal");
		}
		else
		{
			System.out.println("not same");
		}
		Thread.sleep(5000);
		driver.quit();
	}

}
