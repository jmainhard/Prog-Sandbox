#ifndef IOCONTROLLER_H
#define IOCONTROLLER_H

#include <iostream>

#include "html.h"

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

void drawHTMLhead()
{
    std::cout << CONTENT_TYPE;
	std::cout << HEAD_TAG;
		std::cout << META << CHARSET_UTF_8 << _CLOSE_TAG;
		std::cout << STYLE_TAG;
		std::cout << "body { font-family: 'Brush Script MT', cursive; max-width: 750px; margin-right: auto; margin-left: auto; } h1 { font-size: 3.5em;}";
		std::cout << _STYLE_TAG;
	std::cout << _HEAD_TAG;
}

void drawFooter()
{
	std::cout << HR_TAG;
	std::cout << HYPERLINK_TAG << HREF << "../registrar.html" << _CLOSE_TAG
	 << " < Volver al inicio"
	 << _HYPERLING_TAG << LINE_BR;
}

#endif // IOCONTROLLER_H