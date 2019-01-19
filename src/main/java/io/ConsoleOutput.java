package io;

import java.io.OutputStream;

/**
 * Created by malang on 17/01/19.
 */
public class ConsoleOutput extends OutputChannel {
    @Override
    public OutputStream getOutputStream() {
        return System.out;
    }
}
