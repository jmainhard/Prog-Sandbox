// 18-06-2021 Jorge M.

#include "user.hpp"

#include <iostream>

using namespace std;

User::User()
{
    nombre = "Claudio";
    correo = "correo@servidor.com";
    clave = "UNDEFINED";
    perfil = "UNDEFINED";
}

User::~User()
{
 // destructor "silencioso"
}

string User::getClave() const
{
    return clave;
}

void User::setClave(string c)
{
    this->clave = c;
}

string User::getPerfil() const
{
    return perfil;
}

void User::setPerfil(string p)
{
    this->perfil = p;
}

string User::getCorreo() const
{
    return correo;
}

string User::getNombre() const
{
    return nombre;
}
