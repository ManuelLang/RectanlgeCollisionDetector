package io;

import org.apache.commons.lang3.StringUtils;

import java.io.*;

/**
 * Created by malang on 17/01/19.
 */
public class FileOutput extends OutputChannel {

    protected String filePath;

    public FileOutput(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public OutputStream getOutputStream() {
        if (StringUtils.isBlank(this.filePath))
            throw new IllegalArgumentException("The filePath is required to load JSON");

        File outputFile = new File(this.filePath);

        if (!outputFile.exists()) {
            try {
                Boolean result = outputFile.createNewFile();
                if (!result)
                    throw new IllegalArgumentException("File not created");
            } catch (IOException e) {
                throw new IllegalArgumentException("Can not create the specified file: '%s'");
            }
        }
        try {
            return new BufferedOutputStream(new FileOutputStream(outputFile, true));
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException("Can not find the specified file: '%s'");
        }
    }
}
