package testamazon;

import static org.junit.Assert.*;

import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.SessionId;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.functions.ExpectedCondition;
import io.appium.java_client.touch.offset.PointOption;

public class testamazonphase4 {

	static AndroidDriver<MobileElement> driver;

	@BeforeClass
	public static void beforeClass() throws Exception {
		System.out.println("Create Driver Instance");
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "11");
		cap.setCapability("appPackage", "com.amazon.mShop.android.shopping");
		cap.setCapability("appActivity", "com.amazon.mShop.home.HomeActivity");

		driver = new AndroidDriver<MobileElement>(url, cap);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		SessionId sessionId = driver.getSessionId();
		System.out.println(sessionId);

		Thread.sleep(3000);

		driver.findElement(By.xpath("//android.widget.Button[@text='Skip sign in']")).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//android.widget.Button[@text='Go to Amazon.sg']")).click();
		Thread.sleep(5000);
	}

	@Test
	public void search() throws InterruptedException {

		driver.findElementByXPath("//android.widget.EditText[@resource-id='com.amazon.mShop.android.shopping:id/rs_search_src_text']")
				.sendKeys("earphones with microphone");
		WebDriverWait wait = new WebDriverWait(driver, 80);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.id("com.amazon.mShop.android.shopping:id/rs_search_src_text")));

		driver.findElement(By.id("com.amazon.mShop.android.shopping:id/rs_search_src_text")).click();
		System.out.println("click");
		Thread.sleep(3000);

		driver.findElement(By.id("com.amazon.mShop.android.shopping:id/rs_search_src_text"))
				.sendKeys("panasonic earphones with microphone");
		Thread.sleep(4000);

		List<MobileElement> searchDd = driver
				.findElementsById("com.amazon.mShop.android.shopping:id/iss_search_dropdown_item_text");
		System.out.println(searchDd.size());
		Thread.sleep(4000);

		searchDd.get(0).click();
		System.out.println("Selection Done");
		Thread.sleep(3000);

		List<MobileElement> searchFd = driver
				.findElementsById("com.amazon.mShop.android.shopping:id/mshop_webView_container");
		System.out.println(searchFd.size());
		Thread.sleep(4000);

		searchFd.get(0).click();
		Thread.sleep(3000);

		System.out.println("Selected item displayed");
		Thread.sleep(3000);

		scrollUp();

		Thread.sleep(3000);

		System.exit(0);

	}

	public void scrollUp() {
		int height = driver.manage().window().getSize().getHeight();
		int width = driver.manage().window().getSize().getWidth();

		int StartX = (int) (0.5 * width);
		int endX = (int) (0.5 * width);

		int StartY = (int) (0.85 * height);
		int endY = (int) (0.15 * height);

		TouchAction action = new TouchAction(driver);

		action.longPress(PointOption.point(StartX, StartY)).moveTo(PointOption.point(endX, endY)).release().perform();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean isSelected(String id) {
		MobileElement me = driver.findElement(By.id(id));
		boolean status = false;
		if (me.getAttribute("checked").equals("true")) {
			status = true;
		}
		return status;
	}

	public boolean isSelected(MobileElement me) {

		boolean status = false;
		if (me.getAttribute("checked").equals("true")) {
			status = true;
		}
		return status;
	}
}
