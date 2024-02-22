package assignments.Day4;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ButtonInteraction {

	public static void main(String[] args) {

		ChromeDriver driver = new ChromeDriver();
		driver.get("https://leafground.com/button.xhtml");
		driver.manage().window().maximize();
		//Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));


		//Click on the button with the text ‘Click and Confirm title.’ 
		driver.findElement(By.xpath("(//h5[text()='Click and Confirm title.']/following::span)[1]")).click();
		//Verify that the title of the page is ‘dashboard.’ 
		String title = driver.getTitle();
		if(title.equals("Dashboard")) {
			System.out.println("Page Title is correct");
		}
		driver.navigate().back();
		//Check if the button with the text ‘Confirm if the button is disabled’ is disabled. 
		WebElement element = driver.findElement(By.xpath("//span[text()='Disabled']/parent::button"));
		boolean enabled = element.isEnabled();
		if(!enabled) {
			System.out.println("Button is disabled");
		}
		//Find and print the position of the button with the text ‘Submit.’ 
		Point location = driver.findElement(By.xpath("(//span[text()='Submit']/parent::button)[1]")).getLocation();
		System.out.println("Position of the submit button: "+location);
		//Find and print the background color of the button with the text ‘Find the Save button color.’ 
		String cssValue = driver.findElement(By.xpath("//span[text()='Save']/parent::button")).getCssValue("color");
		System.out.println("Color of the save button: "+cssValue);
		//Find and print the height and width of the button with the text ‘Find the height and width of this button.
		Dimension size = driver.findElement(By.xpath("(//span[text()='Submit']/parent::button)[2]")).getSize();
		System.out.println("Size of the submit button: "+size);
		//Close the browser window.
		driver.close();
	}
}
