package com.modmed.clinical.apis.tests;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.microsoft.playwright.APIResponse;
import com.modmed.clinical.apis.helpers.PetServiceHelper;
import com.modmed.clinical.apis.model.Pet;
import com.modmed.clinical.apis.utils.JsonUtil;
import org.apache.juneau.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PetPostTest {
    PetServiceHelper petServiceHelper = new PetServiceHelper();

    @Test
    public void verifyCreationOfNewPet() throws ParseException {
        String newPetText = petServiceHelper.createNewPet().text();
        Assert.assertNotNull(newPetText);
        Pet pet = JsonUtil.getJsonObject(Pet.class, newPetText);
        Assert.assertEquals(pet.getName(),"doggie321");
    }
}


