package tests;

import dto.LoginRequest;
import dto.LoginResponseError;
import dto.LoginResponseSuccess;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static tests.BaseTest.postRequestWithoutAccessToken;

public class LoginTest {
    @Test
    public void userLogin(){
        String email = "testQA311023@gmail.com";
        String password = "Milla2103";
        LoginRequest requestBody = new LoginRequest(email, password);
        LoginResponseSuccess responseSuccessBody = postRequestWithoutAccessToken("/auth/login",200, requestBody)
                .body().jsonPath()
                .getObject("",LoginResponseSuccess.class);


        //proverka
        assertFalse(responseSuccessBody.getAccessToken().isEmpty());
        assertFalse(responseSuccessBody.getRefreshToken().isEmpty());
        assertFalse(responseSuccessBody.getExpiration().isEmpty());
    }
    @Test
    public void userUserLoginWithInvalidEmail() {
        String email = "testQA311023@gmail.co";
        String password = "Milla2103";
        LoginRequest requestBody = new LoginRequest(email, password);
        LoginResponseError responseErrorBody = postRequestWithoutAccessToken("/auth/login", 401, requestBody) // bug report error 404
                .body().jsonPath()
                .getObject("", LoginResponseError.class);

        //proverka
        assertEquals("Unauthorized", responseErrorBody.getHttpStatus());
        assertEquals("The password does not match the one saved in the database!", responseErrorBody.getHttpStatus());
    }

    @Test
    public void userLoginWithoutEmail() {
        String password = "Milla2103";
        LoginRequest requestBodyBuilder =  LoginRequest.builder()
                .password(password)
                .build();
        LoginResponseError responseErrorBody = postRequestWithoutAccessToken("/auth/login", 400, requestBodyBuilder)
                .body().jsonPath()
                .getObject("", LoginResponseError.class);
//proverka
        assertEquals("Email cannot be empty", responseErrorBody.getEmail().get(0));
    }
}
