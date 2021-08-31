package org.quarkus.trireme.module.job.upload;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.CoreMatchers.containsString;

@QuarkusTest
class ReactiveJobUploadServiceTest {

    @Test
    void uploadIfJobDoesNotExist() {

        given()
                .when().post("/jars/upload")
                .then()
                .statusCode(200)
                ;
    }
}