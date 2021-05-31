// 10-05-2021 Jorge M.
// Actividad practica 1 MYSQL

#include <iostream>
#include <mysql.h>
#include <mysqld_error.h>

#include "html.h"

#define CONTENT_TYPE "Content-type:text/html\r\n\r\n"

using namespace std;

MYSQL* connectDB()
{
	MYSQL* mysql;
	mysql = mysql_init(0);
		
	if (!mysql)
	{
		cout << "Error al crear el objeto mysql" << endl;
	}
	if (!mysql_real_connect(mysql, "localhost", "root", "", "cplusplus", 0, NULL, 0))
	{
		cout << mysql_error(mysql);
	}
	return mysql;
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

int main()
{
	MYSQL* mysql = connectDB();
	string nombre, creador, fecha;
	string query, cadena;
	
	cout << CONTENT_TYPE;
	cout << HEAD_TAG << META << CHARSET_UTF_8 << _CLOSE_TAG << _HEAD_TAG;
	
	if (!mysql)
	{
		cout << HTML_ENDLINE << "Ocurrió un error al conectarse a la base de datos";
		return -1;
	}
	
	char* value = getenv("QUERY_STRING");

	cadena = value;
	nombre = getElement(cadena, "nombre");
	creador = getElement(cadena, "creador");
	fecha = getElement(cadena, "fecha");
		
	nombre = '\'' + nombre + '\'';
	creador = '\'' + creador + '\'';
	fecha = '\'' + fecha + '\'';
	
	query = "INSERT INTO lenguajes values(NULL,";
	query.append(nombre + ",");
	query.append(creador + ",");
	query.append(fecha + ")");
	
//	cout << query;
	
	mysql_query(mysql, query.c_str());
    
	if(*mysql_error(mysql))
	{
	  	cout << HEADING_2_TAG << "Ocurrió un problema: " << mysql_error(mysql) << _HEADING_2_TAG;
	}
	else
	{
		cout << HEADING_2_TAG << "Lenguaje ingresado con éxito!" << _HEADING_2_TAG;
	}
	mysql_close(mysql);
	
	return 0;
}