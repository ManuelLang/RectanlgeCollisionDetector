package loader;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.InputChannel;
import model.Shape;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/**
 * Created by malang on 17/01/19.
 */
public abstract class ShapeJsonLoader<T extends Shape> {

    private InputChannel input;

    public ShapeJsonLoader(InputChannel input) {
        this.input = input;
    }

    public abstract List<T> loadShapes(int limit);

    protected static final ObjectMapper objectMapper = new ObjectMapper();

    protected JsonNode parseInput() {
        JsonNode jsonTree = null;
        try {
            jsonTree = objectMapper.readTree(this.input.getInputStream());
        } catch (JsonProcessingException ex) {
            throw new UnsupportedOperationException(String.format(
                    "The input '%s' does not contain valid JSON, please validate its content with https://jsonlint.com/. Error: %s",
                    this.input, ex));
        } catch (IOException ex) {
            throw new UnsupportedOperationException(String.format("The input '%s' can not be open. Error: %s",
                    this.input, ex));
        }

        if (jsonTree == null || jsonTree.isNull() || jsonTree.isMissingNode())
            throw new IllegalArgumentException("The JSON file is expected to contain 1 root JSON object");

        Iterator<JsonNode> it = jsonTree.elements();    // Takes first element
        if (!it.hasNext())
            throw new IllegalArgumentException("The JSON root node does not contain any element");
        JsonNode shapes = it.next();

        if (!shapes.isArray())
            throw new IllegalArgumentException("The JSON root node is expected to contain array of shapes");

        return shapes;
    }
}
