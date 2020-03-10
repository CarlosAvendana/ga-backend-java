use gadb; 

-- Create Carrera
DROP PROCEDURE IF EXISTS PRC_INS_CARRERA;

DELIMITER //
CREATE PROCEDURE PRC_INS_CARRERA(codigo_ varchar(10), titulo_ varchar(25),nombre_ varchar(100))
BEGIN
	insert into gadb.carrera (codigo, titulo, nombre) 
	values (codigo_,titulo_,nombre_);
END
//
DELIMITER ;

-- Retrieve Carrera
DROP PROCEDURE IF EXISTS PRC_OBTIENE_UNA_CARRERA;

DELIMITER //
CREATE PROCEDURE PRC_OBTIENE_UNA_CARRERA(codigo_ varchar(10))
BEGIN
	SELECT codigo, titulo, nombre FROM gadb.carrera 
	where codigo=codigo_;
END 
//
DELIMITER ;

-- Update Carrera
DROP PROCEDURE IF EXISTS PRC_UPD_CARRERA;

DELIMITER //
CREATE PROCEDURE PRC_UPD_CARRERA(codigo_ varchar(10), titulo_ varchar(25),nombre_ varchar(100))
BEGIN
	update gadb.carrera
	set codigo=codigo_,titulo=titulo_,nombre=nombre_
	where codigo=codigo_;
END
//
DELIMITER ; 

-- Delete Carrera	
DROP PROCEDURE IF EXISTS PRC_DEL_CARRERA;

DELIMITER //
CREATE PROCEDURE PRC_DEL_CARRERA(codigo_ varchar(10))
BEGIN 
	delete from gadb.carrera 
	where codigo=codigo_;
END
//
DELIMITER ;

-- All Carrera
DROP PROCEDURE IF EXISTS PRC_ObtieneTODOS_CARRERA;

DELIMITER //
CREATE PROCEDURE PRC_ObtieneTODOS_CARRERA()
BEGIN
	SELECT codigo, titulo, nombre FROM gadb.carrera;
END 
//
DELIMITER ;

-- Retrieve Curso
DROP PROCEDURE IF EXISTS PRC_OBTIENE_UN_CURSO;

DELIMITER //
CREATE PROCEDURE PRC_OBTIENE_UN_CURSO(codigo_ varchar(10))
BEGIN
	SELECT codigo, carrera_codigo, anio, ciclo, nombre,creditos,horas_semanales FROM gadb.curso 
	where codigo=codigo_;
END 
//
DELIMITER ;

-- Create Curso
DROP PROCEDURE IF EXISTS PRC_INS_CURSO;

DELIMITER //
CREATE PROCEDURE PRC_INS_CURSO(codigo_ varchar(10), carrera_codigo_ varchar(10),anio_ varchar(15),ciclo_ varchar(15),nombre_ varchar(100), creditos_ int, horas_semanales_ int)
BEGIN
	insert into gadb.curso (codigo,carrera_codigo,anio,ciclo,nombre,creditos,horas_semanales) 
	values (codigo_,carrera_codigo_,anio_,ciclo_,nombre_,creditos_,horas_semanales_);
END
//
DELIMITER ;

--Delete Curso
DROP PROCEDURE IF EXISTS PRC_DEL_CURSO;

DELIMITER //
CREATE PROCEDURE PRC_DEL_CURSO(codigo_ varchar(10))
BEGIN 
	delete from gadb.curso 
	where codigo=codigo_;
END
//
DELIMITER ;

--Cantidad curso carrera
DROP PROCEDURE IF EXISTS PRC_CANT_CURSO_CARRERA;

DELIMITER //
CREATE PROCEDURE PRC_CANT_CURSO_CARRERA(codigo_ varchar(10))
BEGIN 
	Select count(*) cantidad from gadb.curso
	where carrera_codigo = codigo_;
END
//
DELIMITER ;

-- Update Curso
DROP PROCEDURE IF EXISTS PRC_UPD_CURSO;

DELIMITER //
CREATE PROCEDURE PRC_UPD_CURSO(codigo_ varchar(10), carrera_codigo_ varchar(10),anio_ varchar(15),ciclo_ varchar(15),nombre_ varchar(100), creditos_ int, horas_semanales_ int)
BEGIN
	update gadb.curso
	set anio=anio_,ciclo=ciclo_,nombre=nombre_,creditos=creditos_,horas_semanales=horas_semanales
	where codigo=codigo_ and carrera_codigo=carrera_codigo_;
END
//
DELIMITER ; 

-- All Curso
DROP PROCEDURE IF EXISTS PRC_ObtieneTODOS_CURSOS;

DELIMITER //
CREATE PROCEDURE PRC_ObtieneTODOS_CURSOS()
BEGIN
	SELECT codigo, carrera_codigo, anio, ciclo, nombre,creditos,horas_semanales FROM gadb.curso;
END 
//
DELIMITER ;

-- All Usuario
DROP PROCEDURE IF EXISTS PRC_ObtieneTODOS_Usuario;

DELIMITER //
CREATE PROCEDURE PRC_ObtieneTODOS_Usuario()
BEGIN
	SELECT cedula, contrasena, nombre FROM gadb.usuario;
END 
//
DELIMITER ;

-- Retrieve Usuario
DROP PROCEDURE IF EXISTS PRC_OBTIENE_UN_USUARIO;

DELIMITER //
CREATE PROCEDURE PRC_OBTIENE_UN_USUARIO(cedula_ int)
BEGIN
	SELECT cedula, contrasena, nombre FROM gadb.usuario 
	where cedula=cedula_;
END 
//
DELIMITER ;

-- Valida Usuario
DROP PROCEDURE IF EXISTS PRC_VALIDA_USUARIO;

DELIMITER //
CREATE PROCEDURE PRC_VALIDA_USUARIO(cedula_ int,contrasena_ varchar(45))
BEGIN
	SELECT cedula, contrasena FROM gadb.usuario 
	where cedula=cedula_ AND contrasena=contrasena_;
END 
//
DELIMITER ;
