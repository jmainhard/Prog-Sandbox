// 11-05-2021 Jorge M.
// Actividad practica 1 MYSQL

#include <iostream>
#include <mysql.h>
#include <mysqld_error.h>

#include "../../html_generator/html.h"

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

void mostrarLenguajes(MYSQL* mysql)
{
	MYSQL_ROW row;
	int totalrows, numfields;
	
	mysql_query(mysql, "SELECT * FROM lenguajes");
	MYSQL_RES *confres = mysql_store_result(mysql);
	
	totalrows = mysql_num_rows(confres);
	numfields = mysql_num_fields(confres);
	
	// fuente: https://stackoverflow.com/questions/1194453
	cout << TABLE << STYLE << "\"width:100%\"" << _CLOSE_TAG;
	while((row = mysql_fetch_row(confres)))
	{
		cout << TR;
	    for(int i = 0; i < numfields; i++)
	    {
	    	cout << TD;
	        char* val = row[i];
			cout << val;
			cout << _TD;
	    }
	    cout << _TR;
//	    cout << LINE_BR;
	}
	cout << _TABLE;

	
}

int main()
{
	MYSQL* mysql = connectDB();
	string nombre, creador, fecha;
	
	cout << CONTENT_TYPE;
	cout << HEAD_TAG << META << CHARSET_UTF_8 << _CLOSE_TAG << _HEAD_TAG;
	
	if (!mysql)
	{
		cout << HTML_ENDLINE << "Ocurrió un error al conectarse a la base de datos";
		return -1;
	}
	
	mostrarLenguajes(mysql);
    
	if(*mysql_error(mysql))
	{
	  	cout << HEADING_2_TAG << "Ocurrió un problema: " << mysql_error(mysql) << _HEADING_2_TAG;
	}
	else
	{
//		cout << HEADING_2_TAG << "Lenguaje ingresado con éxito!" << _HEADING_2_TAG;
	}
	mysql_close(mysql);
	
	return 0;
}