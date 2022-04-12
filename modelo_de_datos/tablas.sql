CREATE TABLE Usuario
(
   nombre_de_usuario    VARCHAR(255)    PRIMARY KEY,
   correo_electronico   VARCHAR(255)    NOT NULL,
   contrasena           VARCHAR(255)    NOT NULL,
   pais                 VARCHAR(255)    NOT NULL,
   puntos               INTEGER     NOT NULL
);

CREATE TABLE Amigo
(
   usuario1             VARCHAR(255),
   usuario2             VARCHAR(255),
   PRIMARY KEY (usuario1,usuario2),
   FOREIGN KEY (usuario1) REFERENCES Usuario(nombre_de_usuario),
   FOREIGN KEY (usuario2) REFERENCES Usuario(nombre_de_usuario)
);

