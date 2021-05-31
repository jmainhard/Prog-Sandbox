// 18-06-2021 Jorge M.

#ifndef USER_HPP
#define USER_HPP

#include <iostream>

class User
{
    std::string nombre;
    std::string correo;
    std::string clave;
    std::string perfil;
public:
    User();
    ~User();
    // funciones prototipo
    std::string getClave() const;
    // no necesitan el nombre del argumento (c) pero se agrega para mejor entendimiento
    void setClave(std::string c); 
    std::string getPerfil() const;
    void setPerfil(std::string p);
    std::string getCorreo() const;
    std::string getNombre() const;
};

// ignorar
class Perro
{
	std::string nombre = "Perrito"; // privado
public:
	std::string getNombre()
	{
	    return this->nombre;
	}
};


#endif // USER_HPP