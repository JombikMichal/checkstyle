package cz.cuni.mff.checkstyle.tests;

import java.util.List;

public class PackageFormat implements Checker {

    private final String regex;
    private final String startLine;

    public PackageFormat(String regex, String startLine) {
        this.regex = regex;
        this.startLine = startLine;
    }

    @Override
    public void performCheck(List<String> lines, String relativePath) {
        for (String line : lines){
            if(line.startsWith(startLine) && !line.matches(regex)){
                System.err.println(String.format("%s: wrong package format", relativePath));
                break;
            }
        }
    }
}