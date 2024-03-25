package test.framework.listeners;

import io.cucumber.plugin.ConcurrentEventListener;
import io.cucumber.plugin.event.*;
import test.framework.utils.PicoContainer;

import static test.framework.elastic.ElasticUtils.sendDetailsToElastic;

public class ElasticListener implements ConcurrentEventListener {

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
            System.out.println("Error =" + error.getMessage());
            sendDetailsToElastic(result, picoContainer, "FAILED");
        } else if (status.toString().equals("UNDEFINED")) {
            System.out.println("UNDEFINED steps in " + testCase.getName());
            sendDetailsToElastic(result, picoContainer, "UNDEFINED");
        }

    }
}
