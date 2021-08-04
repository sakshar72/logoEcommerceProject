package cucumber;

import java.io.IOException;

import PageObjectManagers.PageObjectManager;
import resources.UtilityFunctions;

public class TestContext extends UtilityFunctions {

	private PageObjectManager pageObjectManagerObject;
	public ScenarioContext scenarioContext;

	public TestContext() throws IOException {
		System.out.println("Test Context");
		driverObject = browserinitialization();
		scenarioContext = new ScenarioContext();
		System.out.println("Value of driver Object" + driverObject);
		pageObjectManagerObject = new PageObjectManager(driverObject);
	}

	public PageObjectManager getPageObjectManager() {
		return pageObjectManagerObject;
	}

	public ScenarioContext getScenarioContext() {
		return scenarioContext;
	}
}
