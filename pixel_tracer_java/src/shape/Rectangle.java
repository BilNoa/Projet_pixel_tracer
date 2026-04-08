package shape;

/**
 * Class Rectangle
 */
public class Rectangle extends Shape {

    private Point p1;
    private int width;
    private int height;

    public Rectangle() {}

    public void setP1(Point newVar) {
        p1 = newVar;
    }

    public Point getP1() {
        return p1;
    }

    public void setWidth(int newVar) {
        width = newVar;
    }

    public int getWidth() {
        return width;
    }

    public void setHeight(int newVar) {
        height = newVar;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return "Rectangle[p1=" + p1 + ", width=" + width + ", height=" + height + "]";
    }
}
