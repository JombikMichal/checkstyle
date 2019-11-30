package cz.cuni.mff.checkstyle.tests;

import java.util.List;

public class LineLength implements Checker {

    private final int lineLength;

    public LineLength(int lineLength) {
        this.lineLength = lineLength;
    }

    @Override
    public void performCheck(List<String> lines,String relativePath) {
        for (int i = 0; i < lines.size(); i++) {
                if (lines.get(i).length() > lineLength) {
                    System.err.println(String.format("%s: %d LineLength exceeded: actual length %d, maximum %d", relativePath,i + 1, lines.get(i).length(), lineLength));
                }
            }
    }
}
