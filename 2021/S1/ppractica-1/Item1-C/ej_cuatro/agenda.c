// 20-05-2021
// el siguiente código hace uso de json-c https://github.com/json-c/json-c
// se compiló con gcc en ubuntu sin problemas
// lamentablemente no encontré una forma de momento
// para compilar en w10 incluyendo todo lo necesario (sin devc++)
// no obstante inclui en Makefile.txt el comando para compilar
// que podría funcionar mejorándolo
// adjunto una imagen del funcionamiento de agenda.exe
// cualquier duda puede contactarme
// - Jorge M.

#include <stdio.h>
#include <string.h>
#include <json-c/json.h>
#include <errno.h>

// para manejo a bajo nivel de archivos
#include <sys/types.h>
#include <sys/stat.h>

const char *ask_name()
{
    char *inputName;
    do
    {
        printf("Ingrese nombre a buscar (considere mayúsculas):\n");
        // regex para linea completa
        scanf("%[^\n]", inputName);
    } while (strlen(inputName) > 50);
    return inputName;
}

// return: -1 si existen errores
//          0 si el archivo está vacio
// fuente: https://stackoverflow.com/questions/8236
off_t checkfile(const char *filename)
{
    // propiedades del archivo a bajo nivel
    // me permite dejar de usar FILE*
    struct stat st;

    if (stat(filename, &st) == 0)
        return st.st_size;

    fprintf(stderr, "No se pudo determinar el tamaño de (agenda) %s: %s\n",
            filename, strerror(errno));

    return -1;
}

void buscar_fn()
{
    json_object *root, *temp;
    char *nameTemp;
    int n_personas;
    unsigned short int found = 0;
    unsigned short int isEmpty = 0;

    // para archivo completamente vacio
    if (checkfile("datos.json") == 0)
    {
        printf("\t\t-- El archivo está vacio --\n");
    }
    
    root = json_object_from_file("datos.json");

    const char* name = ask_name();

    json_object *personas = json_object_object_get(root, "personas");
    n_personas = json_object_array_length(personas);

    if (n_personas == 0)
    {
        isEmpty = 1;
    }

    for (int i = 0; i < n_personas; i++)
    {
        temp = json_object_array_get_idx(personas, i);
        json_object *nameObj = json_object_object_get(temp, "nombre");
        nameTemp = strdup(json_object_get_string(nameObj));
        if (strcmp(nameTemp, name) == 0)
        {
            json_object *telObj = json_object_object_get(temp, "tel");
            json_object *emailObj = json_object_object_get(temp, "email");
            printf("\t-- Se ha encontrado 1 coincidencia en la posición %d de un total de %d registros --\n", i + 1, n_personas);
            printf("\t%d.  Nombre: %s,  ", i + 1, nameTemp);
            printf("Celular: %s,   ", json_object_get_string(telObj));
            printf("Correo: %s\n", json_object_get_string(emailObj));
            found = 1;
            break;
        }
    }
    if (!found)
    {
        printf("\t\t\t%s\n", " -- No se han encontrado coincidencias para este nombre --");
        if (isEmpty)
        {
            printf("\t\t\t\t\t%s\n", " -- La agenda está vacía --");
        }
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
