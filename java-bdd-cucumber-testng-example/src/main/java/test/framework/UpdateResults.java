package test.framework;

import org.influxdb.InfluxDB;
import org.influxdb.InfluxDBFactory;
import org.influxdb.dto.Point;
public class UpdateResults {
    private static final InfluxDB INFLXUDB = InfluxDBFactory.connect("http://localhost:8086", "admin", "admin");
    private static final String DB_NAME = "automation_test";
    static {
        INFLXUDB.setDatabase(DB_NAME);
    }
    public static void post(final Point point) {
        INFLXUDB.write(point);
    }
}
// References: https://blog.testproject.io/2020/05/12/make-your-selenium-test-results-live-using-grafana-and-influxdb/
