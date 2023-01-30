package com.modmed.clinical.apis.helpers;

import com.fasterxml.jackson.databind.ser.Serializers;
import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.RequestOptions;
import com.modmed.clinical.apis.utils.ConfigManager;


abstract public class BaseService {
    public static Playwright playwright;
    public static APIRequestContext apiRequestContext;
    private static final String Base_URL = ConfigManager.getInstance().getString("baseUrl");

    public BaseService(){
        playwright = Playwright.create();
        this.apiRequestContext = playwright.request().newContext(new APIRequest.NewContextOptions().setBaseURL(this.Base_URL));
    }

    protected APIResponse get(String endpoints, RequestOptions params){
        return apiRequestContext.get(endpoints, params);
    }

    protected APIResponse post(String endpoints, RequestOptions params){
        return apiRequestContext.post(endpoints, params);
    }

}
