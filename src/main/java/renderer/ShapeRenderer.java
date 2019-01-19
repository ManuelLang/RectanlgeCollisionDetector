package renderer;

import io.OutputChannel;
import model.Shape;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;

/**
 * Created by malang on 17/01/19.
 */
public abstract class ShapeRenderer<T extends Shape> {

    private OutputChannel output;
    protected String renderedOutput;


    public ShapeRenderer(OutputChannel output) {
        this.output = output;
    }


    public String getRenderedOutput() {
        return renderedOutput;
    }

    public abstract void render(T shape);

    public void writeOut() {
        if (this.getRenderedOutput() == null)
            throw new UnsupportedOperationException("The shape must be rendered first");

        try (OutputStream outputStream = this.output.getOutputStream()) {
            outputStream.write(this.getRenderedOutput().getBytes(Charset.forName("UTF-8")));
        } catch (IOException ex) {
            throw new UnsupportedOperationException(String.format("Unable to write rendered shape to output channel: %s", ex));
        }
    }

}
