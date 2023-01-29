package com.modmed.clinical.apis.tests;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.Playwright;
import com.modmed.clinical.apis.helpers.PetServiceHelper;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class PetGetTest {
    public static  Playwright playwright;
    public static APIRequestContext apiRequestContext;
    PetServiceHelper petServiceHelper = new PetServiceHelper();
//
//    @BeforeClass
//    public void setup(){
//        Map<String, String> header = new HashMap<>();
//        header.put("Content-Type","application/json");
//        playwright = Playwright.create();
//        apiRequestContext = playwright.request().newContext(new APIRequest.NewContextOptions()
//                .setBaseURL("http://localhost:3000")
//                .setExtraHTTPHeaders(header));
//    }

//    @BeforeClass
//    public void setup(){
//        Map<String, String> header = new HashMap<>();
//        header.put("Content-Type","application/json");
//        playwright = Playwright.create();
//        apiRequestContext = playwright.request().newContext(new APIRequest.NewContextOptions()
//                .setBaseURL("https://petstore.swagger.io")
//                .setExtraHTTPHeaders(header));
//    }

//    @Test
//    public void getRequest() {
//        int reponsecode = apiRequestContext.get("/comments").status();
//        System.out.print(reponsecode);
//    }

    @Test
    public void postRequest() {
        Map<String, String> header = new HashMap<>();
        header.put("Content-Type","application/json");
        header.put("Accept","application/json");
        playwright = Playwright.create();
        apiRequestContext = playwright.request().newContext(new APIRequest.NewContextOptions()
                .setBaseURL("https://petstore.swagger.io")
                .setExtraHTTPHeaders(header));
        String response = apiRequestContext.get("/v2/pet/1").statusText();
        System.out.print(response);
    }


    @Test
    public void getPet() {
        String text = petServiceHelper.getSpecificPet("2");
    }

    @Test
    public void getPetStatus() {
        petServiceHelper.getSpecificPetStatus();
    }

    @Test
    public void createNewPet() {
        String newPet = petServiceHelper.createNewPet();
        System.out.println(newPet);
        Assert.assertNotNull(newPet);
        JsonObject jsonObjectobj = new Gson().fromJson(newPet, JsonObject.class);
        JsonElement element = jsonObjectobj.getAsJsonObject("category");
        System.out.println(element);

        JsonElement element1 = jsonObjectobj.getAsJsonObject().get("id");
        System.out.println(element1);

        JsonElement name = jsonObjectobj.getAsJsonArray("photoUrls");
        System.out.println(name.getAsString());

        JsonArray name1 = jsonObjectobj.getAsJsonArray("tags");
        System.out.println(name1.get(0).getAsJsonObject().get("id"));
        Assert.assertEquals(name1.get(0).getAsJsonObject().get("id").toString().trim(),"0");



    }
}
