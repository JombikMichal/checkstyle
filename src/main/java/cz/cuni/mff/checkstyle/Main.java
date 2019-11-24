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

        try {
            for (File cnfg : configs) {
                for (File testFile : javaFiles) {
                    //wrongLineLengthProject(cnfg, testFile, absotulePath);
                    //wrongHeaderProject(testFile, cnfg, args, absotulePath);
                    //wrongNewlineAtEndProjectTest(testFile);
                    //wrongPackageFormatProjectTest(testFile, absotulePath);
                    //wrongTabCharProjectTest(testFile, absotulePath);
                    checkDirsProjectTest();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void checkDirsProjectTest() throws IOException{

    }

    static void wrongTabCharProjectTest(File testFile, String absotulePath) throws IOException {
        List<String> fileContent = ContentReader.getFileContent(testFile);
        String relative = new File(absotulePath).toURI().relativize(new File(testFile.toURI()).toURI()).getPath();
        for (int i = 0; i < fileContent.size(); i++) {
            if (fileContent.get(i).contains("\t")) {
                System.err.println(String.format("%s: contains tab char at %d:%d", relative, i + 1, fileContent.get(i).indexOf("\t")));
            }
        }
    }

    static void wrongPackageFormatProjectTest(File testFile, String absotulePath) throws IOException {
        List<String> fileContent = ContentReader.getFileContent(testFile);
        String relative = new File(absotulePath).toURI().relativize(new File(testFile.toURI()).toURI()).getPath();
        for (String line : fileContent) {
            if (line.startsWith("package") && !line.matches("^[a-z]+(\\.[a-zA-Z_][a-zA-Z0-9_]*)*$")) {
                System.err.println(String.format("%s: wrong package format", relative));
                break;
            }
        }
    }

    static void wrongNewlineAtEndProjectTest(File testFile) throws IOException {
        List<String> fileContent = ContentReader.getFileContent(testFile);
        if (!fileContent.get(fileContent.size() - 1).isEmpty()) {
            System.err.println("MyClass.java: does not contain newline at the end of file");
        }
    }

    static void wrongLineLengthProject(File cnfg, File testFile, String absotulePath) throws IOException {
        int lineLenght = Integer.parseInt(ConfigReader.getProperties(cnfg, "LineLength"));
        List<String> fileContent = ContentReader.getFileContent(testFile);
        for (int i = 0; i < fileContent.size(); i++) {
            if (fileContent.get(i).length() > lineLenght) {
                String relative = new File(absotulePath).toURI().relativize(new File(testFile.toURI()).toURI()).getPath();
                System.err.println(String.format("%s: %d LineLength exceeded: actual length %d, maximum %d", relative, i + 1, fileContent.get(i).length(), lineLenght));
            }
        }
    }

    static void wrongHeaderProject(File testFile, File cnfg, String[] args, String absotulePath) throws IOException {
        String content = ConfigReader.getProperties(cnfg, "CheckHeader");
        if (ContentReader.getList(args, FilenameUtils.getExtension(content)).size() == 1) {
            if (!ContentReader.compareHeaders(ContentReader.getList(args, FilenameUtils.getExtension(content)).get(0), testFile)) {
                String relative = new File(absotulePath).toURI().relativize(new File(testFile.toURI()).toURI()).getPath();
                System.err.println(String.format("%s: Wrong header", relative));
            }
        }
    }
}
