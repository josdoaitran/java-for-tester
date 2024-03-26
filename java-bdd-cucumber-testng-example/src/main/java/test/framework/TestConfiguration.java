package test.framework;

public interface TestConfiguration {
    interface Glue{
        String STEPS = "steps";
        String CORE = "test.framework";
    }
    interface Plugin{
        String PRETTY = "pretty";
        String JSON = "json:target/test-reports/cucumber/cucumber.json";
        String ELASTIC_LISTENER = "test.framework.listeners.ElasticListener";
    }
}
