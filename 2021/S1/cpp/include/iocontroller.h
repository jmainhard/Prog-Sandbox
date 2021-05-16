/*
15-05-2021 Jorge Mainhard
*/

#ifndef IOCONTROLLER_H
#define IOCONTROLLER_H

#include <iostream>
#include <fstream>
#include <iomanip>

#include "nlohmann/json.hpp"

// namespaces comentados: no son estrictamente necesarios
// namespace cgi_c
// {
std::string getElement(std::string query, std::string name)
{
    std::string element;
    int posicion = query.find(name);
    for (int i = posicion + name.length() + 1; i < query.length(); i++)
    {
        if (query[i] != '&')
        {
            if (query[i] == '+')
            {
                element.append(" ");
                continue;
            }
            element += query[i];
        }
        else
        {
            break;
        }
    }
    return element;
}

// } // end namespace cgi

// namespace json_c
// {

bool serialize(std::string jsonFile, nlohmann::json jsonObject)
{
	std::ofstream o(jsonFile);
	o << std::setw(4) << jsonObject << std::endl;
	o.close();
	return true;
}

nlohmann::json deserialize(std::string jsonFile)
{
    std::ifstream i(jsonFile);
    nlohmann::json j;
    i >> j;
    i.close();
    return j;
}
// } // end namespace json

#endif