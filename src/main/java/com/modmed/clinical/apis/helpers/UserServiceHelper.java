package com.modmed.clinical.apis.helpers;

import com.modmed.clinical.apis.utils.ConfigManager;

public class UserServiceHelper {

    //We need to read the config variables
    //Make a Get Request and send data to Test

    private static final String Base_URL = ConfigManager.getInstance().getString("baseUrl");

    public static void main(String args[]) {
        System.out.print(Base_URL);
    }
}


