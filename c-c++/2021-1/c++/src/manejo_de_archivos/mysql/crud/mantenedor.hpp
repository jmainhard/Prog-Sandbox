// 06-2021 Jorge M.
// conexión mysql y modificación bd

#ifndef MANTENEDOR_HPP
#define MANTENEDOR_HPP

#include <iostream>
#include <mysql.h>
#include <mysqld_error.h>

// no se debiera incluir namespace
using namespace std;


namespace std
{
	bool insert()
	{
		
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

}

int main()
{
	return 0;
}

#endif