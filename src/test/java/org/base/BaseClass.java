package org.base;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseClass {
    public static AppiumDriverLocalService build ;
    public static UiAutomator2Options uiAutomator2Options;
    public static AndroidDriver driver ;
    public static JavascriptExecutor js;
	public void startServer(String deviceName,String appPath) throws MalformedURLException {
		build = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\hp\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js")).withIPAddress("127.0.0.1").usingPort(4723).build();
		build.start();
		uiAutomator2Options = new UiAutomator2Options();
		uiAutomator2Options.setCapability("deviceName", deviceName);
		uiAutomator2Options.setChromedriverExecutable("C:\\Users\\hp\\eclipse-workspace\\AndroidStudio\\src\\test\\resources\\chromedriver.exe");
		uiAutomator2Options.setCapability("browserType", "Chrome");
		uiAutomator2Options.setCapability("app", appPath);
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"),uiAutomator2Options);

	}
	public void getSendKeys(WebElement element,String text) {
		element.sendKeys(text);

	}
	public void buttonClick(WebElement element) {
		element.click();

	}
	public void scrollGesture(String text) {
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"));"));

	}
	public void longGesture(WebElement element,int time) {
		js= (JavascriptExecutor) driver;
		js.executeScript("mobile:longClickGesture", ImmutableMap.of("elementId",((RemoteWebElement)element).getId(),"duration", time));

	}
	public void swipeGesture(WebElement element, String direction,int percent) {
		js= (JavascriptExecutor) driver;
		js.executeScript("mobile:swipeGesture", ImmutableMap.of("elementId",((RemoteWebElement)element).getId(),"direction", direction, percent , percent));

	}
	public void dragGesture(WebElement element,int endX,int endY) {
		js= (JavascriptExecutor) driver;
		js.executeScript("mobile:dragGesture", ImmutableMap.of("elementId",((RemoteWebElement)element).getId(),"endX", endX, "endY" , endY));

	}
	public void getImplicitWait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
     	
	}
	public void quitDriver() {
		driver.quit();

	}
	public void stopServer() {
		build.stop();

	}
	public static void main(String[] args) {
		System.out.println("QA works fine");
	}
	
	
}
