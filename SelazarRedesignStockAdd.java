package uk.co.selazarlabs.thenew;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class SelazarRedesignStockAdd {
	@Test
	public void AddStock() {
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
		
		//Click On Inventory
		WebElement InventoryButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".chakra-button.css-zztv8l")));
		InventoryButton.click();
		sleep(2);
		
		//Click on Product Library
		WebElement ProductLibraryButton = driver.findElement(By.cssSelector("li:nth-of-type(1) > .chakra-button.css-11fna2p > .css-1eziwv"));
		ProductLibraryButton.click();
		sleep(2);
		
		//Click Add stock for the first product 
		WebElement AddStockButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("tr:nth-of-type(1) .chakra-button.css-70qo3o")));
		AddStockButton.click();
		sleep(2);
		
		//Select the dropdown menu to select the warehouse 
		/*WebElement Dropdownmenu = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[class='chakra-icon css-1f3fjoy']")));
		Select dropdown = new Select(Dropdownmenu);
		dropdown.selectByVisibleText("Selazar Nuneaton");*/
		
		//Click on Single product button 
		WebElement SingleProductButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html//div[@id='chakra-modal--body-inventory-send-consignment-slz-modal']//form/div[@class='chakra-fade']/div[@class='chakra-stack css-71zv5g']/div[@role='group']//div[@class='chakra-stack css-xh6f63']/div[1]/div[@name='consignmentType']")));
		SingleProductButton.click();
		sleep(2);
		
		//Click on Next
		WebElement NextStepButton = driver.findElement(By.xpath("//div[@id='chakra-modal--body-inventory-send-consignment-slz-modal']//form//button[@type='submit']"));
		NextStepButton.click();
		sleep(2);	
		
		//Enter the product
		WebElement  EnterProduct = wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("Search")));
		EnterProduct.sendKeys("111HAT");
		WebElement SelectProduct = driver.findElement(By.cssSelector("/html//div[@id='chakra-modal--body-inventory-send-consignment-slz-modal']//form/div[@class='chakra-fade']/div[@class='chakra-stack css-cghuib']/div[@role='group']//div[@class='css-1jke4yk']//table[@class='chakra-table css-11gtrqb']//tr/td[3]/div[@class='css-9r9s3y']/div[@class='css-0']"));
		SelectProduct.click();
		sleep(2);	

		//Select consignment box
		WebElement SelectConsingmentBox = driver.findElement(By.cssSelector("[data-name='Path 3455']"));
		SelectConsingmentBox.click();
		sleep(2);	
		
		WebElement EnterH = driver.findElement(By.cssSelector("[class='chakra-stack css-84zodg'] [data-group='true']:nth-of-type(1) #slz-custom-input"));
		EnterH.sendKeys("15");
		sleep(2);	

		WebElement EnterW = driver.findElement(By.cssSelector("div:nth-of-type(2) > input#slz-custom-input"));
		EnterW.sendKeys("15");
		sleep(2);	
		
		WebElement EnterD = driver.findElement(By.cssSelector("div:nth-of-type(3) > input#slz-custom-input"));
		EnterD.sendKeys("15");
		sleep(2);
		
		WebElement Enterkg = driver.findElement(By.cssSelector("div[role='group'] > .chakra-input__group.css-xp222h > input#slz-custom-input"));
		Enterkg.sendKeys("1");
		sleep(2);
		
		WebElement StockBoxQuantities = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[class] [class='chakra-stack css-1pd9o9m']:nth-of-type(2) .css-qkd4np:nth-of-type(1) [class='chakra-form-control css-1kxonj9']:nth-of-type(1) #slz-custom-input")));
		StockBoxQuantities.sendKeys("10");
		sleep(2);
		
		
		
	}
	private void sleep(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		}catch(InterruptedException e){
			//TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
