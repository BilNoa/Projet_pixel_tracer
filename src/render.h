#include <stdlib.h>
#include <stdio.h>
#include "layers.h"
#include "area.h"
#include "pixel.h"

#ifndef _RENDER_H_
#  define _RENDER_H_

typedef enum { EMPTY_CELL, BLACK_CELL, RED_CELL } color_cell;

#  define EMPTY_CHAR '.'
#  define FULL_CHAR  '#'

/**
 * @brief Affiche la grille de l'area caractère par caractère.
 * 
 * Parcourt area->area[][] et imprime empty_char ou full_char selon la valeur
 * de chaque cellule.
 */
void draw_area(Area * area);

/**
 * @brief Efface le terminal (compatible Linux / Windows).
 */
void clear_screen();

/**
 * @brief Convertit les shapes d'un layer en pixels et les écrit dans la grille.
 *
 * Pour chaque shape du layer, génère la liste de pixels via create_shape_to_pixel()
 * puis marque les cellules correspondantes à FULL_CHAR dans area->area[][].
 * Les pixels hors bornes sont ignorés.
 */
void draw_layer_shapes(Area * area, Layer * layer);

/**
 * @brief Remet la grille à zéro puis dessine tous les layers visibles.
 *
 * Appelle clear_area() puis draw_layer_shapes() pour chaque layer dont
 * visible == LAYER_VISIBLE, dans l'ordre de la liste.
 */
void draw_all_layers(Area * area);

#endif
