package com.modmed.clinical.apis.utils;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class RequestUtils {
    private static RequestUtils instance;
    private static ConfigManager configManager = ConfigManager.getInstance();;

    private RequestUtils() {
    }

    private static RequestUtils instance() {
        if (instance == null) {
            instance = new RequestUtils();
        }
        return instance;
    }

    public static String getAuthorizationHeaderValue() {
        return "Basic "+Base64.getEncoder().encodeToString(configManager.getString("username").concat(":").concat(configManager.getString("password")).getBytes());
    }
}
