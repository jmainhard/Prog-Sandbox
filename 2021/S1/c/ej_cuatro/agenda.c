// 20-05-2021
// el siguiente código hace uso de json-c
// se compiló con gcc en ubuntu sin problemas
// lamentablemente no encontré una forma de momento
// para compilar en w10 incluyendo todo lo necesario
// no obstante inclui en Makefile.txt el comando para compilar
// que podría funcionar mejorándolo
// adjunto una imagen del funcionamiento de agenda.exe
// cualquier duda puede contactarme
// - Jorge M.

#include <stdio.h>
#include <string.h>
#include <json-c/json.h>

const char *ask_name()
{
    char *inputName;
    do {
        printf("\nIngrese nombre a buscar (considere mayúsculas):\n");
        scanf("%[^\n]", inputName);
    } while (strlen(inputName) > 50);
    return inputName;
}

void buscar_fn()
{
    json_object *root, *temp;
    char *nameTemp;
    int n_personas;
    unsigned short int flag = 0;

    root = json_object_from_file("datos.json");
    const char *name = ask_name();

    json_object *personas = json_object_object_get(root, "personas");
    n_personas = json_object_array_length(personas);
    for (int i = 0; i < n_personas; i++)
    {
        temp = json_object_array_get_idx(personas, i);
        json_object *nameObj = json_object_object_get(temp, "nombre");
        nameTemp = strdup(json_object_get_string(nameObj)); 
        if (strcmp(nameTemp, name) == 0)
        {
            json_object *telObj = json_object_object_get(temp, "tel");
            json_object *emailObj = json_object_object_get(temp, "email");
            printf("\t-- Se ha encontrado 1 coincidencia en la posición %d de un total de %d registros --\n", i+1, n_personas);
            printf("\t%d.  Nombre: %s,  ", i+1, nameTemp);
            printf("Celular: %s,   ", json_object_get_string(telObj));
            printf("Correo: %s\n", json_object_get_string(emailObj));
            flag = 1;
            break;
        }
    }
    if (!flag)
    {
        printf("\t\t\t%s\n", " -- No se han encontrado coincidencias para este nombre --");
    }
    else // ui
    {
    printf("\t\t\t\t\t%s\n", "--  <>  --");
    }

    // liberar memoria (archivo)
    json_object_put(root);
}

int main(int argc, char const *argv[])
{
    buscar_fn();
    return 0;
}

