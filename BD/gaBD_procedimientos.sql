-- Procedimientos para cursos


-- drop procedure ObtieneTODOS_CURSOS;

DELIMITER //
CREATE PROCEDURE ObtieneTODOS_CURSOS()
BEGIN
	SELECT codigo, carrera_codigo, anio, ciclo, nombre,creditos,horas_semanales FROM gadb.curso;
END 
//
DELIMITER ;

