package tests;

import dto.LoginRequest;
import dto.UserUpdateResponse
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class UserUpdateTest {
    @Test
    public void successUserUpdate(){
        String email = "testUpdateId@gmail.ru";
        String password = "Milla2103Test";
        LoginRequest requestBody = new LoginRequest(email, password);
        String accessToken = given()
                .contentType(ContentType.JSON)
                .body(loginRequest)
                .when()
                .post("/login") // Предположим, что у вас есть эндпоинт для аутентификации
                .then()
                .statusCode(200)
                .extract()
                .path("accessToken");

        UserUpdateResponse updatedUser = given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + accessToken) // Передача токена доступа в заголовке
                .body(buildUserUpdateRequestBody()) // Здесь вызывается метод для построения тела запроса на обновление пользователя
                .when()
                .put("/updateUser/{userId}", "userId") // Предположим, что у вас есть эндпоинт для обновления пользователя
                .then()
                .statusCode(200)
                .extract()
                .as(UserUpdateResponse.class);
    }
    @Test
    public void unsuccessfulUserUpdate(){ //swagger error 400 Error
        String email = "testUpdateId@gmail.ru";
        String password = "Milla2103Test";
        LoginRequest requestBody = new LoginRequest(email, password);

    }
}
