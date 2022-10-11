package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "DealX/dealx_features/DealX_Cart.feature",		
		glue = {"dealx_seleniumGlueCode", "dealx_runner"}, 
		monochrome = true)
public class DealXTestRunner {

}
