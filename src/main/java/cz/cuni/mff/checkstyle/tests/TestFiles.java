package cz.cuni.mff.checkstyle.tests;

import cz.cuni.mff.checkstyle.utils.ConfigReader;

public interface TestFiles {
    void performTest(TestRequirements testRequirements, ConfigReader checks);
}
