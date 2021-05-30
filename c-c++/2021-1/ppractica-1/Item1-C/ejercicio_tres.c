// Generar método, Cambiar hacia el centro-Dado un arreglo, 
// cambia el primer y último valor, el tercero con el ante penútimo y así sucesivamente, 
// Ejemplos:
// cambiaHaciaElCentro([1,2]) y muestre[2,1].
// cambiaHaciaElCentro([1,2,3,4,5,6]) y muestre[6,2,4,3,5,1].
// cambiaHaciaElCentro([1,2,3,4,5,6,7,8,9,10]) y muestre[10,2,8,4,6,5,7,3,9,1].

#include <stdio.h>

// le paso el tamaño en tiempo de ejecución
// para evitar el cambio de length al hacer una copia de arr en la función
void cambiaHaciaElCentro(int arr[], size_t length)
{
    size_t i = 0;
    size_t j = length - 1;
    int res[length];
    do
    {
        res[i] = arr[j];
        res[j] = arr[i];
        res[i+1] = arr[i+1];
        res[j-1] = arr[j-1];
        i += 2;
        j -= 2;
    } while (i < length / 2);
    
    // intercambiar valores centrales
    j = length - 1;
    res[(j / 2)] = arr[(j / 2) +1];
    res[(j / 2) +1] = arr[(j / 2)];

    printf("arr: ");
    for (size_t k = 0; k < length; k++)
    {
        printf("%d, ", arr[k]);
    }
    printf("\nres: ");
    for (size_t l = 0; l < length; l++)
    {
        printf("%d, ", res[l]);
    }
}

int main(int argc, char const *argv[])
{
    int arr[] = {1,2};
    int arr_2[] = {1,2,3,4,5,6};
    int arr_3[] = {1,2,3,4,5,6,7,8,9,10};
    int arr_4[] = {1,2,3,4,5,6,7,8,9,10,11,12,13};
    size_t n = sizeof(arr) / sizeof(arr[0]) ;
    size_t n_2 = sizeof(arr_2) / sizeof(arr_2[0]) ;
    size_t n_3 = sizeof(arr_3) / sizeof(arr_3[0]) ;
    size_t n_4 = sizeof(arr_4) / sizeof(arr_4[0]) ;
    
    // arr: [1,2]
    // res: [2,1]
    cambiaHaciaElCentro(arr, n);
    printf("\n\n");

    // arr: [1,2,3,4,5,6]
    // res: [6,2,4,3,5,1]
    cambiaHaciaElCentro(arr_2, n_2);
    printf("\n\n");

    // arr: [1,2,3,4,5,6,7,8,9,10]
    // res: [10,2,8,4,6,5,7,3,9,1]
    cambiaHaciaElCentro(arr_3, n_3);
    printf("\n\n");

    cambiaHaciaElCentro(arr_4, n_4);
    printf("\n\n");

    return 0;
}
