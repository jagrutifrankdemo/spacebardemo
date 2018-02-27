package main;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-pretty-reports", "json:target/cucumber.json"},
        glue = {"stepDefinition"},
        features = {"src/test/resources"},
        tags = {"@integration","~@ignore"})
public class CucumberTest {
}
