#include <iostream>
// 29-04-2021 Jorge M.
// foto(19.40) codigo Mara V.

using namespace std;

int main()
{
  string arreglo[5]={"1","hola","2","chao","3"};
  int numero;
  
 	for(int i=0;i<5;i++) 
  {
    try 
    {
      numero = stoi(arreglo[i]);
      cout << numero + 1 << endl;
    }
    catch (exception &e)
    {
       cout << e.what() << endl;
       continue;
    }
          
	}


  return 0;
}