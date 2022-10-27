package com.unvise.oop.task3;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TxtFileFinderTest {
    private static final Path DIRECTORY_PATH =
            Paths.get("src", "main", "resources", "task3").toAbsolutePath();

    @Test
    void byNameTest() throws IOException {
        var file = TxtFileFinder.byName(DIRECTORY_PATH, "hello");
        assertTrue(file.isPresent());
    }

    @Test
    void byContentTest() throws IOException {
        var files = TxtFileFinder.byContent(DIRECTORY_PATH, "Hello World!");
        assertEquals(2, files.size());
    }
}