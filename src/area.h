#include <stdlib.h>
#include <stdio.h>
#include "layers.h"

#ifndef _AREA_H_
#  define _AREA_H_


/**
 * @brief Zone de dessin ASCII.
 *
 * Une area est une grille 2D de caractères (width x height) sur laquelle
 * les layers et leurs shapes sont rendus. Les caractères empty_char et
 * full_char définissent l'aspect visuel du fond et des formes.
 */
struct area {
    unsigned char id;
    char name[255];
    unsigned int width;
    unsigned int height;
    char **area;
    LayersList *lst_layers;
    char empty_char;
    char full_char;
};

typedef struct area Area;

typedef list AreaList;

/**
 * @brief Crée une area et alloue sa grille 2D.
 */
Area *create_area(unsigned int width, unsigned int height,
                  unsigned char id, char *name);
                  
/**
 * @brief Libère la grille 2D et la structure area. 
 * @note Les layers ne sont pas encore supprimés (TODO).
 */
void delete_area(Area * area);

/**
 * @brief Remet toutes les cellules de la grille à EMPTY_CELL.
 */
void clear_area(Area * area);


AreaList *create_area_list();

void delete_area_list(AreaList * area_list);

void add_area_to_list(AreaList * area_list, Area * area);

void remove_area_from_list(AreaList * area_list, Area * area);




#endif
