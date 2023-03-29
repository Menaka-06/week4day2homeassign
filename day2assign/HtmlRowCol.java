package week4.day2assign;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HtmlRowCol {

	public static void main(String[] args) {
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		option.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.get("https://html.com/tags/table/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebElement findtable = driver.findElement(By.xpath("//caption[text()='The Three Most Popular JavaScript Libraries']/parent::table"));
		//System.out.println("the table name is== "+findtable.getText());
		List<WebElement> rowscount = findtable.findElements(By.tagName("tr"));
		int rowsize = rowscount.size();
		System.out.println("the row count of the table is "+rowsize);
		List<WebElement> columncount = findtable.findElements(By.tagName("td"));
		int columnsize = columncount.size();
		System.out.println("the column count of the table is "+columnsize);
		
		WebElement table2 = driver.findElement(By.xpath("//table[@class='attributes-list']"));
		List<WebElement> rowscount2 = table2.findElements(By.tagName("tr"));
		System.out.println("the table2 rowcount is == "+rowscount2.size());
		List<WebElement> column2count = table2.findElements(By.tagName("th"));
		System.out.println("the table2 column2count is == "+column2count.size());
	}

}
