package cz.cuni.mff.checkstyle.tests;

import cz.cuni.mff.checkstyle.utils.ConfigReader;
import cz.cuni.mff.checkstyle.utils.ContentReader;

import java.io.File;
import java.util.List;

public class NewlineAtEnd implements TestFiles {
    @Override
    public void performTest(TestRequirements testRequirements, ConfigReader checks) {
        for (File testFile : testRequirements.getJavaFiles()) {
            List<String> fileContent = ContentReader.getFileContent(testFile);
            if (!fileContent.get(fileContent.size() - 1).isEmpty()) {
                String relative = new File(testRequirements.getPath()).toURI().relativize(new File(testFile.toURI()).toURI()).getPath();
                System.out.println(String.format("%s: does not contain newline at the end of file", relative));
                System.err.println(String.format("%s: does not contain newline at the end of file", relative));
            }
        }
    }
}
