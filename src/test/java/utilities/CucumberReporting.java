package utilities;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;


public class CucumberReporting {
	// Provides pretty html reports for Cucumber. 
	// It works by generating html from the cucumber json file.
	public static void cucumberReporting() {
		
		File reportOutputDirectory =
				new File(System.getProperty("user.dir") + "\\target");
		List<String> jsonFiles = new ArrayList();
		jsonFiles.add(
				System.getProperty("user.dir") + "\\target\\cucumber-reports\\cucumber.json");
		
		String projectName = "Appium Testing";
		Configuration config = new Configuration(reportOutputDirectory, projectName);
		config.addClassifications("Platform", "Android");
		config.addClassifications("Application", "Flipboard");
		config.addClassifications("Branch", "Master");
		
		new ReportBuilder(jsonFiles, config).generateReports();
		
	}

}
