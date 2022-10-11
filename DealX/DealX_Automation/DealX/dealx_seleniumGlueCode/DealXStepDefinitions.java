package dealx_seleniumGlueCode;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dealx_accelerators.DealXActions;
import dealx_accelerators.DealXBase;
import dealx_pageObjects.DealXObjects;
import dealx_utility.DealXExceptionHandle;
import dealx_utility.DealXUtils;

public class DealXStepDefinitions {

	@Given("^Navigate to URL$")
	public void Navigate_to_URL() throws InterruptedException {
		try {
			Thread.sleep(1000);
			DealXBase.driver.get(DealXActions.EnvironmentURL);
			Thread.sleep(1000);
			DealXActions.waitForElementToBeVisible(DealXObjects.Logo, 5);
			Thread.sleep(2000);
		} catch (Exception e) {
			DealXExceptionHandle.HandleException(e, "Unable to navigate to the url");
		}
	}

	@When("^I perform a search$")
	public void I_perform_a_search() throws Throwable {
		if (DealXActions.isElementVisible(DealXObjects.Search_txt, "Search Textbox")) {
			DealXActions.typeInTextBox(DealXObjects.Search_txt, "Blouse", "Search Textbox");
		}
		DealXActions.clickOnElement(DealXObjects.Search_btn, "Search button");
	}

	@Then("^I confirm search results are successfull$")
	public void I_confirm_search_results_are_successfull() throws Throwable {
		if (!DealXActions.isElementVisible(DealXObjects.Blouse_img, "Result 1 label")) {
			DealXExceptionHandle.HandleAssertion("Result 1 not found");
		}
	}

	@Then("^I perform three searches$")
	public void I_perform_three_searches() throws Throwable {
		String search[] = new String[3];
		String result[] = new String[3];
		search[0] = "Blouse";
		search[1] = "Printed Dress";
		search[2] = "Printed Chiffon Dress";

		result[0] = DealXObjects.Blouse_img.toString();
		result[1] = DealXObjects.PrintedDress_img.toString();
		result[2] = DealXObjects.PrintedChiffonDress_img.toString();

		int i = 0;
		while (i < search.length) {
			if (DealXActions.isElementVisible(DealXObjects.Search_txt, "Search Textbox")) {
				DealXActions.typeInTextBox(DealXObjects.Search_txt, search[i], "Search Textbox");
			}
			DealXActions.clickOnElement(DealXObjects.Search_btn, "Search button");
			if (!DealXActions.isElementVisible(DealXObjects.Blouse_img, "Result 1 label")) {
				DealXExceptionHandle.HandleAssertion("Result not found");
			}
			i++;
		}

	}

	@When("^I perform a search using test data \"([^\"]*)\"$")
	public void I_perform_a_search_using_test_data(String sSearch) throws Throwable {
		String Search = DealXUtils.getProperty(sSearch);
		if (DealXActions.isElementVisible(DealXObjects.Search_txt, "Search Textbox")) {
			DealXActions.typeInTextBox(DealXObjects.Search_txt, Search, "Search Textbox");
		}
		DealXActions.clickOnElement(DealXObjects.Search_btn, "Search button");
	}

	@When("^I click on Sign in button$")
	public void i_click_on_Sign_in_button() throws Throwable {

		if (DealXActions.isElementVisible(DealXObjects.SignIn_btn, "Sign in button")) {
			DealXActions.clickOnElement(DealXObjects.SignIn_btn, "Sign in button");
		}
	}

	@When("^I enter invalid credentials \"([^\"]*)\" and \"([^\"]*)\"$")
	public void i_enter_invalid_credentials_and(String sInvalidUsername, String sInvalidPassword) throws Throwable {
		String InvalidUsername = DealXUtils.getProperty(sInvalidUsername);
		String InvalidPassword = DealXUtils.getProperty(sInvalidPassword);
		DealXActions.waitForElementToBeClickable(DealXObjects.Username_txt, 5);
		DealXActions.typeInTextBox(DealXObjects.Username_txt, InvalidUsername, "Invalid Username");
		DealXActions.typeInTextBox(DealXObjects.Password_txt, InvalidPassword, "Invalid Password");
	}

	@Then("^I click on login button$")
	public void i_click_on_login_button() throws Throwable {
		DealXActions.clickOnElement(DealXObjects.SubmitLogin_btn, "Login");
	}

	@Then("^I confirm login is unsuccessful$")
	public void i_confirm_login_is_unsuccessful() throws Throwable {
		if (!DealXActions.isElementVisible(DealXObjects.ErrorMsg_lbl, "Error label")) {
			DealXExceptionHandle.HandleAssertion("Error message not visible");
		}
	}

	@Then("^I enter valid credentials \"([^\"]*)\" and \"([^\"]*)\"$")
	public void i_enter_valid_credentials_and(String sValidUsername, String sValidPassword) throws Throwable {
		String ValidUsername = DealXUtils.getProperty(sValidUsername);
		String ValidPassword = DealXUtils.getProperty(sValidPassword);
		DealXActions.waitForElementToBeClickable(DealXObjects.Username_txt, 5);
		DealXActions.typeInTextBox(DealXObjects.Username_txt, ValidUsername, "Valid Username");
		DealXActions.typeInTextBox(DealXObjects.Password_txt, ValidPassword, "Valid Password");
	}

	@And("^I confirm login is successful$")
	public void i_confirm_login_is_successful() throws Throwable {
		if (!DealXActions.isElementVisible(DealXObjects.Logout_btn, "Logout button")) {
			DealXExceptionHandle.HandleAssertion("Login not successful");
		}
	}

	@When("^I click on Tshirt button$")
	public void i_click_on_Tshirt_button() throws Throwable {
		if (DealXActions.isElementVisible(DealXObjects.Tshirts_btn, "T shirt button"))
			DealXActions.clickOnElement(DealXObjects.Tshirts_btn, "T shirt button");
		else {
			DealXExceptionHandle.HandleAssertion("Failed to click on T shirt button");
		}
	}

	@Then("^I hover over Tshirt image and click$")
	public void i_hover_over_Tshirt_image_and_click() throws Throwable {
		if (DealXActions.isElementVisible(DealXObjects.Tshirt_img, "T shirt image")) {
			DealXActions.HoverMouse(DealXObjects.Tshirt_img);
			DealXActions.clickOnElement(DealXObjects.AddToCart_btn, "Add to cart button");
		} else {
			DealXExceptionHandle.HandleAssertion("Failed to click on Add to cart button");
		}
		DealXActions.waitForElementToBeClickable(DealXObjects.Close_btn, 20);
		DealXActions.clickOnElement(DealXObjects.Close_btn, "Close button");
	}

	@When("^I click on view cart$")
	public void i_click_on_view_cart() throws Throwable {
		if (DealXActions.isElementVisible(DealXObjects.ViewCart, "View cart button"))
			DealXActions.clickOnElement(DealXObjects.ViewCart, "View cart button");
		else {
			DealXExceptionHandle.HandleAssertion("Failed to click on View cart button");
		}
		if (!DealXActions.isElementVisible(DealXObjects.CartTitle_lbl, "Cart Title label")) {
			DealXExceptionHandle.HandleAssertion("Failed to navigate to shopping cart");
		}
	}

	@Then("^I increase quantity$")
	public void i_increase_quantity() throws Throwable {
		int i = 0;

		while (i < 4) {
			DealXActions.clickOnElement(DealXObjects.QuantityPlus_btn, "Quantity plus button");

			i++;
		}
	}

	@Then("^Calculate total$")
	public void calculate_total() throws Throwable {
		String unitPrice = DealXObjects.UnitPrice_lbl.toString();
		String quantity = DealXObjects.Quantity_lbl.toString();
		double total = 0;

		total = Double.parseDouble(unitPrice.toString().substring(1)) * Double.parseDouble(quantity.toString().substring(1));

		if (total == Double.parseDouble(DealXObjects.Total_lbl.toString().substring(1))) {
			System.out.println("Calculation successful");
		}
	}

}
