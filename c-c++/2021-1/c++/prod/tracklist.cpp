#include <cstdio>
#include <iostream>
#include <cstring>
#include <string>

using namespace std;

// 24-04-2021 Jorge M.

struct track 
{
  string songName;
  string lyrics;
};

// case sensitive
bool comparar(string s1, string s2)
{
    int x = s1.compare(s2);
    if (x == 0) 
    {
      return true;
    }
    else
    {
      return false; 
    }
}

int main() 
{
  // lista
  track trackList[4];
  string searchedSong;
  bool found;

  // canciones disponibles (esto no hace nada)
  trackList[0];
  trackList[1];
  trackList[2];
  trackList[3];

  // asignaciones
  trackList[0].songName = "La Grange";
  trackList[0].lyrics = "LETRA Cancion 1";

  trackList[1].songName = "Cancion 2";
  trackList[1].lyrics = "LETRA Cancion 2";

  trackList[2].songName = "Cancion 3";
  trackList[2].lyrics = "LETRA Cancion 3";

  trackList[3].songName = "Cancion 4";
  trackList[3].lyrics = "LETRA Cancion 4";

  cout << "  -- TrackList --" << endl;

  // todas las canciones
  // se podrian usar vectores o sizeof para conseguir el tamaño a través de los bytes
  // o recorrer el array con tamaño fixed 4 (for i < 4)
  // pero esta manera me parecio mejor  
  cout << "  -- Canciones en Tracklist --" << endl;
  for (const auto &track : trackList) 
  {
    cout << "Nombre: " + track.songName << endl
      << "Letra: " + track.lyrics << endl << endl;
  }
  
  cout << "Busque una cancion:" << endl;
  getline(cin, searchedSong);
  cout << "\nCancion buscada: " + searchedSong << endl << endl;    

  // buscar 
  // (casi foreach?)
  // para cada referencia de track en trackList 
  // (keyword auto al parecer deduciría el tipo de una variable)
  for (const auto &track : trackList) 
  {
    if (comparar(track.songName, searchedSong))
    {
      cout << "Cancion encontrada: " + track.songName << endl
        << "Letra: " + track.lyrics << endl << endl;
        // sin break por si hubieran dos canciones de mismo nombre
        found = false;
    }
  }
  
  if (!found) {
    cout << "Cancion no encontrada" << endl << endl;
  }

  return 0;
}
