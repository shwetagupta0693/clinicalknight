package com.modmed.clinical.apis.helpers;

import com.microsoft.playwright.options.RequestOptions;
import com.modmed.clinical.apis.constants.EndPoints;
import com.modmed.clinical.apis.utils.ConfigManager;

import java.util.HashMap;
import java.util.Map;

public class PetServiceHelper extends BaseService {

    //We need to read the config variables
    //Make a Get Request and send data to Test

    public PetServiceHelper() {
        super();
    }

    public String getSpecificPet(String id) {
        return super.get("/v2/pet/"+id, RequestOptions.create().setHeader("Content-Type", "application/json")).text();

    }

    public void getSpecificPetStatus() {
        String response = super.get("/v2/pet/findByStatus?", RequestOptions.create().setHeader("Content-Type", "application/json").setQueryParam("status","available")).text();
        System.out.print(response);
    }

    public String createNewPet() {
        String json = "{" +
                "  \"id\": 3," +
                "  \"category\": {" +
                "    \"id\": 0," +
                "    \"name\": \"string\"" +
                "  },\n" +
                "  \"name\": \"doggie123\"," +
                "  \"photoUrls\": [" +
                "    \"string\"" +
                "  ]," +
                "  \"tags\": [" +
                "    {" +
                "      \"id\": 0," +
                "      \"name\": \"string\"" +
                "    }" +
                "  ]," +
                "  \"status\": \"available\"" +
                "}";
        return super.post(EndPoints.Add_New_Pet, RequestOptions.create().setHeader("Content-Type", "application/json").setData(json)).text();
    }

}


