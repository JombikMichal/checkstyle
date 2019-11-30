package cz.cuni.mff.checkstyle;

import cz.cuni.mff.checkstyle.tests.Checker;
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
            // args[0] means absolute path to particular directory
            // get list of all files with .java suffix in current repository
            List<File> javaFiles = ContentReader.findFiles(args[0],FilesSuffix.JAVA.toString());
            // get all available checks from config file
            List<Checker> checks = ConfigReader.getConfig(args[0]);
            // browse all java files and perform particular check on it via config
            for (File file : javaFiles){
                // relative path must be set as parameter
                String relativePath = ContentReader.getRelativePath(args[0],file);
                // first and the most important parameter is content of file as list of strings
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