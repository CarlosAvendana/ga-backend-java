-- Procedimientos para cursos


-- drop procedure ObtieneTODOS_CURSOS;

DELIMITER //
CREATE PROCEDURE PRC_ObtieneTODOS_CURSOS()
BEGIN
	SELECT codigo, carrera_codigo, anio, ciclo, nombre,creditos,horas_semanales FROM gadb.curso;
END 
//
DELIMITER ;

-- drop procedure PRC_INS_CURSO;
DELIMITER //
CREATE PROCEDURE PRC_INS_CURSO(codigo_ varchar(10), carrera_codigo_ varchar(10),anio_ varchar(15),ciclo_ varchar(15),nombre_ varchar(100), creditos_ int, horas_semanales_ int)
BEGIN
	insert into gabd.curso (codigo,carrera_codigo,anio,ciclo,nombre,creditos,horas_semanales) 
	values (codigo_,carrera_codigo_,anio_,ciclo_,nombre_,nombre_,creditos_,horas_semanales_);
END
//
DELIMITER ;

