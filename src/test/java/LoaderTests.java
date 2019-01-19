import io.InputChannel;
import io.StringInput;
import loader.RectangleJsonLoader;
import model.Rectangle;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by malang on 18/01/19.
 */
public class LoaderTests {

    @Test(expectedExceptions = UnsupportedOperationException.class)
    public void shouldRaiseExceptionInvalidJson(){
        InputChannel input = new StringInput("Not a json string");
        RectangleJsonLoader loader = new RectangleJsonLoader(input);
        List<Rectangle> rectangles = loader.loadShapes(1);
    }

    @Test
    public void shouldLoadRectangle(){
        InputChannel input = new StringInput("{\"rescts\": [{\"x\": 100,\"y\": 100,\"w\": 250,\"h\": 80}, {\"x\": 110,\"y\": 90,\"w\": 25,\"h\": 100}]}");
        RectangleJsonLoader loader = new RectangleJsonLoader(input);
        List<Rectangle> rectangles = loader.loadShapes(1);
        Assert.assertNotNull(rectangles);
        Assert.assertEquals(rectangles.size(), 1);
    }

}
