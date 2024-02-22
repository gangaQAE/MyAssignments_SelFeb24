package assignments.Day4;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Checkbox {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://leafground.com/checkbox.xhtml");
		driver.manage().window().maximize();

		// Implicit wait for 30seconds
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//span[text()='Basic']")).click();

		// Ajax click
		driver.findElement(By.xpath("//span[text()='Ajax']")).click();
		WebElement ajax = driver.findElement(By.xpath("//span[@class='ui-growl-title']"));
		if (ajax.isDisplayed()) {
			System.out.println("CAjax box is checked successfully");
		}
		Thread.sleep(7000); // Added Thread.sleep() - to avoid conflict with Tri-state status
		driver.findElement(By.xpath("//label[text()='Java']")).click();

		// TriState check
		driver.findElement(By.xpath("//div[contains(@id,'ajaxTriState')]")).click();
		String triState = driver.findElement(By.xpath("//span[@class='ui-growl-title']/following::p")).getText();
		System.out.println(triState + " : is choosen as Tri-state");

		// toggle switch
		WebElement toggle = driver.findElement(By.xpath("//div[@class='ui-toggleswitch ui-widget']"));
		if (toggle.isSelected()) {
			System.out.println("Toggle option is in enabled");
		} else {
			System.out.println("Toggle option is in disabled state");
		}
		Thread.sleep(7000); // Added Thread.sleep() - to avoid java.net.SocketException: Connection reset

		// multiple options - cities
		WebElement city = driver
				.findElement(By.xpath("//ul[contains(@class,'selectcheckboxmenu-multiple-container')]"));
		city.click();
		WebElement selectCity = driver.findElement(By.xpath("(//label[text()='Berlin'])[2]"));
		System.out.println(selectCity.getText()); // App issue - sometimes Berlin is not printing but selecting the city
		selectCity.click();
		city.click();

		// Disable button
		boolean disableButton = driver.findElement(By.xpath("(//div[contains(@class,'selectbooleancheckbox')]/div)[6]"))
				.isSelected();
		if (disableButton) {
			System.out.println("disable Button is in enabled");
		} else {
			System.out.println("disable Button is in disabled state");
		}
		Thread.sleep(3000);

		driver.close();

	}

}
