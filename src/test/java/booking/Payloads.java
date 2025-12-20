package booking;

import java.util.HashMap;
import java.util.Map;

public class Payloads {

    public static String getCreateBookingPayload(String firstName, String lastName, int totalPrice, boolean depositPaid, Map<String, String> bookingDates, String additionalNeeds) {
        String checkin = bookingDates.get("checkin");
        String checkout = bookingDates.get("checkout");

        return "{\n" +
                "    \"firstname\" : \"" + firstName + "\",\n" +
                "    \"lastname\" : \"" + lastName + "\",\n" +
                "    \"totalprice\" : " + totalPrice + ",\n" +
                "    \"depositpaid\" : " + depositPaid + ",\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"" + checkin + "\",\n" +
                "        \"checkout\" : \"" + checkout + "\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"" + additionalNeeds + "\"\n" +
                "}";
    }

    public static Map<String, Object> getCreateBookingPayloadFromMap(String firstName, String lastName, int totalPrice, boolean depositPaid, Map<String, String> bookingDates, String additionalNeeds) {

        Map<String, Object> bookingData = new HashMap<>();
        bookingData.put("firstname", firstName);
        bookingData.put("lastname", lastName);
        bookingData.put("totalprice", totalPrice);
        bookingData.put("depositpaid", depositPaid);
        bookingData.put("bookingdates", bookingDates);
        bookingData.put("additionalneeds", additionalNeeds);

        return bookingData;
    }

}
