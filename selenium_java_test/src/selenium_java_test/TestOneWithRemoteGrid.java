package selenium_java_test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TestOneWithRemoteGrid {

    static String username = "jeffersoncantores13";
    static String accesskey = "N4DSvUUHZlTKanmHd3sTrzJMnNHWM3Vw1TH0KaZouoDJVfMB9t";
    static RemoteWebDriver driver = null;
    static String gridURL = "@hub.lambdatest.com/wd/hub";
    static boolean status = false;

    public static void main(String[] args) {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "Chrome");
        capabilities.setCapability("browserVersion", "101.0");
        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
        ltOptions.put("user",username);
        ltOptions.put("accessKey",accesskey);
        ltOptions.put("build", "Selenium Java Test");
        ltOptions.put("name", "TestOne");
        ltOptions.put("platformName", "Windows 11");
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

        //Maximize window
        driver.manage().window().maximize();

        //Launch the Site.
        driver.get("https://www.lambdatest.com/selenium-playground/simple-form-demo");

        //Enter values into form and submit
        driver.findElement(By.id("sum1")).sendKeys("2");
        driver.findElement(By.id("sum2")).sendKeys("5");
        driver.findElement(By.xpath("//*[@id='gettotal']/button")).click();

        //Verify the result
        String result = driver.findElement(By.xpath("//*[@id='addmessage']")).getText();

        if( Integer.parseInt(result) == 7) {
            System.out.println("Test Success");
        } else {
            System.out.println("Test Failed - " + result);
        }

        //Close browser
        driver.quit();
    }
}

