#include <stdio.h>
#include <string.h>
#include <json-c/json.h>
// ACTIVIDAD
// Hacer Menu con las siguientes opciones 
// 1. realizar busqueda por rut,
// 2. cantidad de registros totales
// 3. promedio de edad total,
// 4. registro de mayor y menor edad
// Agregar 10 registros mínimo.

// 10-04-2021
// Jorge M.

struct persona
{
    char *rut;
    char *nombre;
    int edad;
};


// int menu() 
// {
// 	unsigned short opcion = 0;
// 	while (opcion >= 0 && opcion < 5) {
// 	  printf("%s\n", "[1] - Buscar por rut");
// 	  printf("%s\n", "[2] - Cantidad de registros");
// 	  printf("%s\n", "[3] - Promedio de las edades");
// 	  printf("%s\n", "[4] - Mayor y menor edad");
// 	  printf("%s\n", "[5] - Salir");
// 	  scanf("%hu", &opcion);
// 	  switch (opcion) {
// 		case 1:
// 			opcion = 0;
// 			break;
// 		case 2:
// 			opcion = 0;
// 			break;
// 		case 3:
// 			break;
// 		case 4:
// 			break;
// 		case 5:
// 			return 0;
// 		default:
// 			opcion = 0;
// 			break;
// 	  }
// 	}
// }

// deprecated
void leer_json()
{
    FILE *fp; // file pointer
    char buffer[1024];

    // estructura con el documento json parseado
    struct json_object *parsed_json; 

    struct json_object *rut; 
    struct json_object *nombre; 
    struct json_object *edad; 

    fp = fopen("datos.json", "r");
    fread(buffer, 1024, 1, fp);
    fclose(fp);

    parsed_json = json_tokener_parse(buffer);

    // convierte cada atributo a un json object
    json_object_object_get_ex(parsed_json, "rut", &rut); 
    json_object_object_get_ex(parsed_json, "nombre", &nombre);
    json_object_object_get_ex(parsed_json, "edad", &edad);

    // métodos de json-c para rescatar el valor
    printf("RUT. %s\n", json_object_get_string(rut));
    printf("NOMBRE. %s\n", json_object_get_string(nombre));
    printf("EDAD. %d\n", json_object_get_int(edad));
}

void buscar_fn(const char **rut)
{
    json_object *root, *temp;
    char *rutTemp, *nombre;
    int edad, n_personas;

    root = json_object_from_file("datos.json");

    json_object *personas = json_object_object_get(root, "personas");
    n_personas = json_object_array_length(personas);
    printf("%s\n", rut);
    for (int i = 0; i < n_personas; i++)
    {
        temp = json_object_array_get_idx(personas, i);
        json_object *rutObj = json_object_object_get(temp, "rut");
        rutTemp = strdup(json_object_get_string(rutObj)); 
        printf("%s, ", rutTemp);
        printf("%s\n", rut);
        if (strcmp(rutTemp,rut) == 0)
        {
            json_object *nameObj = json_object_object_get(temp, "nombre");
            json_object *ageObj = json_object_object_get(temp, "edad");
            printf("\t\t\t%s\n", " -- Persona encontrada --");
            printf("\t%d.  Rut: %s,  ", i+1, json_object_get_string(rutObj));
            printf("Nombre: %s,   ", json_object_get_string(nameObj));
            printf("Edad: %d\n", json_object_get_int(ageObj));
            break;
        }
    }
    json_object_put(root);
}

const char *ask_rut()
{
    char *inputRut;
    do {
        printf("\nIngrese rut a buscar: (sin puntos, con guion)\n");
        scanf("%s", inputRut);
    } while (strlen(inputRut) > 10);
    return inputRut+'\0';
}

struct persona get_persona(int idx)
{
    struct persona personaOut;
    json_object *root, *temp;
    int n_personas;

    root = json_object_from_file("datos.json");
    if (!root)
       return personaOut;

    char *rut, *nombre;
    int edad;


    json_object *personas = json_object_object_get(root, "personas");
    n_personas = json_object_array_length(personas);


    for (int i = 0; i < n_personas; i++)
    {
        temp = json_object_array_get_idx(personas, i);
        json_object *rutObj = json_object_object_get(temp, "rut");
        json_object *nameObj = json_object_object_get(temp, "nombre");
        json_object *ageObj = json_object_object_get(temp, "edad");
        printf("\t%d.  Rut: %s,  ", i+1, json_object_get_string(rutObj));
        printf("Nombre: %s,   ", json_object_get_string(nameObj));
        printf("Edad: %d\n", json_object_get_int(ageObj));
    }
    
    // convierte cada atributo a un json object
    json_object *rut_persona = json_object_object_get(root, "rut");
    json_object *nombre_persona = json_object_object_get(root, "nombre");
    json_object *edad_persona = json_object_object_get(root, "edad");
    
    // Store the string values of these json_objects in our char arrays
    rut = strdup(json_object_get_string(rut_persona)); 
    nombre = strdup(json_object_get_string(nombre_persona)); 
    edad = json_object_get_int(edad_persona); 

    // Lose ownership of our json_objects
    // json_object_put(root);

    personaOut.rut = rut;
    personaOut.nombre = nombre;
    personaOut.edad = edad;
   
    // Cleanup
    // free(rut);
    // free(nombre);

    return personaOut;
}

void mostrar_persona(struct persona persona)
{
    printf("RUT. %s\n", persona.rut);
    printf("NOMBRE. %s\n", persona.nombre);
    printf("EDAD. %d\n", persona.edad);
}

int main(void) 
{
    const char *rut = ask_rut();
    printf("_DEBUG\n");
    buscar_fn(*rut);
    return 0;
}
