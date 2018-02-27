package helpers;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class APICommonActions {
    public static Response response;
    public static ValidatableResponse json;
    public static RequestSpecification request;
    public static String jsonString;
    public static String site = "http://localhost:8080/public/info";
}