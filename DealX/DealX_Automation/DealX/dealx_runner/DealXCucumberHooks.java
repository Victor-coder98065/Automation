package dealx_runner;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import dealx_accelerators.DealXActions;
import dealx_accelerators.DealXBase;
import dealx_utility.DealXExceptionHandle;

public class DealXCucumberHooks {

//	Everything that needs to be done before every scenario is run
	@Before
	public void beforeScenario(Scenario scenario) {
		try {
			DealXActions.sTestCaseName = scenario.getName();
			DealXBase.OpenBrowser();
		} catch (Exception e) {
			DealXExceptionHandle.HandleException(e, e.getMessage());
		}
	}
//	Everything that needs to be done after every scenario is run
	@After
	public void afterScenario(Scenario scenario) {
		try {
			DealXActions.sTestCaseName = scenario.getName();
			DealXBase.tearDown();
		} catch (Exception e) {
			DealXExceptionHandle.HandleException(e, e.getMessage());
		}

	}
}
