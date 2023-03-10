package com.modmed.clinical.apis.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigManager {

    private static ConfigManager manager;
    private final static Properties prop = new Properties();


    private ConfigManager() throws IOException {
        InputStream stream = ConfigManager.class.getResourceAsStream("/config.properties");
        prop.load(stream);
    }

    public static ConfigManager getInstance(){
        if (manager == null) {
            synchronized (ConfigManager.class){
                try {
                    manager = new ConfigManager();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return manager;
    }

    public static String getString(String key){
        return System.getProperty(key,prop.getProperty(key));
    }
}
