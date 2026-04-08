package shape;

/**
 * Class Curve
 * Représente une courbe de Bézier cubique définie par 4 points de contrôle.
 */
public class Curve extends Shape {

    private Point p1;
    private Point p2;
    private Point p3;
    private Point p4;

    public Curve() {}

    public void setP1(Point newVar) { p1 = newVar; }
    public Point getP1() { return p1; }

    public void setP2(Point newVar) { p2 = newVar; }
    public Point getP2() { return p2; }

    public void setP3(Point newVar) { p3 = newVar; }
    public Point getP3() { return p3; }

    public void setP4(Point newVar) { p4 = newVar; }
    public Point getP4() { return p4; }

    @Override
    public String toString() {
        return "Curve[p1=" + p1 + ", p2=" + p2 + ", p3=" + p3 + ", p4=" + p4 + "]";
    }
}
