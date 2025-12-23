package booking.pojos;

import lombok.Builder;
import lombok.Data;
import utils.RandomDataGenerator;
import utils.RandomDataTypeNames;

@Data
@Builder
public class Book {

    private String firstname;
    private String lastname;
    private int totalprice;
    private boolean depositpaid;
    private BookingDates bookingdates;
    private String additionalneeds;

    public static Book createRandomBook() {
        return Book.builder()
                .firstname(RandomDataGenerator.getRandomDataFor(RandomDataTypeNames.FIRST_NAME))
                .lastname(RandomDataGenerator.getRandomDataFor(RandomDataTypeNames.LAST_NAME))
                .totalprice(RandomDataGenerator.getRandomIntDataFor(100, 1000))
                .depositpaid(RandomDataGenerator.getRandomBooleanDataFor())
                .bookingdates(BookingDates.createRandomDates())
                .additionalneeds(RandomDataGenerator.getRandomDataFor(RandomDataTypeNames.ADDITIONAL_NEEDS))
                .build();
    }
}
