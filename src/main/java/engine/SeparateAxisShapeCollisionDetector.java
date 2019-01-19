package engine;

import model.Intersection;
import model.Rectangle;
import model.Shape;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by malang on 17/01/19.
 */
public abstract class SeparateAxisShapeCollisionDetector<T extends Shape> {

    protected abstract Rectangle getRectangularProjection(T shape);

    public List<Intersection> getIntersections(List<T> shapes) {
        // Compute shape projections on X and Y axis
        List<Rectangle> projections = new ArrayList<>();
        for (T shape : shapes) {
            projections.add(this.getRectangularProjection(shape));
        }

        // Compare all rectangles for intersections: all intersections have rectangular shape
        Map<Integer, Intersection> intersectionsMap = new HashMap<>();
        for (Rectangle r1 : projections) {
            for (Rectangle r2 : projections) {
                if(r1.getId() == r2.getId())
                    continue;
                Intersection intersection = getOverlappingArea(r1, r2);
                if (intersection == null)
                    continue;
                intersectionsMap.putIfAbsent(intersection.getId(), intersection);
            }
        }

        this.computeIntersections(projections, intersectionsMap);

        List<Intersection> intersections = new ArrayList<>(intersectionsMap.values());
        Collections.sort(intersections);
        return intersections;
    }

    private void computeIntersections(List<Rectangle> rectangles,
                                      Map<Integer, Intersection> intersectionsMap) {
        if (intersectionsMap.size() < 1)
            return;

        for (Rectangle r1 : rectangles) {
            List<Intersection> intersections = new ArrayList<>(intersectionsMap.values());
            for (Intersection i : intersections) {
                if(i.getRectangleIds().contains(r1.getId()))
                    continue;   // the rectangle is already taken into account for this intersection
                Intersection intersection = getOverlappingArea(r1, i);
                if (intersection == null)
                    continue;
                List<Integer> rectangleIds = intersection.getRectangleIds();
                Collections.sort(rectangleIds);
                int id = Integer.parseInt(String.join("", rectangleIds.stream().map(Object::toString)
                        .collect(Collectors.toList())));
                intersectionsMap.putIfAbsent(id, intersection);
            }
        }
    }

    protected static Intersection getOverlappingArea(Rectangle r1, Rectangle r2) {
        if (!r1.isColliding(r2))
            return null;

        int lowerBoundX, upperBoundX, lowerBoundY, upperBoundY;

        if (r1.getX() < r2.getX())
            lowerBoundX = r2.getX();
        else
            lowerBoundX = r1.getX();

        if ((r1.getX() + r1.getHeight()) < (r2.getX() + r2.getHeight()))
            upperBoundX = r1.getX() + r1.getHeight();
        else
            upperBoundX = r2.getX() + r2.getHeight();

        if (r1.getY() < r2.getY())
            lowerBoundY = r2.getY();
        else
            lowerBoundY = r1.getY();

        if ((r1.getY() + r1.getWidth()) < (r2.getY() + r2.getWidth()))
            upperBoundY = r1.getY() + r1.getWidth();
        else
            upperBoundY = r2.getY() + r2.getWidth();

        int width = upperBoundY - lowerBoundY;
        int height = upperBoundX - lowerBoundX;

        if (width < 1 || height < 1)
            return null;    // in case of super imposition

        // A intersect B == B intersect A
        String key;
        if (r1.getId() < r2.getId())
            key = String.format("%s%s", r1.getId(), r2.getId());
        else
            key = String.format("%s%s", r2.getId(), r1.getId());
        int id = Integer.parseInt(key);
        Intersection i = new Intersection(id, lowerBoundX, lowerBoundY, width, height);
        i.addIntersectingRectangle(r1);
        i.addIntersectingRectangle(r2);
        return i;
    }

}
