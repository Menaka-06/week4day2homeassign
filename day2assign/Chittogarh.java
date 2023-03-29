package week4.day2assign;

import java.time.Duration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Chittogarh {

	public static void main(String[] args) {
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		option.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.get("https://www.chittorgarh.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.findElement(By.xpath("//a[text()='STOCK MARKET ']")).click();
		driver.findElement(By.xpath("(//div[@class='row ch-bar-block'])[3]//div[2]//a[2]")).click();
		WebElement findtable = driver.findElement(By.xpath("//div[@class='table-responsive']//table[contains(@class,'striped table-hover')]"));
		List<WebElement> tablerows = findtable.findElements(By.tagName("tr"));
		System.out.println(tablerows.size());
		Set<String> securitynames = new HashSet<String>();
		for (int i = 1; i < tablerows.size(); i++) {
			String namelists = driver.findElement(By.xpath("//div[@class='table-responsive']//table[contains(@class,'striped table-hover')]//tr["+i+"]//td[1]")).getText();
			securitynames.add(namelists);
			}
		System.out.println(securitynames);
		
		for (String names : securitynames ) {
			
			System.out.println(names);
			}}
		
	}


