package com.example.securitylab;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Reads a file from a nominal application data directory.
 */
public final class FileService {
    private final Path dataDirectory;

    public FileService(Path dataDirectory) {
        this.dataDirectory = dataDirectory;
    }

    /**
     * INTENTIONAL VULNERABILITY: caller-controlled path is resolved without
     * checking that the normalized result stays inside dataDirectory.
     */
    public String readFile(String requestedFile) throws IOException {
        Path file = dataDirectory.resolve(requestedFile);
        return Files.readString(file);
    }
}
