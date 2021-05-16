#include <fstream>
#include <iostream>

#include "html.h"
#include "nlohmann/json.hpp"

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

void drawHead()
{
	cout << CONTENT_TYPE;
	cout << HEAD_TAG;
		cout << META << CHARSET_UTF_8 << _CLOSE_TAG;
		cout << STYLE_TAG;
		cout << "table, th, td { border: 1px solid black; border-collapse: collapse; }";
		cout << "th, td { padding: 5px; }";
		cout << "th { text-align: left; }";
		cout << _STYLE_TAG;
	cout << _HEAD_TAG;
}

void drawTable(json j)
{
	cout << "Number of items in visits: " << j.size() << std::endl;
	json temp;

	cout << TABLE << STYLE << "\"width:100%\"" << _CLOSE_TAG;
	cout << TR << TH << "Comentario" << _TH << TH << "Correo" << _TH << TH << "Nombre" << _TH << _TR;
	for (int i = 0; i < j.size(); i++)
	{
		cout << TR;
		temp = j[i].get<json>();
		// iterar el objeto temp
		for (json::iterator it = temp.begin(); it != temp.end(); ++it) 
		{
			cout << TD;
			cout << it.value().get<string>();
			cout << _TD;
		}
		cout << _TR;
	}
	cout << _TABLE;
}

void drawFooter()
{
	cout << HR_TAG;
	cout << HYPERLINK_TAG << HREF << "../new_visit.html" << _CLOSE_TAG
	 << " < Volver atrás"
	 << _HYPERLING_TAG << LINE_BR;
}

int main()
{
	string file = "visits.json";
	json j;

	// cargar archivo
	j = deserialize(file);

    // html head
	drawHead();

    // mostrar tabla
    // FIXME 02: hay un problema al ingresar caracteres especiales
    // p.ej. letras con tildes, se guardan en el json con errores
    drawTable(j);
	
	// pie de pagina
	drawFooter();
    
    return 0;
}