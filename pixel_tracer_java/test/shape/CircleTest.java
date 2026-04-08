package shape;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CircleTest {

    @Test
    void testSetEtGetCenter() {
        Circle c = new Circle();
        Point center = new Point();
        center.setPos_x(5);
        center.setPos_y(5);
        c.setCenter(center);
        assertEquals(5, c.getCenter().getPos_x());
        assertEquals(5, c.getCenter().getPos_y());
    }

    @Test
    void testCenterParDefautEstNull() {
        Circle c = new Circle();
        assertNull(c.getCenter());
    }

    @Test
    void testToString() {
        Circle c = new Circle();
        Point center = new Point();
        center.setPos_x(3);
        center.setPos_y(4);
        c.setCenter(center);
        assertEquals("Circle[center=Point[pos_x=3, pos_y=4]]", c.toString());
    }
}
