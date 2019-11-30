package cz.cuni.mff.checkstyle.utils;

import cz.cuni.mff.checkstyle.tests.Checker;
import cz.cuni.mff.checkstyle.tests.FactoryCheck;

import java.io.*;
import java.nio.file.Files;
import java.util.*;

public class ConfigReader {

    private static final String CONFIG_FILE = "checkstyle.config";

    // TODO: remake this function with lambdas

    public static List<Checker> getConfig(String base) throws IOException {
        List<String> lines = Files.readAllLines(new File(base, CONFIG_FILE).toPath());
        List<Checker> checks = new ArrayList<>();
        FactoryCheck factoryCheck = new FactoryCheck(base);
        lines.forEach((l) -> {
            String[] parts = l.split("=");
            if (parts.length == 1) {
                checks.add(factoryCheck.getCheck(parts[0], Optional.empty()));
            } else if (parts.length == 2) {
                checks.add(factoryCheck.getCheck(parts[0], Optional.of(parts[1])));
            }
        });
        return checks;
    }

    // using simple for loop to find checks
    public static List<Checker> getConfig2(String base) throws IOException {
        getConfig2(base);
        List<Checker> checks = new ArrayList<>();
        List<String> lines = Files.readAllLines(new File(base, CONFIG_FILE).toPath());
        FactoryCheck factoryCheck = new FactoryCheck(base);
        for (String line : lines) {
            String[] parts = line.split("=");
            if (parts.length == 1) {
                checks.add(factoryCheck.getCheck(parts[0], Optional.empty()));
            } else if (parts.length == 2) {
                checks.add(factoryCheck.getCheck(parts[0], Optional.of(parts[1])));
            }
        }
        return checks;
    }

}
