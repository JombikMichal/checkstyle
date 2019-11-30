package cz.cuni.mff.checkstyle.tests;

import java.util.List;

public interface Checker {
    void performCheck(List<String> lines,String relativePath);
}
