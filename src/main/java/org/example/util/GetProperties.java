package org.example.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
public class GetProperties {
    private static String url;
    private static String username;
    private static String pwd;
    public GetProperties() {
        Properties prop = new Properties();
        InputStream input = null;

        try {
            // Load the config.properties file
            input = GetProperties.class.getClassLoader().getResourceAsStream("config.properties");
            prop.load(input);

            // Access the properties
            this.url = prop.getProperty("db.url");
            this.username = prop.getProperty("db.username");
            this.pwd = prop.getProperty("db.password");

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public String getUrl() {
        return url;
    }

    public String getUsername() {
        return username;
    }

    public String getPwd() {
        return pwd;
    }
}
