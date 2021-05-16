// 6-05-2021 Prof. Jorge Astorga

#include <iostream>
#include <mysql.h>
#include <mysqld_error.h>
using namespace std; 

int main() {
	MYSQL *mysql;
	mysql = mysql_init(0);
	if(!mysql){
		cout<<"Error al crear el objeto mysql";
	}
	if (!mysql_real_connect(mysql,"localhost","root","","cplusplus",0,NULL,0))
	{
	    cout<<mysql_error(mysql);
	}
	else{
		cout<<"Conexion realizada con exito";
		//string query = "insert into usuarios values(null,'Jorge','j@123.com')";
		string query = "delete from usuarios";
		mysql_query(mysql, query.c_str());
	}
	mysql_close(mysql); 
	return 0;
}





/*string nombre="Jorge2";
string query = "insert into usuarios values(null,'"+nombre+"','j@123.com')";
cout<<query;


mysql_query(mysql, query.c_str());

cout<<mysql_error(mysql);
*/