package shape;

/**
 * Class Square
 */
public class Square extends Shape {

    private Point p1;
    private int length;

    public Square() {}

    public void setP1(Point newVar) {
        p1 = newVar;
    }

    public Point getP1() {
        return p1;
    }

    public void setLength(int newVar) {
        length = newVar;
    }

    public int getLength() {
        return length;
    }

    @Override
    public String toString() {
        return "Square[p1=" + p1 + ", length=" + length + "]";
    }
}
