package testamazon;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class testgoogle {

	public static void main(String[]args) throws MalformedURLException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin 2\\Desktop\\Sangee\\QA Automation Course\\Phase4\\chromedriver.exe");
       
//        WebDriver driver = new ChromeDriver();
        
        URL URL = new URL("http://localhost:4444/wd/hub");
        ChromeOptions options = new ChromeOptions();
        
         WebDriver driver = new RemoteWebDriver(URL, options);
     	 driver.get("https://www.google.com");
        System.out.println(driver.getTitle());
    }

}
