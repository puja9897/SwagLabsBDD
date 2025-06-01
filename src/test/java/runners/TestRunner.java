package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features/InventoryProductListing.feature", 
glue = { "stepDefinitions","hooks" })
public class TestRunner extends AbstractTestNGCucumberTests {

}
