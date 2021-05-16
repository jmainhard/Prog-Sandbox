#include <iostream>
#include "../html_generator/html.h"

// Jorge M.
// 4-05-2021
// Clase de CGI
// foto(18.32) esteban haciendo cgi, 
// link profe: https://www.delftstack.com/es/howto/cpp/how-to-find-substring-in-string-cpp/
// foto(18.41) separación de nombres foto(18.45)
// trabajo de formularios:
// see: "./cgi_form/query.cpp"
// nota: cgi cc libreria a investigar, permite-
// recibir formulario y sacar el campo que quiera de manera sencilla

using namespace std;

int main()
{
    cout << "Content-Type: text/html\r\n\r\n";
    cout << HTML_TAG << HTML_ENDLINE;
    cout << HEAD_TAG << HTML_ENDLINE;
    cout << TITLE_TAG << "Saludo" << _TITLE_TAG << HTML_ENDLINE,
    cout << _HEAD_TAG << HTML_ENDLINE;
    cout << BODY_TAG << HTML_ENDLINE;
    cout << HEADING_2_TAG << "Hola Mundo! Mi primer CGI para la web" << _HEADING_2_TAG << HTML_ENDLINE;
    cout << _BODY_TAG << HTML_ENDLINE;
    cout << _HTML_TAG << HTML_ENDLINE;  
}