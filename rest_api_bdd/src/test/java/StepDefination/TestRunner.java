/**
 * @author Abhishek.Mishra
 * @summary This is runner class for Advance Test Execution
 */
package StepDefination;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Features",glue= {"StepDefination"},
monochrome=true,
plugin= {"pretty","html:target/HtmlReports"},
tags="@Regression"		

		)

public class TestRunner {

}
