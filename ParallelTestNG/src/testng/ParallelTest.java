package testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;

public class ParallelTest {   
  public String username = "jeffersoncantores13";
  public String accesskey = "N4DSvUUHZlTKanmHd3sTrzJMnNHWM3Vw1TH0KaZouoDJVfMB9t";
  public RemoteWebDriver driver = null;
  public String gridURL = "@hub.lambdatest.com/wd/hub";
  boolean status = false;
  
  @BeforeMethod
  @Parameters(value={"browser","version","platform"})
  public void setUp(String browser, String version, String platform) throws Exception {
	       DesiredCapabilities capabilities = new DesiredCapabilities();
	       capabilities.setCapability("browserName", browser);
	       capabilities.setCapability("browserVersion",version);
	       HashMap<String, Object> ltOptions = new HashMap<String, Object>();
	       ltOptions.put("user", username);
	       ltOptions.put("accessKey", accesskey);
	       ltOptions.put("build", "TestNG Parallel Test");
	       ltOptions.put("name", "TestOne");
	       ltOptions.put("platformName", platform);
	
	       ltOptions.put("selenium_version","4.1.2");
	       ltOptions.put("driver_version","101.0");
	       capabilities.setCapability("LT:Options", ltOptions);
	
	   try {
	       driver = new RemoteWebDriver(new URL("https://" + username + ":" + accesskey + gridURL), capabilities);
	   } catch (MalformedURLException e) {
	       System.out.println("Invalid grid URL");
	   } catch (Exception e) {
	       System.out.println(e.getMessage());
	   }
	}


  @Test
  public void addValues() {
      //Maximize window      
      driver.manage().window().maximize();    
     
      //Launch the Site.
      driver.get("https://www.lambdatest.com/selenium-playground/simple-form-demo");
     
      //Enter values into form and submit        
      driver.findElement(By.id("sum1")).sendKeys("2");                    
      driver.findElement(By.id("sum2")).sendKeys("5");    
      driver.findElement(By.xpath("//*[@id='gettotal']/button")).click();  
     
      //Verify the result
      String result = driver.findElement(By.xpath("//*[@id=\'addmessage\']")).getText();
     
      if( Integer.parseInt(result) == 7) {
           System.out.println("Test Success");
      } else {
           System.out.println("Test Failed - " + result);
      }
  }
      
  @AfterMethod
  public void tearDown() throws Exception {
       if (driver != null) {
            driver.quit();
       }
  }

}
