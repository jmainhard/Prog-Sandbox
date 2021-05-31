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

int main()
{
	// FIXME: numbers.json debe existir en el directorio actual
	string file = "number.json";
	json j;
	int numToSet;
	char* env;
	string envStr;

	// cargar archivo
	j = deserialize(file);

	// get numToSet
	env = getenv("QUERY_STRING");
	envStr = env;
	numToSet = stoi( getElement(envStr, "numToSet") );
	j["number"] = numToSet;

    // html head
	drawHTMLhead();

	if (serialize(file, j))
	{
		cout << "Número actualizado correctamente" << LINE_BR;
	}

	// pie de pagina
	drawHTMLfooter();
    
    return 0;
}