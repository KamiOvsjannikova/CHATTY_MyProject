package tests;

import com.github.javafaker.Faker;
import dto.CreateUserRequest;
import dto.LoginResponseError;
import dto.LoginResponseSuccess;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static tests.BaseTest.postRequest;
import static tests.BaseTest.postRequestWithoutAccessToken;

public class CreateUserTest {
    Faker faker = new Faker();// dlja random email/phone i t.d.
    @Test
    public void successCreateUserWithUserRole() { // v swagger 200 owibka, u menja 201
        //Faker faker = new Faker();// dlja raddom email i t.d.
        String userEmail = faker.internet().emailAddress();
        String userPassword = faker.regexify("[a-zA-Z0-9]{8,10}");
        String confirmPassword = userPassword;
        String role = "user";

        //CreateUserRequest requestBody = new CreateUserRequest(userEmail, userPassword, confirmPassword,role );
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
    public void createNewUserWithAdminRole() { // v swagger 401 owibka,a u menja 201
        //Faker faker = new Faker();// dlja raddom email i t.d.
        String userEmail = faker.internet().emailAddress();
        String userPassword = faker.regexify("[a-zA-Z0-9]{8,10}");
        String confirmPassword = userPassword;
        String role = "admin";

        //CreateUserRequest requestBody = new CreateUserRequest(userEmail, userPassword, confirmPassword,role );
        CreateUserRequest reqBodyBuilder = CreateUserRequest.builder() // sozdajem
                .email(userEmail)
                .password(userPassword)
                .confirmPassword(userPassword)
                .role(role)
                .build();
        LoginResponseError userError = postRequestWithoutAccessToken("/auth/register", 401 ,reqBodyBuilder) // sozdajem
                .body().jsonPath()
                .getObject("", LoginResponseError.class);
        //Check that all fields are not empty
        assertEquals("Unauthorized", userError.getHttpStatus());
    }

}
