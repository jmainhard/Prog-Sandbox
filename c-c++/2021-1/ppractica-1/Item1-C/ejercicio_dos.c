// Usando  estructuras  generar  un  tipo  de  dato  llamado Vector,
// que  contenga las coordenadas x,y,z, 
// Generar 2 vectores de ejemplo y por último
// construir un métodoque sume los 2 vectores(recibiéndoloscomo parámetros) 
// y retorne el Vectorresultante

#include <stdio.h>

struct vector
{
    float x;
    float y;
    float z;
};

struct vector add_vectors(struct vector a, struct vector b)
{
    struct vector res;
    res.x = a.x + b.x;
    res.y = a.y + b.y;
    res.z = a.z + b.z;
    return res;
}

int main(int argc, char const *argv[])
{
    struct vector a;
    struct vector b;
    struct vector c;

    a.x = -7;
    a.y = 12;
    a.z = 0;

    b.x = -3;
    b.y = -6;
    b.z = 0;

    c = add_vectors(a, b);

    printf("Ax + Bx = %.2f\n", c.x);
    printf("Ay + By = %.2f\n", c.y);
    printf("Az + Bz = %.2f\n", c.z);

    return 0;
}



