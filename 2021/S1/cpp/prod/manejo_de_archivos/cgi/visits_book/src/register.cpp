// 13-05-2021 Jorge M.
// libro de visitas con CGI y json
#include <nlohmann/json.hpp>
#include <fstream>
#include <iostream>
#include <iomanip> // setw()

#include "html.h"
#include "iocontroller.h"

using json = nlohmann::json;
using namespace std;

int main()
{
	// estructura json vacia
	json j, newData;
	string file = "visits.json";

	char* env = getenv("QUERY_STRING");
	string envStr = env;

	// cargar archivo (FIXME: crear e inicializar el archivo cuando este no exista)
	j = deserialize(file);
	
	// get nuevos datos
	string name = getElement(envStr, "name");
	string email = getElement(envStr, "email");
	string comment = getElement(envStr, "comment");

	// add nuevos datos
	newData = { {"name", name}, {"email", email}, {"comment", comment} };
	j.push_back(newData);
	
	// guardar a archivo
	serialize(file, j);
	
	cout << CONTENT_TYPE;
	cout << HEAD_TAG << META << CHARSET_UTF_8 << _CLOSE_TAG << _HEAD_TAG;
	cout << "Visita registrada!";
	
	// footer
	cout << HR_TAG;
	cout << HYPERLINK_TAG << HREF << "../new_visit.html" << _CLOSE_TAG
	 << " < Volver atrás"
	 << _HYPERLING_TAG << " | ";
	cout << HYPERLINK_TAG << HREF << "show.exe" << _CLOSE_TAG
	 << "Visitas registradas"
	 << _HYPERLING_TAG << LINE_BR;

	return 0;
}

