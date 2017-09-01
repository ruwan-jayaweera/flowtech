CREATE DATABASE  IF NOT EXISTS `flowtech` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `flowtech`;
-- MySQL dump 10.13  Distrib 5.6.13, for Win32 (x86)
--
-- Host: localhost    Database: flowtech
-- ------------------------------------------------------
-- Server version	5.6.10

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
-- Table structure for table `role_permission`
--

DROP TABLE IF EXISTS `role_permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role_permission` (
  `id` varchar(45) NOT NULL,
  `permission_id` varchar(45) NOT NULL,
  `role_id` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKBD40D5381FE11D8` (`role_id`),
  KEY `FKBD40D538B6C388B8` (`permission_id`),
  CONSTRAINT `FKBD40D5381FE11D8` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`),
  CONSTRAINT `FKBD40D538B6C388B8` FOREIGN KEY (`permission_id`) REFERENCES `permission` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role_permission`
--

LOCK TABLES `role_permission` WRITE;
/*!40000 ALTER TABLE `role_permission` DISABLE KEYS */;
INSERT INTO `role_permission` VALUES ('19234a71-c875-4354-b151-72ede58b75ea','3','fed1f586-6c91-46fc-a3c7-df867c811aca'),('22f7886e-c228-4c67-a4a8-8814e0fbcd7c','1','fed1f586-6c91-46fc-a3c7-df867c811aca'),('36b06940-b722-439b-a768-b00e1ea2f6d4','8','fed1f586-6c91-46fc-a3c7-df867c811aca'),('b9da6bf3-fd35-444e-a4bc-6c428cb03e45','2','fed1f586-6c91-46fc-a3c7-df867c811aca'),('ba4035ce-f18f-4f81-85e5-60677d439df9','10','fed1f586-6c91-46fc-a3c7-df867c811aca'),('c58ffb2e-4a5d-470b-bf6c-637218f86171','4','fed1f586-6c91-46fc-a3c7-df867c811aca'),('cdf47f50-2148-4197-84a7-9c9faa3e471f','5','fed1f586-6c91-46fc-a3c7-df867c811aca'),('ce76598f-aad9-4ba4-9da5-054ae7f75596','9','fed1f586-6c91-46fc-a3c7-df867c811aca'),('e25316ce-c824-47b4-b3cb-835350073f25','6','fed1f586-6c91-46fc-a3c7-df867c811aca'),('f5fae31c-b509-49f0-9952-973db84f9971','7','fed1f586-6c91-46fc-a3c7-df867c811aca');
/*!40000 ALTER TABLE `role_permission` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-08-29 22:25:40
