package cz.cuni.mff.checkstyle.utils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ContentReader {

    public static List<File> findFile(String path, String sufix) throws IOException {
        List<File> filesList = new ArrayList<>();
        Files.walk(Paths.get(path))
                .filter(Files::isRegularFile)
                .forEach((f) -> {
                    if (f.toFile().getName().endsWith(sufix))
                        filesList.add(f.toFile());
                });

        return filesList;
    }
    //funckia ktora hlada konkretny file - podla mena a typu - otazka je ci ju nedat ako jedinu a checkovat co je null?
    public static List<File> findFile(String path, String sufix, String name) throws IOException {
        List<File> filesList = new ArrayList<>();
        Files.walk(Paths.get(path))
                .filter(Files::isRegularFile)
                .forEach((f) -> {
                    if (f.toFile().getName().equals(name) && f.toFile().getName().endsWith(sufix))
                        filesList.add(f.toFile());
                });

        return filesList;
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
}
