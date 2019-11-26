package cz.cuni.mff.checkstyle.tests;

import cz.cuni.mff.checkstyle.utils.ContentReader;
import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.util.Objects;

public class CheckHeader implements TestFiles {

    private final String content;

    public CheckHeader(String content) {
        this.content = content;
    }

    @Override
    public void performTest(TestRequirements testRequirements) {
        File pattern = ContentReader.findFile(testRequirements.getPath(), content, FilenameUtils.getExtension(content));
        for (File testFile : testRequirements.getJavaFiles()) {
            if (!ContentReader.compareHeaders(pattern, testFile)) {
                System.err.println(String.format("%s: Wrong header", ContentReader.getRelativePath(testRequirements.getPath(), testFile)));
            }
        }
    }

    public String getContent() {
        return content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CheckHeader that = (CheckHeader) o;
        return Objects.equals(content, that.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(content);
    }
}