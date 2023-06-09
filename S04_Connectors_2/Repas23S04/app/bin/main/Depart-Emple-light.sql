-- MySQL dump 10.13  Distrib 8.0.30, for macos12 (x86_64)
--
-- Host: 51.210.43.140    Database: DEPART_EMPLE_LIGHT
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
-- Table structure for table `DEPART`
--

DROP TABLE IF EXISTS `DEPART`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `DEPART` (
  `DEPT_NO` int NOT NULL,
  `DNOMBRE` varchar(30) DEFAULT NULL,
  `LOC` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`DEPT_NO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `EMPLE`
--

DROP TABLE IF EXISTS `EMPLE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `EMPLE` (
  `EMP_NO` int NOT NULL,
  `APELLIDO` varchar(50) NOT NULL,
  `OFICIO` varchar(30) DEFAULT NULL,
  `DIR` int DEFAULT NULL,
  `FECHA_ALT` date DEFAULT NULL,
  `SALARIO` decimal(10,2) DEFAULT NULL,
  `COMISION` decimal(10,2) DEFAULT NULL,
  `DEPT_NO` int DEFAULT NULL,
  PRIMARY KEY (`EMP_NO`),
  KEY `DIR` (`DIR`),
  KEY `DEPT_NO` (`DEPT_NO`),
  CONSTRAINT `EMPLE_ibfk_1` FOREIGN KEY (`DIR`) REFERENCES `EMPLE` (`EMP_NO`),
  CONSTRAINT `EMPLE_ibfk_2` FOREIGN KEY (`DEPT_NO`) REFERENCES `DEPART` (`DEPT_NO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;


/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-03-28 18:50:23
