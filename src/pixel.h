#ifndef _PIXEL_H_
#  define _PIXEL_H_

#  include <stdlib.h>
#  include "shape.h"
#  include "list.h"

struct pixel {
    int px;   /**< ligne (axe y de l'area) */
    int py;   /**< colonne (axe x de l'area) */
    int color;
};
typedef struct pixel Pixel;

/**
 * @brief Convertit une Shape en liste de Pixel prêts à être placés dans la grille.
 *
 * Dispatch vers la fonction pixel_xxx correspondante selon shape_type.
 * Retourne NULL si ptrShape est NULL.
 */
list *create_shape_to_pixel(Shape * shape);

/**
 * @brief Libère la liste de pixels produite par create_shape_to_pixel.
 * @note Non implémenté (TODO).
 */
void remove_pixel_shape(list * pixel_lst);

/* Fonctions internes — une par type de forme */
Pixel *create_pixel(int px, int py, int color);
void delete_pixel(Pixel * pixel);

void pixel_point(Shape * shape, list * lst);
void pixel_line(Shape * shape, list * lst);
void pixel_cercle(Shape * shape, list * lst);
void pixel_rectangle(Shape * shape, list * lst);
void pixel_square(Shape * shape, list * lst);
void pixel_polygon(Shape * shape, list * lst);

/**
 * @brief Trace une courbe de Bézier cubique par l'algorithme de Casteljau.
 *
 * Échantillonne t de 0 à 1 par pas de 0.0001 et génère un pixel par pas.
 */
void pixel_curve(Shape * shape, list * lst);

#endif
