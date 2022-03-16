CREATE TABLE Usuario
(
   Nombre_de_usuario           CHAR(-1) PRIMARY KEY,
   Correo_electronico          CHAR(-1)        NOT NULL,
   Contrasena                  CHAR(-1)        NOT NULL,
   Pais                        CHAR(-1)        NOT NULL,
   Puntos                      NUMBER        NOT NULL,
   Conectado                   BOOLEAN        NOT NULL,
   Usuario_Nombre_de_usuario   CHAR(-1)        NOT NULL,
   FOREIGN KEY (Usuario_Nombre_de_usuario) REFERENCES Usuario(Nombre_de_usuario)
);

