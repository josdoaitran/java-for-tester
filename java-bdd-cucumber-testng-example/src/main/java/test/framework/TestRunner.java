package test.framework;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.influxdb.dto.Point;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

@CucumberOptions(plugin = {TestConfiguration.Plugin.PRETTY, TestConfiguration.Plugin.JSON},
        glue = {TestConfiguration.Glue.STEPS})
public class TestRunner extends AbstractTestNGCucumberTests {
    protected static final Logger LOGGER = LoggerFactory.getLogger(TestRunner.class);

    @BeforeSuite
    public static void setup() {
        LOGGER.info("Setup testing for each execution time");
    }

    private void postTestMethodStatus(ITestResult iTestResult, String status) {
        Point point = Point.measurement("testmethod").time(System.currentTimeMillis(), TimeUnit.MILLISECONDS)
                .tag("testclass", iTestResult.getTestClass().getName()).tag("name", iTestResult.getName())
                .tag("description", iTestResult.getMethod().getDescription()).tag("result", status)
                .addField("duration", (iTestResult.getEndMillis() - iTestResult.getStartMillis())).build();
        UpdateResults.post(point);
    }
    private void postTestClassStatus(ITestContext iTestContext) {
        Point point = Point.measurement("testclass").time(System.currentTimeMillis(), TimeUnit.MILLISECONDS)
                .tag("name", iTestContext.getAllTestMethods()[0].getTestClass().getName())
                .addField("duration", (iTestContext.getEndDate().getTime() - iTestContext.getStartDate().getTime()))
                .build();
        UpdateResults.post(point);
    }
}

