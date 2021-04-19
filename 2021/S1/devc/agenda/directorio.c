#include <stdio.h>
#include <json-c/json.h>
#include <string.h>
// estructura de datos para un directorio personal
// 18-04-2021
// Jorge M.

void save_persona(const char *nombre, const char *direccion)
{
    const char *file_name = "datos_agenda.json";
    char *suffix = nombre[0]; 
    char *prefix = "per_";
    json_object *root = json_object_from_file("datos.json");

    strcat(prefix, suffix);
    const char *key = prefix;

    json_object *contactos = json_object_object_get(root, key);
    json_object *new_persona = json_object_new_object();

    json_object_object_add(new_persona, "nombre", json_object_new_string(nombre));
    json_object_object_add(new_persona, "direccion", json_object_new_string(direccion));
    json_object_array_add(contactos, new_persona);

    if (json_object_to_file_ext(file_name, root, JSON_C_TO_STRING_PRETTY)) 
    {
        printf("Error: no se pudo guardar %s!!\n", file_name);
    }
    else
    {
        printf("%s guardado.\n", file_name);
    }
    json_object_put(root); 
}

/*
 *  Muestra el nombre y direccion de una persona, selecciona de arrays
 *  agrupados por letra
 *
 *  @param idx indice de la persona a ser mostrada
 *  @param letra primera letra del 'objeto' a ser buscado
 */
void show_persona(int idx, char *letra)
{

}

int main(void)
{
    save_persona("Jorge Mainhard", "Avenida siempre viva 740");
    return 0;
}