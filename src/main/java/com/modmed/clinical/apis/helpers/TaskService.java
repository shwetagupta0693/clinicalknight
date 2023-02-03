package com.modmed.clinical.apis.helpers;

import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.options.RequestOptions;
import com.modmed.clinical.apis.constants.EndPoints;
import com.modmed.clinical.apis.utils.RequestUtils;
import org.apache.log.format.SyslogFormatter;


public class TaskService extends BaseService {

    public TaskService() {

    }
    public APIResponse getAssignableTasksData() {
        return super.get(EndPoints.Task_Assignable,
                RequestOptions.create().setHeader("Content-Type", "application/json").setHeader("Authorization",RequestUtils.getAuthorizationHeaderValue()));
    }
}
