package cz.cuni.mff.checkstyle;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

public final class Main {

    public static void main(final String[] args) {
        for (String s : args){
            readRepository(s);
        }
    }

    static void readRepository(String path) throws NullPointerException {
        File root = new File(path);
        File[] list = root.listFiles();

        for (File files : list) {
            if (files.isDirectory()) {
                readRepository(files.getAbsolutePath());
            } else {
                System.out.println("FILE NAME: " + files.getName());
                //printFileContent(files.getAbsoluteFile());
            }
        }
    }

}
