package io.swagger.petstore.cucumber.steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.ValidatableResponse;
import io.swagger.petstore.info.PetsSteps;
import io.swagger.petstore.utils.TestUtils;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.HashMap;

import static org.hamcrest.Matchers.anything;

public class MyStepdefs_pets {

    static ValidatableResponse response;
    static long petId;

    static HashMap<String, Object> category;
    static String name;

    static ArrayList<String> photoUrls;

    static ArrayList<HashMap<String, Object>> tags;

    static String status;

    @Steps
    PetsSteps petsSteps;

    @When("^I create new pet by providing the information category \"([^\"]*)\" name \"([^\"]*)\" photoUrls \"([^\"]*)\" tags \"([^\"]*)\" status \"([^\"]*)\"$")
    public void iCreateNewPetByProvidingTheInformationCategoryNamePhotoUrlsTagsStatus(String cate, String name, String photo, String tag, String status) {
        name = "Suzzy" + TestUtils.getRandomValue();
        status = "available";
        HashMap<String, Object> category = new HashMap<>();
        category.put("id", "2");
        category.put("name", "Mixed");

        ArrayList<String> photoUrls = new ArrayList<>();
        photoUrls.add("String");

        ArrayList<HashMap<String, Object>> tags = new ArrayList<>();
        HashMap<String, Object> tagMap = new HashMap<>();
        tagMap.put("id", 301);
        tagMap.put("name", "Suzzy");
        tags.add(tagMap);

        response = petsSteps.createPet(petId, category, name, photoUrls, tags, status);
    }

    @Then("^I verify that the pet is created with status 200$")
    public void iVerifyThatThePetIsCreatedWithStatus() {
        response.statusCode(200);
        petId = response.log().all().extract().path("id");
    }

    @When("^I get a new pet with petId$")
    public void iGetANewPetWithPetId() {
        HashMap<String, Object> petMap = petsSteps.findPetById(petId);
        Assert.assertThat(petMap, anything(name));
    }

    @Then("^I verify that the pet is created$")
    public void iVerifyThatThePetIsCreated() {
        response.statusCode(200);
    }

    @When("^I update pet with status$")
    public void iUpdatePetWithStatus() {
        name = "Suzzy" + TestUtils.getRandomValue();
        status = "Not available";
        HashMap<String, Object> category = new HashMap<>();
        category.put("name", "Mixed");
        category.put("id", "2");

        ArrayList<String> photoUrls = new ArrayList<>();
        photoUrls.add("https://th.bing.com/th/id/OIP.L90UXlIDXPcyWOOnOIjlggHaFa?pid=ImgDet&rs=1");

        ArrayList<HashMap<String, Object>> tags = new ArrayList<HashMap<String, Object>>();
        HashMap<String, Object> tagMap = new HashMap<>();
        tagMap.put("id", 301);
        tagMap.put("name", "Suzzy");
        tags.add(tagMap);

        response = petsSteps.updatePet(petId, category, name, photoUrls, tags, status);

    }

    @Then("^I verify that pet is updated$")
    public void iVerifyThatPetIsUpdated() {
        HashMap<String, Object> petMap = petsSteps.findPetById(petId);
        Assert.assertThat(petMap, anything(status));
    }

    @When("^I delete pet that created$")
    public void iDeletePetThatCreated() {
        response=petsSteps.deletePetById(petId);
    }

    @Then("^I verify pet is deleted$")
    public void iVerifyPetIsDeleted() {
//        petId = response.log().all().extract().path("id");
        response.statusCode(404);
        petsSteps.getPetById(petId).statusCode(200);
    }
}
