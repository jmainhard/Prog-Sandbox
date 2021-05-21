// Crear un arreglo con los siguientesvalores: 3,5,1,2,7,9,8,13,25,32. 
// Imprimirla suma de todos los números en el arreglo.
// Crear método que debe mostrarelarreglo que incluya solo los números que son mayores a 10 
// (Por ejemplo,cuando envía el arreglo anterior, debe mostrarun arreglo con los valores de 13,25,32
#include <stdio.h>

void show_greaters_than(int arr[], int filter, size_t length)
{
    for (size_t i = 0; i < length; i++)
    {
        if (arr[i] > 10)
        {
            printf("%d\n", arr[i]);
        }
    }
}

int main(void)
{
    int arr[] = {3,5,1,2,7,9,8,13,25,32};
    int suma = 0;
    size_t n = sizeof(arr)/sizeof(arr[0]); // size a traves de sus bytes

    for (size_t i = 0; i < n; i++)
    {
        suma += arr[i];
    }
    printf("Suma: %d\n", suma);
    printf("Mayores que 10:\n");
    show_greaters_than(arr, 10, n);
    return 0;   
}

