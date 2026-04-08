#ifndef _PIXEL_TRACER_H_
#  define _PIXEL_TRACER_H_

#  include "list.h"
#  include "id.h"
#  include "area.h"
#  include "layers.h"
#  include "shape.h"
#  include "pixel.h"
#  include "render.h"

/**
 * @brief Structure principale de l'application.
 *
 * Contient la liste de toutes les areas ainsi que les pointeurs
 * vers l'area, le layer et la shape actuellement sélectionnés.
 */
struct pixel_tracer {
    AreaList *list_area;
    Area *current_area;
    Layer *current_layer;
    Shape *current_shape;
};

typedef struct pixel_tracer Pixel_tracer_app;

/**
 * @brief Initialise l'application avec une area (80x40) et un layer par défaut.
 */
void init_app(Pixel_tracer_app * app);

/**
 * @brief Libère toutes les ressources de l'application.
 */
void destry_app(Pixel_tracer_app * app);

#endif
