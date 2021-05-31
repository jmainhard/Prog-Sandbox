#include <iostream>

using namespace std;
// 25-04-2021 Jorge M.

class Dog
{
  public:
  // atributos
  string name;
  int age = 10;
  
  // constructor (declaracion)
  Dog();
  
  // destructor (declaracion)
  ~Dog();
  
  // funciones o métodos (declaracion)
  // Functions that do not modify the state of the object
  // should be marked as const.
  void ladrar() const;
};

// definicion constructor
Dog::Dog()
{
  name = "Barkley";
  age = 10;
  cout << "Un perro fue construido\n";
}

// def. destructor
Dog::~Dog()
{
  cout << "Goodbye " << name << '\n';
}

// def. metodo
void Dog::ladrar() const
{
  cout << "Woof!\n";
}

int main()
{
  Dog myDog;
  
  for (int i = 0; i < 4; i++)
  {
    myDog.ladrar();
  }
  
  return 0;
}



