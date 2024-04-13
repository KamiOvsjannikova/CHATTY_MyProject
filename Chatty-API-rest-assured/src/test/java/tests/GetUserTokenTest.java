package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import dto.GetUserResponse;
import dto.UserTokenRequest;
import dto.UserTokenResponse;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static tests.BaseTest.*;

public class GetUserTokenTest {
    @Test
    public void getToken() { //ne rabotaet
        String email = "testQA311023@gmail.com";
        String password = "Milla2103";
        UserTokenRequest requestBody = new UserTokenRequest(email, password);
        UserTokenResponse responseBody = postRequestWithoutAccessToken("/auth/login",200, requestBody)
                .body().jsonPath().
                getObject("", UserTokenResponse.class);
        String accessToken = responseBody.getAccessToken();
        GetUserResponse getUserResponse = getRequestWithToken("/me", 200,accessToken)
                .body().jsonPath()
                        .getObject("",GetUserResponse.class);


        assertFalse(getUserResponse.getId().isEmpty());
        assertFalse(getUserResponse.getName().isEmpty());
        assertFalse(getUserResponse.getSurname().isEmpty());
        assertFalse(getUserResponse.getEmail().isEmpty());
        assertFalse(getUserResponse.getPhone().isEmpty());
        assertFalse(getUserResponse.getGender().isEmpty());
        assertFalse(getUserResponse.getRole().isEmpty());
        assertFalse(getUserResponse.getBirthDate().isEmpty());
        assertFalse(getUserResponse.getBackgroundUrl().isEmpty());
        assertFalse(getUserResponse.getAvatarUrl().isEmpty());

//        assertFalse(responseBody.getAccessToken().isEmpty());
//        assertFalse(responseBody.getRefreshToken().isEmpty());
//        assertFalse(responseBody.getExpiration().isEmpty());
    }

    @Test
    public void getUserList(){
        List<GetUserResponse> users = getRequest("/users", 200)
                .body().jsonPath()
                .getList("",GetUserResponse.class);
        for (GetUserResponse user : users){
            assertFalse(user.getEmail().isEmpty());
        }
    }

}
