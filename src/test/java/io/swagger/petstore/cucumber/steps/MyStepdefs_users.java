package io.swagger.petstore.cucumber.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.ValidatableResponse;
import io.swagger.petstore.info.UsersSteps;
import io.swagger.petstore.utils.TestUtils;
import net.thucydides.core.annotations.Steps;

public class MyStepdefs_users {

    static ValidatableResponse response;
    static String id = "5";
    static String username = "test123" + TestUtils.getRandomValue();
    static String firstname = "Anu";
    static String lastname = "Sharma";
    static String email = "anusharma@gmail.com";
    static String password = "pass123";
    static String phone = "78291030122";
    static String userStatus = "1";

    static int userID;

    @Steps
    UsersSteps usersSteps;

    @When("^I create new user by providing the information id \"([^\"]*)\" username \"([^\"]*)\" firstname \"([^\"]*)\" lastname \"([^\"]*)\" email \"([^\"]*)\" password \"([^\"]*)\" phone \"([^\"]*)\" status \"([^\"]*)\"$")
    public void iCreateNewUserByProvidingTheInformationIdUsernameFirstnameLastnameEmailPasswordPhoneStatus(String id, String username, String firstname, String lastname, String email, String password, String phone, String userStatus) {
        id = "5";
        username = "test123" + TestUtils.getRandomValue();
        firstname = "Anu";
        lastname = "Sharma";
        email = "anusharma@gmail.com";
        password = "pass123";
        phone = "78291030122";
        userStatus = "1";

        response = usersSteps.createNewUser(id, username, firstname, lastname, email, password, phone, userStatus);
    }

    @Then("^I verify that the user is created with status 200$")
    public void iVerifyThatTheUserIsCreatedWithStatus() {
        response.statusCode(200);
    }

    @When("^I get a new added user with username \"([^\"]*)\"$")
    public void iGetANewAddedUserWithUsername(String username)  {
        username=response.log().all().extract().path("username");
        response.statusCode(200);
    }

    @When("^I update user with username \"([^\"]*)\"$")
    public void iUpdateUserWithUsername(String username) {
        username = username + "_updated";
        response = usersSteps.updateUser(id,username,firstname,lastname,email,password,phone,userStatus);
    }

    @Then("^I verify that user is updated$")
    public void iVerifyThatUserIsUpdated() {
        response.statusCode(200);
//        HashMap<String, Object> userMap = response.log().all().extract().path("");
//        Assert.assertThat(userMap, hasValue(firstname));
    }

    @When("^I delete user that created$")
    public void iDeleteUserThatCreated() {
        response = usersSteps.deleteUser(username);
    }

    @Then("^I verify user is deleted and status code is 200$")
    public void iVerifyUserIsDeletedAndStatusCodeIs() {
        response.statusCode(200);
        usersSteps.getUserByUserName(username);
    }

    @Given("^User application is running$")
    public void userApplicationIsRunning() {
    }

    @Then("^I verify that the user is created with \"([^\"]*)\"$")
    public void iVerifyThatTheUserIsCreatedWith(String username)  {
        username=response.log().all().extract().path("username");
        response.statusCode(200);
    }

    @Then("^I verify user is deleted$")
    public void iVerifyUserIsDeleted() {
        response = usersSteps.deleteUser(username);
        response.statusCode(404);
    }

}
