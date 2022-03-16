CREATE TABLE Usuario
(
   Nombre_de_usuario    CHAR(50) PRIMARY KEY,
   Correo_electronico   CHAR(100)        NOT NULL,
   Contrasena           CHAR(40)        NOT NULL,
   Pais                 CHAR(50)        NOT NULL,
   Puntos               NUMBER        NOT NULL,
   Conectado            BOOLEAN        NOT NULL
);

CREATE TABLE Amigo
(
   Usuario_Nombre_de_usuario   CHAR(50),
   Usuario_Nombre_de_usuario   CHAR(50),
   PRIMARY KEY (Usuario_Nombre_de_usuario,Usuario_Nombre_de_usuario),
   FOREIGN KEY (Usuario_Nombre_de_usuario) REFERENCES Usuario(Nombre_de_usuario),
   FOREIGN KEY (Usuario_Nombre_de_usuario) REFERENCES Usuario(Nombre_de_usuario)
);

