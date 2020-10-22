package steps;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

import base.TestBase;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import screens.ChooseTopicsScreen;
import screens.HomeScreen;
import screens.LoginScreen;
import screens.SearchScreen;
import utilities.CucumberReporting;

public class FlipboardSteps extends TestBase{
	
	
	LoginScreen login;
	ChooseTopicsScreen  topicScreen;
	HomeScreen home;
	SearchScreen search;
	
	
	@Before
	public void initialization() {	
		setUp();
		login = new LoginScreen(driver);
		topicScreen = new ChooseTopicsScreen(driver);
		home = new HomeScreen(driver);
		search = new SearchScreen(driver);
	}
	
	/*@After
	public void tearDown(Scenario scenario) {
		if(scenario.isFailed()) {
			//captureScreenshot
			ExtentCucumberAdapter.getCurrentStep().fail("Screenshot Attached ----->");
			takeScreenshot();
			//to embed screenshot in Cucumber Report
			scenario.embed(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES), "image/png");
		}
		quit();
	}*/
	
	@After
	public void tearDown(Scenario scenario) {
		if(scenario.isFailed()) {
			//captureScreenshot
			ExtentCucumberAdapter.getCurrentStep().fail("Screenshot Attached ----->");
			takeScreenshot(scenario);
		}
		quit();
	}
		
	@Given("user clicks on getStartedButton")
	public void user_clicks_on_getStartedButton() {
		login.clickGetStartedBtn();
	}


	@When("user selects {int} topics")
	public void user_selects_topics(Integer int1) {
		topicScreen.chooseTopics(int1);
	}

	@Then("user clicks on continue button")
	public void user_clicks_on_continue_button() {
		topicScreen.clickContinue();
	}
	
	@Then("user clicks on skip for now button")
	public void user_clicks_on_skip_for_now_button() {
		topicScreen.skipLogin();
	}

	@Then("user clicks on search panel")
	public void user_clicks_on_search_panel() {
		home.selectBottomPanel(3);
	}

	@Then("^user enters the (.*)$")
	public void user_enters_the_(String searchText) {
		search.searchFlipBoard(searchText);
	}
	
	@Then("user fails the test")
	public void user_fails_the_test() {
		Assert.fail();
	}

}
