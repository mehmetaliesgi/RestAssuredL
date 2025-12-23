package booking;

import net.datafaker.Faker;
import utils.RandomDataGenerator;
import utils.RandomDataTypeNames;

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


    public static Map<String, Object> getCreateBookingPayloadFromMap() {
        Faker faker = new Faker();

        Map<String, String> bookingDates = new HashMap<>();
        bookingDates.put("checkin", RandomDataGenerator.getRandomDataFor(RandomDataTypeNames.CHECK_IN));
        bookingDates.put("checkout", RandomDataGenerator.getRandomDataFor(RandomDataTypeNames.CHECK_OUT));

        Map<String, Object> bookingData = new HashMap<>();

        bookingData.put("firstname", RandomDataGenerator.getRandomDataFor(RandomDataTypeNames.FIRST_NAME));
        bookingData.put("lastname", RandomDataGenerator.getRandomDataFor(RandomDataTypeNames.LAST_NAME));
        bookingData.put("totalprice", RandomDataGenerator.getRandomIntDataFor(100, 1000));
        bookingData.put("depositpaid", RandomDataGenerator.getRandomBooleanDataFor());
        bookingData.put("bookingdates", bookingDates);
        bookingData.put("additionalneeds", RandomDataGenerator.getRandomDataFor(RandomDataTypeNames.ADDITIONAL_NEEDS));

        return bookingData;
    }

}
