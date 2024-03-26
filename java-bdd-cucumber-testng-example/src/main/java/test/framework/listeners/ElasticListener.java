package test.framework.listeners;

import io.cucumber.plugin.ConcurrentEventListener;
import io.cucumber.plugin.event.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import test.framework.TestControl;
import test.framework.utils.PicoContainer;

import static test.framework.elastic.ElasticUtils.sendDetailsToElastic;

public class ElasticListener implements ConcurrentEventListener {
    protected static final Logger LOGGER = LoggerFactory.getLogger(ElasticListener.class);

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
        String featureName = testCase.getUri().toString().split("features/")[1];
        picoContainer.dataStore.put("featureName", featureName);
        picoContainer.dataStore.put("duration", result.getDuration());

        if (status.toString().equals("PASSED")) {
            sendDetailsToElastic(result, picoContainer, "PASSED");
        } else if (status.toString().equals("FAILED")) {
            picoContainer.dataStore.put("error", error.getMessage());
            LOGGER.info("Error =" + error.getMessage());
            sendDetailsToElastic(result, picoContainer, "FAILED");
        } else if (status.toString().equals("UNDEFINED")) {
            LOGGER.info("UNDEFINED steps in " + testCase.getName());
            sendDetailsToElastic(result, picoContainer, "UNDEFINED");
        }

    }
}
