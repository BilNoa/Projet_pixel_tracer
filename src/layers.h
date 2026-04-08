#include "list.h"
#include "shape.h"
#include <stdlib.h>
#include <string.h>

#ifndef _LAYERS_H_
#  define _LAYERS_H_

#  define LAYER_VISIBLE   1
#  define LAYER_UNVISIBLE 0

/**
 * @brief Un layer contient une liste de shapes et un flag de visibilité.
 *
 * Seuls les layers avec visible == LAYER_VISIBLE sont rendus par draw_all_layers().
 */
struct layer {
    unsigned int id;
    char name[255];
    unsigned char visible;
    list shapes;
};
typedef struct layer Layer;

typedef list LayersList;

/**
 * @brief Crée un layer. visible est initialisé à 1 (affiché par défaut).
 */
Layer *create_layer(int id, char *name);

/**
 * @brief Libère les shapes du layer puis le layer lui-même.
 */
void delete_layer(Layer * layer);

LayersList *create_layers_list();
void delete_layers_list(LayersList * layer_list);
void add_layer_to_list(LayersList * layer_list, Layer * layer);
void remove_layer_from_list(LayersList * layer_list, Layer * layer); /* TODO */

void set_layer_visible(Layer * layer);
void set_layer_unvisible(Layer * layer);

void add_shape_to_layer(Layer * layer, Shape * shape);
void remove_shape_to_from(Layer * layer, Shape * shape); /* TODO */

#endif
