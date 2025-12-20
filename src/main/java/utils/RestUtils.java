package utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import java.util.Map;
import java.util.Objects;

public class RestUtils {

    public static Response performPostRequest(String endpoint, String requestPayload, Map<String, String> headers) {
        return RestAssured.given().log().all()
                .baseUri(endpoint)
                .headers(headers)
                .body(requestPayload)
                .post().then().log().all().extract().response();
    }

    public static Response performPostRequest(String endpoint, Map<String, Object> requestPayload, Map<String, String> headers) {
        return RestAssured.given().log().all()
                .baseUri(endpoint)
                .headers(headers)
                .body(requestPayload)
                .post().then().log().all().extract().response();
    }
}
