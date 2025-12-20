package booking;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.RestUtils;

import java.util.HashMap;
import java.util.Map;

public class BookingTests {

    @Test
    public void createBookingTest(){

        String endpoint = "https://restful-booker.herokuapp.com/booking";
        String payload = "{\n" +
                "    \"firstname\" : \"Jim\",\n" +
                "    \"lastname\" : \"Brown\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");

        Response response = RestUtils.performPostRequest(endpoint, payload, headers);

        Assert.assertEquals(response.getStatusCode(), 200);
    }

}
