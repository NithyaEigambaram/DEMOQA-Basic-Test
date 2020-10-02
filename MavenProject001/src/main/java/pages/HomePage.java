package pages;




import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import basePoint.BaseCase;

public class HomePage extends BaseCase{
	
	 public HomePage() throws IOException{
		super();
	}

	public void isLogoPresent(){
		
	WebElement img = driver.findElement(By.xpath("//div[@id='app']//img"));
	Boolean image = img.isDisplayed();	
	if(image==true)	{
		System.out.println("Image is present");
	
	}
	else {
		System.out.println("Image not identified");
	}
	}
	
	
	public FormPage IsFormClickable() throws IOException, InterruptedException
	{
		
		/*WebElement ele = driver.findElement(By.xpath("//h5[text()='Forms']"));
		System.out.println("the retruned element is"+ ele);
		Actions act =  new Actions(driver);
		act.moveToElement(ele).click();*/
		
		
		
		/*WebDriverWait wait = new WebDriverWait(driver,25);
		By locator = By.xpath("//div[@class='category-cards']/div[2]");
		WebElement element = wait.until(ExpectedConditions.
                elementToBeClickable(locator));
		Actions act =  new Actions(driver);
		act.moveToElement(element).click().perform();*/
		
		driver.findElement(By.xpath("//div[@class='category-cards']/div[2]")).click();
		return new FormPage();
		
		
		
	}

	

}
