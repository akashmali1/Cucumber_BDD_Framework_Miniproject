package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features/Login.feature",
        glue = {"stepDefinitions"}, // Path to step definition files
        plugin = {"pretty", "html:target/cucumber-reports.html"}
        //tags = "@smoke" // Specify which tests to run (e.g., smoke tests)
)

public class TestRunner extends AbstractTestNGCucumberTests {
}
