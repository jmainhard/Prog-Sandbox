#include <fstream>
#include <iostream>
#include <iomanip>

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

bool serialize(string jsonFile, json jsonObject)
{
	ofstream o(jsonFile);
	o << setw(4) << jsonObject << endl;
	o.close();
	return true;
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
	string file = "number.json";
	json j;
	int numToSet;
	char* env;
	string envStr;

	// cargar archivo
	j = deserialize(file);
	j["number"] = 0;

	// guardar a archivo
	serialize(file, j);

	// get numToGuess
	env = getenv("QUERY_STRING");
	envStr = env;
	numToSet = stoi( getElement(envStr, "numToGuess") );

    // html head
	drawHTMLhead();


	// pie de pagina
	drawHTMLfooter();
    
    return 0;
}