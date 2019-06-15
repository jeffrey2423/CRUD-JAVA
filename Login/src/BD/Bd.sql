CREATE DATABASE usuarios;

USE usuarios;

CREATE TABLE usuario(
    id INT(11) AUTO_INCREMENT,
    nombre VARCHAR(20) NOT NULL,
    clave VARCHAR(20) NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO usuario(nombre, clave)VALUES('admin', '123456');