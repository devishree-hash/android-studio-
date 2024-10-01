package org.page;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CartPage extends BaseClass {
	public CartPage() {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	@AndroidFindBy(xpath="//android.widget.CheckBox[@text=\"Send me e-mails on discounts related to selected products in future\"]")
	private WebElement select;
	public WebElement getSelect() {
		return select;
	}
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnProceed")
	private WebElement clickCompletePurchase;
	public WebElement getClickCompletePurchase() {
		return clickCompletePurchase;
	}
	
	
}
