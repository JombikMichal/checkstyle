package cz.cuni.mff.checkstyle.tests;

import cz.cuni.mff.checkstyle.utils.ConfigReader;
import cz.cuni.mff.checkstyle.utils.ContentReader;

import java.io.File;
import java.util.List;

public class TabChar implements TestFiles {
    @Override
    public void performTest(TestRequirements testRequirements, ConfigReader checks) {
        for (File testFile : testRequirements.getJavaFiles()) {
            List<String> fileContent = ContentReader.getFileContent(testFile);
            String relative = new File(testRequirements.getPath()).toURI().relativize(new File(testFile.toURI()).toURI()).getPath();
            for (int i = 0; i < fileContent.size(); i++) {
                if (fileContent.get(i).contains("\t")) {
                    char[] o = fileContent.get(i).toCharArray();
                    for (int j = 0; j < o.length; j++) {
                        if (o[j] == '\t') {
                            System.out.println(String.format("%s: contains tab char at %d:%d", relative, i + 1, j));
                            System.err.println(String.format("%s: contains tab char at %d:%d", relative, i + 1, j));
                        }
                    }
                }
            }
        }
    }
}
