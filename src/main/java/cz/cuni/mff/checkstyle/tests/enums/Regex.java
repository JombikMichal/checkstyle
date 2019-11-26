package cz.cuni.mff.checkstyle.tests.enums;

public enum Regex {
    PACKAGE_FORMAT;

    @Override
    public String toString() {
        switch (this) {
            case PACKAGE_FORMAT:
                return "^[a-z]+(\\.[a-zA-Z_][a-zA-Z0-9_]*)*$";
            default:
                throw new IllegalArgumentException("Unsupported format");
        }
    }
}