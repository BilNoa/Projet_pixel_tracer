package area;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class AreaTest {

    @Test
    void testSetEtGetId() {
        Area a = new Area();
        a.setId(3);
        assertEquals(3, a.getId());
    }

    @Test
    void testSetEtGetName() {
        Area a = new Area();
        a.setName("canvas");
        assertEquals("canvas", a.getName());
    }

    @Test
    void testSetEtGetWidth() {
        Area a = new Area();
        a.setHeight(5);
        a.setWidth(10);
        assertEquals(10, a.getWidth());
    }

    @Test
    void testSetEtGetHeight() {
        Area a = new Area();
        a.setWidth(10);
        a.setHeight(5);
        assertEquals(5, a.getHeight());
    }

    @Test
    void testEmptyCharParDefaut() {
        Area a = new Area();
        assertEquals('.', a.getEmptyChar());
    }

    @Test
    void testFullCharParDefaut() {
        Area a = new Area();
        assertEquals('@', a.getFullChar());
    }

    @Test
    void testSetEtGetEmptyChar() {
        Area a = new Area();
        a.setEmptyChar(' ');
        assertEquals(' ', a.getEmptyChar());
    }

    @Test
    void testSetEtGetFullChar() {
        Area a = new Area();
        a.setFullChar('#');
        assertEquals('#', a.getFullChar());
    }

    @Test
    void testGrilleInitialiseeApresWidthEtHeight() {
        Area a = new Area();
        a.setWidth(4);
        a.setHeight(3);
        assertNotNull(a.getGrid());
        assertEquals(3, a.getGrid().length);
        assertEquals(4, a.getGrid()[0].length);
    }

    @Test
    void testClearAreaRemplitAvecEmptyChar() {
        Area a = new Area();
        a.setWidth(3);
        a.setHeight(3);
        // La grille est remplie de '.' après initGrid
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertEquals('.', a.getGrid()[i][j]);
            }
        }
    }

    @Test
    void testClearAreaApresModification() {
        Area a = new Area();
        a.setWidth(2);
        a.setHeight(2);
        a.getGrid()[0][0] = '@';
        a.clearArea();
        assertEquals('.', a.getGrid()[0][0]);
    }

    @Test
    void testLayersParDefautEstVide() {
        Area a = new Area();
        assertNotNull(a.getLayers());
        assertEquals(0, a.getLayers().size());
    }

    @Test
    void testAddLayer() {
        Area a = new Area();
        Layer l = new Layer();
        l.setName("fg");
        a.addLayer(l);
        assertEquals(1, a.getLayers().size());
        assertEquals(l, a.getLayers().get(0));
    }

    @Test
    void testRemoveLayer() {
        Area a = new Area();
        Layer l = new Layer();
        a.addLayer(l);
        a.removeLayer(l);
        assertEquals(0, a.getLayers().size());
    }

    @Test
    void testSetEtGetLayers() {
        Area a = new Area();
        ArrayList<Layer> layers = new ArrayList<>();
        layers.add(new Layer());
        a.setLayers(layers);
        assertEquals(1, a.getLayers().size());
    }
}
