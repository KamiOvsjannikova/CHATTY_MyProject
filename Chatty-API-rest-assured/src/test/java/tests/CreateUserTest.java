package tests;

import com.github.javafaker.Faker;
import dto.CreateUserRequest;
import dto.LoginRequest;
import dto.LoginResponseError;
import dto.LoginResponseSuccess;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static tests.BaseTest.postRequest;
import static tests.BaseTest.postRequestWithoutAccessToken;

public class CreateUserTest extends BaseTest{
    Faker faker = new Faker();// dlja random email/phone i t.d.
    @Test
    public void successCreateUserWithUserRole() { // v swagger 200 status, u menja 201--> bug report
        //Faker faker = new Faker();// dlja raddom email i t.d.
        String userEmail = faker.internet().emailAddress();
        String userPassword = faker.regexify("[a-zA-Z0-9]{8,10}");
        String confirmPassword = userPassword;
        String role = "user";
        CreateUserRequest reqBodyBuilder = CreateUserRequest.builder() // sozdajem
                .email(userEmail)
                .password(userPassword)
                .confirmPassword(userPassword)
                .role(role)
                .build();
        LoginResponseSuccess user = postRequest("/auth/register", 200,reqBodyBuilder) // sozdajem
                .body().jsonPath()
                .getObject("", LoginResponseSuccess.class);
        //Check that all fields are not empty
        assertFalse(user.getExpiration().isEmpty());
        assertFalse(user.getAccessToken().isEmpty());
        assertFalse(user.getRefreshToken().isEmpty());
    }
    @Test
    public void successCreateUserWithAdminRole() { // v swagger 200 status, u menja 201--> bug report
        //Faker faker = new Faker();// dlja raddom email i t.d.
        String userEmail = faker.internet().emailAddress();
        String userPassword = faker.regexify("[a-zA-Z0-9]{8,10}");
        String confirmPassword = userPassword;
        String role = "admin";

        CreateUserRequest reqBodyBuilder = CreateUserRequest.builder() // sozdajem
                .email(userEmail)
                .password(userPassword)
                .confirmPassword(userPassword)
                .role(role)
                .build();
        LoginResponseSuccess user = postRequest("/auth/register", 200,reqBodyBuilder) // sozdajem
                .body().jsonPath()
                .getObject("", LoginResponseSuccess.class);
        //Check that all fields are not empty
        assertFalse(user.getExpiration().isEmpty());
        assertFalse(user.getAccessToken().isEmpty());
        assertFalse(user.getRefreshToken().isEmpty());
    }

    @Test
    public void createUserWithoutEmail() {

        String userPassword = faker.regexify("[a-zA-Z0-9]{8,10}");
        String confirmPassword = userPassword;
        String role = "user";
        CreateUserRequest reqBodyBuilder = CreateUserRequest.builder() // sozdajem
                .password(userPassword)
                .confirmPassword(userPassword)
                .role(role)
                .build();
        LoginResponseError user = postRequest("/auth/register", 400, reqBodyBuilder) // sozdajem
                .body().jsonPath()
                .getObject("", LoginResponseError.class);
        assertEquals("Email cannot be empty", user.getEmail().get(0));

    }
}
