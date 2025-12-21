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

        Map<String, Object> payload = Payloads.getCreateBookingPayloadFromMap();

        Response response = createBooking(payload);

        Assert.assertEquals(response.getStatusCode(), 200);
    }

}
