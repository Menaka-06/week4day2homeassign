package week4.day2assign;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class NykkaShopping {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		option.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.get("https://www.nykaa.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement brand = driver.findElement(By.xpath("//a[text()='brands']"));
		Actions brandover = new Actions(driver);
		brandover.moveToElement(brand).perform();
		driver.findElement(By.xpath("//input[@id='brandSearchBox']")).sendKeys("L'Oreal Paris");
		driver.findElement(By.xpath("//div[@id='list_topbrands']/following::div[6]//a")).click();
		String title = driver.getTitle();
		System.out.println(title);
		 driver.findElement(By.xpath("//div[@id='filter-sort']")).click();
		driver.findElement(By.xpath("//span[text()='customer top rated']")).click();
		driver.findElement(By.xpath("//span[text()='Category']")).click();
		//WebElement selhair =
				driver.findElement(By.xpath("//span[text()='Hair']")).click();
	//	Actions hairelement = new Actions(driver);
		//hairelement.moveToElement(selhair).perform();
		//selhair.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class=' css-b5p5ep']/span[text()='Hair Care']")).click();
		driver.findElement(By.xpath("//div[@class='control-value']/span[text()='Shampoo']")).click();
		driver.findElement(By.xpath("//div[@class='filter-open css-1kwl9pj']/span[text()='Concern']")).click();		
		WebElement colorweb = driver.findElement(By.xpath("//div[@class='control-value']/span[text()='Color Protection']"));
		Actions colorwebelement = new Actions(driver);
		colorwebelement.scrollToElement(colorweb).perform();
		colorweb.click();
		String verifytext = driver.findElement(By.xpath("//div[@class='css-1hjpwet']/span[text()='Filters Applied']")).getText();
		System.out.println("the page contains:  "+verifytext);
		driver.findElement(By.xpath("//div[@class='css-1rd7vky']/div")).click();
		Set<String> windowHandles1 = driver.getWindowHandles();
		List<String> listWindow=new ArrayList<String>(windowHandles1);
		driver.switchTo().window(listWindow.get(1));
		driver.findElement(By.xpath("//span[text()='180ml']")).click();
		String price = driver.findElement(By.xpath("(//div[@class='css-1d0jf8e'])[1]//span[2]")).getText();
		System.out.println("the price of L'oReal Shampoo is :  "+price);
		driver.findElement(By.xpath("(//span[text()='Add to Bag'])[1]")).click();
		driver.findElement(By.xpath("//span[@class='cart-count']")).click();
		driver.switchTo().frame(0);
		String grandtotal = driver.findElement(By.xpath("//span[text()='₹279']")).getText();
		System.out.println("Grand Total  : "+grandtotal);
		driver.findElement(By.xpath("//div[@class='css-ltzjhp e25lf6d7']//button")).click();
		driver.findElement(By.xpath("(//div[@class='css-1ixn3da e9pts8a0'])[2]//button")).click();
		driver.findElement(By.xpath("//span[@class='css-175whwo ehes2bo0']/img")).click();
		String pricetest = driver.findElement(By.xpath("//p[text()='₹279']")).getText();
		System.out.println("the price in cart bag : "+pricetest);
		if(grandtotal==pricetest)
		{
			System.out.println("yes!!! tha price and grandtotal are same:::");
		}
		else {
			System.out.println("The price is not same!!!");
		}
	Thread.sleep(4000);
	driver.quit();
	}

}
