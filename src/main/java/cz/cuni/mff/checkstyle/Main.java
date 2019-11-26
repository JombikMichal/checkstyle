package cz.cuni.mff.checkstyle;

import cz.cuni.mff.checkstyle.tests.TestHandler;
import cz.cuni.mff.checkstyle.tests.TestRequirements;
import cz.cuni.mff.checkstyle.utils.ConfigReader;
import cz.cuni.mff.checkstyle.utils.ContentReader;
import cz.cuni.mff.checkstyle.utils.enums.FilesSuffix;

import java.util.Set;

public final class Main {

    public static void main(final String[] args) {
        ConfigReader checks = new ConfigReader(ContentReader.getList(args[0], FilesSuffix.CONFIG.toString()).get(0));
        Set<Object> keys = checks.getAllKeys();
        if (!(keys.isEmpty() && args[0].isEmpty())) {
            for (Object property : keys) {
                TestHandler.getSuitableTestFile(property.toString(), checks.getPropertyValue(property.toString())).performTest(new TestRequirements(args[0]));
            }
        }
    }
}