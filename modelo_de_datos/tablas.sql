CREATE TABLE Usuario
(
   nombre_de_usuario    CHAR(50)    NOT NULL,
   correo_electronico   CHAR(60)    PRIMARY KEY,
   contrasena           CHAR(30)    NOT NULL,
   pais                 CHAR(70)    NOT NULL,
   puntos               INTEGER     NOT NULL
);

CREATE TABLE Amigo
(
   usuario1             CHAR(50),
   usuario2             CHAR(50),
   PRIMARY KEY (usuario1,usuario2),
   FOREIGN KEY (usuario1) REFERENCES Usuario(correo_electronico),
   FOREIGN KEY (usuario2) REFERENCES Usuario(correo_electronico)
);

