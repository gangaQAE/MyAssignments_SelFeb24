package assignments.Day3;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FacebookRegistration {

	public static void main(String[] args) throws InterruptedException {

		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();

		// Implicit wait for 30seconds
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.findElement(By.linkText("Create new account")).click();
		driver.findElement(By.name("firstname")).sendKeys("rrefd");
		driver.findElement(By.name("lastname")).sendKeys("ra");
		driver.findElement(By.name("reg_email__")).sendKeys("retyf1tt1511@gmail.com");
		driver.findElement(By.name("reg_email_confirmation__")).sendKeys("retyf1tt1511@gmail.com");
		driver.findElement(By.id("password_step_input")).sendKeys("Ab$123");

		WebElement day = driver.findElement(By.id("day"));
		Select dayDropDown = new Select(day);
		dayDropDown.selectByVisibleText("24");

		WebElement month = driver.findElement(By.id("month"));
		Select monthDropDown = new Select(month);
		monthDropDown.selectByVisibleText("May");

		WebElement year = driver.findElement(By.id("year"));
		Select yearDropDown = new Select(year);
		yearDropDown.selectByVisibleText("1993");

		driver.findElement(By.xpath("//input[@value='2']")).click();
		driver.findElement(By.xpath("//label[contains(text(),'Male')]")).click();
		driver.findElement(By.name("websubmit")).click();

		Thread.sleep(20000); // implicit is not working, due to loading option shown beside signup button
		String url = driver.getCurrentUrl();
		System.out.println(url);

		/*
		 * After clicking of sign up, somtimes it is going to checkpoint page- OTP page
		 * or Need more information page
		 * 
		 * so used if-else-if for soft pass.
		 */
		if (url.contains("checkpoint")) {
			System.out.println("Account created successfully");
			System.out.println("We need more information" + " page is loaded");
		} else if (url.contains("confirmemail")) {
			System.out.println("Account created successfully");
			System.out.println("Enter the code from your email" + " page isloaded");
		} else {
			System.out.println("Account creation failed");
		}
		driver.close();

	}

}
