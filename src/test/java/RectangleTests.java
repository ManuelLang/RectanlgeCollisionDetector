import model.Rectangle;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by malang on 18/01/19.
 */
public class RectangleTests {

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void shouldRaiseExceptionNegativeWidth(){
        Rectangle rectangle = new Rectangle(1, 100,110,-250,80);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void shouldRaiseExceptionZeroHeight(){
        Rectangle rectangle = new Rectangle(2, 100,110,250,0);
    }

    @Test
    public void shouldPrintRectangle(){
        Rectangle rectangle = new Rectangle(3, 100,110,250,80);
        Assert.assertEquals(rectangle.getX(), 100);
        Assert.assertEquals(rectangle.getY(), 110);
        Assert.assertEquals(rectangle.getWidth(), 250);
        Assert.assertEquals(rectangle.getHeight(), 80);
        Assert.assertEquals("3: Rectangle at (100,110), w=250, h=80.", rectangle.toString());
    }

}
