-- MySQL dump 10.13  Distrib 8.0.23, for macos10.15 (x86_64)
--
-- Host: 127.0.0.1    Database: front-end
-- ------------------------------------------------------
-- Server version	8.0.26

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
-- Table structure for table `city`
--

DROP TABLE IF EXISTS `city`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `city` (
  `city_id` int NOT NULL AUTO_INCREMENT,
  `zip_code` int DEFAULT NULL,
  `city_name` varchar(45) DEFAULT NULL,
  `country_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`city_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `city`
--

LOCK TABLES `city` WRITE;
/*!40000 ALTER TABLE `city` DISABLE KEYS */;
INSERT INTO `city` VALUES (1,2800,'Lyngby','Danmark'),(2,2450,'København SV','Danmark'),(3,2820,'Gentofte','Danmark');
/*!40000 ALTER TABLE `city` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ENTITYHOBBY`
--

DROP TABLE IF EXISTS `ENTITYHOBBY`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ENTITYHOBBY` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  `NAME` varchar(255) DEFAULT NULL,
  `PERSONS` longblob,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ENTITYHOBBY`
--

LOCK TABLES `ENTITYHOBBY` WRITE;
/*!40000 ALTER TABLE `ENTITYHOBBY` DISABLE KEYS */;
/*!40000 ALTER TABLE `ENTITYHOBBY` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ENTITYPERSON`
--

DROP TABLE IF EXISTS `ENTITYPERSON`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ENTITYPERSON` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `EMAIL` varchar(255) DEFAULT NULL,
  `FIRSTNAME` varchar(255) DEFAULT NULL,
  `HOBBY` longblob,
  `LASTNAME` varchar(255) DEFAULT NULL,
  `PHONENUMBER` int DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ENTITYPERSON`
--

LOCK TABLES `ENTITYPERSON` WRITE;
/*!40000 ALTER TABLE `ENTITYPERSON` DISABLE KEYS */;
/*!40000 ALTER TABLE `ENTITYPERSON` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hobby`
--

DROP TABLE IF EXISTS `hobby`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hobby` (
  `hobby_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`hobby_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hobby`
--

LOCK TABLES `hobby` WRITE;
/*!40000 ALTER TABLE `hobby` DISABLE KEYS */;
INSERT INTO `hobby` VALUES (1,'sport'),(2,'biler'),(3,'gaming'),(4,'alcohol'),(5,'piger');
/*!40000 ALTER TABLE `hobby` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `HOBBYENTITY`
--

DROP TABLE IF EXISTS `HOBBYENTITY`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `HOBBYENTITY` (
  `ID` bigint NOT NULL AUTO_INCREMENT,
  `NAME` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `HOBBYENTITY`
--

LOCK TABLES `HOBBYENTITY` WRITE;
/*!40000 ALTER TABLE `HOBBYENTITY` DISABLE KEYS */;
/*!40000 ALTER TABLE `HOBBYENTITY` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `HOBBYENTITY_PERSONENTITY`
--

DROP TABLE IF EXISTS `HOBBYENTITY_PERSONENTITY`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `HOBBYENTITY_PERSONENTITY` (
  `hobbies_ID` bigint NOT NULL,
  `people_ID` bigint NOT NULL,
  PRIMARY KEY (`hobbies_ID`,`people_ID`),
  KEY `FK_HOBBYENTITY_PERSONENTITY_people_ID` (`people_ID`),
  CONSTRAINT `FK_HOBBYENTITY_PERSONENTITY_hobbies_ID` FOREIGN KEY (`hobbies_ID`) REFERENCES `HOBBYENTITY` (`ID`),
  CONSTRAINT `FK_HOBBYENTITY_PERSONENTITY_people_ID` FOREIGN KEY (`people_ID`) REFERENCES `PERSONENTITY` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `HOBBYENTITY_PERSONENTITY`
--

LOCK TABLES `HOBBYENTITY_PERSONENTITY` WRITE;
/*!40000 ALTER TABLE `HOBBYENTITY_PERSONENTITY` DISABLE KEYS */;
/*!40000 ALTER TABLE `HOBBYENTITY_PERSONENTITY` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `person`
--

DROP TABLE IF EXISTS `person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `person` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(100) DEFAULT NULL,
  `last_name` varchar(100) DEFAULT NULL,
  `fk_hobby` int NOT NULL,
  `email` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_hobby_idx` (`fk_hobby`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person`
--

LOCK TABLES `person` WRITE;
/*!40000 ALTER TABLE `person` DISABLE KEYS */;
INSERT INTO `person` VALUES (1,'Daniel','Pedersen',1,'admin@admin.com'),(2,'Daniel','Pedersen',0,NULL),(3,'admin','Admin',0,NULL),(4,NULL,NULL,0,NULL),(5,NULL,NULL,0,NULL),(6,'admin','admin',1,'admin@admin.com'),(7,'admin','admin',1,'admin@admin.com'),(8,'admin','admin',1,'admin@admin.com'),(9,'admin','admin',1,'admin@admin.com'),(10,'admin','admin',1,'admin@admin.com'),(11,'admin','admin',1,'admin@admin.com');
/*!40000 ALTER TABLE `person` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PERSONENTITY`
--

DROP TABLE IF EXISTS `PERSONENTITY`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `PERSONENTITY` (
  `ID` bigint NOT NULL AUTO_INCREMENT,
  `FIRSTNAME` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PERSONENTITY`
--

LOCK TABLES `PERSONENTITY` WRITE;
/*!40000 ALTER TABLE `PERSONENTITY` DISABLE KEYS */;
/*!40000 ALTER TABLE `PERSONENTITY` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PERSONENTITY_HOBBYENTITY`
--

DROP TABLE IF EXISTS `PERSONENTITY_HOBBYENTITY`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `PERSONENTITY_HOBBYENTITY` (
  `hobbies_ID` bigint NOT NULL,
  `people_ID` bigint NOT NULL,
  PRIMARY KEY (`hobbies_ID`,`people_ID`),
  KEY `FK_PERSONENTITY_HOBBYENTITY_people_ID` (`people_ID`),
  CONSTRAINT `FK_PERSONENTITY_HOBBYENTITY_hobbies_ID` FOREIGN KEY (`hobbies_ID`) REFERENCES `HOBBYENTITY` (`ID`),
  CONSTRAINT `FK_PERSONENTITY_HOBBYENTITY_people_ID` FOREIGN KEY (`people_ID`) REFERENCES `PERSONENTITY` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PERSONENTITY_HOBBYENTITY`
--

LOCK TABLES `PERSONENTITY_HOBBYENTITY` WRITE;
/*!40000 ALTER TABLE `PERSONENTITY_HOBBYENTITY` DISABLE KEYS */;
/*!40000 ALTER TABLE `PERSONENTITY_HOBBYENTITY` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `phone`
--

DROP TABLE IF EXISTS `phone`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `phone` (
  `id` int NOT NULL AUTO_INCREMENT,
  `number` int DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phone`
--

LOCK TABLES `phone` WRITE;
/*!40000 ALTER TABLE `phone` DISABLE KEYS */;
INSERT INTO `phone` VALUES (1,123456,NULL),(2,123,NULL),(3,1234,NULL);
/*!40000 ALTER TABLE `phone` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `RENAMEME`
--

DROP TABLE IF EXISTS `RENAMEME`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `RENAMEME` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `DUMMYSTR1` varchar(255) DEFAULT NULL,
  `DUMMYSTR2` varchar(255) DEFAULT NULL,
  `EMAIL` varchar(255) DEFAULT NULL,
  `FIRSTNAME` varchar(255) DEFAULT NULL,
  `LASTNAME` varchar(255) DEFAULT NULL,
  `PHONENUMBER` int DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `RENAMEME`
--

LOCK TABLES `RENAMEME` WRITE;
/*!40000 ALTER TABLE `RENAMEME` DISABLE KEYS */;
/*!40000 ALTER TABLE `RENAMEME` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `zipcodes`
--

DROP TABLE IF EXISTS `zipcodes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `zipcodes` (
  `id` int NOT NULL AUTO_INCREMENT,
  `zipcode` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `zipcodes`
--

LOCK TABLES `zipcodes` WRITE;
/*!40000 ALTER TABLE `zipcodes` DISABLE KEYS */;
/*!40000 ALTER TABLE `zipcodes` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-10-03 12:20:59
