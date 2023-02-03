package com.modmed.clinical.apis.tests;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.RequestOptions;
import com.modmed.clinical.apis.helpers.PetServiceHelper;
import com.modmed.clinical.apis.helpers.TaskService;
import com.modmed.clinical.apis.utils.JsonUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class TaskTest extends BaseTest{
    public static  Playwright playwright;
    public static APIRequestContext apiRequestContext;

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
    public void getRequest() {
        Map<String, String> header = new HashMap<>();
        header.put("Content-Type","application/json");
        header.put("Accept","application/json");
        playwright = Playwright.create();
        apiRequestContext = playwright.request().newContext(new APIRequest.NewContextOptions()
                .setBaseURL("https://derm.m2perf.com/ema/ws/")
                .setExtraHTTPHeaders(header));
        APIResponse response = apiRequestContext.get("v3/tasks/assignable", RequestOptions.create().setHeader("Authorization","Basic amRvZTpDaGFuZ2VtZTE="));
        System.out.println(response.status());
        System.out.println(response.text());
        System.out.println(response.statusText());
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
    public void verifyTaskAssignableGetRequest() {
        System.out.println(taskService.getAssignableTasksData().status());
        Assert.assertTrue(taskService.getAssignableTasksData().ok());
    }
}
