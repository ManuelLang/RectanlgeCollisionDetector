package io;

import org.apache.commons.lang3.StringUtils;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

/**
 * Created by malang on 18/01/19.
 */
public class StringInput extends InputChannel {

    private String value;

    public StringInput(String value){
        this.value = value;
    }

    @Override
    public InputStream getInputStream() {
        if (this.value == null)
            this.value = StringUtils.EMPTY;

        InputStream targetStream = new ByteArrayInputStream(this.value.getBytes());
        return targetStream;
    }
}
