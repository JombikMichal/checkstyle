package cz.cuni.mff.checkstyle.tests;

import cz.cuni.mff.checkstyle.utils.ConfigReader;
import cz.cuni.mff.checkstyle.utils.ContentReader;
import org.apache.commons.io.FilenameUtils;

import java.io.File;

public class CheckHeader implements TestFiles {
    @Override
    public void performTest(TestRequirements testRequirements, ConfigReader checks) {
        String content = checks.getPropertyValue(testRequirements.getProperty());
        File pattern = ContentReader.findFile(testRequirements.getPath(), content, FilenameUtils.getExtension(content));
        for (File testFile : testRequirements.getJavaFiles()) {
            if (!ContentReader.compareHeaders(pattern, testFile)) {
                String relative = new File(testRequirements.getPath()).toURI().relativize(new File(testFile.toURI()).toURI()).getPath();
                System.out.println(String.format("%s: Wrong header", relative));
                System.err.println(String.format("%s: Wrong header", relative));
            }
        }
    }
}
