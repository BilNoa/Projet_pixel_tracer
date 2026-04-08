package shape;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {

    @Test
    void testSetEtGetP1() {
        Rectangle r = new Rectangle();
        Point p = new Point();
        p.setPos_x(4);
        p.setPos_y(6);
        r.setP1(p);
        assertEquals(4, r.getP1().getPos_x());
        assertEquals(6, r.getP1().getPos_y());
    }

    @Test
    void testSetEtGetWidth() {
        Rectangle r = new Rectangle();
        r.setWidth(20);
        assertEquals(20, r.getWidth());
    }

    @Test
    void testSetEtGetHeight() {
        Rectangle r = new Rectangle();
        r.setHeight(10);
        assertEquals(10, r.getHeight());
    }

    @Test
    void testP1ParDefautEstNull() {
        Rectangle r = new Rectangle();
        assertNull(r.getP1());
    }

    @Test
    void testToString() {
        Rectangle r = new Rectangle();
        Point p = new Point();
        p.setPos_x(0);
        p.setPos_y(0);
        r.setP1(p);
        r.setWidth(8);
        r.setHeight(4);
        assertEquals("Rectangle[p1=Point[pos_x=0, pos_y=0], width=8, height=4]", r.toString());
    }
}
