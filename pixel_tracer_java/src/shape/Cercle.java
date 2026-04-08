package shape;

/**
 * Class Cercle
 */
public class Cercle extends Shape {

    private Point center;
    private int radius;

    public Cercle() {}

    public void setCenter(Point newVar) {
        center = newVar;
    }

    public Point getCenter() {
        return center;
    }

    public void setRadius(int newVar) {
        radius = newVar;
    }

    public int getRadius() {
        return radius;
    }

    @Override
    public String toString() {
        return "Cercle[center=" + center + ", radius=" + radius + "]";
    }
}
