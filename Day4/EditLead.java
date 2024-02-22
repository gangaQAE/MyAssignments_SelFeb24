package assignments.Day4;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class EditLead {

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
		driver.findElement(By.xpath("//a[contains(@href,'createLeadForm')]")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Amazon");
		driver.findElement(By.xpath("//input[@id='createLeadForm_firstName']")).sendKeys("Ganga");
		driver.findElement(By.xpath("//input[@id='createLeadForm_lastName']")).sendKeys("chinna");
		driver.findElement(By.xpath("//input[@id='createLeadForm_firstNameLocal']")).sendKeys("ELR");
		driver.findElement(By.xpath("//input[@id='createLeadForm_departmentName']")).sendKeys("Testing");
		driver.findElement(By.xpath("//textarea[@id='createLeadForm_description']")).sendKeys("I'm writing description");
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("gangaleaf01@gmail.com");
		Select options = new Select(driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId")));
		options.selectByVisibleText("New York");
		driver.findElement(By.name("submitButton")).click();
		driver.findElement(By.xpath("//a[text()='Edit']")).click();
		driver.findElement(By.xpath("//textarea[@id='updateLeadForm_description']")).clear();
		driver.findElement(By.xpath("//textarea[@id='updateLeadForm_description']")).sendKeys("I'm editing description");
		driver.findElement(By.xpath("//textarea[@id='updateLeadForm_importantNote']")).sendKeys("Adding notes during update details");
		driver.findElement(By.xpath("(//input[@name='submitButton'])[1]")).click();
		System.out.println(driver.getTitle());
		driver.close();

	}
}
