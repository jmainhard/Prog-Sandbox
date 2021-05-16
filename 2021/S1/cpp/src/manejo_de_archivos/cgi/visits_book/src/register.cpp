// 13-05-2021 Jorge M.
// libro de visitas con CGI y json
#include <nlohmann/json.hpp>
#include <fstream>
#include <iostream>
#include <iomanip> // setw()

#include "html.h"

using json = nlohmann::json;
using namespace std;

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

json deserialize(string jsonFile)
{
	// de-serealizar archivo JSON
	std::ifstream i(jsonFile);
	json j;
	i >> j;
	i.close();
	return j;
}

bool serialize(string jsonFile, json jsonObject)
{
	// escribir json indentado a un archivo
	ofstream o(jsonFile);
	o << setw(4) << jsonObject << endl;
	o.close();
	return true;
}

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

