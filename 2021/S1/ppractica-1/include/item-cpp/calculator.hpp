// Calculadora básica.
// Se necesita una manera de ejecutar operaciones  y  guardar  el  resultado.
// Por  ahora  lo  único  que  necesita  hacer  el programa  es  sumar,  restar,
// multiplicar,  dividir  y  raíz  cuadrada  de  un  número  (Acá solo setear el-
// primer número y en el operador enviar la palabra “raiz”,)

// Necesitan  los  métodos  realizarOperacion()  y  obtenerResultado(),
// que  ejecutará todas las operaciones y devolverá el resultado final respectivamente.
// Debe aceptar decimales.setearPrimerNumero(10.5)  //guarda  el  primer  número  en  atributo  de  la  Clase Calculadora
// setearOperador(“+”) // Este debe recibir todas las operaciones
// setearSegundoNumero(5.2)    //guarda  el  segundo  numero  en  atributo  de  la  Clase Calculadora
// realizarOperacion() //realiza el calculo
// obtenerResultado()  //muestra el resultado

// declaración e implementación
#ifndef CALCULATOR_HPP
#define CALCULATOR_HPP

#include <cmath>

enum Operacion
{
    Sum,
    Substract,
    Multiply,
    Divide,
    SquareRoot,
    Undefined = 255
};

class Calculator
{
private:
    Operacion operador;
    double numberA;
    double numberB;
    double result;

public:
    Calculator();
    Calculator(Operacion);
    ~Calculator();
    void setOperator(Operacion operacion);
    Operacion getOperator() const;
    void setNumberA(double number);
    void setNumberB(double number);
    void realizarOperacion();
    double getResult() const;
};

Calculator::Calculator()
{
    this->operador = Undefined;
}

Calculator::Calculator(Operacion operador)
{
    this->operador = operador;
}

Calculator::~Calculator()
{
}

// setearOperador
void Calculator::setOperator(Operacion operador)
{
    this->operador = operador;
}

Operacion Calculator::getOperator() const
{
    return operador;
}

// setearPrimerNumero
void Calculator::setNumberA(double number)
{
    this->numberA = number;
}

// setearSegundoNumero
void Calculator::setNumberB(double number)
{
    this->numberB = number;
}

void Calculator::realizarOperacion()
{
    switch (operador)
    {
    case Sum:
        result = numberA + numberB;
        break;
    case Substract:
        result = numberA - numberB;
        break;
    case Multiply:
        result = numberA * numberB;
        break;
    case Divide:
        result = numberA / numberB;
        break;
    case SquareRoot:
        result = sqrt(numberA);
        break;                            
    default:
        std::cout << "Operador no definido" << std::endl;
        break;
    }
}

// obtenerResultado
double Calculator::getResult() const
{
    return this->result;
}

#endif // CALCULATOR_HPP