package basePoint;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BaseCase {
public static	WebDriver driver;
public static	Properties prob;
	
	
	public BaseCase() throws IOException{
		try {
		prob = new Properties();
		FileInputStream fs = new FileInputStream("C:\\SeleniumExecution\\MavenProject001\\config.Properties");
		prob.load(fs);
		}
		catch(Exception e)
		{
			System.out.println("File not found. Please provide the correct file name and path!!!");
		}
		
	}
	
public static void setup(){
	String browser = prob.getProperty("browser");
	System.out.println(browser);
	
	if(browser.contains("Chrome")) {
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumExecution\\MavenProject001\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
	}
	else if(browser.contains("Firefox")) {
		driver = new FirefoxDriver();
		//System.setProperty("webdriver.chrome.driver", "C:\\SeleniumExecution\\MavenProject001\\driver\\chromedriver.exe");
		
		
	}
	else if(browser.contains("IE")) {
		System.setProperty("webdriver.ie.driver","C:\\SeleniumExecution\\MavenProject001\\driver\\chromedriver.exe");
		driver = new InternetExplorerDriver();
		
			
	}
	String url = prob.getProperty("url");
	driver.get(url);
	
}
}
