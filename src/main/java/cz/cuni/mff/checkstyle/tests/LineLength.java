package cz.cuni.mff.checkstyle.tests;

import cz.cuni.mff.checkstyle.utils.ContentReader;

import java.io.File;
import java.util.List;
import java.util.Objects;

public class LineLength implements TestFiles {

    private final int lineLength;

    public LineLength(int lineLength) {
        this.lineLength = lineLength;
    }

    @Override
    public void performTest(TestRequirements testRequirements) {
        for (File testFile : testRequirements.getJavaFiles()) {
            List<String> fileContent = ContentReader.getFileContent(testFile);
            for (int i = 0; i < fileContent.size(); i++) {
                if (fileContent.get(i).length() > lineLength) {
                    System.err.println(String.format("%s: %d LineLength exceeded: actual length %d, maximum %d", ContentReader.getRelativePath(testRequirements.getPath(), testFile), i + 1, fileContent.get(i).length(), lineLength));
                }
            }
        }
    }

    public int getLineLength() {
        return lineLength;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LineLength that = (LineLength) o;
        return lineLength == that.lineLength;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lineLength);
    }
}
