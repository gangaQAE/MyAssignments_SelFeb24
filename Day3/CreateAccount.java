package assignments.Day3;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateAccount {

	public static void main(String[] args)  {
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();

		String name = "Gangadhar";
		// Implicit wait for 30seconds
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.partialLinkText("CRM/SFA")).click();

		// Create Account
		driver.findElement(By.linkText("Create Account")).click();
		driver.findElement(By.id("accountName")).sendKeys(name);
		driver.findElement(By.name("description")).sendKeys("Selenium Automation Tester");

		WebElement industryDropdown = driver.findElement(By.name("industryEnumId"));
		Select dd1 = new Select(industryDropdown);
		dd1.selectByValue("IND_SOFTWARE");

		WebElement ownershipDropdown = driver.findElement(By.name("ownershipEnumId"));
		Select dd2 = new Select(ownershipDropdown);
		dd2.selectByVisibleText("S-Corporation");

		WebElement sourceDropdown = driver.findElement(By.id("dataSourceId"));
		Select dd3 = new Select(sourceDropdown);
		dd3.selectByValue("LEAD_EMPLOYEE");

		WebElement marketingDropdown = driver.findElement(By.id("marketingCampaignId"));
		Select dd4 = new Select(marketingDropdown);
		dd4.selectByIndex(6);

		WebElement stateDropdown = driver.findElement(By.id("generalStateProvinceGeoId"));
		Select dd5 = new Select(stateDropdown);
		dd5.selectByValue("TX");

		driver.findElement(By.className("smallSubmit")).click();
		String User = driver.findElement(By.xpath("//span[text()='Account Name']/following::td[1]")).getText();

		System.out.println(User);
		if (User.contains(name)) {
			System.out.println("Account is matched");
		}

		else {
			System.out.println("Account is Not-matched");
		}
	}
}
