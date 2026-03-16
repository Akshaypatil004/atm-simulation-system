package com.atm.config;

import java.io.InputStream;
import java.util.Properties;

public final class PropertiesLoader {

    private static Properties properties = new Properties();

    static {
        try {
            InputStream input = PropertiesLoader.class
                    .getClassLoader()
                    .getResourceAsStream("application.properties");

            if (input != null) {
                properties.load(input);
            } else {
                System.out.println("application.properties file not found.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getDriver() {
        return properties.getProperty("db.driver");
    }

    public static String getUrl() {
        String env = System.getenv("DB_URL");
        if (env != null && !env.isEmpty()) {
            return env;
        }
        return properties.getProperty("db.url");
    }

    public static String getUsername() {
        String env = System.getenv("DB_USER");
        if (env != null && !env.isEmpty()) {
            return env;
        }
        return properties.getProperty("db.username");
    }

    public static String getPassword() {
        String env = System.getenv("DB_PASSWORD");
        if (env != null && !env.isEmpty()) {
            return env;
        }
        return properties.getProperty("db.password");
    }

    public static String getMaxPoolSize() {
        return properties.getProperty("db.pool.maxSize");
    }

    public static String getMinPoolSize() {
        return properties.getProperty("db.pool.minIdle");
    }

    public static String getConnectionTimeout() {
        return properties.getProperty("db.pool.timeout");
    }
}