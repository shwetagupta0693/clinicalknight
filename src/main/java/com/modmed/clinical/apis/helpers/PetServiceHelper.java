package com.modmed.clinical.apis.helpers;

import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.options.RequestOptions;
import com.modmed.clinical.apis.constants.EndPoints;
import com.modmed.clinical.apis.model.Category;
import com.modmed.clinical.apis.model.Pet;
import com.modmed.clinical.apis.model.Tag;
import com.modmed.clinical.apis.utils.ConfigManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PetServiceHelper extends BaseService {
    Pet pet;
    Category category;
    Tag tag;
    List<Tag> tags = new ArrayList<>();

    //We need to read the config variables
    //Make a Get Request and send data to Test

    public PetServiceHelper() {
        super();
        this.pet = new Pet();
        this.category = new Category();
        this.tag = new Tag();
    }

    public String getSpecificPet(String id) {
        return super.get("/v2/pet/"+id, RequestOptions.create().setHeader("Content-Type", "application/json")).text();

    }

    public void getSpecificPetStatus() {
        String response = super.get("/v2/pet/findByStatus?", RequestOptions.create().setHeader("Content-Type", "application/json").setQueryParam("status","available")).text();
        System.out.print(response);
    }

    public APIResponse createNewPet() {
        pet.setId(4);
        pet.setName("doggie321");
        pet.setStatus("available");
        category.setName("Dog");
        category.setId(100);
        pet.setCategory(category);
        tag.setId(1000);
        tag.setName("tag1");
        tags.add(tag);
        pet.setTags(tags);

        System.out.println(pet.toString());
        return super.post(EndPoints.Add_New_Pet, RequestOptions.create().setHeader("Content-Type", "application/json").setData(pet));
    }

}


