package org.example;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;


public class YandexDiskAPITest {

    private static final String BASE_URL = "https://cloud-api.yandex.net/v1/disk/resources/files";
    private static final String AUTH_TOKEN = "y0_AgAAAABwUIkiAADLWwAAAADrGOTbkXFUv_igT6aJSpwGYe9IceFd_2g"; // Замените на свой токен

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = BASE_URL;
    }


    @Test
    public void testGetFoldersAndFiles() {
        given()
                .header("Authorization", "OAuth " + AUTH_TOKEN)
                .when()
                .get()
                .then()
                .statusCode(200)
                .log().body();

    }

}
