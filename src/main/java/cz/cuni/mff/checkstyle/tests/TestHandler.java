package cz.cuni.mff.checkstyle.tests;

public class TestHandler {

    public static TestFiles getSuitableTestFile(String test){
        switch (test){
            case "CheckHeader":
                return new CheckHeader();
            case "LineLength":
                return new LineLength();
            case "NewlineAtEnd":
                return new NewlineAtEnd();
            case "PackageFormat":
                return new PackageFormat();
            case "TabChar":
                return new TabChar();
            default:
                throw new IllegalArgumentException("Unsupported test!");
        }
    }
}
