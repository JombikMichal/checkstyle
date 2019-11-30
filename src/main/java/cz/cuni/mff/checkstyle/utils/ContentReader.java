package cz.cuni.mff.checkstyle.utils;

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class ContentReader {

    public static List<File> findFiles(String path, String suffix) throws IOException {
        List<File> filesList = new ArrayList<>();
        Files.walk(Paths.get(path))
                .filter(Files::isRegularFile)
                .forEach((f) -> {
                    if (f.toFile().getName().endsWith(suffix))
                        filesList.add(f.toFile());
                });

        return filesList;
    }

    public static File findFile(String base, String relative, String suffix) throws NullPointerException {
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

    public static String getRelativePath(String base, File file) {
        return new File(base).toURI().relativize(new File(file.toURI()).toURI()).getPath();
    }
}