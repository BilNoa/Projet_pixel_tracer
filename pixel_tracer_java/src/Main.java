import shape.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        // Un point
        Point p1 = new Point();
        p1.setPos_x(0);
        p1.setPos_y(0);
        p1.setColor(0xFF0000); // rouge
        System.out.println("Point : " + p1);

        // Une ligne entre deux points
        Point p2 = new Point();
        p2.setPos_x(10);
        p2.setPos_y(10);

        Line ligne = new Line();
        ligne.setP1(p1);
        ligne.setP2(p2);
        ligne.setThickness(2.0f);
        ligne.setColor(0x00FF00); // vert
        System.out.println("Ligne : " + ligne);

        // Un cercle
        Point centre = new Point();
        centre.setPos_x(50);
        centre.setPos_y(50);

        Circle cercle = new Circle();
        cercle.setCenter(centre);
        cercle.setColor(0x0000FF); // bleu
        System.out.println("Cercle : " + cercle);

        // Un polygone (triangle)
        Point a = new Point();
        a.setPos_x(0);
        a.setPos_y(0);

        Point b = new Point();
        b.setPos_x(5);
        b.setPos_y(10);

        Point c = new Point();
        c.setPos_x(10);
        c.setPos_y(0);

        ArrayList<Point> sommets = new ArrayList<>();
        sommets.add(a);
        sommets.add(b);
        sommets.add(c);

        Polygone triangle = new Polygone();
        triangle.setPoints(sommets);
        triangle.setFill('X');
        triangle.setColor(0xFFFF00); // jaune
        System.out.println("Polygone : " + triangle);
    }
}
