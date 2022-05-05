package com.epam.lab.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


public class PropertiesReader {
    private static final Logger logger = LogManager.getLogger(PropertiesReader.class);
    Properties property = new Properties();

    public PropertiesReader() {
        BasicConfigurator.configure();
        FileInputStream fis;
        try {
            fis = new FileInputStream("src/main/resources/config.properties");
            property.load(fis);
            fis.close();
        } catch (IOException e) {
            logger.info("Properties file is not exist!");
            System.err.println("ERROR: Properties file is not exist!");
        }
    }

    public String getUrl() {
        String URL = property.getProperty("URL");
        return URL;
    }

    public String getDriverName() {
        String driverName = property.getProperty("CHROME_DRIVER_NAME");
        return driverName;
    }

    public String getDriverLocation(){
        String driverLocation = property.getProperty("CHROME_DRIVER_LOCATION");
        return driverLocation;
    }
}
