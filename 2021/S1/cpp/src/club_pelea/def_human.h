#ifndef DEF_HUMAN_H
#define DEF_HUMAN_H

#include <iostream>

class Humano
{
  int fuerza;
  int inteligencia;
  int sigilo;
  int salud;
  
  public:
    Humano();
    virtual ~Humano();
    // virtual para sobreescribir método 
    // const ya que no modifica el estado del objeto
    virtual void print() const;

    int getInteligencia() const;
    void setInteligencia(int inteligencia);
    
    int getSalud() const;
    void setSalud(int salud);
    
    int getFuerza() const;
    void setFuerza(int fuerza);
    
    int getSigilo() const;
    void setSigilo(int sigilo);        
    
    virtual void atacar(Humano &atacado) const;
};

Humano::Humano()
{
  fuerza = 3;
  inteligencia = 3;
  sigilo = 3;
  salud = 100;
}

Humano::~Humano()
{
  std::cout << "Humano destruido\n";
}

void Humano::print() const
{
  std::cout << "Humano: " << '\n' 
       << "  Fuerza: " << fuerza << '\n' 
       << "  Inteligencia: " << inteligencia << '\n'
       << "  Sigilo: " << sigilo << '\n'
       << "  Salud: " << salud << "\n\n"; // endl mismo efecto/funcion
}

int Humano::getSalud() const
{
  return salud;
}

void Humano::setSalud(int salud)
{
  this->salud = salud;
}

int Humano::getInteligencia() const
{
  return inteligencia;
}

void Humano::setInteligencia(int inteligencia)
{
  this->inteligencia = inteligencia;
}

int Humano::getFuerza() const
{
  return fuerza;
}

void Humano::setFuerza(int fuerza)
{
  this->fuerza = fuerza;
}

int Humano::getSigilo() const
{
  return sigilo;
}

void Humano::setSigilo(int sigilo)
{
  this->sigilo = sigilo;
}

void Humano::atacar(Humano& atacado) const
{
  atacado.setSalud(atacado.getSalud() - this->getFuerza());
}

#endif