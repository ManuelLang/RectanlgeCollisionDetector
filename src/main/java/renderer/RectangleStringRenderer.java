package renderer;

import io.OutputChannel;
import model.Rectangle;

/**
 * Created by malang on 17/01/19.
 */
public class RectangleStringRenderer extends ShapeRenderer<Rectangle> {

    public RectangleStringRenderer(OutputChannel output) {
        super(output);
    }

    @Override
    public void render(Rectangle shape) {
        super.renderedOutput = shape.toString();
    }
}
