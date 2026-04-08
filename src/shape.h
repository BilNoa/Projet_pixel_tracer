#ifndef _SHAPE_H_
#  define _SHAPE_H_

/**
 * @brief Types de formes supportées.
 */
typedef enum shape_type { POINT, LINE, SQUAR, RECTANGLE, CERCLE,
    POLYGON, CURVE
} Shape_type;

typedef enum color { BLACK, WIGHT, RED, GREEN } Color;

struct point {
    int pos_x;
    int pos_y;
};
typedef struct point Point;

struct line {
    Point *p1;
    Point *p2;
};
typedef struct line Line;

struct squar {
    Point *p1;
    int length;
};
typedef struct squar Squar;

struct rectangle {
    Point *p1;
    int width;
    int height;
};
typedef struct rectangle Rectangle;

struct cercle {
    Point *center;
    int radus;
};
typedef struct cercle Cercle;

struct polygon {
    int n;          /**< Nombre de sommets */
    Point **points;
};
typedef struct polygon Polygon;

/**
 * @brief Courbe de Bézier cubique définie par 4 points de contrôle.
 */
struct curve {
    Point *p1;
    Point *p2;
    Point *p3;
    Point *p4;
};
typedef struct curve Curve;

/**
 * @brief Conteneur générique pour toutes les formes.
 *
 * ptrShape pointe vers la structure concrète (Point, Line, etc.)
 * selon la valeur de shape_type.
 */
struct shape {
    unsigned long long int id;
    Shape_type shape_type;
    void *ptrShape;
    unsigned char fill;
    float thickness;
    Color color;
    double rotation;
};
typedef struct shape Shape;

/* Constructeurs / destructeurs internes */
Point *create_point(int px, int py);
void delete_point(Point * point);
Line *create_line(Point * p1, Point * p2);
void delete_line(Line * line);
Squar *create_squar(Point * point, int legth);
void delete_squar(Squar * squar);
Rectangle *create_rectangle(Point * point, int width, int height);
void delete_rectangle(Rectangle * rectangle);
Cercle *create_cercle(Point * center, int radus);
void delete_cercle(Cercle * cercle);
Polygon *create_polygon(int n);
void delete_polygon(Polygon * polygon);
Curve *create_curve(Point * p1, Point * p2, Point * p3, Point * p4);
void delete_curve(Curve * curve);

/** @brief Alloue un Shape avec id, type et valeurs par défaut. ptrShape = NULL. */
Shape *create_empty_shape(Shape_type shape_type);

/* Sérialisation en chaîne pour l'affichage (list shapes) */
void sprint_point(Point * p, char *str);
void sprint_line(Line * line, char *str);
void sprint_squar(Squar * squar, char *str);
void sprint_rectangle(Rectangle * rectangle, char *str);
void sprint_cercle(Cercle * cercle, char *str);
void sprint_polygon(Polygon * polygon, char *str);
void sprint_curve(Curve * curve, char *str);

/**
 * Fonctions publiques — à utiliser depuis l'extérieur du module.
 * Chaque fonction crée un Shape complet avec son ptrShape initialisé.
 */
Shape *create_point_shape(int px, int py);
Shape *create_line_shape(int px1, int py1, int px2, int py2);
Shape *create_square_shape(int px, int py, int length);
Shape *create_rectangle_shape(int px, int py, int width, int height);
Shape *create_cercle_shape(int px, int py, int radus);
Shape *create_polygon_shape(int n, int *tab); /**< tab : tableau de n coordonnées (x,y) interleaved, n doit être pair */
Shape *create_curve_shape(int px1, int py1, int px2, int py2, int px3,
                          int py3, int px4, int py4);

/** @brief Libère le Shape et sa forme interne selon shape_type. */
void delete_shape(Shape * shape);

/** @brief Écrit les paramètres de la forme dans str (pour affichage). */
void sprint_shape(Shape * shape, char *str);

#endif
