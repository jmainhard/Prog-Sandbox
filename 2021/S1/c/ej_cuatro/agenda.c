#include <stdio.h>
#include <string.h>
#include <json-c/json.h>

void buscar_fn()
{
    json_object *root, *temp;
    char *telTemp, *nombre;
    int edad, n_personas;
    unsigned short int flag = 0;

    root = json_object_from_file("datos.json");
    const char *tel = "+56946580611";

    json_object *personas = json_object_object_get(root, "personas");
    n_personas = json_object_array_length(personas);
    for (int i = 0; i < n_personas; i++)
    {
        temp = json_object_array_get_idx(personas, i);
        json_object *telObj = json_object_object_get(temp, "tel");
        telTemp = strdup(json_object_get_string(telObj)); 
        if (strcmp(telTemp, tel) == 0)
        {
            json_object *nameObj = json_object_object_get(temp, "nombre");
            json_object *emailObj = json_object_object_get(temp, "email");
            printf("\t\t\t%s\n", " -- Persona encontrada --");
            printf("\t%d.  Nombre: %s,  ", i+1, json_object_get_string(nameObj));
            printf("Celular: %s,   ", json_object_get_string(telObj));
            printf("Correo: %s\n", json_object_get_string(emailObj));
            flag = 1;
            break;
        }
    }
    if (!flag)
    {
        printf("\t\t\t%s\n", " -- Persona no encontrada --");
    }
    else // innecesario la verdad
    {
        printf("\t\t\t\t%s\n", "--  <>  --");
    }
    json_object_put(root);
}

int main(int argc, char const *argv[])
{
    buscar_fn();
    return 0;
}

