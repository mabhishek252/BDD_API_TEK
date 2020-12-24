/**
 * @author Abhishek.Mishra
 * @summary This is runner class for Advance Test Execution
 */
package stepDefination;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Features", glue = { "stepDefination" }, monochrome = true, plugin = {
		"pretty", "html:target/HtmlReports.html" }, tags = "@Regression")

public class TestRunner {

}
