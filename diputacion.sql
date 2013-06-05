CREATE DATABASE  IF NOT EXISTS `diputacion` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `diputacion`;
-- MySQL dump 10.13  Distrib 5.6.11, for osx10.7 (x86_64)
--
-- Host: localhost    Database: diputacion
-- ------------------------------------------------------
-- Server version	5.6.11

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `ASIGNACION_FIJO`
--

DROP TABLE IF EXISTS `ASIGNACION_FIJO`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ASIGNACION_FIJO` (
  `fecha_asignacion` date NOT NULL,
  `fecha_fin` date NOT NULL,
  `dni` varchar(9) NOT NULL,
  `codigo_numero` int(11) NOT NULL DEFAULT '0',
  `codigo_terminal` int(11) NOT NULL,
  `codigo_cat` int(11) NOT NULL,
  `codigo` bigint(20) NOT NULL AUTO_INCREMENT,
  `coste` decimal(4,2) DEFAULT NULL,
  `asignado` char(1) NOT NULL,
  PRIMARY KEY (`codigo`),
  KEY `FK_ASIGNACION_FIJO_codigo_terminal` (`codigo_terminal`),
  KEY `FK_ASIGNACION_FIJO_codigo_cat` (`codigo_cat`),
  KEY `FK_ASIGNACION_FIJO_codigo_numero` (`codigo_numero`),
  KEY `FK_ASIGNACION_FIJO_dni` (`dni`),
  CONSTRAINT `FK_ASIGNACION_FIJO_codigo_cat` FOREIGN KEY (`codigo_cat`) REFERENCES `CATEGORIA` (`codigo`),
  CONSTRAINT `FK_ASIGNACION_FIJO_codigo_numero` FOREIGN KEY (`codigo_numero`) REFERENCES `LINEA` (`codigo`),
  CONSTRAINT `FK_ASIGNACION_FIJO_codigo_terminal` FOREIGN KEY (`codigo_terminal`) REFERENCES `TERMINAL` (`codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_ASIGNACION_FIJO_dni` FOREIGN KEY (`dni`) REFERENCES `USUARIO` (`dni`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ASIGNACION_FIJO`
--

LOCK TABLES `ASIGNACION_FIJO` WRITE;
/*!40000 ALTER TABLE `ASIGNACION_FIJO` DISABLE KEYS */;
INSERT INTO `ASIGNACION_FIJO` VALUES ('2013-02-01','2013-12-20','13163532B',26,34,1,1,NULL,'S'),('2015-11-01','2014-05-01','38615781T',35,25,1,2,NULL,'S'),('2013-06-05','2013-06-05','19650728B',27,49,1,3,NULL,'S'),('2013-06-05','2013-06-05','19650728B',28,32,1,4,NULL,'S');
/*!40000 ALTER TABLE `ASIGNACION_FIJO` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ASIGNACION_MOVIL`
--

DROP TABLE IF EXISTS `ASIGNACION_MOVIL`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ASIGNACION_MOVIL` (
  `asignado` char(1) NOT NULL,
  `coste` decimal(38,0) DEFAULT NULL,
  `fecha_asignacion` date DEFAULT NULL,
  `fecha_fin` date DEFAULT NULL,
  `codigo` bigint(20) NOT NULL AUTO_INCREMENT,
  `codigo_terminal` int(11) NOT NULL,
  `codigo_numero` int(11) NOT NULL,
  `dni` varchar(255) NOT NULL,
  `codigo_perfil` int(11) NOT NULL,
  PRIMARY KEY (`codigo`),
  KEY `FK_ASIGNACION_MOVIL_codigo_numero` (`codigo_numero`),
  KEY `FK_ASIGNACION_MOVIL_codigo_perfil` (`codigo_perfil`),
  KEY `FK_ASIGNACION_MOVIL_dni` (`dni`),
  KEY `FK_ASIGNACION_MOVIL_codigo_terminal` (`codigo_terminal`),
  CONSTRAINT `FK_ASIGNACION_MOVIL_codigo_numero` FOREIGN KEY (`codigo_numero`) REFERENCES `LINEA` (`codigo`),
  CONSTRAINT `FK_ASIGNACION_MOVIL_codigo_perfil` FOREIGN KEY (`codigo_perfil`) REFERENCES `PERFIL` (`codigo`),
  CONSTRAINT `FK_ASIGNACION_MOVIL_codigo_terminal` FOREIGN KEY (`codigo_terminal`) REFERENCES `TERMINAL` (`codigo`),
  CONSTRAINT `FK_ASIGNACION_MOVIL_dni` FOREIGN KEY (`dni`) REFERENCES `USUARIO` (`dni`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ASIGNACION_MOVIL`
--

LOCK TABLES `ASIGNACION_MOVIL` WRITE;
/*!40000 ALTER TABLE `ASIGNACION_MOVIL` DISABLE KEYS */;
INSERT INTO `ASIGNACION_MOVIL` VALUES ('S',NULL,'2013-01-01','2013-07-01',1,2,3,'19650728B',1),('S',NULL,'2013-05-02','2013-06-01',2,3,5,'39957941H',1),('S',NULL,'2013-06-05','2013-06-05',4,1,23,'99097605N',1),('S',NULL,'2013-06-05','2013-06-05',5,4,1,'19650728B',6),('S',NULL,'2013-06-05','2013-06-05',6,5,2,'19650728B',8);
/*!40000 ALTER TABLE `ASIGNACION_MOVIL` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `CATEGORIA`
--

DROP TABLE IF EXISTS `CATEGORIA`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `CATEGORIA` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(300) DEFAULT NULL,
  `coste` decimal(4,2) DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CATEGORIA`
--

LOCK TABLES `CATEGORIA` WRITE;
/*!40000 ALTER TABLE `CATEGORIA` DISABLE KEYS */;
INSERT INTO `CATEGORIA` VALUES (1,'Llamadas Provinciales',NULL),(2,'Llamadas Nacionales',NULL),(3,'Llamadas Internacionales',NULL),(4,'Llamadas a Móviles',NULL),(5,'Llamadas a 800X',NULL),(6,'Llamadas a 900X',NULL);
/*!40000 ALTER TABLE `CATEGORIA` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `DIPUTACION`
--

DROP TABLE IF EXISTS `DIPUTACION`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `DIPUTACION` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `direccion` varchar(300) NOT NULL,
  `telefono` varchar(20) DEFAULT NULL,
  `cod_postal` varchar(9) DEFAULT NULL,
  `ciudad` varchar(40) NOT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `DIPUTACION`
--

LOCK TABLES `DIPUTACION` WRITE;
/*!40000 ALTER TABLE `DIPUTACION` DISABLE KEYS */;
INSERT INTO `DIPUTACION` VALUES (1,'C/ Navarro Rodrigo, 17','950211100','04071','Almería'),(2,'Plaza de España , s/n','956240100','11071','Cádiz'),(3,'Plaza de Colón , s/n ','957211100','14071','Córdoba'),(4,'Avenida del Sur, 3 ','958247500','18014','Granada'),(5,'Avenida Martín Alonso Pinzón, 9','959494230','21003','Huelva'),(6,'Plaza de San Francisco, s/n ','953248000','23071','Jaén'),(7,'Plaza de la Marina, s/n ','952133500 ','29071','Málaga'),(8,'Avenida Menéndez y Pelayo, 32 ','954550000','41071','Sevilla');
/*!40000 ALTER TABLE `DIPUTACION` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `GRUPO_RESCATE`
--

DROP TABLE IF EXISTS `GRUPO_RESCATE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `GRUPO_RESCATE` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `GRUPO_RESCATE`
--

LOCK TABLES `GRUPO_RESCATE` WRITE;
/*!40000 ALTER TABLE `GRUPO_RESCATE` DISABLE KEYS */;
INSERT INTO `GRUPO_RESCATE` VALUES (1,'GRUPO_RESCATE A'),(2,'GRUPO_RESCATE B'),(3,'GRUPO_RESCATE C'),(4,'GRUPO_RESCATE D'),(5,'GRUPO_RESCATE E');
/*!40000 ALTER TABLE `GRUPO_RESCATE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `LINEA`
--

DROP TABLE IF EXISTS `LINEA`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `LINEA` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `numero` varchar(40) NOT NULL,
  `periodo_facturacion` date DEFAULT NULL,
  `publico` char(1) DEFAULT NULL,
  PRIMARY KEY (`codigo`),
  UNIQUE KEY `numero` (`numero`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `LINEA`
--

LOCK TABLES `LINEA` WRITE;
/*!40000 ALTER TABLE `LINEA` DISABLE KEYS */;
INSERT INTO `LINEA` VALUES (1,'657770818','2013-02-22','Y'),(2,'696993301','2013-03-14','Y'),(3,'629620754','2013-01-01','Y'),(4,'654320357','2013-01-01','Y'),(5,'653909456','2013-01-01','Y'),(6,'678538235','2013-01-01','Y'),(7,'677170356','2013-01-01','Y'),(8,'651648856','2013-01-01','Y'),(9,'671318095','2013-01-01','Y'),(10,'675530418','2013-01-01','Y'),(11,'692282505','2013-01-01','Y'),(12,'633837978','2013-01-01','Y'),(13,'664855237','2013-01-01','Y'),(14,'610365132','2013-01-01','Y'),(15,'674679003','2013-01-01','Y'),(16,'637009049','2013-01-01','Y'),(17,'602941151','2013-01-01','Y'),(18,'620442146','2013-01-01','Y'),(19,'606831597','2013-01-01','Y'),(20,'684207229','2013-01-01','Y'),(21,'657770878','2013-01-01','Y'),(22,'657770979','2013-01-01','Y'),(23,'655883563','2013-01-01','Y'),(24,'606557088','2013-01-01','Y'),(25,'634310475','2013-01-01','Y'),(26,'959338110','2013-01-01','Y'),(27,'953985638','2013-01-01','Y'),(28,'957940920','2013-01-01','Y'),(29,'951693588','2013-01-01','Y'),(30,'959384676','2013-01-01','Y'),(31,'956443914','2013-01-01','Y'),(32,'956420449','2013-01-01','Y'),(33,'957578660','2013-01-01','Y'),(34,'957022891','2013-01-01','Y'),(35,'954760823','2013-01-01','Y'),(36,'950019085','2013-01-01','Y'),(37,'952983389','2013-01-01','Y'),(38,'956198353','2013-01-01','Y'),(39,'954978667','2013-01-01','Y'),(40,'956816697','2013-01-01','Y');
/*!40000 ALTER TABLE `LINEA` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `LLAMADA`
--

DROP TABLE IF EXISTS `LLAMADA`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `LLAMADA` (
  `codigo` bigint(20) NOT NULL,
  `codigo_numero` int(11) NOT NULL,
  `numero_destino` varchar(40) NOT NULL,
  `tipo` varchar(40) DEFAULT NULL,
  `duracion` int(11) NOT NULL,
  `coste` decimal(10,3) NOT NULL,
  `inicio` datetime DEFAULT NULL,
  `fin` datetime DEFAULT NULL,
  PRIMARY KEY (`codigo`),
  KEY `fk_LLAMADA_codigo_numero` (`codigo_numero`),
  CONSTRAINT `fk_LLAMADA_codigo_numero` FOREIGN KEY (`codigo_numero`) REFERENCES `LINEA` (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `LLAMADA`
--

LOCK TABLES `LLAMADA` WRITE;
/*!40000 ALTER TABLE `LLAMADA` DISABLE KEYS */;
INSERT INTO `LLAMADA` VALUES (1,36,'952334312',NULL,1060,4.200,'2013-05-04 13:56:00','2013-05-04 14:16:00'),(2,36,'952312353',NULL,1060,3.000,NULL,NULL),(3,36,'952336762',NULL,1060,3.000,NULL,NULL),(4,36,'952334311',NULL,1060,3.000,NULL,NULL),(5,1,'141542353',NULL,123,4.500,'2013-05-02 00:00:00','2013-05-02 12:00:00');
/*!40000 ALTER TABLE `LLAMADA` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `MUNICIPIO`
--

DROP TABLE IF EXISTS `MUNICIPIO`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `MUNICIPIO` (
  `provincia` varchar(40) NOT NULL,
  `nombre` varchar(200) NOT NULL,
  PRIMARY KEY (`provincia`,`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `MUNICIPIO`
--

LOCK TABLES `MUNICIPIO` WRITE;
/*!40000 ALTER TABLE `MUNICIPIO` DISABLE KEYS */;
INSERT INTO `MUNICIPIO` VALUES ('Almería','ALmería'),('Cádiz','Cádiz'),('Córdoba','Córdoba'),('Granada','Granada'),('Huelva','Huelva'),('Jaén','Jaén'),('Málaga','Málaga'),('Sevilla','Sevilla');
/*!40000 ALTER TABLE `MUNICIPIO` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PERFIL`
--

DROP TABLE IF EXISTS `PERFIL`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `PERFIL` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(300) DEFAULT NULL,
  `saldo_limite` decimal(10,0) DEFAULT NULL,
  `coste` decimal(4,2) DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PERFIL`
--

LOCK TABLES `PERFIL` WRITE;
/*!40000 ALTER TABLE `PERFIL` DISABLE KEYS */;
INSERT INTO `PERFIL` VALUES (1,'TARIFA DEL 20',20,NULL),(2,'TARIFA DEL 40',40,NULL),(3,'TARIFA DEL 60',60,NULL),(4,'TARIFA DEL 80',80,NULL),(5,'TARIFA DEL 100',100,NULL),(6,'TARIFA DEL 200',200,NULL),(7,'TARIFA DEL 300',300,NULL),(8,'TARIFA DEL 500',500,NULL);
/*!40000 ALTER TABLE `PERFIL` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PLAN_CONCERTACION`
--

DROP TABLE IF EXISTS `PLAN_CONCERTACION`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `PLAN_CONCERTACION` (
  `codigo` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `nombre` varchar(200) NOT NULL,
  `descripcion` varchar(300) NOT NULL,
  `precio` decimal(10,0) DEFAULT NULL,
  `codigo_dip` int(11) NOT NULL,
  `nombre1` varchar(200) NOT NULL,
  `provincia` varchar(40) NOT NULL,
  PRIMARY KEY (`codigo_dip`,`codigo`,`nombre1`,`provincia`),
  KEY `fk_6746455C-5879-4FDE-8885-740D68B1BCFF` (`provincia`),
  KEY `fk_PLAN_nombre_provincia` (`provincia`,`nombre1`),
  CONSTRAINT `FK_PLAN_CONCERTACION_codigo_dip` FOREIGN KEY (`codigo_dip`) REFERENCES `DIPUTACION` (`codigo`),
  CONSTRAINT `fk_PLAN_nombre_provincia` FOREIGN KEY (`provincia`, `nombre1`) REFERENCES `MUNICIPIO` (`provincia`, `nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PLAN_CONCERTACION`
--

LOCK TABLES `PLAN_CONCERTACION` WRITE;
/*!40000 ALTER TABLE `PLAN_CONCERTACION` DISABLE KEYS */;
/*!40000 ALTER TABLE `PLAN_CONCERTACION` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `RMA`
--

DROP TABLE IF EXISTS `RMA`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `RMA` (
  `fecha_emision` date NOT NULL,
  `fecha_recepcion` date DEFAULT NULL,
  `detalle` varchar(200) DEFAULT NULL,
  `codigo_terminal` int(11) NOT NULL,
  `codigo` int(11) NOT NULL,
  PRIMARY KEY (`codigo`),
  KEY `fk_RMA_codigo_terminal` (`codigo_terminal`),
  CONSTRAINT `fk_RMA_codigo_terminal` FOREIGN KEY (`codigo_terminal`) REFERENCES `TERMINAL` (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `RMA`
--

LOCK TABLES `RMA` WRITE;
/*!40000 ALTER TABLE `RMA` DISABLE KEYS */;
/*!40000 ALTER TABLE `RMA` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ROLES`
--

DROP TABLE IF EXISTS `ROLES`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ROLES` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `tipo` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ROLES`
--

LOCK TABLES `ROLES` WRITE;
/*!40000 ALTER TABLE `ROLES` DISABLE KEYS */;
INSERT INTO `ROLES` VALUES (1,'administrador'),(2,'controlador'),(3,'jefe de servicio'),(4,'usuario');
/*!40000 ALTER TABLE `ROLES` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TAREA`
--

DROP TABLE IF EXISTS `TAREA`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TAREA` (
  `id_tarea` int(11) NOT NULL AUTO_INCREMENT,
  `tipo_tarea` int(11) NOT NULL,
  `dni` varchar(45) NOT NULL,
  `dni_tarea_asignado` varchar(9) NOT NULL,
  `fecha_emision` date DEFAULT NULL,
  `codigo_perfil` int(11) DEFAULT NULL,
  `codigo_categoria` int(11) DEFAULT NULL,
  `codigo_numero` int(11) DEFAULT NULL,
  `codigo_terminal` int(11) DEFAULT NULL,
  `validado` char(1) DEFAULT 'N',
  PRIMARY KEY (`id_tarea`),
  KEY `FK_TAREA_codigo_categoria` (`codigo_categoria`),
  KEY `FK_TAREA_codigo_numero` (`codigo_numero`),
  KEY `FK_TAREA_codigo_perfil` (`codigo_perfil`),
  KEY `FK_TAREA_codigo_terminal` (`codigo_terminal`),
  KEY `FK_TAREA_dni_tarea_asignado` (`dni_tarea_asignado`),
  KEY `FK_TAREA_tipo_tarea` (`tipo_tarea`),
  CONSTRAINT `FK_TAREA_codigo_categoria` FOREIGN KEY (`codigo_categoria`) REFERENCES `CATEGORIA` (`codigo`),
  CONSTRAINT `FK_TAREA_codigo_numero` FOREIGN KEY (`codigo_numero`) REFERENCES `LINEA` (`codigo`),
  CONSTRAINT `FK_TAREA_codigo_perfil` FOREIGN KEY (`codigo_perfil`) REFERENCES `PERFIL` (`codigo`),
  CONSTRAINT `FK_TAREA_codigo_terminal` FOREIGN KEY (`codigo_terminal`) REFERENCES `TERMINAL` (`codigo`),
  CONSTRAINT `FK_TAREA_dni_tarea_asignado` FOREIGN KEY (`dni_tarea_asignado`) REFERENCES `USUARIO` (`dni`),
  CONSTRAINT `FK_TAREA_tipo_tarea` FOREIGN KEY (`tipo_tarea`) REFERENCES `TIPO_TAREA` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TAREA`
--

LOCK TABLES `TAREA` WRITE;
/*!40000 ALTER TABLE `TAREA` DISABLE KEYS */;
/*!40000 ALTER TABLE `TAREA` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TERMINAL`
--

DROP TABLE IF EXISTS `TERMINAL`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TERMINAL` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `fecha_alta` date DEFAULT NULL,
  `marca` varchar(40) DEFAULT NULL,
  `modelo` varchar(40) DEFAULT NULL,
  `configuracion` varchar(200) DEFAULT NULL,
  `sn` bigint(20) NOT NULL,
  PRIMARY KEY (`codigo`),
  UNIQUE KEY `sn` (`sn`),
  UNIQUE KEY `sn_2` (`sn`)
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TERMINAL`
--

LOCK TABLES `TERMINAL` WRITE;
/*!40000 ALTER TABLE `TERMINAL` DISABLE KEYS */;
INSERT INTO `TERMINAL` VALUES (1,'2013-01-01','Samsung','Galaxy Nexus','MOVIL',123),(2,'2013-01-02','Samsung','Samsung Galaxy S3','MOVIL',124),(3,'2013-01-04','iPhone','4S','MOVIL',125),(4,'2013-01-05','iPhone','5','MOVIL',126),(5,'2013-01-06','Nokia','Lumia','MOVIL',127),(6,'2013-01-07','HTC','ONE','MOVIL',128),(7,'2013-01-08','HTC','Hero','MOVIL',129),(8,'2013-01-09','HTC','Wildfire','MOVIL',130),(9,'2013-01-10','Alcatel','G400','MOVIL',131),(10,'2013-01-11','LG','Nexus 4','MOVIL',132),(11,'2013-01-12','Sony','Xperia P','MOVIL',133),(12,'2013-01-13','Sony','Xperia S','MOVIL',134),(13,'2013-01-14','Sony','Xperia U','MOVIL',135),(14,'2013-01-15','LG Optimus','L5','MOVIL',136),(15,'2013-01-16','Samsung','Galaxy Ace 2','MOVIL',137),(16,'2013-01-17','HTC','Desire X','MOVIL',138),(17,'2013-01-18','Blackberry','Curve','MOVIL',139),(18,'2013-01-19','Nokia','Lumia 710','MOVIL',140),(19,'2013-01-20','Motorola','MOTOLUXE','MOVIL',141),(20,'2013-01-21','Huawei','Ascend P1','MOVIL',142),(21,'2013-01-22','ZTE','Blade','MOVIL',143),(22,'2013-01-23','Nokia','5580','MOVIL',144),(23,'2013-01-24','Samsung','Google Nexus 7','MOVIL',145),(24,'2013-01-25','Philips','C300','FIJO',146),(25,'2013-01-26','Philips','C300','FIJO',147),(26,'2013-01-27','Philips','C300','FIJO',148),(27,'2013-01-28','Philips','C300','FIJO',149),(28,'2013-01-29','Philips','C300','FIJO',150),(29,'2013-01-30','Philips','C300','FIJO',151),(30,'2013-01-31','Philips','C300','FIJO',152),(31,'2013-02-01','Philips','C300','FIJO',153),(32,'2013-02-02','DOMO','D1','FIJO',154),(33,'2013-02-03','DOMO','D1','FIJO',155),(34,'2013-02-04','DOMO','D1','FIJO',156),(35,'2013-02-05','DOMO','D1','FIJO',157),(36,'2013-02-06','DOMO','D1','FIJO',158),(37,'2013-02-07','DOMO','D1','FIJO',159),(38,'2013-02-08','DOMO','D1','FIJO',160),(39,'2013-02-09','DOMO','D1','FIJO',161),(40,'2013-02-10','TELECOM','SPC','FIJO',162),(41,'2013-02-11','TELECOM','SPC','FIJO',163),(42,'2013-02-12','TELECOM','SPC','FIJO',164),(43,'2013-02-13','TELECOM','SPC','FIJO',165),(44,'2013-02-14','TELECOM','SPC','FIJO',166),(45,'2013-02-15','TELECOM','SPC','FIJO',167),(46,'2013-02-16','TELECOM','SPC','FIJO',168),(47,'2013-02-17','TELECOM','SPC','FIJO',169),(48,'2013-02-18','Siemens','Gigaset','FIJO',170),(49,'2013-02-19','Siemens','Gigaset','FIJO',171),(50,'2013-02-20','Siemens','Gigaset','FIJO',172),(56,'2013-05-31','1','1','1',11897),(57,'2013-05-31','12','123','321',123141),(58,'2013-05-31','4','4','4',4),(59,'2013-05-31','EL MOVIL MÁS RESHULÓN DEL MUNDO','DEL PARAGÜENO JIJI','MOVIL',12345),(60,'2013-06-03','wqe','qwq','pojqpow',123123);
/*!40000 ALTER TABLE `TERMINAL` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TIPO_TAREA`
--

DROP TABLE IF EXISTS `TIPO_TAREA`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TIPO_TAREA` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TIPO_TAREA`
--

LOCK TABLES `TIPO_TAREA` WRITE;
/*!40000 ALTER TABLE `TIPO_TAREA` DISABLE KEYS */;
INSERT INTO `TIPO_TAREA` VALUES (1,'TARIFA'),(2,'SOLICITAR TERMINAL FIJO'),(3,'SOLICITAR TERMINAL MOVIL'),(4,'SOLICITAR LINEA'),(5,'CATEGORIA');
/*!40000 ALTER TABLE `TIPO_TAREA` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `USUARIO`
--

DROP TABLE IF EXISTS `USUARIO`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `USUARIO` (
  `dni` varchar(9) NOT NULL,
  `contrasena` varchar(45) NOT NULL,
  `nombre` varchar(200) NOT NULL,
  `apellidos` varchar(200) NOT NULL,
  `email` varchar(50) NOT NULL,
  `codigo_rescate` int(11) NOT NULL,
  `codigo_dip` int(11) DEFAULT NULL,
  `codigo_rol` int(11) NOT NULL,
  PRIMARY KEY (`dni`),
  KEY `fk_USUARIO_ROLES1` (`codigo_rol`),
  KEY `fk_USUARIO_codigo_rescate` (`codigo_rescate`),
  KEY `fk_USUARIO_codigo_dip` (`codigo_dip`),
  CONSTRAINT `fk_USUARIO_codigo_dip` FOREIGN KEY (`codigo_dip`) REFERENCES `DIPUTACION` (`codigo`),
  CONSTRAINT `fk_USUARIO_codigo_rescate` FOREIGN KEY (`codigo_rescate`) REFERENCES `GRUPO_RESCATE` (`codigo`),
  CONSTRAINT `fk_USUARIO_codigo_rol` FOREIGN KEY (`codigo_rol`) REFERENCES `ROLES` (`codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `USUARIO`
--

LOCK TABLES `USUARIO` WRITE;
/*!40000 ALTER TABLE `USUARIO` DISABLE KEYS */;
INSERT INTO `USUARIO` VALUES ('03082054P','1234454','Jesús','Cristo De la Repolla','jcruzfreire@gmail.com',1,1,1),('13163532B','1234','María José','Márques Martínez','mjosemarques@gmail.com',4,2,2),('16867684J','1234','María Dolores','González Fernández','mgonzalezfernandez@gmail.com',1,8,2),('19650728B','1234','Mercedes','Rufo Sánchez','mrufosanchez@gmail.com',1,7,3),('19998743J','1234','Marta','Sola Taylor','msolataylor@gmail.com',4,4,4),('29002943N','1234','Marta','Gil Montserrat','mgilmontserrat@gmail.com',4,6,4),('30370939Z','1234','María Jesús','Ramos Macia','mramosmacia@gmail.com',5,7,2),('34182948A','1234','Antonio','Navarro  Sánchez','anavarrosanchez@gmail.com',2,7,4),('34529080P','1234','Antonio','Otero De Juan','aoterodejuan@gmail.com',1,1,1),('36060096Y','1234','Ramón','Alfonso González','ralfonsogonzalez@gmail.com',3,6,3),('38615781T','1234','Carmen','Salgado Prieto','csalgadoprieto@gmail.com',1,4,2),('39124960M','1234','Rosario','Trujillo López','rtrujillo@gmail.com',2,6,2),('39957941H','1234','Jesús','Aparicio Carpio','japaricio@gmail.com',5,5,3),('44103398R','1234','Gloria','Del Castillo Etxebarria','gcastillo@gmail.com',4,5,2),('59133396M','1234','Beatriz','Sánchez  Barrena','bsanchezbarrena@gmail.com',1,5,4),('62626527B','1234','Pedro','García Ruano','pgarciaruano@gmail.com',5,3,4),('63719306Z','1234','María Dolores','González Bernal','mgonzalezbernal@gmail.com',3,3,2),('71946976D','1234','Juan','Romero Tello','jromerotello@gmail.com',1,7,1),('84018843G','1234','Marta','Cortés Paños','mcortespaños@gmail.com',3,1,3),('85698664C','1234','Raquel','Nicolás Juárez','rnicolas@gmail.com',2,2,4),('87404617V','1234','María Carmen','Casanova Soriano','mcasanovasoriano@gmail.com',5,8,4),('87787332N','1234','Francisco','Suárez Miro','fsuarezmiro@gmail.com',4,3,3),('93147298N','1234','José Miguel','Sancho Espínola','jsancho@gmail.com',2,4,3),('93164374E','1234','María Teresa','Vázquez Álvarez','mvazquezalvarez@gmail.com',4,8,3),('99097605N','1234','Ángeles','Pardo Llanos','apardollanos@gmail.com',1,2,3);
/*!40000 ALTER TABLE `USUARIO` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-06-05 17:45:31
