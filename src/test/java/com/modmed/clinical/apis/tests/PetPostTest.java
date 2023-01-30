package com.modmed.clinical.apis.tests;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.modmed.clinical.apis.helpers.PetServiceHelper;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PetPostTest {
    PetServiceHelper petServiceHelper = new PetServiceHelper();

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


