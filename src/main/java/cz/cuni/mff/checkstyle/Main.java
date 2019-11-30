package cz.cuni.mff.checkstyle;

import cz.cuni.mff.checkstyle.tests.Checker;
import cz.cuni.mff.checkstyle.tests.FactoryCheck;
import cz.cuni.mff.checkstyle.utils.ConfigReader;
import cz.cuni.mff.checkstyle.utils.ContentReader;
import cz.cuni.mff.checkstyle.utils.enums.FilesSuffix;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;


public  final class Main {

    public static void main(final String[] args) {
        try {
            List<File> javaFiles = ContentReader.findFile(args[0],FilesSuffix.JAVA.toString());
            List<Checker> checks = ConfigReader.getConfig(args[0]);
            for (File file : javaFiles){
                String relativePath = ContentReader.getRelativePath(args[0],file);
                List<String> lines = Files.readAllLines(file.toPath());
                   for(Checker check : checks){
                       check.performCheck(lines,relativePath);
                   }
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}