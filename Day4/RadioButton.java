package assignments.Day4;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioButton {

	public static void main(String[] args) throws InterruptedException {

		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/radio.xhtml");
		//To maximize the browser
		driver.manage().window().maximize();
		//implicit wait- 30seconds, will wait max'm to check for the webelements
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.findElement(By.xpath("//label[text()='Safari']")).click();
		WebElement city = driver.findElement(By.xpath("//label[text()='Chennai']"));
		city.click();

		/*update from @vineeth- Testleaf trainer
		 * due to webpage issue- below methods are behaving as below, but the code is written as per rules
		 * isSelected() - returning false for selected/unselected radio button.
		 * isEnabled() - returning true for selected/unselected radio button.
		 */

		//verify the radio button is selected or not
		System.out.println("city radio button selected status: "+city.isSelected()); // will print true if selected, else false
		//to uncheck the button, clicking the button
		city.click();
		System.out.println("city radio button selected status: "+city.isSelected()); // will print true if selected, else false


		//Identify the radio button that is initially selected by default
		WebElement element1 = driver.findElement(By.xpath("(//table[contains(@id,'console2')]//td)[1]")); 
		boolean selected1 = element1.isSelected();
		if(selected1) {
			System.out.println(element1.getText()+" is selected by default");
		}

		//element2
		WebElement element2 = driver.findElement(By.xpath("(//table[contains(@id,'console2')]//td)[2]")); 
		boolean selected2 = element2.isSelected();
		if(selected2) {
			System.out.println(element2.getText()+" is selected by default");
		}

		//element3
		WebElement element3 = driver.findElement(By.xpath("(//table[contains(@id,'console2')]//td)[3]")); 
		boolean selected3 = element3.isSelected();
		if(selected3) {
			System.out.println(element3.getText()+" is selected by default");
		}

		//element4
		WebElement element4 = driver.findElement(By.xpath("(//table[contains(@id,'console2')]//td)[3]")); 
		boolean selected4 = element4.isSelected();
		if(selected4) {
			System.out.println(element4.getText()+" is selected by default");
		}

		//select the age group (21-40 Years)
		WebElement ageElement = driver.findElement(By.xpath("//label[contains(text(),'21-40 Years')]"));
		System.out.println(ageElement.getText()+" is displayed");
		boolean selected = ageElement.isSelected();
		if(selected != true) {
			ageElement.click();
			selected = true;
			System.out.println(ageElement.getText()+" is selected-- if");
		}
		else {
			System.out.println(ageElement.getText()+" is selected-- else");
		}

		driver.close();
	}	
}
