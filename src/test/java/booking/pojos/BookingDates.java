package booking.pojos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import utils.RandomDataGenerator;
import utils.RandomDataTypeNames;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookingDates {

    private String checkin;
    private String checkout;

    public static BookingDates createRandomDates() {
        return BookingDates.builder()
                .checkin(RandomDataGenerator.getRandomDataFor(RandomDataTypeNames.CHECK_IN))
                .checkout(RandomDataGenerator.getRandomDataFor(RandomDataTypeNames.CHECK_OUT))
                .build();
    }
}