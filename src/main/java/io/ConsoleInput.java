package io;

import java.io.InputStream;

/**
 * Created by malang on 17/01/19.
 */
public class ConsoleInput extends InputChannel {

    @Override
    public InputStream getInputStream()
    {
        System.out.println("Please enter JSON rectangles:");
        return System.in;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ConsoleInput{");
        sb.append('}');
        return sb.toString();
    }
}
