package cz.cuni.mff.checkstyle.utils;

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ContentReader {

    public static List<File> findFile(String path, String suffix) throws IOException {
        List<File> filesList = new ArrayList<>();
        Files.walk(Paths.get(path))
                .filter(Files::isRegularFile)
                .forEach((f) -> {
                    if (f.toFile().getName().endsWith(suffix))
                        filesList.add(f.toFile());
                });

        return filesList;
    }

//    public static File findFile(String path,String name, String suffix) throws NullPointerException {
//
//        String r = getAbsolutePath(path,name);
//        System.out.println("hovno: " + r);
//
//        File root = new File(path);
//        File[] list = root.listFiles();
//
//        for (File file : list) {
//            if (file.isDirectory()) {
//                findFile(file.getAbsolutePath(),name,suffix);
//            } else {
//                if (file.getName().equals(name) && file.getName().endsWith(suffix)){
//                    return file;
//                }
//            }
//        }
//        return null;
//    }

    public static File findFile(String base,String relative, String suffix) throws NullPointerException {
        Path basePath = FileSystems.getDefault().getPath(base);
        Path resolvedPath = basePath.resolve(relative);
        File file = new File(resolvedPath.normalize().toUri());
        return file;
    }

    public static List<String> getFileContent(File file) {
        List<String> content = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line = br.readLine();
            while (line != null) {
                content.add(line);
                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }


    public static boolean compareHeaders(File pattern, File file) {
        List<String> patternCompare = getFileContent(pattern);
        List<String> testFile = getFileContent(file);
        for (int i = 0; i < patternCompare.size(); i++) {
            if (!patternCompare.get(i).equals(testFile.get(i))) {
                return false;
            }
        }
        return true;
    }

    public static List<File> getList(String path,String suffix){
        List<File> list = new ArrayList<>();
        try {
            list.addAll(ContentReader.findFile(path, suffix));
        }catch (IOException e){
            e.printStackTrace();
        }
        return list;
    }
}
