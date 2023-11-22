CREATE DATABASE IF NOT EXISTS BDWarmisitAI;

USE  BDWarmisitAI;

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

DELIMITER //
CREATE PROCEDURE listar_incidencias_sin_tipo(IN id_tipo_incidencia INT)
BEGIN
    SELECT fecha, hora, nombre, descripcion
    FROM tbl_Incidencia_Reportada 
    WHERE id_tipo_incidencia IS NULL;
END //
DELIMITER ;

CREATE TABLE IF NOT EXISTS tbl_Tipo_Incidencia_Reportado (
    id_tipo_incidencia INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50)
);
INSERT INTO tbl_Tipo_Incidencia_Reportado (nombre) values
('Tecnologico'),
('No Tecnologico'),
('Emitido por Entidades Externas');



-- TECNICOS --
CREATE TABLE IF NOT EXISTS tbl_Tecnico (
    id_tecnico INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255),
    apellidos VARCHAR(150),
    dni VARCHAR(8) UNIQUE,
    telefono VARCHAR(9),
    estado ENUM('DISPONIBLE', 'OCUPADO')
);
INSERT INTO tbl_Tecnico (nombre, apellidos, dni, telefono, estado) VALUES
('Paolo', 'Guerrero', '12345678', '987654321', 'DISPONIBLE'),
('Jefferson', 'Farfán', '87654321', '123456789', 'OCUPADO'),
('Renato', 'Tapia', '56781234', '987654321', 'DISPONIBLE'),
('Yoshimar', 'Yotún', '43218765', '123456789', 'OCUPADO');
select * from tbl_Tecnico;




