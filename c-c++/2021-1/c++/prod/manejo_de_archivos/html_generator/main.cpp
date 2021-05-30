#include <iostream>
#include <fstream>
#include <array>
#include <string>

#include "html.h"

using namespace std;

//  4-05-2021 Jorge M.

// el siguiente código es innecesariamente "grande"
// pero la idea era reducir al máximo el tiempo de codificacion y error de sintaxis
// estandarizando etiquetas html en archivo HTML.h
int main()
{
    ofstream indexFile("index.html");
    string title, heading, heading_2, paragraph, sourceFile, link;
    array<string, 3> intereses;

    indexFile << DOCTYPE_TAG << HTML_ENDLINE;
    indexFile << HTML_TAG << HTML_ENDLINE;

    cout << "Ingrese titulo de la web:\n";
    getline(cin, title); // input con espacios (cin toma espacios como dos entradas)

    cout << "Ingrese un encabezado:\n";
    getline(cin, heading);

    cout << "Ingrese subtitulo:\n";
    getline(cin, heading_2);

    cout << "Ingrese parrafo de bienvenida:\n";
    getline(cin, paragraph);

    cout << "Ingrese imagen (p.ej. man_working):\n";
    getline(cin, sourceFile);
    sourceFile += ".png";

    cout << "Ingrese enlace:\n";
    getline(cin, link);

    for (int i = 0; i < intereses.size(); i++)
    {
        cout << "Ingrese interes " << i + 1 << endl;
        getline(cin, intereses[i]);
    }
    
    // escribir el archivo
    indexFile << TITLE_TAG << title << _TITLE_TAG << HTML_ENDLINE;
    indexFile << HEADING_TAG << heading << _HEADING_TAG << HTML_ENDLINE;
    indexFile << HEADING_2_TAG << heading_2 << _HEADING_2_TAG << HTML_ENDLINE;
    indexFile << PARAGRAPH_TAG << paragraph << _PARAGRAPH_TAG << HTML_ENDLINE;
    indexFile << IMG_TAG << SRC << "\"images/" << sourceFile << "\"" << ALT << "\"User Input Image\"" << _CLOSE_TAG << LINE_BR << HTML_ENDLINE;
    indexFile << HYPERLINK_TAG << HREF << "\"" << link << "\"" << _CLOSE_TAG << "Link usuario" << _HYPERLING_TAG << HTML_ENDLINE;
    indexFile << UL_TAG << HTML_ENDLINE;
        for (int i = 0; i < intereses.size(); i++)
        {
            indexFile << LI_TAG << intereses[i] << _LI_TAG << HTML_ENDLINE;
        }
    indexFile << _UL_TAG << HTML_ENDLINE;

    indexFile << _HTML_TAG << HTML_ENDLINE;
    indexFile.close();
    return 0;
}