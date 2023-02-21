package selenium_java_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestOne {

    public static void main(String[] args) {
        // 1st step: Define browser driver
        System.setProperty("webdriver.chrome.driver", "C:/Selenium/chromedriver.exe");

        // 2nd step: Declare Webdriver element
        WebDriver driver = new ChromeDriver();

        try {
        	
        	// maximize window
            driver.manage().window().maximize();

            // launch the site
            driver.get("https://www.lambdatest.com/selenium-playground/simple-form-demo");

            // input elements
            driver.findElement(By.id("sum1")).sendKeys("1");
            driver.findElement(By.id("sum2")).sendKeys("2");

            // commence operation
            driver.findElement(By.xpath("//*[@id='gettotal']/button")).click();

            // verify results
            String result = driver.findElement(By.id("addmessage")).getText();

            if (Integer.parseInt(result) == 3) {
                System.out.println("Success!");
            }else {
                System.out.println("Failed!");
            }

            //close browser and driver
            driver.quit();
        	
        }catch(Exception e) {
        	e.printStackTrace();
        }     
    }
}

