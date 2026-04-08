package shape;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CercleTest {

    @Test
    void testSetEtGetCenter() {
        Cercle c = new Cercle();
        Point center = new Point();
        center.setPos_x(5);
        center.setPos_y(5);
        c.setCenter(center);
        assertEquals(5, c.getCenter().getPos_x());
        assertEquals(5, c.getCenter().getPos_y());
    }

    @Test
    void testSetEtGetRadius() {
        Cercle c = new Cercle();
        c.setRadius(7);
        assertEquals(7, c.getRadius());
    }

    @Test
    void testCenterParDefautEstNull() {
        Cercle c = new Cercle();
        assertNull(c.getCenter());
    }

    @Test
    void testToString() {
        Cercle c = new Cercle();
        Point center = new Point();
        center.setPos_x(3);
        center.setPos_y(4);
        c.setCenter(center);
        c.setRadius(10);
        assertEquals("Cercle[center=Point[pos_x=3, pos_y=4], radius=10]", c.toString());
    }
}
