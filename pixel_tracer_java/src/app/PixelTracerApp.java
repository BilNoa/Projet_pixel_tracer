package app;

import area.Area;
import area.Layer;
import shape.Shape;
import java.util.ArrayList;

/**
 * Structure principale de l'application (équivalent de pixel_tracer.h/.c).
 * Contient la liste de toutes les areas et les pointeurs vers la sélection courante.
 */
public class PixelTracerApp {

    private ArrayList<Area> areas;
    private Area currentArea;
    private Layer currentLayer;
    private Shape currentShape;

    public PixelTracerApp() {
        areas = new ArrayList<>();

        Area area = new Area();
        area.setId((int) IdGenerator.getNextId());
        area.setName("Area1");
        area.setWidth(80);
        area.setHeight(40);
        areas.add(area);
        currentArea = area;

        Layer layer = new Layer();
        layer.setId((int) IdGenerator.getNextId());
        layer.setName("Layer 1");
        area.addLayer(layer);
        currentLayer = layer;
        currentShape = null;
    }

    public ArrayList<Area> getAreas() { return areas; }
    public void addArea(Area area) { areas.add(area); }

    public Area getCurrentArea() { return currentArea; }
    public void setCurrentArea(Area a) { currentArea = a; }

    public Layer getCurrentLayer() { return currentLayer; }
    public void setCurrentLayer(Layer l) { currentLayer = l; }

    public Shape getCurrentShape() { return currentShape; }
    public void setCurrentShape(Shape s) { currentShape = s; }
}
