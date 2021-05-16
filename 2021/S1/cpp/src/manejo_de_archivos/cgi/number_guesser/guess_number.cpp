#include <fstream>
#include <iostream>

#include "nlohmann/json.hpp"
#include "html.h"

using json = nlohmann::json;
using namespace std;

json deserialize(string jsonFile)
{
	ifstream i(jsonFile);
	json j;
	i >> j;
	i.close();
	return j;
}

string getElement(string query, string name){
	string element;
	int posicion = query.find(name);
	for(int i = posicion + name.length() + 1; i < query.length(); i++) {
		if (query[i] != '&') {
			if (query[i] == '+') {
				element.append(" ");
				continue;
			}
			element += query[i];
		} else {
			break;
		}	
	}
	return element;
}

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

	// // cargar archivo
	j = deserialize("number.json");
	savedNumber = j["number"].get<int>();

	// get numToGuess
	char* env = getenv("QUERY_STRING");
	string envStr = env;
	numToGuess = stoi( getElement(envStr, "numtoguess") );

	// comparar
	if (savedNumber == numToGuess)
	{
		guessed = true;
	}
	
    // html head
	drawHTMLhead();
	cout << savedNumber;

	if (guessed)
	{
		cout << "Número adivinado!" << LINE_BR;
		drawHTMLnumGuess(numToGuess, savedNumber);
	}
	else
	{
		cout << "Número NO adivinado!" << LINE_BR;
		drawHTMLnumGuess(numToGuess, savedNumber);
	}
	
	// pie de pagina
	drawHTMLfooter();
    
    return 0;
}