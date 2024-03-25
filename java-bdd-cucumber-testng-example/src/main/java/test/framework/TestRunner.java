package test.framework;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeSuite;


@CucumberOptions(plugin = {TestConfiguration.Plugin.PRETTY,
        TestConfiguration.Plugin.JSON,
        TestConfiguration.Plugin.ELASTIC_LISTENER},
        glue = {TestConfiguration.Glue.STEPS})
public class TestRunner extends AbstractTestNGCucumberTests{
    protected static final Logger LOGGER = LoggerFactory.getLogger(TestRunner.class);

    @BeforeSuite
    public static void setup() {
        LOGGER.info("Setup testing for each execution time");
    }

}

