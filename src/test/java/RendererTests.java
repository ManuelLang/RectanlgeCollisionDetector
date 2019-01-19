import io.ConsoleOutput;
import io.OutputChannel;
import model.Rectangle;
import org.testng.Assert;
import org.testng.annotations.Test;
import renderer.RectangleStringRenderer;
import renderer.ShapeRenderer;

/**
 * Created by malang on 18/01/19.
 */
public class RendererTests {

    @Test
    public void shouldRenderRectangle(){
        Rectangle rectangle = new Rectangle(1, 100,110,250,80);
        OutputChannel outputChannel = new ConsoleOutput();
        ShapeRenderer renderer = new RectangleStringRenderer(outputChannel);
        renderer.render(rectangle);
        String result = renderer.getRenderedOutput();
        Assert.assertEquals("1: Rectangle at (100,110), w=250, h=80.", result);
        renderer.writeOut();
    }
}
