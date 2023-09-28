package uk.co.selazarlabs.thenew;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SelazarRedesignOrders {
	@Test
	public void Orders() {
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

		// Enter Username
		WebElement Username = driver.findElement(By.cssSelector("[class='css-12awv07'] #slz-custom-input"));
		Username.sendKeys("james.smith@selazartest.com");
		sleep(2);

		// Enter Password
		WebElement Password = driver.findElement(
				By.cssSelector("div:nth-of-type(2) > .chakra-input__group.css-4km3zk > input#slz-custom-input"));
		Password.sendKeys("password");
		sleep(2);

		// Click Login
		WebElement LoginButton = driver.findElement(By.cssSelector(".chakra-button.css-k7up7k"));
		LoginButton.click();
		sleep(2);
		
		//Click on Orders tab
		WebElement OrdersButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".chakra-button.css-12z5lvi")));
		OrdersButton.click();
		sleep(2);
		
		//Click on B2C
		WebElement B2CButton = driver.findElement(By.cssSelector("li:nth-of-type(1) > .chakra-button.css-11fna2p > .css-1eziwv"));
		B2CButton.click();
		sleep(2);
		
		//Go to Processed tab
		WebElement ProcessedTabButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html//div[@id='root']/div[@class='content-wrapper css-1hcgb50']/div[@class='css-1sx2lkp']//div[@role='tablist']/button[4]")));
		ProcessedTabButton.click();
		System.out.println("correct");
		sleep(10);
		
		//Click the arrow down next to each order
		WebElement ArrowDownButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/table[1]/tbody[1]/tr[1]/td[8]/div[1]/div[1]/button[1]/*[name()='svg'][1]")));
		ArrowDownButton.click();
		System.out.println("correct");
		sleep(2);
		
		WebElement MessageEAN = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[normalize-space()='EAN/SUID']")));
		String expectedMessageEAN = "EAN/SUID";
		String ActualMessageEAN = MessageEAN.getText();
		Assert.assertFalse(ActualMessageEAN.contains(expectedMessageEAN),"Message doesn't match");
		System.out.println("correct");

		
		WebElement MessageWH = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/table[1]/tbody[1]/tr[2]/td[1]/div[1]/table[1]/tbody[1]/tr[1]/td[5]/div[1]/div[1]/p[1]")));
		String expectedMessageWH = "Ware house";
		String ActualMessageWH = MessageWH.getText();
		Assert.assertTrue(ActualMessageWH.contains(expectedMessageWH),"Message doesn't match");
		
		WebElement MessageQuantity = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/table[1]/tbody[1]/tr[2]/td[1]/div[1]/table[1]/tbody[1]/tr[1]/td[6]/div[1]/div[1]/p[1]")));
		String expectedMessageQuantity = "Quantity";
		String ActualMessageQuantity = MessageQuantity.getText();
		Assert.assertTrue(ActualMessageQuantity.contains(expectedMessageQuantity),"Message doesn't match");
		
		WebElement MessagePrice = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/table[1]/tbody[1]/tr[2]/td[1]/div[1]/table[1]/tbody[1]/tr[1]/td[7]/div[1]/div[1]/p[1]")));
		String expectedMessagePrice = "Quantity";
		String ActualMessagePrice = MessagePrice.getText();
		Assert.assertTrue(ActualMessagePrice.contains(expectedMessagePrice),"Message doesn't match");
		
		WebElement MessageWeight = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/table[1]/tbody[1]/tr[2]/td[1]/div[1]/table[1]/tbody[1]/tr[1]/td[8]/div[1]/div[1]/p[1]")));
		String expectedMessageWeight = "Quantity";
		String ActualMessageWeight = MessageWeight.getText();
		Assert.assertTrue(ActualMessageWeight.contains(expectedMessageWeight),"Message doesn't match");
	
		
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
