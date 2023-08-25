package module.nine.test;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SubmitButtonAlert {
	public WebDriver driver;

	@BeforeMethod
	public void setup() {
		WebDriverManager.chromedriver().setup();
		this.driver = new ChromeDriver();
		this.driver.manage().window().maximize();
		this.driver.get("https://demo.guru99.com/test/delete_customer.php");
	}

	@AfterMethod

	public void close() {
		this.driver.quit();
	}

	@Test
	void buttonAlert() throws InterruptedException {
		driver.findElement(By.name("cusid")).sendKeys("63520");
		driver.findElement(By.name("submit")).submit();

		Alert alert = driver.switchTo().alert();

		String alertMessage = driver.switchTo().alert().getText();

		System.out.println(alertMessage);
		Thread.sleep(4000);

		alert.accept();
	}

	@Test
	void submitAlertDemo() throws InterruptedException {
		driver.get("http://example.com");

		WebElement submitButton = driver.findElement(By.id("submitButton"));

		submitButton.click();

		Alert alert = driver.switchTo().alert();

		String alertText = alert.getText();
		System.out.println("Alert Text: " + alertText);
		Thread.sleep(4000);
		alert.accept();
	}
}
