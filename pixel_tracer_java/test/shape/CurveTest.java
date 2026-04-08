package shape;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CurveTest {

    private Point makePoint(int x, int y) {
        Point p = new Point();
        p.setPos_x(x);
        p.setPos_y(y);
        return p;
    }

    @Test
    void testSetEtGetP1() {
        Curve c = new Curve();
        c.setP1(makePoint(1, 2));
        assertEquals(1, c.getP1().getPos_x());
        assertEquals(2, c.getP1().getPos_y());
    }

    @Test
    void testSetEtGetP2() {
        Curve c = new Curve();
        c.setP2(makePoint(3, 4));
        assertEquals(3, c.getP2().getPos_x());
        assertEquals(4, c.getP2().getPos_y());
    }

    @Test
    void testSetEtGetP3() {
        Curve c = new Curve();
        c.setP3(makePoint(5, 6));
        assertEquals(5, c.getP3().getPos_x());
        assertEquals(6, c.getP3().getPos_y());
    }

    @Test
    void testSetEtGetP4() {
        Curve c = new Curve();
        c.setP4(makePoint(7, 8));
        assertEquals(7, c.getP4().getPos_x());
        assertEquals(8, c.getP4().getPos_y());
    }

    @Test
    void testTousLesPointsParDefautSontNull() {
        Curve c = new Curve();
        assertNull(c.getP1());
        assertNull(c.getP2());
        assertNull(c.getP3());
        assertNull(c.getP4());
    }

    @Test
    void testToString() {
        Curve c = new Curve();
        c.setP1(makePoint(0, 0));
        c.setP2(makePoint(1, 3));
        c.setP3(makePoint(4, 3));
        c.setP4(makePoint(5, 0));
        assertEquals(
            "Curve[p1=Point[pos_x=0, pos_y=0], p2=Point[pos_x=1, pos_y=3], p3=Point[pos_x=4, pos_y=3], p4=Point[pos_x=5, pos_y=0]]",
            c.toString()
        );
    }
}
