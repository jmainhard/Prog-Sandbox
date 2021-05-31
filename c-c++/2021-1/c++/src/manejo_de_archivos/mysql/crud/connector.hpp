//  --- FIXME ---
// 17-05-2021 Jorge M.
// intento de complementar act. 1 con OOP/POO
// no logrado
// intente varias formas y lo más lejos que llegué fue
// conexión a la base de datos, no estoy podiendo ejecutar el crud
// la versión actual de este hpp está totalmente desestimada
// por razones de tiempo no la volveré a su estado funcional (sólo conexión)
// seguire el desarrollo con funciones aisladas en crud.hpp

#ifndef CONNECTOR_HPP
#define CONNECTOR_HPP

#include <iostream>
#include <mysql.h>
#include <mysqld_error.h>

// no se debiera incluir namespace
using namespace std;

class Connector
{
	MYSQL* mysql;
	public:
		Connector();
		~Connector();
		MYSQL* connectDB();
		void close();
		bool insert();
		// void read
		// boold update
		// bool delete
		MYSQL* getMysql() const;
		void setMysql(MYSQL* mysql);
};

Connector::Connector()
{
	this->setMysql(connectDB());
	if (!getMysql())
	{
		cout << "Ocurrió un error al conectarse a la base de datos";
	}
}

Connector::~Connector()
{
	mysql_close(this->getMysql());
}

MYSQL* Connector::connectDB()
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

void Connector::setMysql(MYSQL* mysql)
{
	this->mysql = mysql_init(0);
}

MYSQL* Connector::getMysql() const
{
	return this->mysql;
}

bool Connector::insert()
{
	// testing
	string nombre = "'nombre'";
	string creador = "'creador'";
	string fecha = "'2021-05-03'";
	string fecha_2 = "'03-08-2021";
	
	string query = "INSERT INTO lenguajes values(NULL,";
	query.append(nombre + ",");
	query.append(creador + ",");
	query.append(fecha + ")");
	
	MYSQL* mysql;
	mysql = mysql_init(0);
	mysql_query(mysql, query.c_str());
	if(*mysql_error(mysql))
	{
	  	cout << "Ocurrió un problema: " << mysql_error(mysql) << endl;
	}
	else
	{
		cout << "Lenguaje ingresado con éxito!" << endl;
	}
	mysql_close(mysql);
	return true;
}

void Connector::close()
{
	mysql_close(this->getMysql());
}



#endif