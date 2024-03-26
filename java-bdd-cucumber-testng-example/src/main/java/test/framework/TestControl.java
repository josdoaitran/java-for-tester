package test.framework;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;

public final class TestControl {
    protected static final Logger LOGGER = LoggerFactory.getLogger(TestControl.class);
    public static String testCaseID = null;

    @Before()
    public static void beforeScenario(Scenario scenario){
        Collection<String> tags = scenario.getSourceTagNames();
        for (String tag : tags) {
            if (tag.contains("TC")) {
                TestControl.testCaseID = tag.replace("@", "");
            }
        }
    }
}
