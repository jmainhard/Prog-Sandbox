#include <fstream>
#include <iostream>

#include "nlohmann/json.hpp"
#include "html.h"
#include "iocontroller.h"

using json = nlohmann::json;
using namespace std;

void drawHTMLhead()
{
	cout << CONTENT_TYPE;
	cout << HEAD_TAG << META << CHARSET_UTF_8 << _CLOSE_TAG << _HEAD_TAG;
}

void drawHTMLfooter()
{
	cout << HR_TAG;
	cout << HYPERLINK_TAG << HREF << "../index.html" << _CLOSE_TAG
	 << " < Volver"
	 << _HYPERLING_TAG << LINE_BR;
}

void drawHTMLnumGuess(int numToGuess, int savedNumber)
{
	cout << "Su número: " << numToGuess << LINE_BR;
	cout << "Número guardado: " << savedNumber <<  LINE_BR;
}

int main()
{
	// con json me aseguro de que sea un número 
	// con posiblemente menos código que sólo <fstream>
	// (aunque probablemente más lento)
	json j;
	int savedNumber, numToGuess;
	bool guessed;
	char* env;
	string envStr;

	// cargar archivo
	// FIXME: numbers.json debe existir en el directorio actual 
	j = deserialize("number.json");
	savedNumber = j["number"].get<int>();

	// get numToGuess
	env = getenv("QUERY_STRING");
	envStr = env;
	numToGuess = stoi( getElement(envStr, "numToGuess") );

	// comparar
	if (savedNumber == numToGuess)
	{
		guessed = true;
	}
	
    // html head
	drawHTMLhead();

	if (guessed)
	{
		cout << "Número adivinado!" << LINE_BR;
		drawHTMLnumGuess(numToGuess, savedNumber);
	}
	else
	{
		cout << "Número NO adivinado :(" << LINE_BR;
		drawHTMLnumGuess(numToGuess, savedNumber);
	}
	
	// pie de pagina
	drawHTMLfooter();
    
    return 0;
}