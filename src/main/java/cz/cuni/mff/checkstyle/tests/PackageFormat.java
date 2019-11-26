package cz.cuni.mff.checkstyle.tests;

import cz.cuni.mff.checkstyle.utils.ContentReader;

import java.io.File;
import java.util.List;
import java.util.Objects;

public class PackageFormat implements TestFiles {

    private final String regex;
    private final String startLine;

    public PackageFormat(String regex, String startLine) {
        this.regex = regex;
        this.startLine = startLine;
    }

    @Override
    public void performTest(TestRequirements testRequirements) {
        for (File testFile : testRequirements.getJavaFiles()) {
            List<String> fileContent = ContentReader.getFileContent(testFile);
            for (String line : fileContent) {
                if (line.startsWith(startLine) && !line.matches(regex)) {
                    System.err.println(String.format("%s: wrong package format", ContentReader.getRelativePath(testRequirements.getPath(), testFile)));
                    break;
                }
            }
        }
    }

    public String getRegex() {
        return regex;
    }

    public String getStartLine() {
        return startLine;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PackageFormat that = (PackageFormat) o;
        return Objects.equals(regex, that.regex) &&
                Objects.equals(startLine, that.startLine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(regex, startLine);
    }
}
