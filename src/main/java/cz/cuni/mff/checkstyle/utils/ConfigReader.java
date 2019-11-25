package cz.cuni.mff.checkstyle.utils;

import java.io.*;
import java.util.Properties;
import java.util.Set;

public class ConfigReader {
    private Properties prop = null;
    private File file;

    public ConfigReader(File file) {
        this.file = file;
        InputStream is = null;
        try {
            this.prop = new Properties();
            is = new FileInputStream(file);
            prop.load(is);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Set<Object> getAllKeys() {
        Set<Object> keys = prop.keySet();
        return keys;
    }

    public String getPropertyValue(String key) {
        return this.prop.getProperty(key);
    }
}

