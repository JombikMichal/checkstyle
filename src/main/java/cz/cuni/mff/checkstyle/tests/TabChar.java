package cz.cuni.mff.checkstyle.tests;

import cz.cuni.mff.checkstyle.utils.ContentReader;

import java.io.File;
import java.util.List;
import java.util.Objects;

public class TabChar implements TestFiles {

    private final char testChar;


    public TabChar(char testChar) {
        this.testChar = testChar;
    }

    @Override
    public void performTest(TestRequirements testRequirements) {
        for (File testFile : testRequirements.getJavaFiles()) {
            List<String> fileContent = ContentReader.getFileContent(testFile);
            for (int i = 0; i < fileContent.size(); i++) {
                if (fileContent.get(i).contains(String.valueOf(testChar))) {
                    char[] chars = fileContent.get(i).toCharArray();
                    for (int j = 0; j < chars.length; j++) {
                        if (chars[j] == testChar) {
                            System.err.println(String.format("%s: contains tab char at %d:%d", ContentReader.getRelativePath(testRequirements.getPath(), testFile), i + 1, j));
                        }
                    }
                }
            }
        }
    }

    public char getTestChar() {
        return testChar;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TabChar tabChar = (TabChar) o;
        return testChar == tabChar.testChar;
    }

    @Override
    public int hashCode() {
        return Objects.hash(testChar);
    }
}