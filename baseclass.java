package com.appium_assessment.appium_asse;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.touch.offset.PointOption;

public class baseclass {
	public AndroidDriver driver;
	 AppiumDriverLocalService service;
	@BeforeMethod
	public void test() throws MalformedURLException, InterruptedException {
		AppiumDriverLocalService service;
		service=new AppiumServiceBuilder()
						.withAppiumJS( new File("C:\\Users\\ASUS\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
						.withIPAddress("127.0.0.1")
						.withTimeout(Duration.ofSeconds(20))
						.usingPort(4723)
						.build();
				service.start();

		
		
		
		
		UiAutomator2Options options=new UiAutomator2Options();
		options.setDeviceName("Dilip");
//		options.setApp("C:\\Appium\\apk file-20240209T045039Z-001\\apk file\\ApiDemos-debug.apk");
//		options.setApp("C:\\Appium\\apk file-20240209T045039Z-001\\apk file\\General-Store.apk");
		options.setApp("C:\\Appium\\apk file-20240209T045039Z-001\\apk file\\instagram-254-0-0-19-109.apk");
		
		driver=new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
	}
	public void longPressAction(WebElement ele) throws InterruptedException
	{
		((JavascriptExecutor)driver).executeScript("mobile: longClickGesture",
				ImmutableMap.of("elementId",((RemoteWebElement)ele).getId(),
						"duration",2000));
//		implicit wait
		
		Thread.sleep(5000);
	}
	public void seekBar(WebElement slider) {
		int xAxisStartPoint=slider.getLocation().getX();
		int xAxisEndPoint=xAxisStartPoint+slider.getSize().getWidth();
		int yAxisStartPoint=slider.getLocation().getY();
		
		
		TouchAction action=new TouchAction(driver);
		
		action.press(PointOption.point(xAxisStartPoint, yAxisStartPoint))
		.moveTo(PointOption.point(xAxisEndPoint-50,yAxisStartPoint))
		.release()
		.perform();

	}
public void drapNDrop(WebElement source) {
	((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
		    "elementId", ((RemoteWebElement) source).getId(),
		    "endX", 619,
		    "endY", 560
		));


}
	public void swipeAction(WebElement ele,String direction)
	{
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
				"elementId", ((RemoteWebElement)ele).getId(),
			 
			    "direction", direction,
			    "percent", 0.75
			));		
	}


	
	@AfterMethod
	public void teardown() throws InterruptedException {
		Thread.sleep(9000);
	driver.quit();
	service.stop();
	}
}
