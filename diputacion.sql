SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET latin1 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`LINEA`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`LINEA` (
  `codigo` INT(11) NOT NULL ,
  `numero` VARCHAR(40) NOT NULL ,
  `periodo_facturacion` DATE NULL DEFAULT NULL ,
  `publico` CHAR(1) NULL DEFAULT NULL ,
  PRIMARY KEY (`codigo`) ,
  UNIQUE INDEX `numero` (`numero` ASC) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `mydb`.`CATEGORIA`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`CATEGORIA` (
  `codigo` INT(11) NOT NULL ,
  `descripcion` VARCHAR(300) NULL DEFAULT NULL ,
  PRIMARY KEY (`codigo`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `mydb`.`TERMINAL`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`TERMINAL` (
  `codigo` INT(11) NOT NULL ,
  `fecha_alta` DATE NULL DEFAULT NULL ,
  `fecha_baja` DATE NULL DEFAULT NULL ,
  `marca` VARCHAR(40) NULL DEFAULT NULL ,
  `modelo` VARCHAR(40) NULL DEFAULT NULL ,
  `configuracion` VARCHAR(200) NULL DEFAULT NULL ,
  `sn` BIGINT NOT NULL ,
  `numero_interno` VARCHAR(40) NULL DEFAULT NULL ,
  `pedido` VARCHAR(400) NULL DEFAULT NULL ,
  `product` VARCHAR(200) NULL DEFAULT NULL ,
  PRIMARY KEY (`codigo`) ,
  UNIQUE INDEX `sn` (`sn` ASC) ,
  UNIQUE INDEX `sn_2` (`sn` ASC) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `mydb`.`GRUPO_RESCATE`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`GRUPO_RESCATE` (
  `codigo` INT(11) NOT NULL ,
  `nombre` VARCHAR(100) NOT NULL ,
  PRIMARY KEY (`codigo`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `mydb`.`DIPUTACION`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`DIPUTACION` (
  `codigo` INT(11) NOT NULL ,
  `direccion` VARCHAR(300) NOT NULL ,
  `telefono` VARCHAR(20) NULL DEFAULT NULL ,
  `cod_postal` VARCHAR(9) NULL DEFAULT NULL ,
  `ciudad` VARCHAR(40) NOT NULL ,
  PRIMARY KEY (`codigo`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `mydb`.`ROLES`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`ROLES` (
  `codigo` INT(11) NOT NULL ,
  `tipo` VARCHAR(45) NULL DEFAULT NULL ,
  PRIMARY KEY (`codigo`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `mydb`.`USUARIO`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`USUARIO` (
  `dni` VARCHAR(9) NOT NULL ,
  `nombre` VARCHAR(200) NOT NULL ,
  `apellidos` VARCHAR(200) NOT NULL ,
  `email` VARCHAR(50) NOT NULL ,
  `codigo_rescate` INT(11) NOT NULL ,
  `codigo_dip` INT(11) NULL DEFAULT NULL ,
  `codigo_rol` INT(11) NOT NULL ,
  PRIMARY KEY (`dni`) ,
  INDEX `fk_9CFA7928-7362-48F4-8DCA-109E06768401` (`codigo_rescate` ASC) ,
  INDEX `fk_E4F5117A-7DF2-47F6-83F0-36378FDD65C1` (`codigo_dip` ASC) ,
  INDEX `fk_USUARIO_ROLES1` (`codigo_rol` ASC) ,
  CONSTRAINT `fk_9CFA7928-7362-48F4-8DCA-109E06768401`
    FOREIGN KEY (`codigo_rescate` )
    REFERENCES `mydb`.`GRUPO_RESCATE` (`codigo` ),
  CONSTRAINT `fk_E4F5117A-7DF2-47F6-83F0-36378FDD65C1`
    FOREIGN KEY (`codigo_dip` )
    REFERENCES `mydb`.`DIPUTACION` (`codigo` ),
  CONSTRAINT `fk_USUARIO_ROLES2`
    FOREIGN KEY (`codigo_rol` )
    REFERENCES `mydb`.`ROLES` (`codigo` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `mydb`.`ASIGNACION_FIJO`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`ASIGNACION_FIJO` (
  `fecha_asignacion` DATE NOT NULL ,
  `fecha_fin` DATE NOT NULL ,
  `dni` VARCHAR(9) NOT NULL ,
  `codigo_numero` INT(11) NOT NULL DEFAULT '0' ,
  `codigo_terminal` INT(11) NOT NULL ,
  `codigo_cat` INT(11) NOT NULL ,
  PRIMARY KEY (`dni`, `codigo_numero`, `codigo_cat`) ,
  INDEX `fk_06E77907-E6D8-4570-8F31-0A4910C9AF01` (`codigo_numero` ASC) ,
  INDEX `fk_70807A7D-9571-4E2B-94B8-1A33EF4E5464` (`codigo_cat` ASC) ,
  INDEX `fk_F8AE2F64-6F8A-4A5A-97F2-48A4DE1423AA` (`codigo_terminal` ASC) ,
  CONSTRAINT `fk_06E77907-E6D8-4570-8F31-0A4910C9AF01`
    FOREIGN KEY (`codigo_numero` )
    REFERENCES `mydb`.`LINEA` (`codigo` ),
  CONSTRAINT `fk_70807A7D-9571-4E2B-94B8-1A33EF4E5464`
    FOREIGN KEY (`codigo_cat` )
    REFERENCES `mydb`.`CATEGORIA` (`codigo` ),
  CONSTRAINT `fk_F8AE2F64-6F8A-4A5A-97F2-48A4DE1423AA`
    FOREIGN KEY (`codigo_terminal` )
    REFERENCES `mydb`.`TERMINAL` (`codigo` ),
  CONSTRAINT `fk_284804E8-3D3C-4AC1-B5EC-98B567F7ED9B`
    FOREIGN KEY (`dni` )
    REFERENCES `mydb`.`USUARIO` (`dni` ))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `mydb`.`PERFIL`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`PERFIL` (
  `codigo` INT(11) NOT NULL ,
  `descripcion` VARCHAR(300) NULL DEFAULT NULL ,
  `saldo_limite` DECIMAL(10,0) NULL DEFAULT NULL ,
  PRIMARY KEY (`codigo`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `mydb`.`ASIGNACION_MOVIL`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`ASIGNACION_MOVIL` (
  `fecha_asignacion` DATE NOT NULL ,
  `fecha_fin` DATE NOT NULL ,
  `dni` VARCHAR(9) NOT NULL ,
  `codigo_perfil` INT(11) NULL DEFAULT NULL ,
  `codigo_numero` INT(11) NOT NULL ,
  `codigo_terminal` INT(11) NOT NULL ,
  PRIMARY KEY (`dni`, `codigo_numero`, `codigo_terminal`) ,
  INDEX `fk_A7DD52BF-5999-432F-8C6D-3FAF36AEF601` (`codigo_perfil` ASC) ,
  INDEX `fk_FAF55427-DE51-4BC3-978A-DAC15B73893F` (`codigo_terminal` ASC) ,
  INDEX `fk_37EFF3E8-EB5A-482B-880E-0A12D8214335` (`codigo_numero` ASC) ,
  CONSTRAINT `fk_A7DD52BF-5999-432F-8C6D-3FAF36AEF601`
    FOREIGN KEY (`codigo_perfil` )
    REFERENCES `mydb`.`PERFIL` (`codigo` ),
  CONSTRAINT `fk_ABFE6D03-941A-464D-8C06-476D4AED081D`
    FOREIGN KEY (`dni` )
    REFERENCES `mydb`.`USUARIO` (`dni` ),
  CONSTRAINT `fk_FAF55427-DE51-4BC3-978A-DAC15B73893F`
    FOREIGN KEY (`codigo_terminal` )
    REFERENCES `mydb`.`TERMINAL` (`codigo` ),
  CONSTRAINT `fk_37EFF3E8-EB5A-482B-880E-0A12D8214335`
    FOREIGN KEY (`codigo_numero` )
    REFERENCES `mydb`.`LINEA` (`codigo` ))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `mydb`.`LLAMADA`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`LLAMADA` (
  `numero_destino` VARCHAR(40) NOT NULL ,
  `tipo` VARCHAR(40) NULL DEFAULT NULL ,
  `duracion` INT NOT NULL ,
  `coste` DECIMAL(10,0) NOT NULL ,
  `codigo_numero` INT(11) NOT NULL ,
  PRIMARY KEY (`codigo_numero`) ,
  CONSTRAINT `fk_9228D15F-0E19-43D3-99FC-EDCF2EBC67C3`
    FOREIGN KEY (`codigo_numero` )
    REFERENCES `mydb`.`LINEA` (`codigo` ))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `mydb`.`MUNICIPIO`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`MUNICIPIO` (
  `provincia` VARCHAR(40) NOT NULL ,
  `nombre` VARCHAR(200) NOT NULL ,
  PRIMARY KEY (`provincia`, `nombre`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `mydb`.`PLAN_CONCERTACION`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`PLAN_CONCERTACION` (
  `codigo` INT(11) NOT NULL ,
  `fecha` DATE NOT NULL ,
  `nombre` VARCHAR(200) NOT NULL ,
  `descripcion` VARCHAR(300) NOT NULL ,
  `precio` DECIMAL(10,0) NULL DEFAULT NULL ,
  `codigo_dip` INT(11) NOT NULL ,
  `nombre1` VARCHAR(200) NOT NULL ,
  `provincia` VARCHAR(40) NOT NULL ,
  PRIMARY KEY (`codigo_dip`, `codigo`, `nombre1`, `provincia`) ,
  INDEX `fk_6746455C-5879-4FDE-8885-740D68B1BCFF` (`provincia` ASC) ,
  INDEX `fk_nombre_provincia_municipio` (`provincia` ASC, `nombre1` ASC) ,
  CONSTRAINT `fk_1DE59C0E-CB27-4262-9E33-0049DB9827CC`
    FOREIGN KEY (`codigo_dip` )
    REFERENCES `mydb`.`DIPUTACION` (`codigo` ),
  CONSTRAINT `fk_nombre_provincia_municipio`
    FOREIGN KEY (`provincia` , `nombre1` )
    REFERENCES `mydb`.`MUNICIPIO` (`provincia` , `nombre` ))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `mydb`.`RMA`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`RMA` (
  `fecha_emision` DATE NOT NULL ,
  `fecha_recepcion` DATE NULL DEFAULT NULL ,
  `detalle` VARCHAR(200) NULL DEFAULT NULL ,
  `codigo_terminal` INT(11) NOT NULL ,
  `codigo` INT(11) NOT NULL ,
  PRIMARY KEY (`codigo`) ,
  INDEX `fk_D666DF7E-0898-441C-A18B-7ADA93B4080D` (`codigo_terminal` ASC) ,
  CONSTRAINT `fk_D666DF7E-0898-441C-A18B-7ADA93B4080D`
    FOREIGN KEY (`codigo_terminal` )
    REFERENCES `mydb`.`TERMINAL` (`codigo` ))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `mydb`.`TIPO_TAREA`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`TIPO_TAREA` (
  `id` INT(11) NOT NULL ,
  `nombre` VARCHAR(100) NULL DEFAULT NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1
COLLATE = latin1_swedish_ci;


-- -----------------------------------------------------
-- Table `mydb`.`TAREA`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`TAREA` (
  `id_tarea` INT(11) NOT NULL ,
  `tipo_tarea` INT(11) NULL DEFAULT NULL ,
  `dni` VARCHAR(9) NULL DEFAULT NULL ,
  `dni_tarea_asignado` VARCHAR(9) NULL DEFAULT NULL ,
  `fecha_emision` DATE NULL DEFAULT NULL ,
  `codigo_perfil` INT(11) NULL DEFAULT NULL ,
  `codigo_categoria` INT(11) NULL DEFAULT NULL ,
  `codigo_numero` INT(11) NULL DEFAULT NULL ,
  `codigo_terminal` INT(11) NULL DEFAULT NULL ,
  `validado` CHAR(1) NULL DEFAULT 'N' ,
  PRIMARY KEY (`id_tarea`) ,
  INDEX `dni` (`dni` ASC) ,
  INDEX `dni_tarea_asignado` (`dni_tarea_asignado` ASC) ,
  INDEX `codigo_perfil` (`codigo_perfil` ASC) ,
  INDEX `codigo_categoria` (`codigo_categoria` ASC) ,
  INDEX `codigo_numero` (`codigo_numero` ASC) ,
  INDEX `codigo_terminal` (`codigo_terminal` ASC) ,
  INDEX `tipo_tarea` (`tipo_tarea` ASC) ,
  CONSTRAINT `tarea_ibfk_1`
    FOREIGN KEY (`dni` )
    REFERENCES `mydb`.`USUARIO` (`dni` ),
  CONSTRAINT `tarea_ibfk_2`
    FOREIGN KEY (`dni_tarea_asignado` )
    REFERENCES `mydb`.`USUARIO` (`dni` ),
  CONSTRAINT `tarea_ibfk_3`
    FOREIGN KEY (`codigo_perfil` )
    REFERENCES `mydb`.`PERFIL` (`codigo` ),
  CONSTRAINT `tarea_ibfk_4`
    FOREIGN KEY (`codigo_categoria` )
    REFERENCES `mydb`.`CATEGORIA` (`codigo` ),
  CONSTRAINT `tarea_ibfk_5`
    FOREIGN KEY (`codigo_numero` )
    REFERENCES `mydb`.`LINEA` (`codigo` ),
  CONSTRAINT `tarea_ibfk_6`
    FOREIGN KEY (`codigo_terminal` )
    REFERENCES `mydb`.`TERMINAL` (`codigo` ),
  CONSTRAINT `tarea_ibfk_7`
    FOREIGN KEY (`tipo_tarea` )
    REFERENCES `mydb`.`TIPO_TAREA` (`id` ))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1
COLLATE = latin1_swedish_ci;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
