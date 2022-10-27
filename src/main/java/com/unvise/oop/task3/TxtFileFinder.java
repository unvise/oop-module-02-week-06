package com.unvise.oop.task3;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static com.unvise.oop.task3.FileUtils.*;

public class TxtFileFinder {
    public static Optional<File> byName(Path directoryPath, String name) throws IOException {
        return Arrays.stream(Objects.requireNonNull(getDirectory(directoryPath).listFiles()))
                .parallel()
                .filter(File::isFile)
                .filter(TxtFileFinder::isFileHasTxtExtension)
                .filter(file -> isFileNamesEquals(file, name))
                .findFirst();
    }

    public static List<File> byContent(Path directoryPath, String content) throws IOException {
        return Arrays.stream(Objects.requireNonNull(getDirectory(directoryPath).listFiles()))
                .parallel()
                .filter(File::isFile)
                .filter(TxtFileFinder::isFileHasTxtExtension)
                .filter(file -> {
                    try {
                        return isFileContentEquals(file, content);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                })
                .toList();
    }

    private static Boolean isFileHasTxtExtension(File file) {
        String fileName = file.getName();
        return Optional.of(fileName)
                .filter(FileUtils::hasExtension)
                .map(FileUtils::getFileExtension)
                .filter(TxtFileFinder::isEqualsTxt)
                .isPresent();
    }

    private static Boolean isEqualsTxt(String extension) {
        return "txt".equals(extension);
    }
}
