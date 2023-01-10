package io.swagger.petstore.cucumber;

import cucumber.api.CucumberOptions;
import io.swagger.petstore.testbase.TestBase;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

//@CucumberOptions(features = "src/test/java/resources/feature/pets.feature")
//@CucumberOptions(features = "src/test/java/resources/feature/user.feature")

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/java/resources/feature/")
public class CucumberRunner extends TestBase {

}
