#ifndef DEF_MAGE_H
#define DEF_MAGE_H

#include <iostream>
#include "def_human.h"

class Mago: public Humano
{
  public:
    Mago();
    // sgt. linea: 
    // not necesario (creo, almenos que quiera dar info extra al momento de destruir)
//    ~Mago(); 

    
    void print() const;
    
    void atacar(Humano& atacado) const; // = bolaDeFuego()
    void sanar(Humano& sanado) const;
};

Mago::Mago()
{
  setInteligencia(8);
  setSalud(50);
}

//Mago::~Mago()
//{
//  std::cout << "Mago deconstruido\n";
//}

void Mago::print() const
{
  std::cout << "Mago: " << '\n' 
       << "  Fuerza: " << getFuerza() << '\n' 
       << "  Inteligencia: " << getInteligencia() << '\n'
       << "  Sigilo: " << getSigilo() << '\n'
       << "  Salud: " << getSalud() << "\n\n";
}

void Mago::atacar(Humano& atacado) const
{
  int salud = atacado.getSalud() - (this->getInteligencia() * 3);
  atacado.setSalud(salud);
}

void Mago::sanar(Humano& sanado) const
{
  sanado.setSalud(sanado.getSalud() + this->getInteligencia());
}

#endif