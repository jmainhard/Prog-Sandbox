// 16-05-2021 Jorge M.
// Actividad practica 1 MYSQL

#include <iostream>
#include <mysql.h>
#include <mysqld_error.h>

#include "crud.hpp"
#include "connector.hpp"

#define CONTENT_TYPE "Content-type:text/html\r\n\r\n"

using namespace std;

int main()
{
	MYSQL* mysql = connectDB();
	insert(mysql);
	

	
	return 0;
}