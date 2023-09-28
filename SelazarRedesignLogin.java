package uk.co.selazarlabs.thenew;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class SelazarRedesignLogin {
	@Test
	public void Login() {
		// Create driver
		WebDriver driver = new ChromeDriver();
		System.out.println("Test Started");
		sleep(2);

		// Create wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		// open page
		String url = "https://thenew.selazar-labs.co.uk/";
		driver.get(url);
		driver.manage().window().maximize();
		sleep(2);
		
		//Enter Username
		WebElement Username = driver.findElement(By.cssSelector("[class='css-12awv07'] #slz-custom-input"));
		Username.sendKeys("james.smith@selazartest.com");
		sleep(2);
		
		//Enter Password
		WebElement Password = driver.findElement(By.cssSelector("div:nth-of-type(2) > .chakra-input__group.css-4km3zk > input#slz-custom-input"));
		Password.sendKeys("password");
		sleep(2);
		
		//Click Login
		WebElement LoginButton = driver.findElement(By.cssSelector(".chakra-button.css-k7up7k"));
		LoginButton.click();
		sleep(2);
	
		//Click on Profile circle
		WebElement ProfileCircle = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[class=\"chakra-avatar css-1y6t4i8\"]")));
		ProfileCircle.click();
		sleep(2);
		
		//Click on Log Out button
		WebElement LogOutButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='popover-body-:r1m:']/button[4]")));
		LogOutButton.click();
		sleep(2);
		
		driver.quit();
	}

	private void sleep(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
