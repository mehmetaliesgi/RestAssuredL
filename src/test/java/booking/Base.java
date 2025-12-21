package booking;

import utils.JsonUtils;

import java.util.Map;

public class Base {

    public static Map<String, Object> dataFromJsonFile;

    static {
        String env = System.getProperty("ENV") == null ? "qa" : System.getProperty("ENV");

        dataFromJsonFile = JsonUtils.getJsonDataAsMap("booking/"+env+"/bookingApiData.json");
    }
}
