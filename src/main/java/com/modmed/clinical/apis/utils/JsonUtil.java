package com.modmed.clinical.apis.utils;

import org.apache.juneau.json.JsonParser;
import org.apache.juneau.parser.ParseException;

import java.io.IOException;
import java.util.List;

public class JsonUtil {
    JsonParser jsonParser;
    private static JsonUtil instance;

    private JsonUtil() {
        jsonParser = JsonParser.DEFAULT;
    }

    private static JsonUtil instance() {
        if (instance == null) {
            instance = new JsonUtil();
        }
        return instance;
    }

    public static <T> T getJsonObject(Class<T> type, String jsonValue) throws ParseException {
        return instance().jsonParser.parse(jsonValue, type);
    }

    public static <T> T getJsonList(Class<T> type, List<String> jsonValue) throws ParseException, IOException {
        return instance().jsonParser.parse(jsonValue, type);
    }
}
