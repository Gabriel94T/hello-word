package StepDefinitions;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		features = "src/test/resources/Features",
		
		glue = {"StepDefinitions"},
		
		monochrome = true,
		
		//tags="@3Shools",
		//tags = "@GithubTest",
		//tags = "@ExTestWithTable",
		
		plugin = { "pretty", "html:target/HTMLReport/HTMLREPORT.html",
		"junit:target/JunitReport/report.xml",
		"json:target/JsonReport/report.json"}
		
		
		)

		
public class TestRunner {

}
