package area;

import shape.Shape;
import java.util.ArrayList;

/**
 * Class Layer
 * Un layer contient une liste de shapes et un flag de visibilité.
 * Seuls les layers visibles sont rendus.
 */
public class Layer {

    private int id;
    private String name;
    private boolean visible;
    private ArrayList<Shape> shapes;

    public Layer() {
        this.shapes = new ArrayList<>();
        this.visible = true; // visible par défaut, comme en C
    }

    // id
    public void setId(int newVar) { id = newVar; }
    public int getId() { return id; }

    // name
    public void setName(String newVar) { name = newVar; }
    public String getName() { return name; }

    // visible
    public void setVisible(boolean newVar) { visible = newVar; }
    public boolean isVisible() { return visible; }

    // shapes
    public void setShapes(ArrayList<Shape> newVar) { shapes = newVar; }
    public ArrayList<Shape> getShapes() { return shapes; }

    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    public void removeShape(Shape shape) {
        shapes.remove(shape);
    }

    @Override
    public String toString() {
        return "Layer[id=" + id + ", name=" + name + ", visible=" + visible + ", shapes=" + shapes + "]";
    }
}
