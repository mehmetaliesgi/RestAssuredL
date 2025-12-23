package booking;

import booking.pojos.Book;
import io.restassured.response.Response;
import restUtils.RestUtils;

import java.util.HashMap;
import java.util.Map;

public class BookingAPIs {

    public Response createBooking(Map<String, Object> createBookingPayload) {
        String endpoint = (String) Base.dataFromJsonFile.get("createBookingEndpoint");

        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");

        return RestUtils.performPostRequest(endpoint, createBookingPayload, headers);
    }

    public Response createBooking(Book createBookingPayload) {
        String endpoint = (String) Base.dataFromJsonFile.get("createBookingEndpoint");

        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");

        return RestUtils.performPostRequest(endpoint, createBookingPayload, headers);
    }
}
