package org.mobileapptesting;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.base.BaseClass;
import org.manager.PageManager;
import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.page.CartPage;
import org.page.LoginPage;
import org.page.ProductPage;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class MobileAppTesting extends BaseClass {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		BaseClass base=new BaseClass();
		base.startServer("Sample", "C:\\Users\\hp\\eclipse-workspace\\AndroidStudio\\src\\test\\resources\\General-Store.apk");
     	base.getImplicitWait();
     	PageManager pageManager=new PageManager();
     	WebElement dropDown = pageManager.getLogin().getDropDown();
     	base.buttonClick(dropDown);
     	base.getImplicitWait();
     	Thread.sleep(4000);
     	base.scrollGesture("Australia");
     	WebElement australiaClick = pageManager.getLogin().getClickAustralia();
     	base.buttonClick(australiaClick);
     	WebElement name =pageManager.getLogin().enterName();
		base.getSendKeys(name, "Devi");
		WebElement letsShop =pageManager.getLogin().clickLetsShop();
		base.buttonClick(letsShop);
		Thread.sleep(4000);
		WebElement cart =pageManager.getProductPage().getClickCart();
		base.buttonClick(cart);
		WebElement cartIcon =pageManager.getProductPage().getClickCartIcon();
		base.buttonClick(cartIcon);
		Thread.sleep(4000);
		WebElement select = pageManager.getCartPage().getSelect();
		base.buttonClick(select);
		WebElement completePurchase = pageManager.getCartPage().getClickCompletePurchase();
		base.buttonClick(completePurchase);
		Thread.sleep(30000);
		Set<String> contextHandles = driver.getContextHandles();
		List<String> li=new ArrayList();
		li.addAll(contextHandles);
		System.out.println(li);
		System.out.println("asdfghjklzxcvbnmqwertyuiop");
		driver.context("WEBVIEW_com.androidsample.generalstore, WEBVIEW_chrome");
		WebElement searchBox = driver.findElement(By.id("input"));
		searchBox.click();
		searchBox.sendKeys("Application /n");
		
		base.quitDriver();
		
		base.stopServer();
	}
}
