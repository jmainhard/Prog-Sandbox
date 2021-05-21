#include <iostream>

#include "item-cgi/html.h"
#include "item-cgi/iocontroller.h"

using namespace std;

struct persona
{
	// en caso de que query falle
	string name = "Desconocido";
	string language = "Desconocido";
	string country = "Desconocido";
};

int main(int argc, char const *argv[])
{
	char* env;
	string envStr, name, language, country;
	persona p;

	env = getenv("QUERY_STRING");
	envStr = env;

	name = getElement(envStr, "name");
	language = getElement(envStr, "language");
	country = getElement(envStr, "country");

	p.name = name.empty() ? "Desconocido" : name ;
	p.language = language.empty()  ? "Desconocido" : language;
	p.country =  country.empty() ? "Desconocido" : country;

	// html
	drawHTMLhead();

	cout << HEADING_TAG <<  "Bienvenido!, " << p.name << _HEADING_TAG << LINE_BR;
	cout << HEADING_3_TAG << "Tu lenguaje favorito es: " << p.language << _HEADING_3_TAG << LINE_BR;
	cout << HEADING_3_TAG << "Tu país es: " << p.country << _HEADING_3_TAG << LINE_BR;

	drawFooter();

	return 0;
}
