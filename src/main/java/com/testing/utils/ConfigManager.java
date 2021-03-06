package com.testing.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigManager {

    private static Properties prop = new Properties();
    private static ConfigManager manager;

    private ConfigManager() throws IOException {
        InputStream stream = ConfigManager.class.getResourceAsStream("../resources/config.properties");
        prop.load(stream);

    }


    public static ConfigManager getInstance() {
        if (manager == null) {
            synchronized (ConfigManager.class) {
                try {
                    manager = new ConfigManager();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return manager;
    }

    public String getString(String key) {
        return System.getProperty(key, prop.getProperty(key));
    }
}
