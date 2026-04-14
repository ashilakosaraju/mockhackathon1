package com.autoqa.utils;

import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    private Properties prop;

    public Properties init_prop() {
        prop = new Properties();
        try {
            InputStream ip = getClass().getClassLoader().getResourceAsStream("config.properties");
            if (ip != null) {
                prop.load(ip);
                System.out.println("LOG: config.properties loaded successfully.");
            } else {
                System.out.println("ERROR: config.properties file not found in resources!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return prop;
    }
}