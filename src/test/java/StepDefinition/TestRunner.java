package StepDefinition;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features="src/test/resources/Feature",
        glue="StepDefinition",
        tags="@AmazonFinal1",
        		plugin = {"json:target/cucumber.json"}
       
)
public class TestRunner {

}
