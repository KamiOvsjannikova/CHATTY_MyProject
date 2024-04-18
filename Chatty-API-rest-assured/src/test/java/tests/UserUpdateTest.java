package tests;

import dto.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;
import static tests.BaseTest.*;

import com.github.javafaker.Faker;

public class UserUpdateTest extends BaseTest {
    Faker faker = new Faker();// dlja random email/phone i t.d.
    String userEmail = faker.internet().emailAddress();
    String userPassword = faker.regexify("[a-zA-Z0-9]{8,10}");
    String confirmPassword = userPassword;
    String role = "user";

    @Test
    public void successUserUpdate()  {
        // snachala novij user
        CreateUserRequest reqBodyBuilder = CreateUserRequest.builder()
                .email(userEmail)
                .password(userPassword)
                .confirmPassword(userPassword)
                .role(role)
                .build();
        LoginResponseSuccess user = postRequest("/auth/register", 201, reqBodyBuilder)                            //pokazivaet 201 u menja, v swagger 200
                .body().jsonPath()
                .getObject("", LoginResponseSuccess.class);
// poluchaju Access Token
        String accessToken = user.getAccessToken();
        Response getUserResponse =  getRequestWithTokenUserID("/me", 200, accessToken);
        String userId = getUserResponse.body().jsonPath().getString("id");
        //object dlja obnov profile, a imnenno Name
        UserUpdateRequest updateProfileRequest = UserUpdateRequest.builder()
                .name("UpdateName")
                .build();
        // PUT zapros na obovlenie profile
        String endPoint = "/users/" + userId;
        // Otpravljau PUT na obnovlenie
        Response response = BaseTest.putRequest(endPoint, 200,accessToken, updateProfileRequest);
        // proverka
        response.then().statusCode(200);
        // izvlekaju name and proverka
        String updateName = response.jsonPath().getString("name");
        assertEquals("UpdateName", updateName);
    }
}
