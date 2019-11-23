package cz.cuni.mff.checkstyle;

import cz.cuni.mff.checkstyle.utils.ConfigReader;
import cz.cuni.mff.checkstyle.utils.ContentReader;
import cz.cuni.mff.checkstyle.utils.FilesSufix;
import cz.cuni.mff.checkstyle.wrongHeaderProject.MyFile;
import cz.cuni.mff.checkstyle.wrongHeaderProject.TTT;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Properties;

public final class Main {


    public static void main(final String[] args) {
        List<File> configs = new ArrayList<>();
        List<File> javaFiles = new ArrayList<>();

        // System.err.println("src/MyClass.java: Wrong header");
//        System.err.println("MyClass.java: 4 LineLength exceeded: actual length 102, maximum 101");
//        System.err.println("MyClass.java: 7 LineLength exceeded: actual length 162, maximum 101");


        try {
            for (String s : args) {
                javaFiles.addAll(ContentReader.findFile(s, FilesSufix.JAVA.toString()));
                configs.addAll(ContentReader.findFile(s, FilesSufix.CONFIG.toString()));
            }
        }catch (IOException e){
            e.printStackTrace();
        }

        for (File cnfg : configs){
            try {
                String name = ConfigReader.getProperties(cnfg,"CheckHeader");
            }catch (IOException e){
                e.printStackTrace();
            }

        }

        TTT t = new TTT("Michal");
        TTT tt = new TTT("Michal");

        System.out.println(t.equals(tt));

    }

}
