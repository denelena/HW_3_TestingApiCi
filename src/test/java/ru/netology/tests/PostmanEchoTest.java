package ru.netology.tests;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class PostmanEchoTest {

    private String payLoad =
                    "Twas brillig, and the slithy toves "+
                    "Did gyre and gimble in the wabe; "+
                    "All mimsy were the borogoves, "+
                    "And the mome raths outgrabe.";


    @Test
    void shouldGetResponseFromPostmanEcho() {
        // Given - When - Then
        // Предусловия
        given()
                .baseUri("https://postman-echo.com")
                .body(payLoad) // отправляемые данные (заголовки и query можно выставлять аналогично)
                // Выполняемые действия
                .when()
                .post("/post")
                // Проверки
                .then()
                .statusCode(200)
                .body("data", equalTo("Если на клетке слона прочтёшь надпись «буйвол», не верь глазам своим."));
    }
}
