package cz.cuni.mff.checkstyle.tests;

import cz.cuni.mff.checkstyle.utils.ContentReader;
import cz.cuni.mff.checkstyle.utils.FilesSuffix;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class TestRequirements {
    private String path;
    private List<File> javaFiles = new ArrayList<>();
    private String property;

    public TestRequirements(String path, String property) {
        this.path = path;
        this.property = property;
        init();
    }

    private void init() {
        javaFiles.addAll(ContentReader.getList(path, FilesSuffix.JAVA.toString()));
    }

    public String getPath() {
        return path;
    }

    public List<File> getJavaFiles() {
        return javaFiles;
    }

    public String getProperty() {
        return property;
    }
}
