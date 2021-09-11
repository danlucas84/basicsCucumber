package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "target/test-classes/features" },
        glue = { "steps" },
        plugin = { "html:target/cukes/cukes.html", "pretty" },
        stepNotifications = true,
        tags =  "@dev" )
public class RunCucumberTestLocally {
}