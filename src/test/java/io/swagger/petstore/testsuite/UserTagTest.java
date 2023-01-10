package io.swagger.petstore.testsuite;

import io.swagger.petstore.testbase.TestBase;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.core.annotations.WithTags;
import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(SerenityRunner.class)
public class UserTagTest extends TestBase {

    @WithTag("userfeature:NEGATIVE")
    @Title("Provide a 405 status code when incorrect HTTP method is used to access resource")
    @Test
    public void invalidMethod() {
        SerenityRest.rest()
                .given()
                .when()
                .post("/user")
                .then()
                .statusCode(405)
                .log().all();
    }

    @WithTags({
            @WithTag("userfeature:SMOKE"),
            @WithTag("userfeature:POSITIVE")
    })
    @Title("This test will verify if a status code of 200 is returned for GET request")
    @Test
    public void verifyIfTheStatusCodeIs200() {
        SerenityRest.rest()
                .given()
                .when()
                .get("/user")
                .then()
                .statusCode(200)
                .log().all();
    }

    @WithTags({
            @WithTag("userfeature:SMOKE"),
            @WithTag("userfeature:NEGATIVE")
    })
    @Title("This test will provide an error code of 400 when user tries to access an invalid resource")
    @Test
    public void inCorrectResource() {
        SerenityRest.rest()
                .given()
                .when()
                .get("/user123")
                .then()
                .statusCode(400)
                .log().all();
    }
}
