package command;

import app.IdGenerator;
import app.PixelTracerApp;
import area.Area;
import area.Layer;
import shape.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Lit une commande sur stdin, la parse et l'exécute (équivalent de command.c).
 *
 * Codes de retour :
 *   0 = succès (redessine)   4 = exit     5 = clear
 *   6 = plot                 7 = help     8 = done (sans redessin)
 *   1 = commande inconnue    2 = vide     3 = mauvais paramètres
 *   9 = id inconnu
 */
public class CommandExecutor {

    private static final String[] ERROR_MESSAGES = {
        "",
        "commande inconnue",
        "commande manquante",
        "erreur parametres, consulter la commande help",
        "exit",
        "clear",
        "plot",
        "~~~ Help ~~~",
        "done",
        "id inconnu dans la list"
    };

    private static final Scanner scanner = new Scanner(System.in);

    // -------------------------------------------------------------------------
    // Lecture stdin
    // -------------------------------------------------------------------------

    public static Command readFromStdin() {
        Command cmd = new Command();
        System.out.print("~> ");
        if (!scanner.hasNextLine()) return cmd;

        String line = scanner.nextLine().toLowerCase();
        int hashIdx = line.indexOf('#');
        if (hashIdx >= 0) line = line.substring(0, hashIdx);
        line = line.trim();
        if (line.isEmpty()) return cmd;

        for (String token : line.split("\\s+")) {
            if (isWord(token)) {
                cmd.addStrParam(token);
            } else if (isInt(token)) {
                cmd.addIntParam(Integer.parseInt(token));
            } else {
                cmd.addStrParam("error");
            }
        }
        return cmd;
    }

    private static boolean isWord(String s) {
        if (s.isEmpty()) return false;
        for (char c : s.toCharArray())
            if (c < 'a' || c > 'z') return false;
        return true;
    }

    private static boolean isInt(String s) {
        if (s.isEmpty()) return false;
        for (char c : s.toCharArray())
            if (c < '0' || c > '9') return false;
        return true;
    }

    // -------------------------------------------------------------------------
    // Validation des paramètres
    // -------------------------------------------------------------------------

    private static boolean check(Command cmd, int nbStr, int nbInt, int nbFlt) {
        return cmd.getStrParams().size() == nbStr
            && cmd.getIntParams().size() == nbInt
            && cmd.getFltParams().size() == nbFlt;
    }

    private static boolean checkPolygon(Command cmd) {
        int n = cmd.getIntParams().size();
        return cmd.getStrParams().size() == 1
            && n >= 2 && n % 2 == 0
            && cmd.getFltParams().isEmpty();
    }

    // -------------------------------------------------------------------------
    // Point d'entrée principal
    // -------------------------------------------------------------------------

    public static int readAndExecute(PixelTracerApp app) {
        Command cmd = readFromStdin();
        int errorNum = dispatch(cmd, app);
        System.out.println(ERROR_MESSAGES[errorNum]);
        return errorNum;
    }

    // -------------------------------------------------------------------------
    // Dispatch des commandes
    // -------------------------------------------------------------------------

    private static int dispatch(Command cmd, PixelTracerApp app) {
        List<String> strs = cmd.getStrParams();
        List<Integer> ints = cmd.getIntParams();

        if (strs.isEmpty()) return 2;
        String name = strs.get(0);

        switch (name) {

            case "exit":
                if (!check(cmd, 1, 0, 0)) return 3;
                return 4;

            case "clear":
                if (!check(cmd, 1, 0, 0)) return 3;
                return 5;

            case "plot":
                if (!check(cmd, 1, 0, 0)) return 3;
                return 6;

            case "help":
                if (!check(cmd, 1, 0, 0)) return 3;
                printHelp();
                return 7;

            case "point": {
                if (!check(cmd, 1, 2, 0)) return 3;
                Point p = new Point();
                p.setId(IdGenerator.getNextId());
                p.setPos_x(ints.get(0));
                p.setPos_y(ints.get(1));
                app.getCurrentLayer().addShape(p);
                return 0;
            }

            case "line": {
                if (!check(cmd, 1, 4, 0)) return 3;
                Point p1 = new Point(); p1.setPos_x(ints.get(0)); p1.setPos_y(ints.get(1));
                Point p2 = new Point(); p2.setPos_x(ints.get(2)); p2.setPos_y(ints.get(3));
                Line line = new Line();
                line.setId(IdGenerator.getNextId());
                line.setP1(p1);
                line.setP2(p2);
                app.getCurrentLayer().addShape(line);
                return 0;
            }

            case "square": {
                if (!check(cmd, 1, 3, 0)) return 3;
                Point p = new Point(); p.setPos_x(ints.get(0)); p.setPos_y(ints.get(1));
                Square sq = new Square();
                sq.setId(IdGenerator.getNextId());
                sq.setP1(p);
                sq.setLength(ints.get(2));
                app.getCurrentLayer().addShape(sq);
                return 0;
            }

            case "rectangle": {
                if (!check(cmd, 1, 4, 0)) return 3;
                Point p = new Point(); p.setPos_x(ints.get(0)); p.setPos_y(ints.get(1));
                Rectangle rect = new Rectangle();
                rect.setId(IdGenerator.getNextId());
                rect.setP1(p);
                rect.setWidth(ints.get(2));
                rect.setHeight(ints.get(3));
                app.getCurrentLayer().addShape(rect);
                return 0;
            }

            case "circle": {
                if (!check(cmd, 1, 3, 0)) return 3;
                Point center = new Point(); center.setPos_x(ints.get(0)); center.setPos_y(ints.get(1));
                Cercle cercle = new Cercle();
                cercle.setId(IdGenerator.getNextId());
                cercle.setCenter(center);
                cercle.setRadius(ints.get(2));
                app.getCurrentLayer().addShape(cercle);
                return 0;
            }

            case "polygon": {
                if (!checkPolygon(cmd)) return 3;
                ArrayList<Point> points = new ArrayList<>();
                for (int i = 0; i < ints.size(); i += 2) {
                    Point pt = new Point();
                    pt.setPos_x(ints.get(i));
                    pt.setPos_y(ints.get(i + 1));
                    points.add(pt);
                }
                Polygone poly = new Polygone();
                poly.setId(IdGenerator.getNextId());
                poly.setPoints(points);
                app.getCurrentLayer().addShape(poly);
                return 0;
            }

            case "curve": {
                if (!check(cmd, 1, 8, 0)) return 3;
                Point p1 = new Point(); p1.setPos_x(ints.get(0)); p1.setPos_y(ints.get(1));
                Point p2 = new Point(); p2.setPos_x(ints.get(2)); p2.setPos_y(ints.get(3));
                Point p3 = new Point(); p3.setPos_x(ints.get(4)); p3.setPos_y(ints.get(5));
                Point p4 = new Point(); p4.setPos_x(ints.get(6)); p4.setPos_y(ints.get(7));
                Curve curve = new Curve();
                curve.setId(IdGenerator.getNextId());
                curve.setP1(p1); curve.setP2(p2); curve.setP3(p3); curve.setP4(p4);
                app.getCurrentLayer().addShape(curve);
                return 0;
            }

            case "list":   return dispatchList(cmd, app);
            case "new":    return dispatchNew(cmd, app);
            case "select": return dispatchSelect(cmd, app);
            case "delete": return dispatchDelete(cmd, app);
            case "set":    return dispatchSet(cmd, app);

            default:
                return 1;
        }
    }

    // -------------------------------------------------------------------------
    // Sous-commandes
    // -------------------------------------------------------------------------

    private static int dispatchList(Command cmd, PixelTracerApp app) {
        if (!check(cmd, 2, 0, 0)) return 3;
        switch (cmd.getStrParams().get(1)) {

            case "areas":
                for (Area area : app.getAreas()) {
                    String marker = (area == app.getCurrentArea()) ? " * " : " - ";
                    System.out.printf("%s %3d %s%n", marker, area.getId(), area.getName());
                }
                return 8;

            case "layers":
                for (Layer layer : app.getCurrentArea().getLayers()) {
                    String marker = (layer == app.getCurrentLayer()) ? " * " : " - ";
                    char vis = layer.isVisible() ? 'V' : 'H';
                    System.out.printf("%s %3d (%c) %s%n", marker, layer.getId(), vis, layer.getName());
                }
                return 8;

            case "shapes":
                for (Shape shape : app.getCurrentLayer().getShapes()) {
                    String marker = (shape == app.getCurrentShape()) ? " * " : " - ";
                    System.out.printf("%s %3d : %s %s%n", marker, shape.getId(),
                        shape.getClass().getSimpleName().toUpperCase(), shape);
                }
                return 8;

            default:
                return 3;
        }
    }

    private static int dispatchNew(Command cmd, PixelTracerApp app) {
        if (!check(cmd, 2, 0, 0)) return 3;
        switch (cmd.getStrParams().get(1)) {

            case "area": {
                Area area = new Area();
                area.setId((int) IdGenerator.getNextId());
                area.setName("area_name");
                area.setWidth(80);
                area.setHeight(40);
                app.addArea(area);
                app.setCurrentArea(area);
                Layer layer = new Layer();
                layer.setId((int) IdGenerator.getNextId());
                layer.setName("Layer 1");
                area.addLayer(layer);
                app.setCurrentLayer(layer);
                app.setCurrentShape(null);
                return 8;
            }

            case "layer": {
                Layer layer = new Layer();
                layer.setId((int) IdGenerator.getNextId());
                layer.setName("layer_name");
                app.getCurrentArea().addLayer(layer);
                app.setCurrentLayer(layer);
                app.setCurrentShape(null);
                return 8;
            }

            default:
                return 3;
        }
    }

    private static int dispatchSelect(Command cmd, PixelTracerApp app) {
        if (!check(cmd, 2, 1, 0)) return 3;
        String target = cmd.getStrParams().get(1);
        int id = cmd.getIntParams().get(0);

        switch (target) {

            case "area":
                for (Area area : app.getAreas()) {
                    if (area.getId() == id) {
                        app.setCurrentArea(area);
                        ArrayList<Layer> layers = area.getLayers();
                        app.setCurrentLayer(layers.get(layers.size() - 1));
                        app.setCurrentShape(null);
                        System.out.printf("%3d %s : selected%n", area.getId(), area.getName());
                        return 8;
                    }
                }
                return 9;

            case "layer":
                for (Layer layer : app.getCurrentArea().getLayers()) {
                    if (layer.getId() == id) {
                        app.setCurrentLayer(layer);
                        app.setCurrentShape(null);
                        return 8;
                    }
                }
                return 9;

            case "shape":
                for (Shape shape : app.getCurrentLayer().getShapes()) {
                    if (shape.getId() == id) {
                        app.setCurrentShape(shape);
                        return 8;
                    }
                }
                return 9;

            default:
                return 3;
        }
    }

    private static int dispatchDelete(Command cmd, PixelTracerApp app) {
        if (!check(cmd, 2, 1, 0)) return 3;
        if (!cmd.getStrParams().get(1).equals("shape")) return 3;

        int id = cmd.getIntParams().get(0);
        ArrayList<Shape> shapes = app.getCurrentLayer().getShapes();
        for (Shape shape : shapes) {
            if (shape.getId() == id) {
                shapes.remove(shape);
                app.setCurrentShape(null);
                return 8;
            }
        }
        return 9;
    }

    private static int dispatchSet(Command cmd, PixelTracerApp app) {
        if (!check(cmd, 3, 1, 0)) return 3;
        String sub1 = cmd.getStrParams().get(1);
        String sub2 = cmd.getStrParams().get(2);
        int val = cmd.getIntParams().get(0);

        if (sub1.equals("char")) {
            if (sub2.equals("border")) {
                app.getCurrentArea().setFullChar((char) val);
                return 0;
            }
            if (sub2.equals("background")) {
                app.getCurrentArea().setEmptyChar((char) val);
                return 0;
            }
            return 3;
        }

        if (sub1.equals("layer")) {
            if (sub2.equals("visible") || sub2.equals("unvisible")) {
                for (Layer layer : app.getCurrentArea().getLayers()) {
                    if (layer.getId() == val) {
                        layer.setVisible(sub2.equals("visible"));
                        return 0;
                    }
                }
                return 9;
            }
        }

        return 3;
    }

    // -------------------------------------------------------------------------
    // Aide
    // -------------------------------------------------------------------------

    private static void printHelp() {
        System.out.println("\t**************************************************");
        System.out.println("\t****         VECTOR TEXT-BASED EDITOR         ****");
        System.out.println("\t**************************************************");
        System.out.println("\t==== Control ====");
        System.out.println("\tclear : clear screen");
        System.out.println("\texit : exit the program");
        System.out.println("\thelp : print this help");
        System.out.println("\tplot : draw screen");
        System.out.println("\t==== Draw shapes ====");
        System.out.println("\tpoint px py : create point at position (px, py)");
        System.out.println("\tline x1 y1 x2 y2 : draw line from (x1,y1) to (x2,y2)");
        System.out.println("\tsquare x1 y1 l : draw square at (x1,y1) with length l");
        System.out.println("\trectangle x1 y1 w h : draw rectangle at (x1,y1) with width w height h");
        System.out.println("\tcircle x y r : center at (x,y) radius r");
        System.out.println("\tpolygon x1 y1 x2 y2 ... : draw polygon");
        System.out.println("\tcurve x1 y1 x2 y2 x3 y3 x4 y4 : draw Bezier curve");
        System.out.println("\t==== Draw manager ====");
        System.out.println("\tlist {layers, areas, shapes}");
        System.out.println("\tselect {area, layer, shape} {id}");
        System.out.println("\tdelete {area, layer, shape} {id}");
        System.out.println("\tnew {area, layer}");
        System.out.println("\t==== Set ====");
        System.out.println("\tset char {border, background} ascii_code");
        System.out.println("\tset layer {visible, unvisible} {id}");
    }
}
