CREATE DATABASE  IF NOT EXISTS `flowtech` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `flowtech`;
-- MySQL dump 10.13  Distrib 5.6.13, for Win32 (x86)
--
-- Host: localhost    Database: pharmacy
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
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer` (
  `id` varchar(45) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `mobile` varchar(45) DEFAULT NULL,
  `home` varchar(45) DEFAULT NULL,
  `office` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES 
('C00001','Dilshan de Silva','0773866141','2739907','','dishan@gmail.com','21/1 Terrance Avenue, Mount Lavinia'),
('C00002','Nihal Perera','0771580939','112739907','','nihal@yahoo.com','No.11, Katuwawala Mawatha,\nBoralesgamuwa'),
('C00003','Anura de Silva','0718334539','112595465','112595465','anura@gmail.com','47/2 Galle Road,\nBambalapitiya'),
('C00004','Namal Perera','0773866141','','','namal@gmail.com','No.12 Flowers Road\nColombo 07'),
('C00005','Sajeewa Herath','0718334539','','','a_sajeewa@yahoo.com','No.52 Field Avenue\nKohuwala');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `message`
--

DROP TABLE IF EXISTS `message`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `message` (
  `id` varchar(45) NOT NULL,
  `product_code` varchar(45) DEFAULT NULL,
  `supplier_id` varchar(45) DEFAULT NULL,
  `message` longtext,
  `contact_number` varchar(45) DEFAULT NULL,
  `message_type` varchar(45) DEFAULT NULL,
  `msg_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK38EB00074907338E` (`product_code`),
  KEY `FK38EB000741A96B18` (`supplier_id`),
  CONSTRAINT `FK38EB000741A96B18` FOREIGN KEY (`supplier_id`) REFERENCES `supplier` (`id`),
  CONSTRAINT `FK38EB00074907338E` FOREIGN KEY (`product_code`) REFERENCES `product` (`product_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `message`
--

LOCK TABLES `message` WRITE;
/*!40000 ALTER TABLE `message` DISABLE KEYS */;
INSERT INTO `message` VALUES 
('10f64e81-2406-405c-8d65-2bc9b0e7db9c',NULL,NULL,'Done','94718334539','Incoming','2015-07-03 21:13:35'),
('134a29cb-0735-4f93-b75f-245facd376f1',NULL,NULL,'Check the new MDI form. ','94771580939','Incoming','2015-06-30 19:56:41'),
('5983ce28-7abb-4810-aebb-ed9018b60fa2',NULL,NULL,'Make defaultCloseOperation to DISPOSE in all forms except for the main form','94771580939','Incoming','2015-06-30 16:49:32'),
('5f8baf22-b1e3-40f5-811b-d4b3d0f88849',NULL,NULL,'Hello Mr. :Ayesha de Silva(Supplier ID S00002).\nWe would like to order 1000 Obmet Box(Product Code P0002).\nPlease be kind to send the confirmation with your suplier ID & the product code.\nThank you.\nEraj Pharmaceuticals ','0771169711','Outgoing','2015-06-30 15:44:43'),
('60ee0dfe-e8c3-4700-94e5-1102f063e121',NULL,NULL,'Hello Mr. :Anura de Silva(Supplier ID S00003). We would like to order 0 Panadol Box(Product Code P0001). Please be kind to send the confirmation with your suplier ID & the product code. Thank you. Eraj Pharmaceuticals ','0771580939','Outgoing','2015-07-04 16:11:55'),
('64ef6d69-2695-4dc3-8e6e-caf6792b04dd',NULL,NULL,'Done.','94771580939','Incoming','2015-06-28 12:11:15'),
('735ece08-853b-402f-9d1a-3ddc795f1af0',NULL,'S00001','Hello Mr. :Manuri de Silva(Supplier ID S00001).\nWe would like to order 1500 Pedivit Box(Product Code P0005).\nPlease be kind to send the confirmation with your suplier ID & the product code.\nThank you.\nEraj Pharmaceuticals ','0771169711','Outgoing','2015-07-04 16:13:35'),
('7aeabe35-e3e5-451b-8e09-104287cecbfa',NULL,NULL,'Ok i will','94771580939','Incoming','2015-07-03 08:26:24'),
('96403a9c-6ef7-4b69-9bd1-8900821318af',NULL,NULL,'Hello Mr. :Anura de Silva(Supplier ID S00003).\nWe would like to order 1000 Panadol Box(Product Code P0001).\nPlease be kind to send the confirmation with your suplier ID & the product code.\nThank you.\nEraj Pharmaceuticals ','94771580939','Incoming','2015-07-04 16:09:27'),
('a8aaca25-df44-4843-ba17-8412885856f6',NULL,NULL,'Hello Mr. :Anura de Silva(Supplier ID S00003). We would like to order 0 Panadol Box(Product Code P0001). Please be kind to send the confirmation with your suplier ID & the product code. Thank you. Eraj Pharmaceuticals ','0771580939','Outgoing','2015-07-04 16:12:20'),
('aba5d964-4758-4034-a545-5bde9f8b7c52',NULL,NULL,'Please Call Me. Thank you.','94771580939','Incoming','2015-07-02 16:43:12'),
('c6021525-ba36-45fa-9ed8-5f5ba1cf4ee5',NULL,NULL,'Make defaultCloseOperation to DISPOSE in all forms except for the main form','94771580939','Incoming','2015-06-30 16:51:32'),
('c61a59fb-8c04-4ca3-9712-7a9aefd0498c',NULL,NULL,'Take update','94771580939','Incoming','2015-06-30 20:21:46'),
('c621cd72-6823-428b-b476-633c5322d1d3',NULL,NULL,'Make defaultCloseOperation to DISPOSE in all forms except for the main form','94771580939','Incoming','2015-06-30 21:57:04'),
('e944b01c-db76-404b-a84a-3c90540aa28d',NULL,NULL,'Hi','94771580939','Incoming','2015-06-30 16:06:02'),
('f2e059c2-4483-4046-b99b-1fc533f7f0e8',NULL,NULL,'Thank you for your payment of Rs.1000.00.','94718334539','Incoming','2015-07-03 21:17:16'),
('fadfd706-41c4-4bd3-a5f7-6a989b50de64',NULL,NULL,'Hello Mr. :Anura de Silva(Supplier ID S00003).\nWe would like to order 1000 Panadol Box(Product Code P0001).\nPlease be kind to send the confirmation with your suplier ID & the product code.\nThank you.\nEraj Pharmaceuticals ','0771580939','Outgoing','2015-07-03 08:25:32');
/*!40000 ALTER TABLE `message` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `permission`
--

DROP TABLE IF EXISTS `permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `permission` (
  `id` varchar(45) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `code` varchar(45) NOT NULL,
  `description` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `permission`
--

LOCK TABLES `permission` WRITE;
/*!40000 ALTER TABLE `permission` DISABLE KEYS */;
INSERT INTO `permission` VALUES 
('1','Sales','DO_SALES','Perform sales'),
('2','Purchases','DO_PURCHASES','Perform purchases'),
('3','Users','MANAGE_USERS','Manage users'),
('4','Roles','MANAGE_ROLES','Manage roles'),
('5','Customers','MANAGE_CUSTOMERS','Manage customers'),
('6','Suppliers','MANAGE_SUPPLIERS','Manage suppliers'),
('7','Products','MANAGE_PRODUCTS','Manage products'),
('8','Reports','GENERATE_REPORTS','Generate reports'),
('9','Messages','SEND_MESSAGES','Send & receive messages'),
('10','Preferences','SELECT_PREFERENCES','Select Report Location')
;
/*!40000 ALTER TABLE `permission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product` (
  `product_code` varchar(45) NOT NULL,
  `product_name` varchar(45) DEFAULT NULL,
  `category` varchar(45) DEFAULT NULL,
  `unit` varchar(45) DEFAULT NULL,
  `reorder_level` int(11) DEFAULT NULL,
  `standard_reorder_level` int(11) DEFAULT NULL,
  PRIMARY KEY (`product_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES 
('P00003','Piriton','Tablet','Packet',200,500),
('P00004','Vitamin E','Capsule','Cards',500,500),
('P00009','Cetrizine','Tablet','Box',100,200),
('P0001','Panadol','Tablet','Box',750,0),
('P0002','Obmet','Tablet','Box',100,500),
('P00047','Piriton Expectaron','Syrup','Bottle',100,500),
('P0005','Pedivit','Tablet','Box',100,500),
('p02555','Stematil','Tablet','Packet',100,500),
('p12547','Atorva','Tablet','Box',500,100),
('PV0254','Vitamin C','Tablet','Packet',1000,3000);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `id` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  `description` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES ('fed1f586-6c91-46fc-a3c7-df867c811aca','ADMIN','Administrator Role with all permissions.');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

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
INSERT INTO `role_permission` VALUES 
('19234a71-c875-4354-b151-72ede58b75ea','3','fed1f586-6c91-46fc-a3c7-df867c811aca'),
('22f7886e-c228-4c67-a4a8-8814e0fbcd7c','1','fed1f586-6c91-46fc-a3c7-df867c811aca'),
('36b06940-b722-439b-a768-b00e1ea2f6d4','8','fed1f586-6c91-46fc-a3c7-df867c811aca'),
('b9da6bf3-fd35-444e-a4bc-6c428cb03e45','2','fed1f586-6c91-46fc-a3c7-df867c811aca'),
('ba4035ce-f18f-4f81-85e5-60677d439df9','10','fed1f586-6c91-46fc-a3c7-df867c811aca'),
('c58ffb2e-4a5d-470b-bf6c-637218f86171','4','fed1f586-6c91-46fc-a3c7-df867c811aca'),
('cdf47f50-2148-4197-84a7-9c9faa3e471f','5','fed1f586-6c91-46fc-a3c7-df867c811aca'),
('ce76598f-aad9-4ba4-9da5-054ae7f75596','9','fed1f586-6c91-46fc-a3c7-df867c811aca'),
('e25316ce-c824-47b4-b3cb-835350073f25','6','fed1f586-6c91-46fc-a3c7-df867c811aca'),
('f5fae31c-b509-49f0-9952-973db84f9971','7','fed1f586-6c91-46fc-a3c7-df867c811aca');
/*!40000 ALTER TABLE `role_permission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stock`
--

DROP TABLE IF EXISTS `stock`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `stock` (
  `stock_id` varchar(45) NOT NULL,
  `product_code` varchar(45) NOT NULL,
  `supplier_id` varchar(45) NOT NULL,
  `quantity` double NOT NULL,
  `exp_date` datetime DEFAULT NULL,
  `purchased_unit_price` double DEFAULT NULL,
  PRIMARY KEY (`stock_id`),
  KEY `FK68AF7164907338E` (`product_code`),
  KEY `FK68AF71641A96B18` (`supplier_id`),
  CONSTRAINT `FK68AF71641A96B18` FOREIGN KEY (`supplier_id`) REFERENCES `supplier` (`id`),
  CONSTRAINT `FK68AF7164907338E` FOREIGN KEY (`product_code`) REFERENCES `product` (`product_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stock`
--

LOCK TABLES `stock` WRITE;
/*!40000 ALTER TABLE `stock` DISABLE KEYS */;
INSERT INTO `stock` VALUES 
('026c25fb-ccee-49c2-8598-61d013708a66','P0002','S00002',50,'2015-06-28 00:00:00',140),
('1a3d743b-a9bc-486c-a9ec-07e7590121ea','p02555','S00005',1000,'2015-07-04 00:00:00',200),
('321c19e8-e0ea-476e-94ca-1914561518be','P00004','S00001',150,'2015-06-28 00:00:00',150),
('39c1c7f6-cccf-492f-b297-4f53c2c3e3eb','P0005','S00001',10,'2015-06-28 00:00:00',250),
('3ae7cb86-ed2f-44af-8f78-3de076c2028a','PV0254','S00005',3000,'2015-07-04 00:00:00',100),
('49c9dec3-1f4f-46e2-a995-51afb3c6e999','P00047','S00002',1000,'2015-06-28 00:00:00',75),
('be33c469-e499-4691-975f-b964ec87507c','P00009','S00004',2000,'2015-07-04 00:00:00',50),
('f84e3a74-0c07-4abf-84a1-3d0bcd38442c','P0001','S00003',200,'2015-06-28 00:00:00',150),
('fbee68b7-f68c-44db-9a1e-38c4cb6121b7','P00003','S00001',2000,'2015-06-28 00:00:00',5);
/*!40000 ALTER TABLE `stock` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `supplier`
--

DROP TABLE IF EXISTS `supplier`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `supplier` (
  `id` varchar(45) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `mobile` varchar(45) DEFAULT NULL,
  `home` varchar(45) DEFAULT NULL,
  `office` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `supplier`
--

LOCK TABLES `supplier` WRITE;
/*!40000 ALTER TABLE `supplier` DISABLE KEYS */;
INSERT INTO `supplier` VALUES 
('S00001','Manuri de Silva','0771169711','','112735671','manuri@gmail.com','21/1\nTerrance Avenue\nMount Lavinia'),
('S00002','Ayesha de Silva','0771580939','','','ash@gmail.com','47/2\nGalle Road\nBambalapitiya'),
('S00003','Anura de Silva','0771580939','','','anura@gmail.com','47/2\nGalle Road\nBambalapitiya'),
('S00004','Rajitha Munasinghe','0771169711','','','raji@yahoo.com','26B Perera Lane\nMount Lavinia'),
('S00005','Udara Kaushalya','0771580939','','','ud@rocketmail.com','No 215/3A\nNegambo Road\nNegambo');
/*!40000 ALTER TABLE `supplier` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transaction`
--

DROP TABLE IF EXISTS `transaction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transaction` (
  `transaction_id` varchar(45) NOT NULL,
  `customer_id` varchar(45) DEFAULT NULL,
  `supplier_id` varchar(45) DEFAULT NULL,
  `date` datetime NOT NULL,
  `total` double NOT NULL,
  `transaction_type` varchar(45) NOT NULL,
  `payment_method` varchar(45) NOT NULL,
  PRIMARY KEY (`transaction_id`),
  KEY `FK7FA0D2DE41A96B18` (`supplier_id`),
  KEY `FK7FA0D2DE7C7BD9D8` (`customer_id`),
  CONSTRAINT `FK7FA0D2DE41A96B18` FOREIGN KEY (`supplier_id`) REFERENCES `supplier` (`id`),
  CONSTRAINT `FK7FA0D2DE7C7BD9D8` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaction`
--

LOCK TABLES `transaction` WRITE;
/*!40000 ALTER TABLE `transaction` DISABLE KEYS */;
INSERT INTO `transaction` VALUES 
('0a067a17-d810-4f76-bc74-a1b4f760238d','C00001',NULL,'2015-07-04 00:00:00',3250,'SALES','CASH'),
('138c8b50-9825-453b-b6be-80d89ad496a4',NULL,'S00003','2015-06-28 00:00:00',150000,'PURCHASE','CASH'),
('155ed5d4-6065-4f02-a13a-43d5b241872a','C00001',NULL,'2015-07-02 00:00:00',122500,'SALES','CASH'),
('215c03ba-8194-40b2-870c-0088c6d45ec6',NULL,'S00001','2015-06-28 00:00:00',135000,'PURCHASE','CASH'),
('334aa95e-f433-4112-8d95-8cfb26058ca1','C00002',NULL,'2015-06-28 00:00:00',156800,'SALES','CASH'),
('4a14d588-3ae9-414a-9d3b-8bf27c79b216','C00001',NULL,'2015-06-30 00:00:00',196000,'SALES','CASH'),
('4b58b2ce-beb1-4060-994a-808515e0aed7','C00001',NULL,'2015-06-28 00:00:00',24750,'SALES','CASH'),
('5e61b74a-dd09-44e5-9471-3253c8af7b8d','C00001',NULL,'2015-06-28 00:00:00',29400,'SALES','CASH'),
('5f2b8afb-4232-4882-9395-dc8dd3ca33fe','C00003',NULL,'2015-07-02 00:00:00',49000,'SALES','CASH'),
('62a81940-f38f-4aca-9692-f69f40e953b5','C00003',NULL,'2015-07-03 00:00:00',166600,'SALES','CASH'),
('637ea9c7-d28f-4fa2-b012-2f01eaafb773',NULL,'S00004','2015-07-04 00:00:00',100000,'PURCHASE','CASH'),
('646c7966-68c4-4842-9a07-03e31cb9e569',NULL,'S00001','2015-06-28 00:00:00',150000,'PURCHASE','CASH'),
('6b895f04-13a3-4572-a50f-caaa95292733',NULL,'S00005','2015-07-04 00:00:00',500000,'PURCHASE','CASH'),
('710f561b-50ec-4bfb-98d1-37dc4149357f',NULL,'S00002','2015-06-28 00:00:00',215000,'PURCHASE','CASH'),
('e01b5ed0-5c61-447d-8990-081434dd0a01',NULL,'S00003','2015-06-28 00:00:00',25000,'PURCHASE','CASH');
/*!40000 ALTER TABLE `transaction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transaction_detail`
--

DROP TABLE IF EXISTS `transaction_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transaction_detail` (
  `transaction_detail_id` varchar(45) NOT NULL,
  `product_code` varchar(45) DEFAULT NULL,
  `transaction_id` varchar(45) DEFAULT NULL,
  `unit_price` double DEFAULT NULL,
  `discount` double DEFAULT NULL,
  `exp_date` datetime DEFAULT NULL,
  `quantity` double DEFAULT NULL,
  PRIMARY KEY (`transaction_detail_id`),
  KEY `FKCA4DECD24907338E` (`product_code`),
  KEY `FKCA4DECD2EFAAAB5C` (`transaction_id`),
  CONSTRAINT `FKCA4DECD24907338E` FOREIGN KEY (`product_code`) REFERENCES `product` (`product_code`),
  CONSTRAINT `FKCA4DECD2EFAAAB5C` FOREIGN KEY (`transaction_id`) REFERENCES `transaction` (`transaction_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaction_detail`
--

LOCK TABLES `transaction_detail` WRITE;
/*!40000 ALTER TABLE `transaction_detail` DISABLE KEYS */;
INSERT INTO `transaction_detail` VALUES 
('0bae41c7-7b9e-45c8-8508-5e75c8c26d7a','P00004','62a81940-f38f-4aca-9692-f69f40e953b5',200,2,NULL,850),
('11d3c5a9-06e4-49a3-9c8e-81523bdcd755','PV0254','6b895f04-13a3-4572-a50f-caaa95292733',100,NULL,'2016-06-30 00:00:00',3000),
('1ddd848e-f650-45fe-ab7b-f9bb6eb3c892','P0002','710f561b-50ec-4bfb-98d1-37dc4149357f',140,NULL,'2018-02-28 00:00:00',1000),
('3676dc1b-522e-4737-ba7e-5ad6d60974a0','P00003','215c03ba-8194-40b2-870c-0088c6d45ec6',5,NULL,'2016-11-30 00:00:00',2000),
('3ed2da22-6e67-4cab-98c8-31866078b636','P00047','710f561b-50ec-4bfb-98d1-37dc4149357f',75,NULL,'2017-05-31 00:00:00',1000),
('4062444c-68ba-485a-aa25-483ceaf02151','P0001','138c8b50-9825-453b-b6be-80d89ad496a4',150,NULL,'2017-02-28 00:00:00',1000),
('64036573-8d3e-4146-8aee-bdb170061168','P0005','155ed5d4-6065-4f02-a13a-43d5b241872a',350,0,NULL,350),
('716b41a4-69ee-4aff-90ad-ded304c569ad','p02555','6b895f04-13a3-4572-a50f-caaa95292733',200,NULL,'2016-06-30 00:00:00',1000),
('938deb03-ba11-43d5-b00d-03917dfd2306','P0001','4a14d588-3ae9-414a-9d3b-8bf27c79b216',250,2,NULL,800),
('977faeac-4e57-4d4b-bf1a-d971945c718d','p02555','4b58b2ce-beb1-4060-994a-808515e0aed7',55,0,NULL,450),
('99c670ee-9081-4ddb-9ea2-4b32f6d51bbd','p02555','0a067a17-d810-4f76-bc74-a1b4f760238d',65,0,NULL,50),
('9c668b7f-498f-482d-a950-9ad01a0502f2','P0002','334aa95e-f433-4112-8d95-8cfb26058ca1',200,2,NULL,800),
('a3b14b66-5323-4cd9-bf59-ab7017b173b7','P00009','637ea9c7-d28f-4fa2-b012-2f01eaafb773',50,NULL,'2017-03-08 00:00:00',2000),
('b940bc47-e2f0-436b-bc10-d65237dc1364','P00004','646c7966-68c4-4842-9a07-03e31cb9e569',150,NULL,'2016-07-31 00:00:00',1000),
('c8ade1a7-36b6-4478-b814-8608f8328432','P0002','5e61b74a-dd09-44e5-9471-3253c8af7b8d',200,2,NULL,150),
('c9495240-e494-45c7-b060-94e435b3229a','P0005','215c03ba-8194-40b2-870c-0088c6d45ec6',250,NULL,'2017-07-31 00:00:00',500),
('d0c51414-c8ab-4ddb-a79b-282c45af56fe','P0005','5f2b8afb-4232-4882-9395-dc8dd3ca33fe',350,0,NULL,140),
('f2203e16-b399-4096-939e-8704196f3feb','p02555','e01b5ed0-5c61-447d-8990-081434dd0a01',50,NULL,'2016-10-31 00:00:00',500);
/*!40000 ALTER TABLE `transaction_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` varchar(45) NOT NULL,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `userid` varchar(45) NOT NULL,
  `email` varchar(45) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `userid` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('2f82d26e-0a17-4d86-8620-3f83e1340c87','Administrator','','admin','admin@abc.com','5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_role` (
  `id` varchar(45) NOT NULL,
  `user_id` varchar(45) NOT NULL,
  `role_id` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK143BF46A1FE11D8` (`role_id`),
  KEY `FK143BF46AA728D5B8` (`user_id`),
  CONSTRAINT `FK143BF46A1FE11D8` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`),
  CONSTRAINT `FK143BF46AA728D5B8` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES ('aabb1444-c02a-4f93-838c-dcd28fbfa26b','2f82d26e-0a17-4d86-8620-3f83e1340c87','fed1f586-6c91-46fc-a3c7-df867c811aca');
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-07-04 17:00:58
