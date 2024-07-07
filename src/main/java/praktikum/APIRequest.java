package praktikum;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;

import praktikum.model.UserRequest;

import static io.restassured.RestAssured.given;

public class APIRequest {

    @Step("Отправка запроса на создание пользователя")
    public ValidatableResponse createUser(String name, String email, String password){
        UserRequest userRequest = new UserRequest();
        userRequest.setEmail(email);
        userRequest.setPassword(password);
        userRequest.setName(name);
        return given()
                .header("Content-type", "application/json")
                .and()
                .body(userRequest)
                .when()
                .post("https://stellarburgers.nomoreparties.site/api/auth/register")
                .then();
    }

    @Step("Отправка запроса на удаление пользователя")
    public ValidatableResponse deleteUser(String authorization){
        return given()
                .header("Content-type", "application/json")
                .headers("Authorization", authorization)
                .when()
                .delete("https://stellarburgers.nomoreparties.site/api/auth/user")
                .then();
    }

    @Step("Отправка запроса на логин пользователя")
    public ValidatableResponse loginUser(String email, String password){
        UserRequest userRequest = new UserRequest();
        userRequest.setEmail(email);
        userRequest.setPassword(password);
        return given()
                .header("Content-type", "application/json")
                .and()
                .body(userRequest)
                .when()
                .post("https://stellarburgers.nomoreparties.site/api/auth/login")
                .then();
    }
}
