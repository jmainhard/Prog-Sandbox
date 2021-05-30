// 10-05-2021 Jorge M.
// prueba de conexion a bd

#include <iostream>
#include <mysql.h>
#include <mysqld_error.h>
using namespace std;

int main()
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
	else
	{
		cout << "Conexion realizada con exito" << endl;	
	}
	
	string query = "INSERT INTO usuarios values(NULL, 'Jorge', 'jorge@123.cl')";
	mysql_query(mysql, query.c_str());
	
	cout << mysql_error(mysql);
	
	mysql_close(mysql);
	return 0;
}