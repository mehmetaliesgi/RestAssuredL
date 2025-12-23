package restUtils;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;
import reporting.ExtentReportManager;

import java.util.Map;

public class RestUtils {

    private static RequestSpecification getRequestSpecification(String endpoint, Object requestPayload, Map<String, String> headers) {
        return RestAssured.given().log().all()
                .baseUri(endpoint)
                .headers(headers)
                .body(requestPayload);

    }

    private static void printRequestLogInReporter(RequestSpecification requestSpecification) {
        QueryableRequestSpecification queryableRequestSpecification = SpecificationQuerier.query(requestSpecification);

        ExtentReportManager.logInfoDetail("Endpoint is " + queryableRequestSpecification.getBaseUri());
        ExtentReportManager.logInfoDetail("Method is " + queryableRequestSpecification.getMethod());
        ExtentReportManager.logInfoDetail("Headers are ");
        ExtentReportManager.logHeaders(queryableRequestSpecification.getHeaders().asList());
        ExtentReportManager.logInfoDetail("Request body is ");
        ExtentReportManager.logJson(queryableRequestSpecification.getBody());
    }

    private static void printResponseLogInReporter(Response response) {
        ExtentReportManager.logInfoDetail("Response status is " + response.getStatusCode());
        ExtentReportManager.logInfoDetail("Headers are ");
        ExtentReportManager.logHeaders(response.getHeaders().asList());
        ExtentReportManager.logInfoDetail("Response body is ");
        ExtentReportManager.logJson(response.getBody().prettyPrint());
    }

    public static Response performPostRequest(String endpoint, String requestPayload, Map<String, String> headers) {
        RequestSpecification requestSpecification = getRequestSpecification(endpoint, requestPayload, headers);
        Response response = requestSpecification.post();

        printRequestLogInReporter(requestSpecification);
        printResponseLogInReporter(response);

        return response;
    }

    public static Response performPostRequest(String endpoint, Map<String, Object> requestPayload, Map<String, String> headers) {
        RequestSpecification requestSpecification = getRequestSpecification(endpoint, requestPayload, headers);

        Response response = requestSpecification.post();

        printRequestLogInReporter(requestSpecification);
        printResponseLogInReporter(response);

        return response;
    }

    public static Response performPostRequest(String endpoint, Object requestPayloadAsPojo, Map<String, String> headers) {
        RequestSpecification requestSpecification = getRequestSpecification(endpoint, requestPayloadAsPojo, headers);

        Response response = requestSpecification.post();

        printRequestLogInReporter(requestSpecification);
        printResponseLogInReporter(response);

        return response;
    }
}
