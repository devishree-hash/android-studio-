package org.manager;

import org.base.BaseClass;
import org.page.CartPage;
import org.page.LoginPage;
import org.page.ProductPage;

public class PageManager extends BaseClass{

	private LoginPage login;
	public LoginPage getLogin() {
		return (login==null) ? login=new LoginPage() : login;
	}
	private ProductPage product;
	public ProductPage getProductPage() {
		return (product==null) ?product=new ProductPage() : product;
	}
	private CartPage cartPage;
	public CartPage getCartPage() {
		return (cartPage==null) ? cartPage=new CartPage(): cartPage;
	}
	
	
	
	
}
