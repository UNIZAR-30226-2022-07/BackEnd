CREATE TABLE Usuario
(
   Nombre_de_usuario    CHAR(50) NOT NULL,
   Correo_electronico   CHAR(60)        PRIMARY KEY,
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
   FOREIGN KEY (Usuario) REFERENCES Usuario(Correo_electronico)
);

CREATE TABLE Amigo
(
   Usuario   CHAR(50),
   Usuario2   CHAR(50),
   PRIMARY KEY (Usuario,Usuario2),
   FOREIGN KEY (Usuario) REFERENCES Usuario(Correo_electronico),
   FOREIGN KEY (Usuario2) REFERENCES Usuario(Correo_electronico)
);

