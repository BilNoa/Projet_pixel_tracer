package area;

import org.junit.jupiter.api.Test;
import shape.Point;
import shape.Shape;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class LayerTest {

    @Test
    void testSetEtGetId() {
        Layer l = new Layer();
        l.setId(1);
        assertEquals(1, l.getId());
    }

    @Test
    void testSetEtGetName() {
        Layer l = new Layer();
        l.setName("background");
        assertEquals("background", l.getName());
    }

    @Test
    void testVisibleParDefautEstTrue() {
        Layer l = new Layer();
        assertTrue(l.isVisible());
    }

    @Test
    void testSetVisible() {
        Layer l = new Layer();
        l.setVisible(false);
        assertFalse(l.isVisible());
        l.setVisible(true);
        assertTrue(l.isVisible());
    }

    @Test
    void testShapesParDefautEstVide() {
        Layer l = new Layer();
        assertNotNull(l.getShapes());
        assertEquals(0, l.getShapes().size());
    }

    @Test
    void testAddShape() {
        Layer l = new Layer();
        Point p = new Point();
        p.setPos_x(1);
        p.setPos_y(2);
        l.addShape(p);
        assertEquals(1, l.getShapes().size());
        assertEquals(p, l.getShapes().get(0));
    }

    @Test
    void testRemoveShape() {
        Layer l = new Layer();
        Point p = new Point();
        l.addShape(p);
        l.removeShape(p);
        assertEquals(0, l.getShapes().size());
    }

    @Test
    void testSetEtGetShapes() {
        Layer l = new Layer();
        ArrayList<Shape> shapes = new ArrayList<>();
        Point p = new Point();
        shapes.add(p);
        l.setShapes(shapes);
        assertEquals(1, l.getShapes().size());
    }

    @Test
    void testToString() {
        Layer l = new Layer();
        l.setId(1);
        l.setName("bg");
        assertEquals("Layer[id=1, name=bg, visible=true, shapes=[]]", l.toString());
    }
}
