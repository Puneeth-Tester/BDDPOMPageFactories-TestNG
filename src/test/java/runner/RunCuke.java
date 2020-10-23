package runner;

import org.testng.annotations.AfterSuite;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import utilities.CucumberReporting;


@CucumberOptions(
				 features= {"src/test/resources/features"}, 
				 glue= {"steps"},
				 plugin = {
						 	"pretty",
						 	"html:target/cucumber-html-report", 
						 	"json:target/cucumber-reports/cucumber.json",
						 	"junit:target/cucumber-reports/cucumber.xml",
							"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
						 	},
				 tags= {"@FailFeature,@LoginFeature,@SearchItem,@ZFailFeature"})
public class RunCuke extends AbstractTestNGCucumberTests {

	@AfterSuite
	public void generateCucumberReport() {
		CucumberReporting.cucumberReporting();
	}
}
