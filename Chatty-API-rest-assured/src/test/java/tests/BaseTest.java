package tests;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class BaseTest {
    final static String BASE_URI = "http://chatty.telran-edu.de:8989/api";


    static RequestSpecification specWithoutAccessToken = new RequestSpecBuilder()
            .setBaseUri(BASE_URI)
            .setContentType(ContentType.JSON)
            .build();


    public static Response postRequest (String endPoint, Integer expectedStatusCode, Object body) {
        Response response = given()
                .spec(specWithoutAccessToken)
                .body(body)
                .when()
                .log().all()
                .post(endPoint)
                .then()
                .log().all()
                .statusCode(expectedStatusCode)
                .extract().response();
        return response;
    }

    public static Response postRequestWithoutAccessToken(String endPoint, Integer expectedStatusCode, Object body) {
        Response response = given()
                .spec(specWithoutAccessToken)
                .body(body) //ekzeplar klassa
                .when()
                .log().all()
                .post(endPoint)
                .then()
                .log().all()
                .statusCode(expectedStatusCode)
                .extract().response();
        return response;
    }

    public static Response getRequestWithToken(String endPoint, Integer expectedStatusCode,String token) {
        Response response = given()
                .spec(specWithoutAccessToken)
                .when()
                .log().all()
                .header("Authorization", "Bearer " + token) 
                .get(endPoint)
                .then()
                .log().all()
                .statusCode(expectedStatusCode)
                .extract().response();
        return response;
    }

    //dlja USER ID
    public static Response getRequestWithTokenUserID(String endPoint, Integer expectedStatusCode, String token) {
        Response response = given()
                .spec(specWithoutAccessToken)
                .when()
                .log().all()
                .header("Authorization", "Bearer " + token) 
                .get(endPoint) 
                .then()
                .log().all()
                .statusCode(expectedStatusCode)
                .extract().response();
        return response;
    }

    public static Response getRequest(String endPoint, Integer expectedStatusCode) {
        Response response = given()
                .spec(specWithoutAccessToken)
                .when()
                .log().all()
                .get(endPoint)
                .then()
                .log().all()
                .statusCode(expectedStatusCode)
                .extract().response();
        return response;
    }

    public static Response putRequest(String endPoint, Integer expectedStatusCode, String token, Object body) {
        Response response = given()
                .spec(specWithoutAccessToken)
                .body(body)
                .when()
                .log().all()
                .header("Authorization", "Bearer " + token)
                .put(endPoint)
                .then()
                .log().all()
                .statusCode(expectedStatusCode)
                .extract().response();
        return response;

    }
}
