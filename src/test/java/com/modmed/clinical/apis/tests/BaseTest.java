package com.modmed.clinical.apis.tests;

import com.modmed.clinical.apis.helpers.PetServiceHelper;
import com.modmed.clinical.apis.helpers.TaskService;

abstract public class BaseTest {
    PetServiceHelper petServiceHelper = new PetServiceHelper();
    TaskService taskService = new TaskService();

    public BaseTest(){

    }
}
