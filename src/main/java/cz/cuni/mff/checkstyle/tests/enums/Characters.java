package cz.cuni.mff.checkstyle.tests.enums;

public enum Characters {
    TAB;

    public char getChar() {
        switch (this) {
            case TAB:
                return '\t';
            default:
                throw new IllegalArgumentException("Unsupported char");
        }
    }
}