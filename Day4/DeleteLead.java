package assignments.Day4;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DeleteLead {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/");
		driver.manage().window().maximize();

		// Implicit wait for 30seconds
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.partialLinkText("CRM/SFA")).click();

		driver.findElement(By.xpath("//a[text()='Leads']")).click();
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
//		driver.findElement(By.xpath("//div[contains(@class,'formatedPrimaryPhone')]")).click();	
//		Thread.sleep(5000);

		

		WebElement s= driver.findElement(By.xpath("//div[contains(@class,'col-partyId')]/a"));
		String leadID = s.getText();
		System.out.println(leadID);
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(leadID);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[contains(@class,'col-partyId')]/a")).click();
		//s.click(); - above code is working, but same from webelement is showing nosuchelement exception
		driver.findElement(By.xpath("//a[@class='subMenuButtonDangerous']")).click();
		
		//after delete, verify deleted or not
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(leadID);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
		String msg = driver.findElement(By.xpath("//div[text()='No records to display']")).getText();
		if(msg.equals("No records to display")) {
			System.out.println(leadID+" is deleted successfully");
		}
		Thread.sleep(5000);
		driver.close();
	}

}
