package booking;

import booking.pojos.Book;
import booking.pojos.CreateBookingResponse;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import tools.jackson.databind.ObjectMapper;

public class BookingTests extends BookingAPIs{

//    @Test
//    public void createBookingTest(){
//
//        //Book payload = Payloads.getCreateBookingPayloadFromPojo();
//
//        Book payload = Book.createRandomBook();
//
//        Response response = createBooking(payload);
//
//        Assert.assertEquals(response.getStatusCode(), 200);
//    }


    @Test
    public void createBookingTest(){
        Book payload = Book.createRandomBook();
        Response response = createBooking(payload);

        ObjectMapper mapper = new ObjectMapper();
        CreateBookingResponse createBookResponse = mapper.readValue(
                response.getBody().asString(),
                CreateBookingResponse.class
        );

        Assert.assertEquals(createBookResponse.getBooking(), payload);

    }

}
