package shape;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ShapeTest {

    // On utilise Point pour tester Shape car Shape est abstraite
    @Test
    void testId() {
        Point p = new Point();
        p.setId(42L);
        assertEquals(42L, p.getId());
    }

    @Test
    void testFill() {
        Point p = new Point();
        p.setFill('X');
        assertEquals('X', p.getFill());
    }

    @Test
    void testThickness() {
        Point p = new Point();
        p.setThickness(1.5f);
        assertEquals(1.5f, p.getThickness());
    }

    @Test
    void testColor() {
        Point p = new Point();
        p.setColor(255);
        assertEquals(255, p.getColor());
    }

    @Test
    void testRotation() {
        Point p = new Point();
        p.setRotation(90.0);
        assertEquals(90.0, p.getRotation());
    }
}
