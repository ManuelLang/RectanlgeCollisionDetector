package model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Created by malang on 17/01/19.
 */
public class Shape implements Comparable<Shape> {

    /**
     * X position of the shape origin point
     */
    int x;

    /**
     * Y position of the shape origin point
     */
    int y;

    int id;

    protected Shape(){}

    public Shape(int id, int x, int y) {
        if (id <= 0)
            throw new IllegalArgumentException("The given width must be a positive integer");
        this.id = id;
        this.x = x;
        this.y = y;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof Shape)) return false;

        Shape shape = (Shape) o;

        return new EqualsBuilder()
                .append(x, shape.x)
                .append(y, shape.y)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(x)
                .append(y)
                .toHashCode();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Shape{");
        sb.append("id=").append(id);
        sb.append(", x=").append(x);
        sb.append(", y=").append(y);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int compareTo(Shape o) {
        return Integer.compare(this.getId(), o.getId());
    }
}
