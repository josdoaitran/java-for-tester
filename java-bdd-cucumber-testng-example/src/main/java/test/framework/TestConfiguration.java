package test.framework;

public interface TestConfiguration {
    interface Glue{
        String STEPS = "test.steps";
    }
    interface Plugin{
        String PRETTY = "pretty";
        String JSON = "json:target/test-reports/cucumber/cucumber.json";
    }
}
