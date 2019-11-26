package cz.cuni.mff.checkstyle.tests;

import cz.cuni.mff.checkstyle.utils.ContentReader;
import cz.cuni.mff.checkstyle.utils.enums.FilesSuffix;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class TestRequirements {
    private String path;
    private List<File> javaFiles = new ArrayList<>();

    public TestRequirements(String path) {
        this.path = path;
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
}
