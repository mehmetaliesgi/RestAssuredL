package booking;

import net.datafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

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
    public static Map<String, Object> getCreateBookingPayloadFromMap() {
        Faker faker = new Faker();

        Map<String, String> bookingDates = new HashMap<>();
        bookingDates.put("checkin", faker.timeAndDate().future(1, TimeUnit.DAYS, "yyyy-MM-dd"));
        bookingDates.put("checkout", faker.timeAndDate().future(7, TimeUnit.DAYS, "yyyy-MM-dd"));

        Map<String, Object> bookingData = new HashMap<>();

        bookingData.put("firstname", faker.name().firstName());
        bookingData.put("lastname", faker.name().lastName());
        bookingData.put("totalprice", faker.number().numberBetween(100,1000));
        bookingData.put("depositpaid", faker.bool().bool());
        bookingData.put("bookingdates", bookingDates);
        bookingData.put("additionalneeds", faker.food().dish());

        return bookingData;
    }

}
