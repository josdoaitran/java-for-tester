package test.framework.elastic;

import io.cucumber.plugin.event.Result;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import test.framework.TestRunner;
import test.framework.utils.PicoContainer;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class ElasticUtils {
    protected static final Logger LOGGER = LoggerFactory.getLogger(ElasticUtils.class);
    private ElasticUtils(){

    }
    public static void sendDetailsToElastic(Result result, PicoContainer picoContainer, String status) {

        if (System.getProperty("pushToElastic").equalsIgnoreCase("yes")) {
            LOGGER.info("Results to ELastic");
            Map<String, Object> map = new HashMap<>();
            map.put("feature", picoContainer.dataStore.get("featureName"));
            map.put("scenarioName", picoContainer.dataStore.get("scenarioName"));
            map.put("status", status);
            map.put("executionTime", LocalDateTime.now().toString());
            map.put("duration", picoContainer.dataStore.get("duration"));
            map.put("Test Case ID", "TC-11"); // Can use this to filter the results in Kibana
            if (result.getStatus().toString().equals("FAILED")) {
                map.put("logs", picoContainer.dataStore.get("error"));
            }
            Response response = given().header("Content-Type", "application/json")
                    .log().all().
                    body(map)
                    .post(ElasticConfiguration.ELK_URL);

            Assert.assertEquals(response.statusCode(), 201);
            response.prettyPrint();
        }
    }
}
