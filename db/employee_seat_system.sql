-- MySQL dump 10.13  Distrib 8.0.43, for Win64 (x86_64)
--
-- Host: localhost    Database: employee_seat_system
-- ------------------------------------------------------
-- Server version	8.0.43

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
-- Table structure for table `employeedata`
--

DROP TABLE IF EXISTS `employeedata`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employeedata` (
  `EMP_ID` int NOT NULL AUTO_INCREMENT,
  `NAME` varchar(50) NOT NULL,
  `EMAIL` varchar(100) NOT NULL,
  `FLOOR_SEAT_SEQ` int DEFAULT NULL,
  PRIMARY KEY (`EMP_ID`),
  UNIQUE KEY `EMAIL` (`EMAIL`),
  KEY `FK_FloorSeat` (`FLOOR_SEAT_SEQ`),
  CONSTRAINT `FK_FloorSeat` FOREIGN KEY (`FLOOR_SEAT_SEQ`) REFERENCES `seatchart` (`FLOOR_SEAT_SEQ`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employeedata`
--

LOCK TABLES `employeedata` WRITE;
/*!40000 ALTER TABLE `employeedata` DISABLE KEYS */;
INSERT INTO `employeedata` VALUES (1,'Schwarz','Schwarz@example.com',3),(2,'Nian','Nian@example.com',4),(3,'Dusk','Dusk@example.com',NULL);
/*!40000 ALTER TABLE `employeedata` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seatchart`
--

DROP TABLE IF EXISTS `seatchart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `seatchart` (
  `FLOOR_SEAT_SEQ` int NOT NULL AUTO_INCREMENT,
  `FLOOR_NO` int NOT NULL,
  `SEAT_NO` varchar(10) NOT NULL,
  `IS_TAKEN` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`FLOOR_SEAT_SEQ`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seatchart`
--

LOCK TABLES `seatchart` WRITE;
/*!40000 ALTER TABLE `seatchart` DISABLE KEYS */;
INSERT INTO `seatchart` VALUES (1,1,'1A',0),(2,1,'2A',0),(3,2,'1B',1),(4,2,'2B',1);
/*!40000 ALTER TABLE `seatchart` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-09-25  2:22:48
