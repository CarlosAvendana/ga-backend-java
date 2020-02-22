use gaBD;

INSERT INTO `gadb`.`carrera` (`codigo`, `titulo`, `nombre`) VALUES ('EIF', 'Bachillerato', 'Informática');
INSERT INTO `gadb`.`carrera` (`codigo`, `titulo`, `nombre`) VALUES ('ETE', 'Bachillerato', 'Administración');
INSERT INTO `gadb`.`carrera` (`codigo`, `titulo`, `nombre`) VALUES ('DAB', 'Bachillerato', 'Danza');
INSERT INTO `gadb`.`carrera` (`codigo`, `titulo`, `nombre`) VALUES ('AEB', 'Bachillerato', 'Arte Escénico');
INSERT INTO `gadb`.`carrera` (`codigo`, `titulo`, `nombre`) VALUES ('MCA', 'Bachillerato', 'Canto');

INSERT INTO `gadb`.`curso` (`codigo`, `carrera_codigo`, `anio`, `ciclo`, `nombre`, `creditos`, `horas_semanales`) VALUES ('EIF200', 'EIF', '2020', 'I', 'Fundamentos de informática', '3', '4');
INSERT INTO `gadb`.`curso` (`codigo`, `carrera_codigo`, `anio`, `ciclo`, `nombre`, `creditos`, `horas_semanales`) VALUES ('EIF204', 'EIF', '2020', 'I', 'Programación II', '4', '6');
INSERT INTO `gadb`.`curso` (`codigo`, `carrera_codigo`, `anio`, `ciclo`, `nombre`, `creditos`, `horas_semanales`) VALUES ('EIF206', 'EIF', '2020', 'I', 'Estructuras de datos', '4', '4');
INSERT INTO `gadb`.`curso` (`codigo`, `carrera_codigo`, `anio`, `ciclo`, `nombre`, `creditos`, `horas_semanales`) VALUES ('EIF208', 'EIF', '2020', 'II', 'Programación III', '4', '6');
INSERT INTO `gadb`.`curso` (`codigo`, `carrera_codigo`, `anio`, `ciclo`, `nombre`, `creditos`, `horas_semanales`) VALUES ('EIF210', 'EIF', '2020', 'II', 'Administración de bases de datos', '4', '6');

INSERT INTO `gadb`.`curso` (`codigo`, `carrera_codigo`, `anio`, `ciclo`, `nombre`, `creditos`, `horas_semanales`) VALUES ('AEB001', 'AEB', '2020', 'I', 'Expresión Escénica I', '4', '6');
INSERT INTO `gadb`.`curso` (`codigo`, `carrera_codigo`, `anio`, `ciclo`, `nombre`, `creditos`, `horas_semanales`) VALUES ('AEB002', 'AEB', '2020', 'I', 'Elementos de Dramaturgia', '3', '4');
INSERT INTO `gadb`.`curso` (`codigo`, `carrera_codigo`, `anio`, `ciclo`, `nombre`, `creditos`, `horas_semanales`) VALUES ('AEB003', 'AEB', '2020', 'I', 'Taller de Experimentación', '4', '6');
INSERT INTO `gadb`.`curso` (`codigo`, `carrera_codigo`, `anio`, `ciclo`, `nombre`, `creditos`, `horas_semanales`) VALUES ('AEB004', 'AEB', '2020', 'II', 'Seminario de investigación I', '4', '6');
INSERT INTO `gadb`.`curso` (`codigo`, `carrera_codigo`, `anio`, `ciclo`, `nombre`, `creditos`, `horas_semanales`) VALUES ('AEB005', 'AEB', '2020', 'II', 'Métodos de investigación en las Artes Escénicas', '3', '6');
INSERT INTO `gadb`.`curso` (`codigo`, `carrera_codigo`, `anio`, `ciclo`, `nombre`, `creditos`, `horas_semanales`) VALUES ('AEB006', 'AEB', '2020', 'II', 'Módulo I: Puesta en escena/plástica/dramaturgia', '5', '12');

INSERT INTO `gadb`.`curso` (`codigo`, `carrera_codigo`, `anio`, `ciclo`, `nombre`, `creditos`, `horas_semanales`) VALUES ('DAB001', 'DAB', '2020', 'II', 'Taller de Expresión y Composición IV', '4', '6');
INSERT INTO `gadb`.`curso` (`codigo`, `carrera_codigo`, `anio`, `ciclo`, `nombre`, `creditos`, `horas_semanales`) VALUES ('DAB002', 'DAB', '2020', 'II', 'Seminario de Estilos de la Danza', '4', '6');
INSERT INTO `gadb`.`curso` (`codigo`, `carrera_codigo`, `anio`, `ciclo`, `nombre`, `creditos`, `horas_semanales`) VALUES ('DAB003', 'DAB', '2020', 'I', 'DISEÑO DE VESTUARIO PARA LAS ARTES ESCÉNICAS', '3', '4');
INSERT INTO `gadb`.`curso` (`codigo`, `carrera_codigo`, `anio`, `ciclo`, `nombre`, `creditos`, `horas_semanales`) VALUES ('DAB004', 'DAB', '2020', 'I', 'MONTAJE E INTERPRETACION ESCENICA', '5', '12');
INSERT INTO `gadb`.`curso` (`codigo`, `carrera_codigo`, `anio`, `ciclo`, `nombre`, `creditos`, `horas_semanales`) VALUES ('DAB005', 'DAB', '2020', 'II', 'Taller de Danzas Costarricenses', '5', '12');

INSERT INTO `gadb`.`curso` (`codigo`, `carrera_codigo`, `anio`, `ciclo`, `nombre`, `creditos`, `horas_semanales`) VALUES ('ETE01', 'ETE', '2020', 'I', 'Desarrollo Socio-económico de Costa Rica', '4', '6');
INSERT INTO `gadb`.`curso` (`codigo`, `carrera_codigo`, `anio`, `ciclo`, `nombre`, `creditos`, `horas_semanales`) VALUES ('ETE02', 'ETE', '2020', 'I', 'Paradigmas Administrativos', '4', '6');
INSERT INTO `gadb`.`curso` (`codigo`, `carrera_codigo`, `anio`, `ciclo`, `nombre`, `creditos`, `horas_semanales`) VALUES ('ETE03', 'ETE', '2020', 'I', 'Finanzas Empresariales', '4', '6');
INSERT INTO `gadb`.`curso` (`codigo`, `carrera_codigo`, `anio`, `ciclo`, `nombre`, `creditos`, `horas_semanales`) VALUES ('ETE04', 'ETE', '2020', 'II', 'Administración y Ambiente', '3', '6');
INSERT INTO `gadb`.`curso` (`codigo`, `carrera_codigo`, `anio`, `ciclo`, `nombre`, `creditos`, `horas_semanales`) VALUES ('ETE05', 'ETE', '2020', 'II', 'Contabilidad Intermedia', '5', '8');

INSERT INTO `gadb`.`curso` (`codigo`, `carrera_codigo`, `anio`, `ciclo`, `nombre`, `creditos`, `horas_semanales`) VALUES ('MCA12', 'MCA', '2020', 'I', 'Introducción al Lied', '5', '12');
