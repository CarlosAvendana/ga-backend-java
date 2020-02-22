use gadb; 

DROP PROCEDURE IF EXISTS PRC_INS_CURSO;

DELIMITER //
CREATE PROCEDURE PRC_INS_CURSO(codigo_ varchar(10), carrera_codigo_ varchar(10),anio_ varchar(15),ciclo_ varchar(15),nombre_ varchar(100), creditos_ int, horas_semanales_ int)
BEGIN
	insert into gadb.curso (codigo,carrera_codigo,anio,ciclo,nombre,creditos,horas_semanales) 
	values (codigo_,carrera_codigo_,anio_,ciclo_,nombre_,creditos_,horas_semanales_);
END
//
DELIMITER ;

DROP PROCEDURE IF EXISTS PRC_DEL_CURSO;

DELIMITER //
CREATE PROCEDURE PRC_DEL_CURSO(codigo_ varchar(10))
BEGIN 
	delete from gadb.curso 
	where codigo=codigo_;
END
//
DELIMITER ;

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

DROP PROCEDURE IF EXISTS PRC_ObtieneTODOS_CURSOS;

DELIMITER //
CREATE PROCEDURE PRC_ObtieneTODOS_CURSOS()
BEGIN
	SELECT codigo, carrera_codigo, anio, ciclo, nombre,creditos,horas_semanales FROM gadb.curso;
END 
//
DELIMITER ;

DROP PROCEDURE IF EXISTS PRC_INS_CARRERA;

DELIMITER //
CREATE PROCEDURE PRC_INS_CARRERA(codigo_ varchar(10), titulo_ varchar(25),nombre_ varchar(100))
BEGIN
	insert into gadb.carrera (codigo, titulo, nombre) 
	values (codigo_,titulo_,nombre_);
END
//
DELIMITER ;
	
DROP PROCEDURE IF EXISTS PRC_DEL_CARRERA;

DELIMITER //
CREATE PROCEDURE PRC_DEL_CARRERA(codigo_ varchar(10))
BEGIN 
	delete from gadb.carrera 
	where codigo=codigo_;
END
//
DELIMITER ;

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

DROP PROCEDURE IF EXISTS PRC_ObtieneTODOS_CARRERA;

DELIMITER //
CREATE PROCEDURE PRC_ObtieneTODOS_CARRERA()
BEGIN
	SELECT codigo, titulo, nombre FROM gadb.carrera;
END 
//
DELIMITER ;