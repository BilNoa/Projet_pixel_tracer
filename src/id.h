#ifndef _ID_H_
#  define _ID_H_

#  define ID_FILE "id.txt"

/**
 * @brief Retourne le prochain identifiant unique global (auto-incrémenté).
 * 
 * Utilisé à la création de chaque Area, Layer et Shape.
 */
unsigned long long int get_next_id();

void set_id(unsigned long long int id);

/**
 * @brief Sauvegarde / restaure l'état du compteur dans ID_FILE.
 * @note Non implémenté (TODO).
 */
void save_id();
void load_id();

#endif
