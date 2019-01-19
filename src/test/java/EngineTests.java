import engine.SeparateAxisRectangleCollisionDetector;
import model.Intersection;
import model.Rectangle;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by malang on 18/01/19.
 */
public class EngineTests {

    @Test
    public void shouldFindCollision1() {
        Rectangle r1 = new Rectangle(1, 100, 100, 250, 80);
        Rectangle r3 = new Rectangle(3, 120, 200, 250, 150);

        boolean isColliding = r1.isColliding(r3);

        Assert.assertTrue(isColliding);
    }

    @Test
    public void shouldNotFindCollision1() {
        Rectangle r1 = new Rectangle(1, 100, 100, 10, 10);
        Rectangle r2 = new Rectangle(2, 111, 111, 10, 10);

        boolean isColliding = r1.isColliding(r2);

        Assert.assertFalse(isColliding);
    }

    @Test
    public void shouldFindIntersection1() {
        List<Rectangle> rectangles = new ArrayList<>();

        Rectangle r1 = new Rectangle(1, 100, 100, 10, 10);
        Rectangle r2 = new Rectangle(2, 105, 105, 10, 10);

        rectangles.add(r1);
        rectangles.add(r2);

        SeparateAxisRectangleCollisionDetector collisionDetector = new SeparateAxisRectangleCollisionDetector();
        List<Intersection> intersections = collisionDetector.getIntersections(rectangles);

        Assert.assertNotNull(intersections);
        Assert.assertEquals(intersections.size(), 1);
        Assert.assertEquals(intersections.get(0).toString(), "Between rectangle 1 and 2 at (105,105), w=5, h=5.");
    }

    @Test
    public void shouldFindIntersection2() {
        List<Rectangle> rectangles = new ArrayList<>();

        Rectangle r1 = new Rectangle(1, 100, 100, 250, 80);
        Rectangle r2 = new Rectangle(2, 120, 200, 250, 150);

        rectangles.add(r1);
        rectangles.add(r2);

        SeparateAxisRectangleCollisionDetector collisionDetector = new SeparateAxisRectangleCollisionDetector();
        List<Intersection> intersections = collisionDetector.getIntersections(rectangles);

        Assert.assertNotNull(intersections);
        Assert.assertEquals(intersections.size(), 1);
        Assert.assertEquals(intersections.get(0).toString(), "Between rectangle 1 and 2 at (120,200), w=150, h=60.");
    }

    @Test
    public void shouldFindIntersection3() {
        List<Rectangle> rectangles = new ArrayList<>();

        Rectangle r2 = new Rectangle(2, 120, 200, 250, 150);
        Rectangle r3 = new Rectangle(3, 140, 160, 250, 100);

        rectangles.add(r2);
        rectangles.add(r3);

        SeparateAxisRectangleCollisionDetector collisionDetector = new SeparateAxisRectangleCollisionDetector();
        List<Intersection> intersections = collisionDetector.getIntersections(rectangles);

        Assert.assertNotNull(intersections);
        Assert.assertEquals(intersections.size(), 1);
        Assert.assertEquals(intersections.get(0).toString(), "Between rectangle 2 and 3 at (140,200), w=210, h=100.");
    }

    @Test
    public void shouldFindIntersection4() {
        List<Rectangle> rectangles = new ArrayList<>();

        Rectangle r1 = new Rectangle(1, 100, 100, 250, 80);
        Rectangle r3 = new Rectangle(3, 140, 160, 250, 100);

        rectangles.add(r1);
        rectangles.add(r3);

        SeparateAxisRectangleCollisionDetector collisionDetector = new SeparateAxisRectangleCollisionDetector();
        List<Intersection> intersections = collisionDetector.getIntersections(rectangles);

        Assert.assertNotNull(intersections);
        Assert.assertEquals(intersections.size(), 1);
        Assert.assertEquals(intersections.get(0).toString(), "Between rectangle 1 and 3 at (140,160), w=190, h=40.");
    }

    @Test
    public void shouldFindIntersection5() {
        List<Rectangle> rectangles = new ArrayList<>();

        Rectangle r1 = new Rectangle(1, 100, 100, 250, 80);
        Rectangle r4 = new Rectangle(4, 160, 140, 350, 190);

        rectangles.add(r1);
        rectangles.add(r4);

        SeparateAxisRectangleCollisionDetector collisionDetector = new SeparateAxisRectangleCollisionDetector();
        List<Intersection> intersections = collisionDetector.getIntersections(rectangles);

        Assert.assertNotNull(intersections);
        Assert.assertEquals(intersections.size(), 1);
        Assert.assertEquals(intersections.get(0).toString(), "Between rectangle 1 and 4 at (160,140), w=210, h=20.");
    }

    @Test
    public void shouldFindIntersection6() {
        List<Rectangle> rectangles = new ArrayList<>();

        Rectangle r2 = new Rectangle(2, 120, 200, 250, 150);
        Rectangle r4 = new Rectangle(4, 160, 140, 350, 190);

        rectangles.add(r2);
        rectangles.add(r4);

        SeparateAxisRectangleCollisionDetector collisionDetector = new SeparateAxisRectangleCollisionDetector();
        List<Intersection> intersections = collisionDetector.getIntersections(rectangles);

        Assert.assertNotNull(intersections);
        Assert.assertEquals(intersections.size(), 1);
        Assert.assertEquals(intersections.get(0).toString(), "Between rectangle 2 and 4 at (160,200), w=250, h=110.");
    }

    @Test
    public void shouldFindIntersection7() {
        List<Rectangle> rectangles = new ArrayList<>();

        Rectangle r3 = new Rectangle(3, 140, 160, 250, 100);
        Rectangle r4 = new Rectangle(4, 160, 140, 350, 190);

        rectangles.add(r3);
        rectangles.add(r4);

        SeparateAxisRectangleCollisionDetector collisionDetector = new SeparateAxisRectangleCollisionDetector();
        List<Intersection> intersections = collisionDetector.getIntersections(rectangles);

        Assert.assertNotNull(intersections);
        Assert.assertEquals(intersections.size(), 1);
        Assert.assertEquals(intersections.get(0).toString(), "Between rectangle 3 and 4 at (160,160), w=250, h=80.");
    }

    @Test
    public void shouldFindIntersection8() {
        List<Rectangle> rectangles = new ArrayList<>();

        Rectangle r2 = new Rectangle(2, 120, 200, 250, 150);
        Rectangle r3 = new Rectangle(3, 140, 160, 250, 100);
        Rectangle r4 = new Rectangle(4, 160, 140, 350, 190);

        rectangles.add(r2);
        rectangles.add(r3);
        rectangles.add(r4);

        SeparateAxisRectangleCollisionDetector collisionDetector = new SeparateAxisRectangleCollisionDetector();
        List<Intersection> intersections = collisionDetector.getIntersections(rectangles);

        Assert.assertNotNull(intersections);
        Assert.assertEquals(intersections.size(), 4);
        Assert.assertEquals(intersections.get(0).toString(), "Between rectangle 2 and 3 at (140,200), w=210, h=100.");
        Assert.assertEquals(intersections.get(1).toString(), "Between rectangle 2 and 4 at (160,200), w=250, h=110.");
        Assert.assertEquals(intersections.get(2).toString(), "Between rectangle 3 and 4 at (160,160), w=250, h=80.");
        Assert.assertEquals(intersections.get(3).toString(), "Between rectangle 2, 3 and 4 at (160,200), w=210, h=80.");
    }
}
