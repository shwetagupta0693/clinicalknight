package com.modmed.clinical.apis.tests;

import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.Playwright;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class PatientGetTest {
    public static  Playwright playwright;
    public static APIRequestContext apiRequestContext;

    @Test
    public void setup() {
        Map<String, String> header = new HashMap<>();
        header.put("Content-Type","application/json");
        playwright = Playwright.create();
        apiRequestContext = playwright.request().newContext(new APIRequest.NewContextOptions()
                .setBaseURL("http://localhost:3000")
                .setExtraHTTPHeaders(header));
        Map<String, String> headers = new HashMap<>();
        header.put("Content-Type","application/json");
        playwright = Playwright.create();
        apiRequestContext = playwright.request().newContext(new APIRequest.NewContextOptions()
                .setBaseURL("http://localhost:3000")
                .setExtraHTTPHeaders(headers));
        int reponsecode = apiRequestContext.get("/comments").status();
        System.out.print(reponsecode);
    }
}
