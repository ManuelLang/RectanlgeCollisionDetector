package engine;

import model.Rectangle;

/**
 * Created by malang on 18/01/19.
 */
public class SeparateAxisRectangleCollisionDetector extends SeparateAxisShapeCollisionDetector<Rectangle> {

    @Override
    protected Rectangle getRectangularProjection(Rectangle shape) {
        return shape;   // No need for projection computation in case of rectangles aligned with X-axis
    }

}
