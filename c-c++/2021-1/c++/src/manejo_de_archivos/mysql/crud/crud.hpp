// functions only header
// 17-05-2021 Jorge M.

#ifndef CRUD_HPP
#define CRUD_HPP

// no debiera incluir namespace
using namespace std;

void menu()
{
	
}

bool insert(MYSQL* mysql)
{
	string nombre, creador, fecha;
	cout << "Ingrese nombre:\n";
	cout << "Ingrese creador:\n";
	cout << "Ingrese fecha (YYYY-MM-DD):\n";
	getline(cin, nombre);
	getline(cin, creador);
	getline(cin, fecha);

	string fecha_2 = "'03-08-2021";

	nombre = '\'' + nombre + '\'';
	creador = '\'' + creador + '\'';
	fecha = '\'' + fecha + '\'';
	
	mysql_query(mysql, query.c_str());
    
	if(*mysql_error(mysql))
	{
	  	cout << "Ocurrió un problema: " << mysql_error(mysql);
	  	return false;
	}
	else
	{
		cout << "Lenguaje ingresado con éxito!";
		return true;
	}
}

void read()
{
	
}

bool update()
{
	return false;	
}

bool del()
{
	return false;
}

MYSQL* connectDB()
{
	MYSQL* mysql;
	mysql = mysql_init(0);
	if (!mysql)
	{
		cout << "Error al iniciar conexion a la base de datos" << endl;
	}
	if (!mysql_real_connect(mysql, "localhost", "root", "", "cplusplus", 0, NULL, 0))
	{
		cout << mysql_error(mysql);
	}
	return mysql;
}

#endif