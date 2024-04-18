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

        assertFalse(responseSuccessBody.getAccessToken().isEmpty());
        assertFalse(responseSuccessBody.getRefreshToken().isEmpty());
        assertFalse(responseSuccessBody.getExpiration().isEmpty());
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

        assertEquals("Email cannot be empty", responseErrorBody.getEmail().get(0));
    }

    @Test
    public void userUserLoginWithInvalidPassword() {
        String email = "testQA311023@gmail.com";
        String password = "Milla25489";
        LoginRequest requestBody = new LoginRequest(email, password);
        LoginResponseError responseErrorBody = postRequestWithoutAccessToken("/auth/login", 401, requestBody)
                .body().jsonPath()
                .getObject("", LoginResponseError.class);
        assertEquals("UNAUTHORIZED", responseErrorBody.getHttpStatus());
    }



    @Test
    public void userUserLoginWithInvalidEmail() {
        String email = "testQQAfghh";
        String password = "Milla2103";
        LoginRequest requestBody = new LoginRequest(email, password);
        LoginResponseError responseErrorBody = postRequestWithoutAccessToken("/auth/login", 400, requestBody) // bug report error 400
                .body().jsonPath()
                .getObject("", LoginResponseError.class);
        
        assertEquals("Invalid email format", responseErrorBody.getEmail().get(0));
    }
}
