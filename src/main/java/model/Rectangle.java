package model;


import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Created by malang on 17/01/19.
 */
public class Rectangle extends Shape {

    @JsonProperty("w")
    int width;

    @JsonProperty("h")
    int height;

    protected Rectangle() {
        super();
    }

    public Rectangle(int id, int x, int y, int width, int height) {
        super(id, x, y);

        if (width <= 0)
            throw new IllegalArgumentException("The given width must be a positive integer");
        if (height <= 0)
            throw new IllegalArgumentException("The given height must be a positive integer");

        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public boolean isColliding(Rectangle other) {
        if (other == null)
            throw new IllegalArgumentException("The rectangle to compare should is required");
        if ((other.getY() + other.getWidth()) < this.getY()             // this (r1) is right to other (r2)
                || (this.getY() + this.getWidth()) < other.getY()       // this (r1) is left to other (r2)
                || (this.getX() + this.getHeight()) < other.getX()      // this (r1) is above to other (r2)
                || (other.getX() + other.getHeight()) < this.getX())    // this (r1) is under to other (r2)
            return false;
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof Rectangle)) return false;

        Rectangle rectangle = (Rectangle) o;

        return new EqualsBuilder()
                .appendSuper(super.equals(o))
                .append(width, rectangle.width)
                .append(height, rectangle.height)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .appendSuper(super.hashCode())
                .append(width)
                .append(height)
                .toHashCode();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(id);
        sb.append(": Rectangle at (");
        sb.append(x);
        sb.append(",").append(y);
        sb.append("), w=").append(width);
        sb.append(", h=").append(height);
        sb.append('.');
        return sb.toString();
    }

}
