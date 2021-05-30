#include <iostream>
#include <ctime>
#include <fstream>

// 29-04-2021 Jorge M.

using namespace std;

string getSystemDate()
{
    // fecha y hora basada en el sistema actual, asignada a un struct
    time_t now = time(0);
    tm *ltm = localtime(&now);
    string date, day, month, year, time;
    
    // from enero 1,1970
    day = to_string(ltm -> tm_mday);
    month = to_string(1 + ltm -> tm_mon);
    year = to_string(1900 + ltm -> tm_year);
    time = to_string(ltm -> tm_hour) + ":" + to_string(ltm -> tm_min) + ":" + to_string(ltm -> tm_sec);
    date = month + "-" + day + "-" + year + " " + time;
    return date;
}

int main()
{
  string arreglo[5] = {"1","hola","2","chao","3"};
  ofstream log("log.txt");
  
  int numero;

  getSystemDate();
  
  for(int i=0;i<5;i++) 
  {
    try 
    {
      numero = stoi(arreglo[i]);
      cout << numero + 1 << endl;
    }
    catch (exception &e)
    {
      string log_error = getSystemDate() + " No se puede transormar a entero, elemento " + arreglo[i];
      cout << log_error << endl;
      log << log_error << endl;
      continue;
    }
	}

  log.close();
  return 0;
}