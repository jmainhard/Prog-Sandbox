#ifndef DEF_NINJA_H
#define DEF_NINJA_H

#include <iostream>
#include "def_human.h"

class Ninja: public Humano
{
  public:
    Ninja();
    
    void print() const;
    void robar(Humano& humano);
    void huir();
};

Ninja::Ninja()
{
  setSigilo(10);
}

void Ninja::print() const
{
  std::cout << "Ninja: " << '\n' 
       << "  Fuerza: " << getFuerza() << '\n' 
       << "  Inteligencia: " << getInteligencia() << '\n'
       << "  Sigilo: " << getSigilo() << '\n'
       << "  Salud: " << getSalud() << "\n\n";  
}

void Ninja::robar(Humano& humano)
{
  int stolen, saludHumano, saludNueva;
  
  saludHumano = humano.getSalud();
  
  saludNueva = saludHumano - this->getSigilo();
  stolen = saludHumano - saludNueva;
  
  humano.setSalud(saludNueva);
  this->setSalud(this->getSalud() + stolen);
}

void Ninja::huir()
{
  setSalud(getSalud() - 10);
}

#endif