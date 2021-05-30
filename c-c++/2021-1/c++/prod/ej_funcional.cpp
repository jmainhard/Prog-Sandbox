#include <iostream>
#include <math.h> 

using namespace std;

// 01-04-2021
// Jorge M.

void calculate() {
  double distancia; 
  double puntAX;
  double puntAY;
  double puntBX;
  double puntBY;

  // << inserción / output |||| >> extracción / input
  cout << "Ingrese punto A: " << endl; 
  cout << "X: ";
  cin >> puntAX;

  cout << "Y: ";
  cin >> puntAY;

  cout << "Ingrese punto B: " << endl; 
  cout << "X: ";
  cin >> puntBX;

  cout << "Y: ";
  cin >> puntBY;

  distancia = pow((puntAX - puntBX), 2) + pow((puntAY - puntBY), 2);
  distancia = sqrt(distancia);

  cout << "La distancia es: " << distancia << endl;
 }
 

int main() {
  calculate(); 
  return 0;
}
