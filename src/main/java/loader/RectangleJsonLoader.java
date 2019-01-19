package loader;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import io.InputChannel;
import model.Rectangle;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by malang on 17/01/19.
 */
public class RectangleJsonLoader extends ShapeJsonLoader<Rectangle> {

    public RectangleJsonLoader(InputChannel input) {
        super(input);
    }

    @Override
    public List<Rectangle> loadShapes(int limit) {
        JsonNode jsonRectangles = super.parseInput();

        List<Rectangle> result = new ArrayList<>();

        int currentIndex = 0;
        for (final JsonNode rectangleNode : jsonRectangles) {
            currentIndex++;
            if(currentIndex > limit)
                break;
            try {
                Rectangle rectangle = objectMapper.treeToValue(rectangleNode, Rectangle.class);
                rectangle.setId(currentIndex);
                result.add(rectangle);
            } catch (JsonProcessingException e) {
                throw new IllegalArgumentException(String.format("Unable to parse Rectangle: %s. Error: %s", rectangleNode, e));
            }
        }
        return result;
    }

}
