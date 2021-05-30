#include <iostream>

#include "item-cpp/calculator.hpp"

using namespace std;

int main(int argc, char const *argv[])
{
    // para las operaciones se utilizan enums
    // Sum,
    // Substract,
    // Multiply,
    // ..
    // @See ../include/item-cpp/calculator.hpp
    Calculator calc; 
    calc.setNumberA(45.2);
    calc.setNumberB(23.2);
    
    calc.setOperator(Sum); // lo mismo que Calculadora calc(Sum); "+"
    calc.realizarOperacion();
    cout << calc.getResult() << endl;

    calc.setOperator(Substract); // lo mismo que Calculadora calc(Substract); "-"
    calc.realizarOperacion();
    cout << calc.getResult() << endl;

    calc.setOperator(Operacion::Multiply); // lo mismo que Calculadora calc(Multiply); "*"
    calc.realizarOperacion();
    cout << calc.getResult() << endl;

    calc.setOperator(Divide); // lo mismo que Calculadora calc(Divide); "/"
    calc.realizarOperacion();
    cout << calc.getResult() << endl;    

    calc.setOperator(Operacion::SquareRoot); // lo mismo que Calculadora calc(SquareRoot); "raiz"
    calc.realizarOperacion();
    cout << calc.getResult() << endl;
    
    return 0;
}
