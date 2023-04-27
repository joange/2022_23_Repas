-- MySQL dump 10.13  Distrib 8.0.30, for macos12 (x86_64)
--
-- Host: 51.210.43.140    Database: AD_U4_CPE
-- ------------------------------------------------------
-- Server version	8.0.32-0ubuntu0.22.04.2

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Barco`
--

DROP TABLE IF EXISTS `Barco`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Barco` (
  `idBarco` bigint NOT NULL AUTO_INCREMENT,
  `lanzamiento` int DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `idClase` bigint DEFAULT NULL,
  PRIMARY KEY (`idBarco`),
  KEY `FK4xaaa3it5v74iobo3v3gcao9s` (`idClase`),
  CONSTRAINT `FK4xaaa3it5v74iobo3v3gcao9s` FOREIGN KEY (`idClase`) REFERENCES `Clase` (`idClase`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Barco`
--

LOCK TABLES `Barco` WRITE;
/*!40000 ALTER TABLE `Barco` DISABLE KEYS */;
INSERT INTO `Barco` VALUES (1,1980,'Mortadelo',1),(2,1982,'Filemon',1),(3,1980,'Bacterio',2),(4,1978,'Pepe Gotera',2),(7,1987,'Otilio',5);
/*!40000 ALTER TABLE `Barco` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Batalla`
--

DROP TABLE IF EXISTS `Batalla`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Batalla` (
  `idBatalla` bigint NOT NULL AUTO_INCREMENT,
  `fecha` datetime DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idBatalla`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Batalla`
--

LOCK TABLES `Batalla` WRITE;
/*!40000 ALTER TABLE `Batalla` DISABLE KEYS */;
INSERT INTO `Batalla` VALUES (1,'1987-03-24 00:00:00','Andorra'),(2,'1988-03-14 00:00:00','Cerler'),(3,'1988-12-02 00:00:00','Almansa'),(4,'1989-11-08 00:00:00','Cordoba'),(5,'1978-04-28 00:00:00','Mallorca'),(6,'1984-03-29 00:00:00','Calpe'),(7,'1983-08-12 00:00:00','Cap de la Nao'),(8,'1982-11-11 00:00:00','Maraca');
/*!40000 ALTER TABLE `Batalla` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Clase`
--

DROP TABLE IF EXISTS `Clase`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Clase` (
  `idClase` bigint NOT NULL AUTO_INCREMENT,
  `desplazamiento` int DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `numArmas` int DEFAULT NULL,
  `pais` varchar(255) DEFAULT NULL,
  `quilla` int DEFAULT NULL,
  PRIMARY KEY (`idClase`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Clase`
--

LOCK TABLES `Clase` WRITE;
/*!40000 ALTER TABLE `Clase` DISABLE KEYS */;
INSERT INTO `Clase` VALUES (1,5,'Ibañez I',4,'ESP',4),(2,52,'Ibañez II',4,'ESP',8),(3,343,'Forges',8,'AND',34),(4,45,'Ortifus',6,'VAL',5),(5,3,'Mingote',5,'AND',4);
/*!40000 ALTER TABLE `Clase` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Participa`
--

DROP TABLE IF EXISTS `Participa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Participa` (
  `idParticipa` bigint NOT NULL AUTO_INCREMENT,
  `resultado` int DEFAULT NULL,
  `idBarco` bigint DEFAULT NULL,
  `idBatalla` bigint DEFAULT NULL,
  PRIMARY KEY (`idParticipa`),
  KEY `FKp6i1askfssqw8j8o4032ragqv` (`idBarco`),
  KEY `FKbpmbybf139lehfko4rkqp87yp` (`idBatalla`),
  CONSTRAINT `FKbpmbybf139lehfko4rkqp87yp` FOREIGN KEY (`idBatalla`) REFERENCES `Batalla` (`idBatalla`),
  CONSTRAINT `FKp6i1askfssqw8j8o4032ragqv` FOREIGN KEY (`idBarco`) REFERENCES `Barco` (`idBarco`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Participa`
--

LOCK TABLES `Participa` WRITE;
/*!40000 ALTER TABLE `Participa` DISABLE KEYS */;
INSERT INTO `Participa` VALUES (1,1,1,1),(2,1,1,2),(3,2,1,4),(4,0,2,1),(5,2,2,3),(6,0,3,2),(7,1,3,3),(8,1,3,4),(9,0,2,6),(12,0,1,7),(19,0,1,7),(20,1,2,7),(21,0,3,7),(25,0,1,8),(26,0,2,8);
/*!40000 ALTER TABLE `Participa` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-04-26 17:44:56
