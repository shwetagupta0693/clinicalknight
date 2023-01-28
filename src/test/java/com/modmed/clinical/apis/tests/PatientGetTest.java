package com.modmed.clinical.apis.tests;

import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.Playwright;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class PatientGetTest {
    public static  Playwright playwright;
    public static APIRequestContext apiRequestContext;
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

    @BeforeClass
    public void setup(){
        Map<String, String> header = new HashMap<>();
        header.put("Content-Type","application/json");
        playwright = Playwright.create();
        apiRequestContext = playwright.request().newContext(new APIRequest.NewContextOptions()
                .setBaseURL("https://petstore.swagger.io")
                .setExtraHTTPHeaders(header));
    }

    @Test
    public void getRequest() {
        int reponsecode = apiRequestContext.get("/comments").status();
        System.out.print(reponsecode);
    }

    @Test
    public void postRequest() {
        Map<String, String> header = new HashMap<>();
        header.put("Content-Type","application/json");
        playwright = Playwright.create();
        apiRequestContext = playwright.request().newContext(new APIRequest.NewContextOptions()
                .setBaseURL("http://localhost:3000")
                .setExtraHTTPHeaders(header));
    }
}
