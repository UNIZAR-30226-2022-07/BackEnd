CREATE TABLE Usuario
(
   nombre_de_usuario    VARCHAR(255)    NOT NULL UNIQUE,
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

CREATE TABLE Invitacion
(
   emisor               VARCHAR(255),
   receptor             VARCHAR(255),
   PRIMARY KEY (emisor,receptor),
   FOREIGN KEY (emisor) REFERENCES Usuario(correo_electronico),
   FOREIGN KEY (receptor) REFERENCES Usuario(correo_electronico)
);
