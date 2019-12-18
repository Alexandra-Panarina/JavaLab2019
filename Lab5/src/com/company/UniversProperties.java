package com.company;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class UniversProperties {
    public static Map<String, String> props = new HashMap<>();

    Properties prop = new Properties();

    public static void readPropertiesFile(String fileName) throws IOException {
        FileInputStream fis = null;
        Properties prop = null;
        try {
            fis = new FileInputStream(fileName);
            prop = new Properties();
            prop.load(fis);
        } catch(IOException fnfe) {
            fnfe.printStackTrace();
        } finally {
            fis.close();
        }

        Enumeration e = prop.propertyNames();

        while (e.hasMoreElements()) {
            String elem = (String) e.nextElement();
            String value = prop.getProperty(elem);
            props.put(elem, value);
        }
    }

}
