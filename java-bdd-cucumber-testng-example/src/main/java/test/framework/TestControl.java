package test.framework;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.util.Collection;

public class TestControl {
    public static String testCaseID;
    @Before
    public void beforeScenario(Scenario scenario){
        Collection<String> tags = scenario.getSourceTagNames();
        for (String tag : tags) {
            if (tag.contains("TC")) {
                testCaseID = tag;
            }
        }
    }
}
