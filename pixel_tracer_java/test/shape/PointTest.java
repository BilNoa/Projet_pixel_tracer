package shape;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PointTest {

    @Test
    void testPos_x() {
        Point p = new Point();
        p.setPos_x(10);
        assertEquals(10, p.getPos_x());
    }

    @Test
    void testPos_y() {
        Point p = new Point();
        p.setPos_y(20);
        assertEquals(20, p.getPos_y());
    }

    @Test
    void testToString() {
        Point p = new Point();
        p.setPos_x(3);
        p.setPos_y(7);
        assertEquals("Point[pos_x=3, pos_y=7]", p.toString());
    }
}
