package io;

import org.apache.commons.lang3.StringUtils;

import java.io.*;

/**
 * Created by malang on 17/01/19.
 */
public class FileInput extends InputChannel {

    protected String filePath;

    public FileInput(String filePath) {
        this.filePath = filePath;
    }

    protected static long MAX_FILE_SIZE = 1024 * 1024 * 2;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("FileInput{");
        sb.append("filePath='").append(filePath).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public InputStream getInputStream() {
        if (StringUtils.isBlank(this.filePath))
            throw new IllegalArgumentException("The filePath is required to load JSON");

        File inputFile = new File(this.filePath);

        if (!inputFile.exists())
            throw new IllegalArgumentException(String.format("The file does not exists: '%s'", this.filePath));

        if (!inputFile.isFile())
            throw new IllegalArgumentException(String.format("The given path is not a File: '%s'", this.filePath));

        long fileSize = inputFile.length();
        if (fileSize > MAX_FILE_SIZE)
            throw new IllegalArgumentException(String.format("The file is too big: '%s'. Maximum size allowed is %s Mb",
                    this.filePath, MAX_FILE_SIZE / (1024 * 1024)));

        try {
            return new BufferedInputStream(new FileInputStream(inputFile));
        } catch (FileNotFoundException ex) {
            throw new IllegalArgumentException(String.format("Unable to read file: '%s'. Error: %s", this.filePath, ex));
        }
    }
}
