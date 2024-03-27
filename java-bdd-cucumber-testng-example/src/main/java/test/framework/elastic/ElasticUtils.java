package test.framework.elastic;

import io.cucumber.plugin.event.Result;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import test.framework.TestControl;
import test.framework.utils.PicoContainer;
import java.time.Instant;
import java.time.format.DateTimeFormatter;

public class ElasticUtils {
    /***
     * The method in this class to call to Elastic Search via RestAssure
     */
    protected static final Logger LOGGER = LoggerFactory.getLogger(ElasticUtils.class);
    private ElasticUtils(){

    }

    private static String currentDate(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSS");
        String formattedUtcTime = Instant.now().toString();
        return formattedUtcTime;
    }
    public static void sendDetailsToElastic(Result result, PicoContainer picoContainer, String status) {

        if (System.getProperty("pushToElastic").equalsIgnoreCase("yes")) {
            LOGGER.info("Results to ELastic");
            JSONObject jsonBody = new JSONObject();
            jsonBody.put("feature", picoContainer.dataStore.get("featureName"));
            jsonBody.put("scenarioName", picoContainer.dataStore.get("scenarioName"));
            jsonBody.put("status", status);
            jsonBody.put("executionTime", currentDate());
            jsonBody.put("duration", picoContainer.dataStore.get("duration"));
            jsonBody.put("testCaseID", TestControl.testCaseID);
            if (result.getStatus().toString().equals("FAILED")) {
                jsonBody.put("logs", picoContainer.dataStore.get("error"));
            }

            Response response = RestAssured.given()
                    .contentType(ContentType.JSON)
                    .body(jsonBody.toString())
                    .log().all()
                    .when()
                    .post(ElasticConfiguration.ELK_URL);

            Assert.assertEquals(response.statusCode(), 201);
            response.prettyPrint();
        }
    }
}
