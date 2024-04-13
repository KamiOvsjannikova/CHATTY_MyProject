package tests;

import com.github.javafaker.Faker;
import dto.CreateUserRequest;
import dto.LoginResponseError;
import dto.LoginResponseSuccess;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertFalse;
import static tests.BaseTest.postRequest;

public class CreateUserTest {
    Faker faker = new Faker();// dlja random email/phone i t.d.
    String fakeEmail = faker.internet().emailAddress();
    String fakePassword = faker.regexify("[aK][io][l][t][u][0-9]{8,10}");
    String confirmPassword =fakePassword;
    String role = "user";

//    @Test
//    public void successCreateUser(){
//       // CreateUserRequest requestBodyBuilder = CreateUserRequest.builder()
//                .email(fakeEmail)
//                .password(fakePassword)
//                .confirmPassword(fakePassword)
//                .role(role)
//                .build();
//
//        LoginResponseSuccess user = postRequest("/auth/register",200, requestBodyBuilder)
//                .body().jsonPath()
//                .getObject("", LoginResponseSuccess.class);
//        assertFalse(user.getExpiration().isEmpty());
//        assertFalse(user.getAccessToken().isEmpty());
//        assertFalse(user.getRefreshToken().isEmpty());
//    }

}
