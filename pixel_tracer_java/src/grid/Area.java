package area;

import java.util.ArrayList;

/**
 * Class Area
 * Zone de dessin ASCII : grille 2D de caractères (width x height)
 * sur laquelle les layers et leurs shapes sont rendus.
 */
public class Area {

    private int id;
    private String name;
    private int width;
    private int height;
    private char emptyChar;
    private char fullChar;
    private char[][] grid;
    private ArrayList<Layer> layers;

    public Area() {
        this.emptyChar = '.';  // valeurs par défaut du C
        this.fullChar = '@';
        this.layers = new ArrayList<>();
    }

    // id
    public void setId(int newVar) { id = newVar; }
    public int getId() { return id; }

    // name
    public void setName(String newVar) { name = newVar; }
    public String getName() { return name; }

    // width
    public void setWidth(int newVar) {
        width = newVar;
        initGrid();
    }
    public int getWidth() { return width; }

    // height
    public void setHeight(int newVar) {
        height = newVar;
        initGrid();
    }
    public int getHeight() { return height; }

    // emptyChar
    public void setEmptyChar(char newVar) { emptyChar = newVar; }
    public char getEmptyChar() { return emptyChar; }

    // fullChar
    public void setFullChar(char newVar) { fullChar = newVar; }
    public char getFullChar() { return fullChar; }

    // grid
    public char[][] getGrid() { return grid; }

    /**
     * Initialise la grille dès que width et height sont tous les deux définis.
     */
    private void initGrid() {
        if (width > 0 && height > 0) {
            grid = new char[height][width];
            clearArea();
        }
    }

    /**
     * Remet toutes les cellules de la grille à emptyChar.
     */
    public void clearArea() {
        if (grid == null) return;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                grid[i][j] = emptyChar;
            }
        }
    }

    // layers
    public void setLayers(ArrayList<Layer> newVar) { layers = newVar; }
    public ArrayList<Layer> getLayers() { return layers; }

    public void addLayer(Layer layer) {
        layers.add(layer);
    }

    public void removeLayer(Layer layer) {
        layers.remove(layer);
    }

    @Override
    public String toString() {
        return "Area[id=" + id + ", name=" + name + ", width=" + width + ", height=" + height
                + ", emptyChar=" + emptyChar + ", fullChar=" + fullChar + ", layers=" + layers + "]";
    }
}
