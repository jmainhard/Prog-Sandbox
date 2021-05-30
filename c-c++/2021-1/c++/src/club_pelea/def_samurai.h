#ifndef DEF_SAMURAI_H
#define DEF_SAMURAI_H

#include <iostream>
#include "def_human.h"

class Samurai: public Humano
{
  public:
    Samurai();
    void print() const;
    void ataqueMortal(Humano& humano);
    void meditar();
};

Samurai::Samurai()
{
  setSalud(200);
}

void Samurai::print() const
{
  std::cout << "Samurai: " << '\n' 
       << "  Fuerza: " << getFuerza() << '\n' 
       << "  Inteligencia: " << getInteligencia() << '\n'
       << "  Sigilo: " << getSigilo() << '\n'
       << "  Salud: " << getSalud() << "\n\n";  
}

void Samurai::ataqueMortal(Humano& humano)
{
  // mata al humano (y lo destruye)
  humano.setSalud(0);
  humano.setFuerza(0);
  humano.setSigilo(0);
  humano.setSalud(0);
  humano.~Humano();
  
  this->setSalud(this->getSalud() / 2);
}

void Samurai::meditar()
{
  setSalud(getSalud() + getSalud() / 2);
}


#endif