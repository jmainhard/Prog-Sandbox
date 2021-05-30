// 18-05-2021
// ítem  II, ej. 2, prueba teórica 1

#include <iostream>

using namespace std;

int main(void)
{
    int valor = 100;
    int* puntero_1;
    int* puntero_2;
    int* puntero_3;

    puntero_1 = &valor;
    puntero_2 = puntero_1;
    puntero_3 = puntero_1;

    cout << *puntero_1 << endl;
    cout << &puntero_2 << endl;
    cout << *puntero_3 << endl;
}
