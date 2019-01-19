import model.Intersection;
import model.Rectangle;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by malang on 18/01/19.
 */
public class IntersectionTests {

    @Test
    public void shouldPrintIntersection() {
        System.out.println("Intersections:");
        Rectangle rect1 = new Rectangle(1, 100, 100, 250, 80);
        Rectangle rect2 = new Rectangle(2, 120, 200, 250, 150);
        Rectangle rect3 = new Rectangle(3, 140, 160, 250, 100);
        Rectangle rect4 = new Rectangle(4, 160, 140, 350, 190);
        {
            Intersection i1 = new Intersection(1, 140, 160, 210, 20);
            i1.addIntersectingRectangle(rect1);
            i1.addIntersectingRectangle(rect3);
            Assert.assertEquals("Between rectangle 1 and 3 at (140,160), w=210, h=20.", i1.toString());
        }
        {
            Intersection i7 = new Intersection(7, 160, 200, 210, 60);
            i7.addIntersectingRectangle(rect2);
            i7.addIntersectingRectangle(rect3);
            i7.addIntersectingRectangle(rect4);
            Assert.assertEquals("Between rectangle 2, 3 and 4 at (160,200), w=210, h=60.", i7.toString());
        }

    }

}
