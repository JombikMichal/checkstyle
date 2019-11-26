package cz.cuni.mff.checkstyle.tests.enums;

public enum StartsLineWith {
    PACKAGE;

    @Override
    public String toString() {
        switch (this) {
            case PACKAGE:
                return "package";
            default:
                throw new IllegalArgumentException("Unsupported start line");
        }
    }
}