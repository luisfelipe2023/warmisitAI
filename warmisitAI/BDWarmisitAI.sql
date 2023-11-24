CREATE DATABASE IF NOT EXISTS BDWarmisitAI;

USE  BDWarmisitAI;
select * from tbl_Tecnico ;
select * from users;

-- INCIDENCIA --
CREATE TABLE tbl_Incidencia_Reportada (
    id int AUTO_INCREMENT PRIMARY KEY,
    fecha DATE,
    hora TIME,
    nombre VARCHAR(255),
    descripcion TEXT,
    id_tipo_incidencia int references tbl_Tipo_Incidencia_Reportado
);
INSERT INTO tbl_Incidencia_Reportada (fecha, hora, nombre, descripcion)
VALUES ('2023-11-18', '12:30:00', 'Error de Conexión de Red', 'Se ha reportado un error de conexión de red al intentar acceder a la aplicación.');

/**TABLA TIPO DE INCIDENCIA**/
CREATE TABLE IF NOT EXISTS tbl_Tipo_Incidencia_Reportado (
    id_tipo_incidencia INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50)
);
INSERT INTO tbl_Tipo_Incidencia_Reportado (nombre) values
('Tecnologico'),
('No Tecnologico'),
('Emitido por Entidades Externas');


DELIMITER //
CREATE PROCEDURE listar_incidencias_sin_tipo(IN id_tipo_incidencia INT)
BEGIN
    SELECT fecha, hora, nombre, descripcion
    FROM tbl_Incidencia_Reportada 
    WHERE id_tipo_incidencia IS NULL;
END //
DELIMITER ;

-- TABLA TECNICOS --
CREATE TABLE IF NOT EXISTS tbl_Tecnico (
    id_tecnico INT AUTO_INCREMENT PRIMARY KEY,
    id BIGINT ,
    FOREIGN KEY (id) REFERENCES users(id),
    dni VARCHAR(8) UNIQUE,
    telefono VARCHAR(9)
);

INSERT INTO tbl_Tecnico (id, dni, telefono)
VALUES
    (1, '12345678', '987654321'),
    (2, '87654321', '123456789');
-- TABLA  LOGIN --
CREATE TABLE users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(255),
    fullname VARCHAR(255) NOT NULL
);
CREATE TABLE Bitacora (
    id INT AUTO_INCREMENT PRIMARY KEY,
    fecha DATE NOT NULL,
    hora TIME NOT NULL,
    descripcion TEXT NOT NULL,
    id_tipo_incidencia int references tbl_Tipo_Incidencia_Reportado,
    incidencia_id INT,
    FOREIGN KEY (incidencia_id) REFERENCES tbl_incidencia_reportada(id)
);

INSERT INTO Bitacora (fecha, hora, descripcion, id_tipo_incidencia, incidencia_id)
VALUES 
    ('2023-11-24', '10:30:00', 'Se ha reportado un error de conexión de red al intentar acceder a la aplicación.', 1, 1);
   
select * from Bitacora;
INSERT INTO users (email, password, role, fullname) VALUES
('pMontes@gmail.com', '741852963', 'MODERADOR', 'Patrick Montes'),
('luisFlp@gmail.com', '963852741', 'USER', 'Luis Felipe'),
('josePacco@hotmail.com', '852741963', 'MODERADOR', 'Jose Pacco'),
('adrLL@hotmail.com', '369258147', 'user', 'Adrian Romero')


