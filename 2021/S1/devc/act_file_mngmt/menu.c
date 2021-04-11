#include <stdio.h>
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


// void menu() 
// {
// 	unsigned short opcion = 0;
// 	while (opcion >= 0 && opcion < 5) {
// 	  printf("%s\n", "[1] - USD to EUR");
// 	  printf("%s\n", "[2] - EUR to USD");
// 	  printf("%s\n", "[3] - Area y perimetro");
// 	  printf("%s\n", "[4] - Precio con descuento");
// 	  printf("%s\n", "[5] - Salir");
// 	  scanf("%hu", &opcion);
// 	  switch (opcion) {
// 		case 1:
// 			usd_to_eur();
// 			opcion = 0;
// 			break;
// 		case 2:
// 			eur_to_usd();
// 			opcion = 0;
// 			break;
// 		case 3:
// 			calc_area_prmtro_rctlo();
// 			break;
// 		case 4:
// 			calc_descuento();
// 			break;
// 		case 5:
// 			return 0;
// 		default:
// 			opcion = 0;
// 			break;
// 	  }
// 	}
// }

void prueba_json()
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

struct persona get_persona(int idx)
{
    json_object *root, *temp;

    // persona a devolver
    struct persona personaOut;

    root = json_object_from_file("datos.json");
    if (!root)
    {
        return personaOut;
    }

    // convierte cada atributo a un json object
    json_object *rut = json_object_object_get(root, "rut");
    json_object *nombre = json_object_object_get(root, "nombre");
    json_object *edad = json_object_object_get(root, "edad");

    printf("RUT. %s\n", json_object_get_string(rut));
    printf("NOMBRE. %s\n", json_object_get_string(nombre));
    printf("EDAD. %d\n", json_object_get_int(edad));

    // const char *rutPer = json_object_get_string(rut);
    // const char *nomPer = json_object_get_string(nombre);
    // int agePer = json_object_get_int(edad);

    // *personaOut.rut = rutPer;
    // *personaOut.nombre = nomPer;
    // personaOut.edad = agePer;

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
    mostrar_persona(get_persona(1));
}
