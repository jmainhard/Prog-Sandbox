#include <iostream>
#include <cstring>
#include <stdlib.h>

// Esteban E. 4-05-2021
// clase de cgi

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

int main() {
	
	cout << "Content-type:text/html\r\n\r\n";
	char *value = getenv("QUERY_STRING");

	string cadena = value;
//	string prueba = "nombre=Esteban&apellido=Esparza&edad=19";
	cout << getElement(cadena,"apellido");
	
	
	return 0;
}