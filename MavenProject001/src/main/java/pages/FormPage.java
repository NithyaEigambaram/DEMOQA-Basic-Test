package pages;



import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import basePoint.BaseCase;
import projUtil.ProjectUtils;

public class FormPage extends BaseCase{

	public FormPage() throws IOException {
		super();
		
	}
	
	public void IsFormInputPage() throws InterruptedException{
		
		driver.findElement(By.xpath("//span[text()='Practice Form']")).click();
	}
	
	public void AddDataToForm(String fname, String lname, String mailId, String gender, String phnNo, String dOB) throws IOException{
		driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys(fname);
		driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys(lname);
		driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys(mailId);
		driver.findElement(By.xpath("//input[@id='userNumber']")).sendKeys(phnNo);
		WebElement genderMale = driver.findElement(By.xpath("//div[@id='genterWrapper']/div[2]//label"));
		WebElement genderFemale = driver.findElement(By.xpath("//div[@id='genterWrapper']/div[2]/div[2]/label"));
		WebElement genderOther = driver.findElement(By.xpath("//input[@value='Other']"));
		
		
		if(gender.contentEquals("male")||(gender.contentEquals("Male"))) {
			genderMale.click();
			
		}
		else if(gender.contentEquals("Female")||(gender.contentEquals("female"))) {
			genderFemale.click();
		}
		
		//driver.findElement(By.xpath("//div[@class='body-height']/div/div[2]/div[2]/div/form/div[11]/div/button")).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		driver.findElement(By.id("submit")).click();
		js.executeScript("window.scrollBy(0,1000)");
		driver.findElement(By.id("closeLargeModal")).click();
	}
	

}
