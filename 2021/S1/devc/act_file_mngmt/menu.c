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

const char *ask_rut()
{
    char *inputRut;
    do {
        printf("\nIngrese rut a buscar: (sin puntos, con guion)\n");
        scanf("%s", inputRut);
    } while (strlen(inputRut) > 10);
    return inputRut;
}

void buscar_fn()
{
    json_object *root, *temp;
    char *rutTemp, *nombre;
    int edad, n_personas;
    unsigned short int flag = 0;

    root = json_object_from_file("datos.json");
    const char *rut = ask_rut();

    json_object *personas = json_object_object_get(root, "personas");
    n_personas = json_object_array_length(personas);
    for (int i = 0; i < n_personas; i++)
    {
        temp = json_object_array_get_idx(personas, i);
        json_object *rutObj = json_object_object_get(temp, "rut");
        rutTemp = strdup(json_object_get_string(rutObj)); 
        if (strcmp(rutTemp,rut) == 0)
        {
            json_object *nameObj = json_object_object_get(temp, "nombre");
            json_object *ageObj = json_object_object_get(temp, "edad");
            printf("\t\t\t%s\n", " -- Persona encontrada --");
            printf("\t%d.  Rut: %s,  ", i+1, json_object_get_string(rutObj));
            printf("Nombre: %s,   ", json_object_get_string(nameObj));
            printf("Edad: %d\n", json_object_get_int(ageObj));
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

void calc_cant_fn()
{
    json_object *root, *temp;
    int n_personas;

    root = json_object_from_file("datos.json");

    json_object *personas = json_object_object_get(root, "personas");
    n_personas = json_object_array_length(personas);
    for (int i = 0; i < n_personas; i++)
    {
        temp = json_object_array_get_idx(personas, i);
        json_object *rutObj = json_object_object_get(temp, "rut");
        json_object *nameObj = json_object_object_get(temp, "nombre");
        json_object *ageObj = json_object_object_get(temp, "edad");
        printf("\t%-3d  Rut: %-12s  ", i+1, json_object_get_string(rutObj));
        printf("Nombre: %-20s   ", json_object_get_string(nameObj));
        printf("Edad: %-3d\n", json_object_get_int(ageObj));
    }
    printf("\t\t\t\t%s %d\n", "Total registros:", n_personas);
    json_object_put(root);
}

void calc_prom_fn()
{
    json_object *root, *temp;
    int edad, n_personas;
    float promEdad = 0.0;

    root = json_object_from_file("datos.json");

    json_object *personas = json_object_object_get(root, "personas");
    n_personas = json_object_array_length(personas);
    for (int i = 0; i < n_personas; i++)
    {
        temp = json_object_array_get_idx(personas, i);
        json_object *ageObj = json_object_object_get(temp, "edad");
        promEdad += (float) json_object_get_int(ageObj);
    }
    printf("\t\tSuma de edades: %f", promEdad);
    promEdad /= (float) n_personas;
    printf("\t%s %.1f\n", "Promedio de la edad:", promEdad);
    json_object_put(root);
}

void mostrar_max_min_fn()
{
    json_object *root, *temp, *objAge;
    int n_personas, tempAge;
    int max = -1;
    int min = -1;

    root = json_object_from_file("datos.json");
    
    json_object *personas = json_object_object_get(root, "personas");
    n_personas = json_object_array_length(personas);

    temp = json_object_array_get_idx(personas, 1);
    objAge = json_object_object_get(temp, "edad");
    max = json_object_get_int(objAge);
    min = json_object_get_int(objAge);

    for (int i = 0; i < n_personas; i++)
    {
        temp = json_object_array_get_idx(personas, i);
        objAge = json_object_object_get(temp, "edad");
        tempAge = json_object_get_int(objAge);
        if (tempAge > max)
        {
            max = tempAge;
        }
        else if (tempAge < min)
        {
            min = tempAge;
        }
    }
    printf("\t\tMayor edad: %d", max);
    printf("\t\tMenor edad: %d\n", min);
    json_object_put(root);
}

// TODO
// IDEA;:
// leer archivo, añadir una persona al array_json_object de personas
void agregar_persona_fn(const char *rut, const char *nombre, int edad)
{
    const char *nombreArchivo = "datos.json";
    json_object *root = json_object_new_object();

    root = json_object_from_file("datos.json");

    json_object *personas = json_object_object_get(root, "personas");
    json_object_object_add(personas, "rut", json_object_new_string(rut));
    json_object_object_add(personas, "nombre", json_object_new_string(nombre));
    json_object_object_add(personas, "edad", json_object_new_int(edad));

    if (json_object_to_file(nombreArchivo, root)) 
    {
        printf("Error: no se pudo guardar %s!!\n", nombreArchivo);
    }
    else
    {
        printf("%s guardado.\n", nombreArchivo);
    }
    json_object_put(root);    
}

int menu() 
{
	unsigned short opcion = 0;
	while (opcion >= 0 && opcion < 5)
	{
	  printf("%s\n", "[1] - Buscar por rut");
	  printf("%s\n", "[2] - Cantidad de registros");
	  printf("%s\n", "[3] - Promedio de las edades");
	  printf("%s\n", "[4] - Mayor y menor edad");
	  printf("%s\n", "[5] - Salir");
	  scanf("%hu", &opcion);
	  switch (opcion) 
	  {
		case 1:
            buscar_fn();
			opcion = 0;
			break;
		case 2:
            calc_cant_fn();
			opcion = 0;
			break;
		case 3:
            calc_prom_fn();
            opcion = 0;
			break;
		case 4:
            mostrar_max_min_fn();
            opcion = 0;
			break;
		case 5:
			return 0;
		default:
			opcion = 0;
			break;
	  }
	}
}

int main(void) 
{
    // después de 3hrs y poco más intentando que ask_rut() me devolviera el string de forma-
    // correcta, abdico, he intentado todo lo que tengo a mi alcance pero-
    // no he podido.
    // Cada vez que utilizo ask_rut() para conseguir el rut desde fuera de buscar_fn() me lanza:
    // Segmentation fault (core dumped)
    //  dejaré la invocación de ask_rut() dentro de buscar_fn() muy a mi pesar
    
    // test agregar persona
    agregar_persona_fn("7787496-8", "Pablo  Reyes", 47);
    menu();
    return 0;
}
