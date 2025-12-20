package booking;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.RestUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class BookingTests {

    @Test
    public void createBookingTest(){

        String endpoint = "https://restful-booker.herokuapp.com/booking";
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
