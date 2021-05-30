// 20-05-2021 Jorge M.
// compiler:
// g++ main.cpp user.cpp -o main

#include <iostream>

#include "user.hpp"

using namespace std;

int main()
{
    User usuario;
    usuario.setClave("1234567890");
    usuario.setPerfil("ADMINISTRADOR");
    cout << usuario.getClave() << endl; // Debe mostrar 1234567890
    cout << usuario.getPerfil() << endl; // Debe mostrar ADMINISTRADOR 
    cout << usuario.getCorreo() << endl; // Debemostrar correo@servidor.com 
    cout << usuario.getNombre() << endl; // Debe mostrar Claudio
    return 0;
}