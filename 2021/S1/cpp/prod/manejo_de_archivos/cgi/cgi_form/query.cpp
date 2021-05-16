#include <iostream>
#include <cstring>
#include <stdlib.h>

#include "iocontroller.h"

using namespace std;

int main() {
	
	cout << "Content-type:text/html\r\n\r\n";
	char *value = getenv("QUERY_STRING");

	string cadena = value;
	cout << getElement(cadena,"apellido");
	
	return 0;
}