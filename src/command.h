#ifndef _COMMAND_H_
#  define _COMMAND_H_

#  define MAX_PARAM 30

#  include <stdlib.h>
#  include <string.h>
#  include <stdio.h>

#  include <readline/readline.h>
#  include <readline/history.h>
#  include "pixel_tracer.h"

/**
 * @brief Représente une commande saisie par l'utilisateur.
 *
 * Après parsing de la ligne stdin, les tokens sont répartis dans trois
 * tableaux selon leur type : mots (str_params), entiers (int_params) et
 * flottants (flt_params). Le premier str_param est toujours le nom de la
 * commande.
 */
struct command {
    char name[50];
    int int_size;
    int int_params[MAX_PARAM];
    int str_size;
    char *str_params[MAX_PARAM];
    int flt_size;
    float flt_params[MAX_PARAM];
};

typedef struct command Command;

Command *create_commande();

void add_int_param(Command * cmd, int p);
void add_float_param(Command * cmd, float p);
void add_str_param(Command * cmd, char *p);

/**
 * @brief Libère les chaînes allouées dans str_params.
 */
void free_cmd(Command * cmd);

/**
 * @brief Lit une ligne stdin, parse les tokens et exécute la commande.
 *
 * Retourne un code d'erreur :
 *   0 = succès (redessine), 4 = exit, 5 = clear screen,
 *   6 = plot, 7/8 = continuer sans redessiner, autres = erreur.
 */
int read_exec_command(Pixel_tracer_app * app);

/**
 * @brief Lit et parse une ligne depuis stdin dans cmd.
 *
 * Utilise readline pour l'historique. Chaque token est classé comme
 * mot, entier ou flottant et ajouté dans le tableau correspondant.
 * Les commentaires (#) et retours à la ligne sont supprimés.
 */
void read_from_stdin(Command * cmd);

#endif
