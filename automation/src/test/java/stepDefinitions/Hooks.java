package stepDefinitions;

import cucumber.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import pageObjects.UrlLaunchPage;

public class Hooks {
	TestContext testContext;
	UrlLaunchPage urlLaunchPage;

	public Hooks(TestContext context) {
		testContext = context;
		urlLaunchPage =  testContext.getPageObjectManager().getUrlLaunchPage();
	}

	@Before
	public void BeforeSteps() {
		urlLaunchPage.navigateToApplicationPage();		
	}

	@After
	public void AfterSteps() {
		testContext.getWebDriverManager().closeDriver();
	}
}
