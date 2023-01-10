package io.swagger.petstore.testsuite;

import io.swagger.petstore.info.PetsSteps;
import io.swagger.petstore.testbase.TestBase;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.Concurrent;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.HashMap;

@Concurrent(threads = "2x")//is working like core cpu speed (System information)
@UseTestDataFrom("src/test/java/resources/testdata/pets.csv")
@RunWith(SerenityParameterizedRunner.class)
public class PetsDataDrivenTest extends TestBase {
    static long petId;
    static HashMap<String, Object> category;
    static String name;
    static ArrayList<String> photoUrls;
    static ArrayList<HashMap<String, Object>> tags;
    static String status;

    @Steps
    PetsSteps petsSteps;

    @Title("Data driven test for adding multiple users to the application")
    @Test
    public void createMultiplePets(){
        petsSteps.createPet(petId,category,name,photoUrls,tags,status).statusCode(200);
    }
}
