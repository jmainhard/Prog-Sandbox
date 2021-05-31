-- 10-05-2021 Jorge M.
CREATE DATABASE cplusplus;
USE cplusplus;

CREATE TABLE usuarios (
	id INTEGER(11) PRIMARY KEY AUTO_INCREMENT,
	nombre VARCHAR(50),
	correo VARCHAR(50)
);

-- Actividad 1
CREATE TABLE lenguajes (
	id INTEGER PRIMARY KEY AUTO_INCREMENT,
	nombre VARCHAR(50),
	creador VARCHAR(50),
	fecha DATE
);

DROP TABLE lenguajes;