package cz.cuni.mff.checkstyle.tests;

import cz.cuni.mff.checkstyle.tests.enums.Characters;
import cz.cuni.mff.checkstyle.tests.enums.Regex;
import cz.cuni.mff.checkstyle.tests.enums.StartsLineWith;

public class TestHandler {

    public static TestFiles getSuitableTestFile(String type, String property) {
        switch (type) {
            case "CheckHeader":
                return new CheckHeader(property);
            case "LineLength":
                return new LineLength(Integer.parseInt(property));
            case "NewlineAtEnd":
                return new NewlineAtEnd();
            case "PackageFormat":
                return new PackageFormat(Regex.PACKAGE_FORMAT.toString(), StartsLineWith.PACKAGE.toString());
            case "TabChar":
                return new TabChar(Characters.TAB.getChar());
            default:
                throw new IllegalArgumentException("Unsupported test!");
        }
    }
}
