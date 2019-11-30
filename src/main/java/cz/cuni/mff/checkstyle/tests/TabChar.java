package cz.cuni.mff.checkstyle.tests;

import java.util.List;


public class TabChar implements Checker {

    private final char testChar;

    public TabChar(char testChar) {
        this.testChar = testChar;
    }

    @Override
    public void performCheck(List<String> lines,String relativePath) {
            for (int i = 0; i < lines.size(); i++) {
                if (lines.get(i).contains(String.valueOf(testChar))) {
                    char[] chars = lines.get(i).toCharArray();
                    for (int j = 0; j < chars.length; j++) {
                        if (chars[j] == testChar) {
                            System.err.println(String.format("%s: contains tab char at %d:%d", relativePath,i + 1, j));
                        }
                    }
                }
            }

    }
}