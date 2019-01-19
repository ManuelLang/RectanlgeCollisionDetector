package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by malang on 17/01/19.
 */
public class Intersection extends Rectangle {

    private List<Rectangle> rectangles = new ArrayList<>();

    public Intersection(int id, int x, int y, int width, int height) {
        super(id, x, y, width, height);
    }

    public List<Rectangle> getRectangles() {
        List<Rectangle> rects = new ArrayList<>();
        for (Rectangle r : rectangles)
            if (r instanceof Intersection) {
                rects.addAll(((Intersection) r).getRectangles());
            } else {
                rects.add(r);
            }
        return rects;
    }

    public void addIntersectingRectangle(Rectangle rectangle) {
        if (rectangle == null)
            throw new IllegalArgumentException("The rectangle is mandatory");
        if (!rectangles.contains(rectangle))
            rectangles.add(rectangle);
    }

    public List<Integer> getRectangleIds() {
        List<Integer> ids = new ArrayList<>();
        for (Rectangle r : rectangles)
            if (r instanceof Intersection) {
                ids.addAll(((Intersection) r).getRectangleIds());
            } else {
                ids.add(r.getId());
            }
        return ids;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Between rectangle ");

        List<Rectangle> rectangles = this.getRectangles();
        int totalRectangles = rectangles.size();
        int currentRectangle = 0;
        for (Rectangle rectangle : rectangles) {
            currentRectangle++;
            if (currentRectangle > 1)
                if (totalRectangles == currentRectangle)
                    sb.append(" and ");
                else
                    sb.append(", ");
            sb.append(rectangle.id);
        }
        sb.append(" at (").append(this.x).append(",").append(this.y)
                .append("), w=").append(this.width)
                .append(", h=").append(this.height).append(".");
        return sb.toString();
    }
}
