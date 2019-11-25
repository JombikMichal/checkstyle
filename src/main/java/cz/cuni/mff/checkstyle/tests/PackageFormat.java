package cz.cuni.mff.checkstyle.tests;

import cz.cuni.mff.checkstyle.utils.ConfigReader;
import cz.cuni.mff.checkstyle.utils.ContentReader;

import java.io.File;
import java.util.List;

public class PackageFormat implements TestFiles {
    @Override
    public void performTest(TestRequirements testRequirements, ConfigReader checks) {
        for (File testFile : testRequirements.getJavaFiles()) {
        List<String> fileContent = ContentReader.getFileContent(testFile);
        String relative = new File(testRequirements.getPath()).toURI().relativize(new File(testFile.toURI()).toURI()).getPath();
        for (String line : fileContent) {
            if (line.startsWith("package") && !line.matches("^[a-z]+(\\.[a-zA-Z_][a-zA-Z0-9_]*)*$")) {
                System.out.println(String.format("%s: wrong package format", relative));
                System.err.println(String.format("%s: wrong package format", relative));
                break;
            }
        }
    }
    }
}
