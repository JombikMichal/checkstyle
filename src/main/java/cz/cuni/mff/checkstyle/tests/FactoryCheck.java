package cz.cuni.mff.checkstyle.tests;

import cz.cuni.mff.checkstyle.tests.enums.Characters;
import cz.cuni.mff.checkstyle.tests.enums.Regex;
import cz.cuni.mff.checkstyle.tests.enums.StartsLineWith;

import java.io.File;
import java.util.Optional;

public class FactoryCheck {

    private String base;

    public FactoryCheck(String base) {
        this.base = base;
    }

    public  Checker getCheck(String key, Optional<String> value) {
        switch (key) {
            case "CheckHeader":
                return new CheckHeader(base + File.separator + value.get());
            case "LineLength":
                return new LineLength(Integer.parseInt(value.get()));
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
