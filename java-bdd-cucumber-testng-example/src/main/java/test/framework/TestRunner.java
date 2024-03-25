package test.framework;

import io.cucumber.plugin.event.*;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.cucumber.plugin.ConcurrentEventListener;
import org.testng.annotations.BeforeSuite;
import test.framework.utils.PicoContainer;

import static test.framework.elastic.ElasticUtils.sendDetailsToElastic;

@CucumberOptions(plugin = {TestConfiguration.Plugin.PRETTY, TestConfiguration.Plugin.JSON},
        glue = {TestConfiguration.Glue.STEPS})
public class TestRunner extends AbstractTestNGCucumberTests implements ConcurrentEventListener{
    protected static final Logger LOGGER = LoggerFactory.getLogger(TestRunner.class);

    @BeforeSuite
    public static void setup() {
        LOGGER.info("Setup testing for each execution time");
    }

    @Override
    public void setEventPublisher(EventPublisher publisher) {
        publisher.registerHandlerFor(TestCaseFinished.class, this::handleTestCaseFinished);
    }

    private void handleTestCaseFinished(TestCaseFinished event) {
        PicoContainer picoContainer = new PicoContainer();
        TestCase testCase = event.getTestCase();
        Result result = event.getResult();
        Status status = result.getStatus();
        Throwable error = result.getError();

        String scenarioName = testCase.getName();
        picoContainer.dataStore.put("scenarioName", scenarioName);
        String featureName = testCase.getUri().toString().split(":")[2].split("features/")[1];
        picoContainer.dataStore.put("featureName", featureName);
        picoContainer.dataStore.put("duration", result.getDuration());

        if (status.toString().equals("PASSED")) {
            sendDetailsToElastic(result, picoContainer, "PASS");
        } else if (status.toString().equals("FAILED")) {
            picoContainer.dataStore.put("error", error.getMessage());
            System.out.println("Error =" + error.getMessage());
            sendDetailsToElastic(result, picoContainer, "FAIL");
        } else if (status.toString().equals("UNDEFINED")) {
            System.out.println("UNDEFINED steps in " + testCase.getName());
            sendDetailsToElastic(result, picoContainer, "UNDEFINED");
        }

    }

}

