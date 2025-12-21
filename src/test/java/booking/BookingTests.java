package booking;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import reporting.Setup;
import restUtils.RestUtils;
import utils.JsonUtils;

import java.util.HashMap;
import java.util.Map;

public class BookingTests extends BookingAPIs{

    @Test
    public void createBookingTest(){

        Map<String, String> bookingDates = new HashMap<>();
        bookingDates.put("checkin", "2118-01-01");
        bookingDates.put("checkout", "2119-01-01");

        Map<String, Object> payload = Payloads.getCreateBookingPayloadFromMap("Jim", "Brown", 111, true, bookingDates, "Breakfast");

        Response response = createBooking(payload);

        Assert.assertEquals(response.getStatusCode(), 200);
    }

}
