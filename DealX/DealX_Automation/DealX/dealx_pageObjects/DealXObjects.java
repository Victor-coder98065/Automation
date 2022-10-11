package dealx_pageObjects;

import org.openqa.selenium.By;

public class DealXObjects {

	public static final By Logo = By.xpath("//img[@class='logo img-responsive']");
	public static final By Search_txt = By.xpath("//input[@id='search_query_top']");
	public static final By Search_btn = By.xpath("//button[@name='submit_search']");
	public static final By Blouse_img = By.xpath("//img[@alt='Blouse']");
	public static final By PrintedDress_img = By.xpath("//img[@alt='Printed Dress']");
	public static final By PrintedChiffonDress_img = By.xpath("//img[@alt='Printed Chiffon Dress']");
	
	//Sign in objects
	public static final By SignIn_btn = By.xpath("//a[@class='login']");
	public static final By ErrorMsg_lbl = By.xpath("//div[@class='alert alert-danger']//ol//li[text()='Invalid password.']");
	public static final By Username_txt = By.xpath("//input[@name='email' and @id='email']");
	public static final By Password_txt = By.xpath("//input[@name='passwd' and @id='passwd']");
	public static final By SubmitLogin_btn =By.xpath("//button[@id='SubmitLogin']");
	public static final By Logout_btn = By.xpath("//a[@class='logout']");
	
	//Cart
	public static final By Tshirts_btn = By.xpath("//header[@id='header']/div[3]/div[@class='container']/div[@class='row']/div[@id='block_top_menu']/ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']/li[3]/a");
	public static final By Tshirt_img = By.xpath("//img[@alt='Faded Short Sleeve T-shirts']");
	public static final By AddToCart_btn = By.xpath("//a[@class='button ajax_add_to_cart_button btn btn-default']/span");
	public static final By Close_btn = By.xpath("//div//span[@class='cross']");
	public static final By ViewCart = By.xpath("//a[@title='View my shopping cart']//b[text()='Cart']");
	public static final By CartTitle_lbl = By.xpath("//h1[@id='cart_title']");
	public static final By QuantityPlus_btn = By.xpath("//a[@class='cart_quantity_up btn btn-default button-plus']");
	public static final By UnitPrice_lbl = By.xpath("//td[@class='cart_unit']//span[@class='price']//span");
	public static final By Quantity_lbl = By.xpath("//td[@class='cart_quantity text-center']//input//following-sibling::input");
	public static final By Total_lbl = By.xpath("//span[@id='total_price']");
	
}
