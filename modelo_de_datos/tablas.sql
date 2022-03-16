DROP TABLE IF EXISTS Amigo;
DROP TABLE IF EXISTS Notificaciones;
DROP TABLE IF EXISTS Usuario;
DROP DATABASE IF EXISTS modelo_datos;

CREATE DATABASE modelo_datos;
CREATE TABLE Usuario
(
   Nombre_de_usuario    CHAR(50) PRIMARY KEY,
   Correo_electronico   CHAR(60)        NOT NULL,
   Contrasena           CHAR(30)        NOT NULL,
   Pais                 CHAR(70)        NOT NULL,
   Puntos               INTEGER        NOT NULL,
   Ultima_partida       INTEGER        NOT NULL
);

CREATE TABLE Notificaciones
(
   valor                       CHAR(200), -- autoincrementado
   Usuario   CHAR(50),
   PRIMARY KEY (valor,Usuario),
   FOREIGN KEY (Usuario) REFERENCES Usuario(Nombre_de_usuario)
);

CREATE TABLE Amigo
(
   Usuario   CHAR(50),
   Usuario2   CHAR(50),
   PRIMARY KEY (Usuario,Usuario2),
   FOREIGN KEY (Usuario) REFERENCES Usuario(Nombre_de_usuario),
   FOREIGN KEY (Usuario2) REFERENCES Usuario(Nombre_de_usuario)
);

