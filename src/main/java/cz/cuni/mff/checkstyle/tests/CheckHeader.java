package cz.cuni.mff.checkstyle.tests;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class CheckHeader implements Checker {

    private List<String> header;

    public CheckHeader(String value) {
        try {
            header = Files.readAllLines(Paths.get(value));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void performCheck(List<String> lines, String relativePath) {
        for (int i = 0; i < header.size(); i++) {
            if (!header.get(i).equals(lines.get(i))) {
                System.err.println(String.format("%s: Wrong header", relativePath));
            }
        }
    }

}