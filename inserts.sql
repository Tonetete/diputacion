
INSERT INTO ROLES(codigo,tipo) VALUES
(1,'administrador') ,
(2,'controlador') ,
(3,'jefe de servicio') ,
(4,'usuario');


INSERT INTO GRUPO_RESCATE (codigo,nombre) VALUES
(1,'GRUPO_RESCATE A') ,
(2,'GRUPO_RESCATE B') ,
(3,'GRUPO_RESCATE C') ,
(4,'GRUPO_RESCATE D') ,
(5,'GRUPO_RESCATE E');


INSERT INTO PERFIL(codigo, descripcion, saldo_limite) VALUES
(1,'TARIFA DEL 20',20.0) ,
(2,'TARIFA DEL 40',40.0) ,
(3,'TARIFA DEL 60',60.0) ,
(4,'TARIFA DEL 80',80.0) ,
(5,'TARIFA DEL 100',100.0) ,
(6,'TARIFA DEL 200',200.0) ,
(7,'TARIFA DEL 300',300.0) ,
(8,'TARIFA DEL 500',500.0);

INSERT INTO MUNICIPIO (provincia, nombre) VALUES
('Málaga','Málaga') ,
('Sevilla','Sevilla') ,
('Jaén','Jaén') ,
('Córdoba','Córdoba') ,
('Huelva','Huelva') ,
('Granada','Granada') ,
('Cádiz','Cádiz') ,
('Almería','ALmería');

INSERT INTO DIPUTACION(codigo,direccion,telefono,cod_postal,ciudad) VALUES
(1,'C/ Navarro Rodrigo, 17','950211100','04071','Almería') ,
(2,'Plaza de España , s/n','956240100','11071','Cádiz') ,
(3,'Plaza de Colón , s/n ','957211100','14071','Córdoba') ,
(4,'Avenida del Sur, 3 ','958247500','18014','Granada') ,
(5,'Avenida Martín Alonso Pinzón, 9','959494230','21003','Huelva') ,
(6,'Plaza de San Francisco, s/n ','953248000','23071','Jaén') ,
(7,'Plaza de la Marina, s/n ','952133500 ','29071','Málaga') ,
(8,'Avenida Menéndez y Pelayo, 32 ','954550000','41071','Sevilla');


INSERT INTO CATEGORIA(codigo,descripcion) VALUES
(1,'Llamadas Provinciales') ,
(2,'Llamadas Nacionales') ,
(3,'Llamadas Internacionales') ,
(4,'Llamadas a Móviles') ,
(5,'Llamadas a 800X') ,
(6,'Llamadas a 900X');

INSERT INTO TERMINAL(codigo,fecha_alta,fecha_baja,marca,modelo,configuracion,sn,numero_interno,pedido,product) VALUES
(1,'2013-01-01 00:00:00', '2013-12-31 00:00:00', 'Samsung', 'Galaxy Nexus','MOVIL','123','','','') ,
(2,'2013-01-02 00:00:00', '2013-12-31 00:00:00', 'Samsung', 'Samsung Galaxy S3','MOVIL','124','','','') ,
(3,'2013-01-04 00:00:00', '2013-12-31 00:00:00', 'iPhone', '4S','MOVIL','125','','','') ,
(4,'2013-01-05 00:00:00', '2013-12-31 00:00:00', 'iPhone', '5','MOVIL','126','','','') ,
(5,'2013-01-06 00:00:00', '2013-12-31 00:00:00', 'Nokia', 'Lumia','MOVIL','127','','','') ,
(6,'2013-01-07 00:00:00', '2013-12-31 00:00:00', 'HTC', 'ONE','MOVIL','128','','','') ,
(7,'2013-01-08 00:00:00', '2013-12-31 00:00:00', 'HTC', 'Hero','MOVIL','129','','','') ,
(8,'2013-01-09 00:00:00', '2013-12-31 00:00:00', 'HTC', 'Wildfire','MOVIL','130','','','') ,
(9,'2013-01-10 00:00:00', '2013-12-31 00:00:00', 'Alcatel', 'G400','MOVIL','131','','','') ,
(10,'2013-01-11 00:00:00', '2013-12-31 00:00:00', 'LG', 'Nexus 4','MOVIL','132','','','') ,
(11,'2013-01-12 00:00:00', '2013-12-31 00:00:00', 'Sony', 'Xperia P','MOVIL','133','','','') ,
(12,'2013-01-13 00:00:00', '2013-12-31 00:00:00', 'Sony', 'Xperia S','MOVIL','134','','','') ,
(13,'2013-01-14 00:00:00', '2013-12-31 00:00:00', 'Sony', 'Xperia U','MOVIL','135','','','') ,
(14,'2013-01-15 00:00:00', '2013-12-31 00:00:00', 'LG Optimus', 'L5','MOVIL','136','','','') ,
(15,'2013-01-16 00:00:00', '2013-12-31 00:00:00', 'Samsung', 'Galaxy Ace 2','MOVIL','137','','','') ,
(16,'2013-01-17 00:00:00', '2013-12-31 00:00:00', 'HTC', 'Desire X','MOVIL','138','','','') ,
(17,'2013-01-18 00:00:00', '2013-12-31 00:00:00', 'Blackberry', 'Curve','MOVIL','139','','','') ,
(18,'2013-01-19 00:00:00', '2013-12-31 00:00:00', 'Nokia', 'Lumia 710','MOVIL','140','','','') ,
(19,'2013-01-20 00:00:00', '2013-12-31 00:00:00', 'Motorola', 'MOTOLUXE','MOVIL','141','','','') ,
(20,'2013-01-21 00:00:00', '2013-12-31 00:00:00', 'Huawei', 'Ascend P1','MOVIL','142','','','') ,
(21,'2013-01-22 00:00:00', '2013-12-31 00:00:00', 'ZTE', 'Blade','MOVIL','143','','','') ,
(22,'2013-01-23 00:00:00', '2013-12-31 00:00:00', 'Nokia', '5580','MOVIL','144','','','') ,
(23,'2013-01-24 00:00:00', '2013-12-31 00:00:00', 'Samsung', 'Google Nexus 7','MOVIL','145','','','') ,
(24,'2013-01-25 00:00:00', '2013-12-31 00:00:00', 'Philips', 'C300','FIJO','146','','','') ,
(25,'2013-01-26 00:00:00', '2013-12-31 00:00:00', 'Philips', 'C300','FIJO','147','','','') ,
(26,'2013-01-27 00:00:00', '2013-12-31 00:00:00', 'Philips', 'C300','FIJO','148','','','') ,
(27,'2013-01-28 00:00:00', '2013-12-31 00:00:00', 'Philips', 'C300','FIJO','149','','','') ,
(28,'2013-01-29 00:00:00', '2013-12-31 00:00:00', 'Philips', 'C300','FIJO','150','','','') ,
(29,'2013-01-30 00:00:00', '2013-12-31 00:00:00', 'Philips', 'C300','FIJO','151','','','') ,
(30,'2013-01-31 00:00:00', '2013-12-31 00:00:00', 'Philips', 'C300','FIJO','152','','','') ,
(31,'2013-02-01 00:00:00', '2013-12-31 00:00:00', 'Philips', 'C300','FIJO','153','','','') ,
(32,'2013-02-02 00:00:00', '2013-12-31 00:00:00', 'DOMO', 'D1','FIJO','154','','','') ,
(33,'2013-02-03 00:00:00', '2013-12-31 00:00:00', 'DOMO', 'D1','FIJO','155','','','') ,
(34,'2013-02-04 00:00:00', '2013-12-31 00:00:00', 'DOMO', 'D1','FIJO','156','','','') ,
(35,'2013-02-05 00:00:00', '2013-12-31 00:00:00', 'DOMO', 'D1','FIJO','157','','','') ,
(36,'2013-02-06 00:00:00', '2013-12-31 00:00:00', 'DOMO', 'D1','FIJO','158','','','') ,
(37,'2013-02-07 00:00:00', '2013-12-31 00:00:00', 'DOMO', 'D1','FIJO','159','','','') ,
(38,'2013-02-08 00:00:00', '2013-12-31 00:00:00', 'DOMO', 'D1','FIJO','160','','','') ,
(39,'2013-02-09 00:00:00', '2013-12-31 00:00:00', 'DOMO', 'D1','FIJO','161','','','') ,
(40,'2013-02-10 00:00:00', '2013-12-31 00:00:00', 'TELECOM', 'SPC','FIJO','162','','','') ,
(41,'2013-02-11 00:00:00', '2013-12-31 00:00:00', 'TELECOM', 'SPC','FIJO','163','','','') ,
(42,'2013-02-12 00:00:00', '2013-12-31 00:00:00', 'TELECOM', 'SPC','FIJO','164','','','') ,
(43,'2013-02-13 00:00:00', '2013-12-31 00:00:00', 'TELECOM', 'SPC','FIJO','165','','','') ,
(44,'2013-02-14 00:00:00', '2013-12-31 00:00:00', 'TELECOM', 'SPC','FIJO','166','','','') ,
(45,'2013-02-15 00:00:00', '2013-12-31 00:00:00', 'TELECOM', 'SPC','FIJO','167','','','') ,
(46,'2013-02-16 00:00:00', '2013-12-31 00:00:00', 'TELECOM', 'SPC','FIJO','168','','','') ,
(47,'2013-02-17 00:00:00', '2013-12-31 00:00:00', 'TELECOM', 'SPC','FIJO','169','','','') ,
(48,'2013-02-18 00:00:00', '2013-12-31 00:00:00', 'Siemens', 'Gigaset','FIJO','170','','','') ,
(49,'2013-02-19 00:00:00', '2013-12-31 00:00:00', 'Siemens', 'Gigaset','FIJO','171','','','') ,
(50,'2013-02-20 00:00:00', '2013-12-31 00:00:00', 'Siemens', 'Gigaset','FIJO','172','','','');



INSERT INTO LINEA (codigo,numero,periodo_facturacion,publico) VALUES
(1,657770878,'2013-01-01 00:00:00','Y') ,
(2,696993301,'2013-01-01 00:00:00','Y') ,
(3,629620754,'2013-01-01 00:00:00','Y') ,
(4,654320357,'2013-01-01 00:00:00','Y') ,
(5,653909456,'2013-01-01 00:00:00','Y') ,
(6,678538235,'2013-01-01 00:00:00','Y') ,
(7,677170356,'2013-01-01 00:00:00','Y') ,
(8,651648856,'2013-01-01 00:00:00','Y') ,
(9,671318095,'2013-01-01 00:00:00','Y') ,
(10,675530418,'2013-01-01 00:00:00','Y') ,
(11,692282505,'2013-01-01 00:00:00','Y') ,
(12,633837978,'2013-01-01 00:00:00','Y') ,
(13,664855237,'2013-01-01 00:00:00','Y') ,
(14,610365132,'2013-01-01 00:00:00','Y') ,
(15,674679003,'2013-01-01 00:00:00','Y') ,
(16,637009049,'2013-01-01 00:00:00','Y') ,
(17,602941151,'2013-01-01 00:00:00','Y') ,
(18,620442146,'2013-01-01 00:00:00','Y') ,
(19,606831597,'2013-01-01 00:00:00','Y') ,
(20,684207229,'2013-01-01 00:00:00','Y') ,
(21,657770878,'2013-01-01 00:00:00','Y') ,
(22,657770978,'2013-01-01 00:00:00','Y') ,
(23,655883563,'2013-01-01 00:00:00','Y') ,
(24,606557088,'2013-01-01 00:00:00','Y') ,
(25,634310475,'2013-01-01 00:00:00','Y') ,
(26,959338110,'2013-01-01 00:00:00','Y') ,
(27,953985638,'2013-01-01 00:00:00','Y') ,
(28,957940920,'2013-01-01 00:00:00','Y') ,
(29,951693588,'2013-01-01 00:00:00','Y') ,
(30,959384676,'2013-01-01 00:00:00','Y') ,
(31,956443914,'2013-01-01 00:00:00','Y') ,
(32,956420449,'2013-01-01 00:00:00','Y') ,
(33,957578660,'2013-01-01 00:00:00','Y') ,
(34,957022891,'2013-01-01 00:00:00','Y') ,
(35,954760823,'2013-01-01 00:00:00','Y') ,
(36,950019085,'2013-01-01 00:00:00','Y') ,
(37,952983389,'2013-01-01 00:00:00','Y') ,
(38,956198353,'2013-01-01 00:00:00','Y') ,
(39,954978667,'2013-01-01 00:00:00','Y') ,
(40,956816697,'2013-01-01 00:00:00','Y');


INSERT INTO USUARIO(dni,nombre,apellidos,email,codigo_rescate,codigo_dip,codigo_rol) VALUES
('71946976D','Juan','Romero Tello','jromerotello@gmail.com',1,NULL,1) ,
('03082054P','Jesús','De la Cruz Freire','jcruzfreire@gmail.com',2,1,2) ,
('84018843G','Marta','Cortés Paños','mcortespaños@gmail.com',3,1,3) ,
('34529080P','Antonio','Otero De Juan','aoterodejuan@gmail.com',4,1,4) ,
('13163532B','María José','Márques Martínez','mjosemarques@gmail.com',5,2,2) ,
('99097605N','Ángeles','Pardo Llanos','apardollanos@gmail.com',1,2,3) ,
('85698664C','Raquel','Nicolás Juárez','rnicolas@gmail.com',2,2,4) ,
('63719306Z','María Dolores','González Bernal','mgonzalezbernal@gmail.com',3,3,2) ,
('87787332N','Francisco','Suárez Miro','fsuarezmiro@gmail.com',4,3,3) ,
('62626527B','Pedro','García Ruano','pgarciaruano@gmail.com',5,3,4) ,
('38615781T','Carmen','Salgado Prieto','csalgadoprieto@gmail.com',1,4,2) ,
('93147298N','José Miguel','Sancho Espínola','jsancho@gmail.com',2,4,3) ,
('19998743J','Marta','Sola Taylor','msolataylor@gmail.com',3,4,4) ,
('44103398R','Gloria','Del Castillo Etxebarria','gcastillo@gmail.com',4,5,2) ,
('39957941H','Jesús','Aparicio Carpio','japaricio@gmail.com',5,5,3) ,
('59133396M','Beatriz','Sánchez	Barrena','bsanchezbarrena@gmail.com',1,5,4) ,
('39124960M','Rosario','Trujillo López','rtrujillo@gmail.com',2,6,2) ,
('36060096Y','Ramón','Alfonso González','ralfonsogonzalez@gmail.com',3,6,3) ,
('29002943N','Marta','Gil Montserrat','mgilmontserrat@gmail.com',4,6,4) ,
('30370939Z','María Jesús','Ramos Macia','mramosmacia@gmail.com',5,7,2) ,
('19650728B','Mercedes','Rufo Sánchez','mrufosanchez@gmail.com',1,7,3) ,
('34182948A','Antonio','Navarro	Sánchez','anavarrosanchez@gmail.com',2,7,4) ,
('16867684J','María Dolores','González Fernández','mgonzalezfernandez@gmail.com',3,8,2) ,
('93164374E','María Teresa','Vázquez Álvarez','mvazquezalvarez@gmail.com',4,8,3) ,
('87404617V','María Carmen','Casanova Soriano','mcasanovasoriano@gmail.com',5,8,4);

INSERT INTO TIPO_TAREA(id,nombre) VALUES
(1,"TARIFA"),
(2,"SOLICITAR TERMINAL FIJO"),
(3,"SOLICITAR TERMINAL MOVIL");
(4,"SOLICITAR LINEA"),
(5,"CATEGORIA");


