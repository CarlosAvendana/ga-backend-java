-- Procedimientos para cursos

drop procedure IF EXISTS PRC_ObtieneTODOS_CURSOS;

DELIMITER //
CREATE PROCEDURE PRC_ObtieneTODOS_CURSOS()
BEGIN
	SELECT codigo, carrera_codigo, anio, ciclo, nombre,creditos,horas_semanales FROM gadb.curso;
END 
//
DELIMITER ;

drop procedure IF EXIST PRC_INS_CURSO;

DELIMITER //
CREATE PROCEDURE PRC_INS_CURSO(codigo_ varchar(10), carrera_codigo_ varchar(10),anio_ varchar(15),ciclo_ varchar(15),nombre_ varchar(100), creditos_ int, horas_semanales_ int)
BEGIN
	insert into gabd.curso (codigo,carrera_codigo,anio,ciclo,nombre,creditos,horas_semanales) 
	values (codigo_,carrera_codigo_,anio_,ciclo_,nombre_,creditos_,horas_semanales_);
END
//
DELIMITER ;

drop procedure IF EXIST PRC_UPD_CURSO;

DELIMITER //
CREATE PROCEDURE PRC_UPD_CURSO(codigo_ varchar(10), carrera_codigo_ varchar(10),anio_ varchar(15),ciclo_ varchar(15),nombre_ varchar(100), creditos_ int, horas_semanales_ int)
BEGIN
	update gabd.curso
	set anio=anio_,ciclo=ciclo_,nombre=nombre_,creditos=creditos_,horas_semanales=horas_semanales
	where codigo=codigo_ and carrera_codigo=carrera_codigo_;
END
//
DELIMITER ; 

drop procedure if exist PRC_DEL_CURSO;

DELIMITER //
CREATE PROCEDURE PRC_DEL_CURSO(codigo_ varchar(10))
BEGIN 
	delete from gabd.curso 
	where codigo=codigo_;
END
//
DELIMITER ;


