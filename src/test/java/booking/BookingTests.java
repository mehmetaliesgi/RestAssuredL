package booking;

import booking.pojos.Book;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BookingTests extends BookingAPIs{

    @Test
    public void createBookingTest(){

        //Book payload = Payloads.getCreateBookingPayloadFromPojo();

        Book payload = Book.createRandomBook();

        Response response = createBooking(payload);

        Assert.assertEquals(response.getStatusCode(), 200);
    }

}
