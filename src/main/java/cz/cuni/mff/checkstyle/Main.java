package cz.cuni.mff.checkstyle;

import cz.cuni.mff.checkstyle.utils.ConfigReader;
import cz.cuni.mff.checkstyle.utils.ContentReader;
import cz.cuni.mff.checkstyle.utils.FilesSuffix;
import org.apache.commons.io.FilenameUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public final class Main {


    public static void main(final String[] args) {
        List<File> configs = new ArrayList<>();
        List<File> javaFiles = new ArrayList<>();
        javaFiles.addAll(ContentReader.getList(args, FilesSuffix.JAVA.toString()));
        configs.addAll(ContentReader.getList(args, FilesSuffix.CONFIG.toString()));
        String absotulePath = args[0];
        for (File cnfg : configs) {
            try {
                String content = ConfigReader.getProperties(cnfg, "CheckHeader");
                for (File testFile : javaFiles) {
                    if (ContentReader.getList(args, FilenameUtils.getExtension(content)).size() == 1) {
                        if (!ContentReader.compareHeaders(ContentReader.getList(args, FilenameUtils.getExtension(content)).get(0), testFile)) {
                            String relative = new File(absotulePath).toURI().relativize(new File(testFile.toURI()).toURI()).getPath();
                            System.err.println(String.format("%s: Wrong header",relative));
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
