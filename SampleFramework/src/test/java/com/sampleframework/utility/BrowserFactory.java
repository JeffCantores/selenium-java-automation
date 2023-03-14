package com.sampleframework.utility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;

public class BrowserFactory {
	
	public static WebDriver startApplication(WebDriver driver, String browserName, String appURL) {
		
		switch (browserName) {
		case "Chrome":
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(options);
			break;
		case "Firefox":
			System.out.println("Opened Firefox browser");
			break;
	    case "Edge":
	    	System.setProperty("webdriver.edge.verboseLogging", "true");
	        EdgeDriverService service = EdgeDriverService.createDefaultService();

	        driver = new EdgeDriver(service);
			break;	
		default:
			System.out.println("The browser " + browserName + " does not exist.");
			break;
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get(appURL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		return driver;
	}
	
	public static void closeBrowser(WebDriver driver) {
		
		driver.quit();
	}


}
