package com.persistance.utilities;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AuthStartupUtility {

    private static final Properties properties = new Properties();

    static {
        try (InputStream input = AuthStartupUtility.class.getClassLoader()
                .getResourceAsStream("startupUtility.properties")) {

            if (input == null) {
                System.err.println("Could not load 'startupUtility.properties' from classpath.");
            } else {
                properties.load(input);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
