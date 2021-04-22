#include <stdio.h>
#include <json-c/json.h>
#include <string.h>
// estructura de datos para un directorio personal
// 18-04-2021
// Jorge M.

int save_persona(const char *nombre, const char *direccion)
{
    const char *file_name = "datos_agenda.json";
    const char *key;

    // queria hacerlo mas elegante juntando "per_" con la primera letra de su nombre
    // pero ya me fundí
    // (esto es horrible)
    if (nombre[0] == 'a' || nombre[0] == 'A')
    {
        key = "per_a";    
    }
    else if (nombre[0] == 'b' || nombre[0] == 'B')
    {
        key = "per_b";
    }
    else if (nombre[0] == 'c' || nombre[0] == 'C')
    {
        key = "per_c";
    }
    else if (nombre[0] == 'd' || nombre[0] == 'D')
    {
        key = "per_d";
    }
    else if (nombre[0] == 'e' || nombre[0] == 'E')
    {
        key = "per_e";
    }
    else if (nombre[0] == 'f' || nombre[0] == 'F')
    {
        key = "per_f";
    }
    else if (nombre[0] == 'g' || nombre[0] == 'G')
    {
        key = "per_g";
    }
    else if (nombre[0] == 'h' || nombre[0] == 'H')
    {
        key = "per_h";
    }
    else if (nombre[0] == 'i' || nombre[0] == 'I')
    {
        key = "per_i";
    }
    else if (nombre[0] == 'j' || nombre[0] == 'J')
    {
        key = "per_j";
    }
    else if (nombre[0] == 'k' || nombre[0] == 'K')
    {
        key = "per_k";
    }
    else if (nombre[0] == 'l' || nombre[0] == 'L')
    {
        key = "per_l";
    }
    else if (nombre[0] == 'm' || nombre[0] == 'M')
    {
        key = "per_m";
    }
    else if (nombre[0] == 'n' || nombre[0] == 'N')
    {
        key = "per_n";
    }
    /* // clasificación particular para nombres con ñ no implementada
    else if (nombre[0] == 164 || nombre[0] == 165) 
    {
        key = "per_nn";
    }
    */
    else if (nombre[0] == 'o' || nombre[0] == 'O')
    {
        key = "per_o";
    }
    else if (nombre[0] == 'p' || nombre[0] == 'P')
    {
        key = "per_p";
    }
    else if (nombre[0] == 'q' || nombre[0] == 'Q')
    {
        key = "per_q";
    }
    else if (nombre[0] == 'r' || nombre[0] == 'R')
    {
        key = "per_r";
    }
    else if (nombre[0] == 's' || nombre[0] == 'S')
    {
        key = "per_s";
    }
    else if (nombre[0] == 't' || nombre[0] == 'T')
    {
        key = "per_t";
    }
    else if (nombre[0] == 'u' || nombre[0] == 'U')
    {
        key = "per_u";
    }
    else if (nombre[0] == 'v' || nombre[0] == 'V')
    {
        key = "per_v";
    }
    else if (nombre[0] == 'w' || nombre[0] == 'W')
    {
        key = "per_w";
    }
    else if (nombre[0] == 'x' || nombre[0] == 'X')
    {
        key = "per_x";
    }
    else if (nombre[0] == 'y' || nombre[0] == 'Y')
    {
        key = "per_y";
    }
    else if (nombre[0] == 'z' || nombre[0] == 'Z')
    {
        key = "per_z";
    }

    // importante primero generar el objecto json
    json_object *root = json_object_new_object();
    // despues rescatar el objeto de la ruta
    root = json_object_from_file("datos_agenda.json");
    
    json_object *contactos = json_object_object_get(root, key);
    json_object *new_persona = json_object_new_object();

    json_object_object_add(new_persona, "nombre", json_object_new_string(nombre));
    json_object_object_add(new_persona, "direccion", json_object_new_string(direccion));
    json_object_array_add(contactos, new_persona);

    if (json_object_to_file_ext(file_name, root, JSON_C_TO_STRING_PRETTY)) 
    {
        printf("Error: no se pudo guardar %s!!\n", file_name);
        return -1;
    }
    else
    {
        printf("%s guardado.\n", file_name);
        return 0;
    }
    json_object_put(root); 
}

/*
 *  Muestra el nombre y direccion las personas, agrupadas en un array
 *  según letra_categoria
 *
 *  @param letra_categoria primera letra_categoria del 'objeto' a ser buscado
 */
void show_personas(char letra_categoria)
{
    json_object *root, *temp;
    const char *key;
    int n_personas_categoria;
    
    
    
    // de nuevo esta cosa fea me disculpo
    if (letra_categoria == 'a' || letra_categoria == 'A')
    {
        key = "per_a";    
    }
    else if (letra_categoria == 'b' || letra_categoria == 'B')
    {
        key = "per_b";
    }
    else if (letra_categoria == 'c' || letra_categoria == 'C')
    {
        key = "per_c";
    }
    else if (letra_categoria == 'd' || letra_categoria == 'D')
    {
        key = "per_d";
    }
    else if (letra_categoria == 'e' || letra_categoria == 'E')
    {
        key = "per_e";
    }
    else if (letra_categoria == 'f' || letra_categoria == 'F')
    {
        key = "per_f";
    }
    else if (letra_categoria == 'g' || letra_categoria == 'G')
    {
        key = "per_g";
    }
    else if (letra_categoria == 'h' || letra_categoria == 'H')
    {
        key = "per_h";
    }
    else if (letra_categoria == 'i' || letra_categoria == 'I')
    {
        key = "per_i";
    }
    else if (letra_categoria == 'j' || letra_categoria == 'J')
    {
        key = "per_j";
    }
    else if (letra_categoria == 'k' || letra_categoria == 'K')
    {
        key = "per_k";
    }
    else if (letra_categoria == 'l' || letra_categoria == 'L')
    {
        key = "per_l";
    }
    else if (letra_categoria == 'm' || letra_categoria == 'M')
    {
        key = "per_m";
    }
    else if (letra_categoria == 'n' || letra_categoria == 'N')
    {
        key = "per_n";
    }
    /* // clasificación particular para nombres con ñ no implementada
    else if (letra_categoria == 164 || letra_categoria == 165) 
    {
        key = "per_nn";
    }
    */
    else if (letra_categoria == 'o' || letra_categoria == 'O')
    {
        key = "per_o";
    }
    else if (letra_categoria == 'p' || letra_categoria == 'P')
    {
        key = "per_p";
    }
    else if (letra_categoria == 'q' || letra_categoria == 'Q')
    {
        key = "per_q";
    }
    else if (letra_categoria == 'r' || letra_categoria == 'R')
    {
        key = "per_r";
    }
    else if (letra_categoria == 's' || letra_categoria == 'S')
    {
        key = "per_s";
    }
    else if (letra_categoria == 't' || letra_categoria == 'T')
    {
        key = "per_t";
    }
    else if (letra_categoria == 'u' || letra_categoria == 'U')
    {
        key = "per_u";
    }
    else if (letra_categoria == 'v' || letra_categoria == 'V')
    {
        key = "per_v";
    }
    else if (letra_categoria == 'w' || letra_categoria == 'W')
    {
        key = "per_w";
    }
    else if (letra_categoria == 'x' || letra_categoria == 'X')
    {
        key = "per_x";
    }
    else if (letra_categoria == 'y' || letra_categoria == 'Y')
    {
        key = "per_y";
    }
    else if (letra_categoria == 'z' || letra_categoria == 'Z')
    {
        key = "per_z";
    }
    
    printf("_key_:%s\n", key);

    root = json_object_from_file("datos_agenda.json");

    json_object *contactos = json_object_object_get(root, key);
    n_personas_categoria = json_object_array_length(contactos);
    for (int i = 0; i < n_personas_categoria; i++)
    {
        temp = json_object_array_get_idx(contactos, i);
        json_object *nom_obj = json_object_object_get(temp, "nombre");
        json_object *dir_obj = json_object_object_get(temp, "direccion");
        printf("%s, %s\n", json_object_get_string(nom_obj), json_object_get_string(dir_obj));
    }

    json_object_put(root); 
}

char ask_letra_categoria()
{
    char letra;
    printf("Ingrese letra de búsqueda [aA-zZ] excluyendo %c (n tilde)\n", (char) 164);
    printf("%s\n", "(Ctrl + C para salir)");
    scanf("%c", &letra);
    return letra;
}

int main(void)
{
    // save_persona("a", "dir");
    // save_persona("A", "dir");
    // save_persona("b", "dir");
    // save_persona("B", "dir");
    // save_persona("c", "dir");
    // save_persona("C", "dir");
    // save_persona("d", "dir");
    // save_persona("D", "dir");
    // save_persona("e", "dir");
    // save_persona("E", "dir");
    // save_persona("f", "dir");
    // save_persona("F", "dir");
    // save_persona("g", "dir");
    // save_persona("G", "dir");
    // save_persona("h", "dir");
    // save_persona("H", "dir");
    // save_persona("i", "dir");
    // save_persona("I", "dir");
    // save_persona("j", "dir");
    // save_persona("J", "dir");
    // save_persona("k", "dir");
    // save_persona("K", "dir");
    // save_persona("l", "dir");
    // save_persona("L", "dir");
    // save_persona("m", "dir");
    // save_persona("M", "dir");
    // save_persona("n", "dir");
    // save_persona("N", "dir");
    // save_persona("ñ", "dir");
    // save_persona("Ñ", "dir");
    // save_persona("o", "dir");
    // save_persona("O", "dir");
    // save_persona("p", "dir");
    // save_persona("P", "dir");
    // save_persona("q", "dir");
    // save_persona("Q", "dir");
    // save_persona("r", "dir");
    // save_persona("R", "dir");
    // save_persona("s", "dir");
    // save_persona("S", "dir");
    // save_persona("t", "dir");
    // save_persona("T", "dir");
    // save_persona("u", "dir");
    // save_persona("U", "dir");
    // save_persona("v", "dir");
    // save_persona("V", "dir");
    // save_persona("x", "dir");
    // save_persona("X", "dir");
    // save_persona("y", "dir");
    // save_persona("Y", "dir");
    // save_persona("z", "dir");
    // save_persona("Z", "dir");
    // prevenir introduccion de indice mayor que el tamaño del arr
    // show_personas('a');
    // show_personas('z');

    // profe: no tuve mucho tiempo para mejorar este código, las entradas no son dinámicas :(
    // me falta mejorar punteros
//    show_personas('a');
//    show_personas('b');
//    show_personas('n');
//    show_personas('z');
    
    
    return 0;
}