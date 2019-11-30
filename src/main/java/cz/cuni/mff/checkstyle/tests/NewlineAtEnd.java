package cz.cuni.mff.checkstyle.tests;

import java.util.List;

public class NewlineAtEnd implements Checker {
    @Override
    public void performCheck(List<String> lines,String relativePath) {
        if (!lines.get(lines.size() - 1).isEmpty()) {
                System.err.println(String.format("%s: does not contain newline at the end of file", relativePath));
            }
    }

}