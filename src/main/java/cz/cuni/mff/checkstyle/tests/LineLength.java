package cz.cuni.mff.checkstyle.tests;

import cz.cuni.mff.checkstyle.utils.ConfigReader;
import cz.cuni.mff.checkstyle.utils.ContentReader;

import java.io.File;
import java.util.List;

public class LineLength implements TestFiles {
    @Override
    public void performTest(TestRequirements testRequirements, ConfigReader checks) {
        int lineLength = Integer.parseInt(checks.getPropertyValue(testRequirements.getProperty().toString()));
        for (File testFile : testRequirements.getJavaFiles()) {
            List<String> fileContent = ContentReader.getFileContent(testFile);
            for (int i = 0; i < fileContent.size(); i++) {
                if (fileContent.get(i).length() > lineLength) {
                    String relative = new File(testRequirements.getPath()).toURI().relativize(new File(testFile.toURI()).toURI()).getPath();
                    System.out.println(String.format("%s: %d LineLength exceeded: actual length %d, maximum %d", relative, i + 1, fileContent.get(i).length(), lineLength));
                    System.err.println(String.format("%s: %d LineLength exceeded: actual length %d, maximum %d", relative, i + 1, fileContent.get(i).length(), lineLength));
                }
            }
        }
    }
}
