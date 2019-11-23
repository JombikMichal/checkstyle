package cz.cuni.mff.checkstyle.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    public static String getProperties(File file, String propertyName) throws IOException {
        Properties prop = new Properties();
        InputStream is = new FileInputStream(file);
        prop.load(is);
        return prop.getProperty(propertyName);
    }
}
