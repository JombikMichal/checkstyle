package cz.cuni.mff.checkstyle.utils.enums;

public enum FilesSuffix {
    JAVA, CONFIG;

    @Override
    public String toString() {
        switch (this) {
            case JAVA:
                return "java";
            case CONFIG:
                return "config";
            default:
                throw new IllegalArgumentException("Unsupported file format");
        }
    }
}