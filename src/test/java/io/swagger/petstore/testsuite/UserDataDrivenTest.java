package io.swagger.petstore.testsuite;

import io.swagger.petstore.info.UsersSteps;
import io.swagger.petstore.testbase.TestBase;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.Concurrent;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;

@Concurrent(threads = "2x")//is working like core cpu speed (System information)
@UseTestDataFrom("src/test/java/resources/testdata/user.csv")
@RunWith(SerenityParameterizedRunner.class)
public class UserDataDrivenTest extends TestBase {
    static String id;
    static String username;
    static String firstname;
    static String lastname;
    static String email;
    static String password;
    static String phone;
    static String userStatus;
    static int userID;

    @Steps
    UsersSteps usersSteps;

    @Title("Data driven test for adding multiple users to the application")
    @Test
    public void createMultipleUsers(){
        usersSteps.createNewUser(id,username,firstname,lastname,email,password,phone,userStatus).statusCode(200);
    }
}
