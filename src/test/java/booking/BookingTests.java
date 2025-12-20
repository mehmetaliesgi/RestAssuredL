package booking;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import restUtils.RestUtils;
import utils.JsonUtils;

import java.util.HashMap;
import java.util.Map;

public class BookingTests {

    @Test
    public void createBookingTest(){

        String env = System.getProperty("ENV") == null ? "qa" : System.getProperty("ENV");

        Map<String,String> data = JsonUtils.getJsonDataAsMap("booking/"+env+"/bookingApiData.json");
        String endpoint = data.get("createBookingEndpoint");

        Map<String, String> bookingDates = new HashMap<>();
        bookingDates.put("checkin", "2018-01-01");
        bookingDates.put("checkout", "2019-01-01");

        Map<String, Object> payload = Payloads.getCreateBookingPayloadFromMap("Jim", "Brown", 111, true, bookingDates, "Breakfast");


        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");

        Response response = RestUtils.performPostRequest(endpoint, payload, headers);

        Assert.assertEquals(response.getStatusCode(), 200);
    }

}
