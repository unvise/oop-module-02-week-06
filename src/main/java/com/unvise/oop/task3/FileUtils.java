package com.unvise.oop.task3;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileUtils {
    public static File getDirectory(Path directoryPath) throws IOException {
        File directory = new File(directoryPath.toUri());
        if (!directory.isDirectory()) {
            throw new IOException("Введенный путь не является директорией");
        }
        return directory;
    }

    public static Boolean isFileContentEquals(File file, String content) throws IOException {
        return Files
                .readString(file.toPath())
                .replaceAll("[\\u0000-\\u001f]", "")
                .equals(content);
    }

    public static Boolean isFileNamesEquals(File file, String name) {
        return file
                .getName()
                .replaceAll("\\..*", "")
                .equals(name);
    }

    public static String getFileExtension(String fileName) {
        return fileName.substring(fileName.lastIndexOf(".") + 1);
    }

    public static Boolean hasExtension(String fileName) {
        return fileName.contains(".");
    }
}
