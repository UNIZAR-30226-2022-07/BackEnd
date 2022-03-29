CREATE TABLE Usuario
(
   nombre_de_usuario    VARCHAR(255)    NOT NULL,
   correo_electronico   VARCHAR(255)    PRIMARY KEY,
   contrasena           VARCHAR(255)    NOT NULL,
   pais                 VARCHAR(255)    NOT NULL,
   puntos               INTEGER     NOT NULL
);

CREATE TABLE Amigo
(
   usuario1             VARCHAR(255),
   usuario2             VARCHAR(255),
   PRIMARY KEY (usuario1,usuario2),
   FOREIGN KEY (usuario1) REFERENCES Usuario(correo_electronico),
   FOREIGN KEY (usuario2) REFERENCES Usuario(correo_electronico)
);

