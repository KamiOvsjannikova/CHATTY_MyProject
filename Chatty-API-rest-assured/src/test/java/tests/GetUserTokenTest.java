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
                .body().jsonPath()
                        .getObject("", UserTokenResponse.class);
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
    }

    //Unauthorized
    @Test
    public void unauthorizedUser(){
        String email = "testQA311023@gmail.com";
        String password = "Milla2103";
        UserTokenRequest requestBody = new UserTokenRequest(email, password);// Эта строка создает новый объект
        UserTokenResponse responseBody = postRequestWithoutAccessToken("/auth/login",200, requestBody) //- Эта строка отправляет POST-запрос к конечной точке /auth/login с кодом состояния 200 и requestBody в качестве тела запроса. Она ожидает ответ в виде UserTokenResponse.
                .body().jsonPath().
                getObject("", UserTokenResponse.class);// Эта часть извлекает JSON-тело ответа POST-запроса и отображает его на объект UserTokenResponse.
        String accessToken = responseBody.getAccessToken();//Эта строка извлекает токен доступа из объекта UserTokenResponse, полученного из предыдущего запроса.
        GetUserResponse getUserResponse = getRequestWithToken("/me", 401,accessToken)//Эта строка отправляет GET-запрос к конечной точке /me с кодом состояния 200 и accessToken в качестве токена в заголовке запроса. Она ожидает ответ в виде GetUserResponse.
                .body().jsonPath()
                .getObject("",GetUserResponse.class);
        assertFalse(responseBody.getAccessToken().isEmpty());
        assertFalse(responseBody.getRefreshToken().isEmpty());
        assertFalse(responseBody.getExpiration().isEmpty());
    }
}
