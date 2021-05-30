CREATE DATABASE qtmysql;

USE qtmysql;

CREATE TABLE usuarios (
	id INTEGER PRIMARY KEY AUTO_INCREMENT,
	nombre VARCHAR(50)
);

INSERT INTO usuarios VALUES(NULL, 'Nombre de Pruebas');

DROP TABLE usuarios;
