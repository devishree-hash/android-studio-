package org.page;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginPage extends BaseClass {
	public LoginPage() {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/spinnerCountry")
	private WebElement dropDown;
	public WebElement getDropDown() {
		return dropDown;
	}
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Australia\"]")
	private WebElement clickAustralia;
	public WebElement getClickAustralia() {
		return clickAustralia;
	}
	@AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
	private WebElement name;
	public WebElement enterName() {
		return name;
	}
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop")
	private WebElement letsShop;
	public WebElement clickLetsShop() {
		return letsShop;
	}
	
}
