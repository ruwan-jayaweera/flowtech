CREATE DATABASE  IF NOT EXISTS `pharmacy` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `pharmacy`;
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
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` (`id`, `name`, `mobile`, `home`, `office`, `email`, `address`) VALUES ('C00001','Heshan Perera','0771589459','112735895','112789456','hesh@gmail.com','21/3,terrence avenue,mount lavinia');
INSERT INTO `customer` (`id`, `name`, `mobile`, `home`, `office`, `email`, `address`) VALUES ('C00002','Udara Janith','0771584977','112258745','114587896','udara@yahoo.com','47/2 galle road,bambalapitiya');
INSERT INTO `customer` (`id`, `name`, `mobile`, `home`, `office`, `email`, `address`) VALUES ('C00003','Dilshan de Silva','0773866141','112588769','112987568','dilshan@gmail.com','56,temple road,maharagama');
INSERT INTO `customer` (`id`, `name`, `mobile`, `home`, `office`, `email`, `address`) VALUES ('C00004','Nihal Perera','0725877458','112735671','112987568','nihal@yahoo.com','56b, campus road, rattanapitiya');
INSERT INTO `customer` (`id`, `name`, `mobile`, `home`, `office`, `email`, `address`) VALUES ('C00005','Anura de Silva','0718334539','112577025','112578890','anura@gmail.com','345, katuwawala road, maharagama');
INSERT INTO `customer` (`id`, `name`, `mobile`, `home`, `office`, `email`, `address`) VALUES ('C00006','Namal Perera','0773866141','','','namal@gmail.com','No.12 Flowers Road\nColombo 07');
INSERT INTO `customer` (`id`, `name`, `mobile`, `home`, `office`, `email`, `address`) VALUES ('C00007','Sajeewa Herath','0718334539','','','a_sajeewa@yahoo.com','No.52 Field Avenue\nKohuwala');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `permission`
--

LOCK TABLES `permission` WRITE;
/*!40000 ALTER TABLE `permission` DISABLE KEYS */;
INSERT INTO `permission` (`id`, `name`, `code`, `description`) VALUES ('1','Sales','DO_SALES','Perform sales');
INSERT INTO `permission` (`id`, `name`, `code`, `description`) VALUES ('2','Purchases','DO_PURCHASES','Perform purchases');
INSERT INTO `permission` (`id`, `name`, `code`, `description`) VALUES ('3','Users','MANAGE_USERS','Manage users');
INSERT INTO `permission` (`id`, `name`, `code`, `description`) VALUES ('4','Roles','MANAGE_ROLES','Manage roles');
INSERT INTO `permission` (`id`, `name`, `code`, `description`) VALUES ('5','Customers','MANAGE_CUSTOMERS','Manage customers');
INSERT INTO `permission` (`id`, `name`, `code`, `description`) VALUES ('6','Suppliers','MANAGE_SUPPLIERS','Manage suppliers');
INSERT INTO `permission` (`id`, `name`, `code`, `description`) VALUES ('7','Products','MANAGE_PRODUCTS','Manage products');
INSERT INTO `permission` (`id`, `name`, `code`, `description`) VALUES ('8','Reports','GENERATE_REPORTS','Generate reports');
INSERT INTO `permission` (`id`, `name`, `code`, `description`) VALUES ('9', 'Messages', 'SEND_MESSAGES', 'Send & receive messages');
INSERT INTO `permission` (`id`, `name`, `code`, `description`) VALUES ('10','Preferences','SELECT_PREFERENCES','Select Report Location');
/*!40000 ALTER TABLE `permission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` (`product_code`, `product_name`, `category`, `unit`, `reorder_level`,`standard_reorder_level`) VALUES ('P00001','Piriton','Tablet','Packet',200,500);
INSERT INTO `product` (`product_code`, `product_name`, `category`, `unit`, `reorder_level`,`standard_reorder_level`) VALUES ('P00002','Vitamin E','Capsule','Cards',500,500);
INSERT INTO `product` (`product_code`, `product_name`, `category`, `unit`, `reorder_level`,`standard_reorder_level`) VALUES ('P00003','Cetrizine','Tablet','Box',100,200);
INSERT INTO `product` (`product_code`, `product_name`, `category`, `unit`, `reorder_level`,`standard_reorder_level`) VALUES ('P00004','Panadol','Tablet','Box',750,0);
INSERT INTO `product` (`product_code`, `product_name`, `category`, `unit`, `reorder_level`,`standard_reorder_level`) VALUES ('P00005','Obmet','Tablet','Box',100,500);
INSERT INTO `product` (`product_code`, `product_name`, `category`, `unit`, `reorder_level`,`standard_reorder_level`) VALUES ('P00006','Piriton Expectaron','Syrup','Bottle',100,500);
INSERT INTO `product` (`product_code`, `product_name`, `category`, `unit`, `reorder_level`,`standard_reorder_level`) VALUES ('P00007','Pedivit','Tablet','Box',100,500);
INSERT INTO `product` (`product_code`, `product_name`, `category`, `unit`, `reorder_level`,`standard_reorder_level`) VALUES ('P00008','Stematil','Tablet','Packet',100,500);
INSERT INTO `product` (`product_code`, `product_name`, `category`, `unit`, `reorder_level`,`standard_reorder_level`) VALUES ('P00009','Atorva','Tablet','Box',500,100);
INSERT INTO `product` (`product_code`, `product_name`, `category`, `unit`, `reorder_level`,`standard_reorder_level`) VALUES ('P00010','Vitamin C','Tablet','Packet',1000,3000);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` (`id`, `name`, `description`) VALUES ('fed1f586-6c91-46fc-a3c7-df867c811aca','ADMIN','Administrator Role with all permissions.');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `role_permission`
--

LOCK TABLES `role_permission` WRITE;
/*!40000 ALTER TABLE `role_permission` DISABLE KEYS */;
INSERT INTO `role_permission` (`id`, `permission_id`, `role_id`) VALUES ('22f7886e-c228-4c67-a4a8-8814e0fbcd7c','1','fed1f586-6c91-46fc-a3c7-df867c811aca');
INSERT INTO `role_permission` (`id`, `permission_id`, `role_id`) VALUES ('b9da6bf3-fd35-444e-a4bc-6c428cb03e45','2','fed1f586-6c91-46fc-a3c7-df867c811aca');
INSERT INTO `role_permission` (`id`, `permission_id`, `role_id`) VALUES ('19234a71-c875-4354-b151-72ede58b75ea','3','fed1f586-6c91-46fc-a3c7-df867c811aca');
INSERT INTO `role_permission` (`id`, `permission_id`, `role_id`) VALUES ('c58ffb2e-4a5d-470b-bf6c-637218f86171','4','fed1f586-6c91-46fc-a3c7-df867c811aca');
INSERT INTO `role_permission` (`id`, `permission_id`, `role_id`) VALUES ('cdf47f50-2148-4197-84a7-9c9faa3e471f','5','fed1f586-6c91-46fc-a3c7-df867c811aca');
INSERT INTO `role_permission` (`id`, `permission_id`, `role_id`) VALUES ('e25316ce-c824-47b4-b3cb-835350073f25','6','fed1f586-6c91-46fc-a3c7-df867c811aca');
INSERT INTO `role_permission` (`id`, `permission_id`, `role_id`) VALUES ('f5fae31c-b509-49f0-9952-973db84f9971','7','fed1f586-6c91-46fc-a3c7-df867c811aca');
INSERT INTO `role_permission` (`id`, `permission_id`, `role_id`) VALUES ('36b06940-b722-439b-a768-b00e1ea2f6d4','8','fed1f586-6c91-46fc-a3c7-df867c811aca');
INSERT INTO `role_permission` (`id`, `permission_id`, `role_id`) VALUES ('ce76598f-aad9-4ba4-9da5-054ae7f75596','9','fed1f586-6c91-46fc-a3c7-df867c811aca');
INSERT INTO `role_permission` (`id`, `permission_id`, `role_id`) VALUES ('ba4035ce-f18f-4f81-85e5-60677d439df9','10','fed1f586-6c91-46fc-a3c7-df867c811aca');
/*!40000 ALTER TABLE `role_permission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `stock`
--

LOCK TABLES `stock` WRITE;
/*!40000 ALTER TABLE `stock` DISABLE KEYS */;
INSERT INTO `stock` (`stock_id`, `product_code`, `supplier_id`, `quantity`, `exp_date`, `purchased_unit_price`) VALUES ('026c25fb-ccee-49c2-8598-61d013708a66','P00005','S00002',5000,'2015-06-28 00:00:00',140);
INSERT INTO `stock` (`stock_id`, `product_code`, `supplier_id`, `quantity`, `exp_date`, `purchased_unit_price`) VALUES ('1a3d743b-a9bc-486c-a9ec-07e7590121ea','P00008','S00002',1000,'2015-07-04 00:00:00',200);
INSERT INTO `stock` (`stock_id`, `product_code`, `supplier_id`, `quantity`, `exp_date`, `purchased_unit_price`) VALUES ('321c19e8-e0ea-476e-94ca-1914561518be','P00002','S00001',1500,'2015-06-28 00:00:00',150);
INSERT INTO `stock` (`stock_id`, `product_code`, `supplier_id`, `quantity`, `exp_date`, `purchased_unit_price`) VALUES ('39c1c7f6-cccf-492f-b297-4f53c2c3e3eb','P00007','S00001',1000,'2015-06-28 00:00:00',250);
INSERT INTO `stock` (`stock_id`, `product_code`, `supplier_id`, `quantity`, `exp_date`, `purchased_unit_price`) VALUES ('3ae7cb86-ed2f-44af-8f78-3de076c2028a','P00010','S00002',3000,'2015-07-04 00:00:00',100);
INSERT INTO `stock` (`stock_id`, `product_code`, `supplier_id`, `quantity`, `exp_date`, `purchased_unit_price`) VALUES ('49c9dec3-1f4f-46e2-a995-51afb3c6e999','P00006','S00002',1000,'2015-06-28 00:00:00',75);
INSERT INTO `stock` (`stock_id`, `product_code`, `supplier_id`, `quantity`, `exp_date`, `purchased_unit_price`) VALUES ('be33c469-e499-4691-975f-b964ec87507c','P00003','S00002',2000,'2015-07-04 00:00:00',50);
INSERT INTO `stock` (`stock_id`, `product_code`, `supplier_id`, `quantity`, `exp_date`, `purchased_unit_price`) VALUES ('f84e3a74-0c07-4abf-84a1-3d0bcd38442c','P00004','S00001',2000,'2015-06-28 00:00:00',150);
INSERT INTO `stock` (`stock_id`, `product_code`, `supplier_id`, `quantity`, `exp_date`, `purchased_unit_price`) VALUES ('fbee68b7-f68c-44db-9a1e-38c4cb6121b7','P00001','S00001',2000,'2015-06-28 00:00:00',5);
/*!40000 ALTER TABLE `stock` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `supplier`
--

LOCK TABLES `supplier` WRITE;
/*!40000 ALTER TABLE `supplier` DISABLE KEYS */;
INSERT INTO `supplier` (`id`, `name`, `mobile`, `home`, `office`, `email`, `address`) VALUES ('S00001','Manuri de Silva','0771169711','','112735671','manuri@gmail.com','21/1\nTerrance Avenue\nMount Lavinia');
INSERT INTO `supplier` (`id`, `name`, `mobile`, `home`, `office`, `email`, `address`) VALUES ('S00002','Ayesha de Silva','0771580939','','','ash@gmail.com','47/2\nGalle Road\nBambalapitiya');
INSERT INTO `supplier` (`id`, `name`, `mobile`, `home`, `office`, `email`, `address`) VALUES ('S00003','Anura de Silva','0718334539','','','anura@gmail.com','47/2\nGalle Road\nBambalapitiya');
INSERT INTO `supplier` (`id`, `name`, `mobile`, `home`, `office`, `email`, `address`) VALUES ('S00004','Rajitha Munasinghe','0773866141','','','raji@yahoo.com','26B Perera Lane\nMount Lavinia');
INSERT INTO `supplier` (`id`, `name`, `mobile`, `home`, `office`, `email`, `address`) VALUES ('S00005','Udara Kaushalya','0714458890','','','ud@rocketmail.com','No 215/3A\nNegambo Road\nNegambo');
/*!40000 ALTER TABLE `supplier` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `message`
--

LOCK TABLES `message` WRITE;
/*!40000 ALTER TABLE `message` DISABLE KEYS */;
INSERT INTO `message` (`id`, `product_code`, `supplier_id`, `message`, `contact_number`, `message_type`, `msg_date`) VALUES ('735ece08-853b-402f-9d1a-3ddc795f1af0',NULL,'S00001','Hello Ms. :Manuri de Silva(Supplier ID S00001).\nWe would like to order 1500 Pedivit Box(Product Code P0005).\nPlease be kind to send the confirmation with your suplier ID & the product code.\nThank you.\nEraj Pharmaceuticals ', '0771169711', 'Outgoing', '2015-07-04 16:13:35');
INSERT INTO `message` (`id`, `product_code`, `supplier_id`, `message`, `contact_number`, `message_type`, `msg_date`) VALUES ('833897c9-91e1-4ea8-91c9-7adb9ecd9fa1',NULL,'S00001','Hello Ms. :Manuri de Silva(Supplier ID S00001). We would like to order 0 Panadol Box(Product Code P00004). Please be kind to send the confirmation with your suplier ID & the product code. Thank you. Eraj Pharmaceuticals ', '0771169711', 'Outgoing', '2015-07-19 13:17:41');
INSERT INTO `message` (`id`, `product_code`, `supplier_id`, `message`, `contact_number`, `message_type`, `msg_date`) VALUES ('88f29870-8caf-4ec1-af5b-42594d50db70',NULL,'S00001','Hello Ms. Manuri de Silva(Supplier ID S00001).\nWe would like to order 500 Vitamin E Cards(Product Code P00002).\nPlease be kind to send the confirmation with your suplier ID & the product code.\nThank you.\nEraj Pharmaceuticals ', '0771169711', 'Outgoing', '2015-07-20 07:44:55');
INSERT INTO `message` (`id`, `product_code`, `supplier_id`, `message`, `contact_number`, `message_type`, `msg_date`) VALUES ('938b7549-5b4a-4e9a-a56b-8570588d63ca',NULL,'S00003','we will send ur order asap. id-s00003 product id-p00008. thank you', '94718334539', 'Incoming', '2015-07-28 22:48:47');
INSERT INTO `message` (`id`, `product_code`, `supplier_id`, `message`, `contact_number`, `message_type`, `msg_date`) VALUES ('d9fcfd17-3c3b-408b-a9d7-e2443b2c6ea1',NULL,'S00002','Hi', '94771580939', 'Incoming', '2015-07-20 07:46:40');
INSERT INTO `message` (`id`, `product_code`, `supplier_id`, `message`, `contact_number`, `message_type`, `msg_date`) VALUES ('7aeabe35-e3e5-451b-8e09-104287cecbfa',NULL,'S00002','Ok i will','94771580939','Incoming','2015-07-03 08:26:24');
INSERT INTO `message` (`id`, `product_code`, `supplier_id`, `message`, `contact_number`, `message_type`, `msg_date`) VALUES ('96403a9c-6ef7-4b69-9bd1-8900821318af',NULL,'S00001','Hello Ms. :Manuri de Silva(Supplier ID S00001).\nWe would like to order 1000 Panadol Box(Product Code P0001).\nPlease be kind to send the confirmation with your suplier ID & the product code.\nThank you.\nEraj Pharmaceuticals ','94771580939','Incoming','2015-07-04 16:09:27');
INSERT INTO `message` (`id`, `product_code`, `supplier_id`, `message`, `contact_number`, `message_type`, `msg_date`) VALUES ('a8aaca25-df44-4843-ba17-8412885856f6',NULL,'S00001','Hello Ms. :Manuri de Silva(Supplier ID S00001). We would like to order 0 Panadol Box(Product Code P0001). Please be kind to send the confirmation with your suplier ID & the product code. Thank you. Eraj Pharmaceuticals ','0771580939','Outgoing','2015-07-04 16:12:20');
INSERT INTO `message` (`id`, `product_code`, `supplier_id`, `message`, `contact_number`, `message_type`, `msg_date`) VALUES ('aba5d964-4758-4034-a545-5bde9f8b7c52',NULL,'S00002','Please Call Me. Thank you.','94771580939','Incoming','2015-07-02 16:43:12');
INSERT INTO `message` (`id`, `product_code`, `supplier_id`, `message`, `contact_number`, `message_type`, `msg_date`) VALUES ('f167f46a-07f2-4235-9ec9-5fcdbdb42f45',NULL,'S00001', 'Hello Mr. :Manuri de Silva(Supplier ID S00001). We would like to order 500 Pedivit Box(Product Code P00007). Please be kind to send the confirmation with your suplier ID & the product code. Thank you. Eraj Pharmaceuticals ', '0771169711', 'Outgoing', '2015-07-19 13:17:24');
INSERT INTO `message` (`id`, `product_code`, `supplier_id`, `message`, `contact_number`, `message_type`, `msg_date`) VALUES ('f4f0f35d-7ed2-4848-8229-a4a4ca144eae',NULL,'S00002', 'Hello', '94771580939', 'Incoming', '2015-07-20 08:03:52');
INSERT INTO `message` (`id`, `product_code`, `supplier_id`, `message`, `contact_number`, `message_type`, `msg_date`) VALUES ('e944b01c-db76-404b-a84a-3c90540aa28d',NULL,'S00002','Done','94771580939','Incoming','2015-06-30 16:06:02');
INSERT INTO `message` (`id`, `product_code`, `supplier_id`, `message`, `contact_number`, `message_type`, `msg_date`) VALUES ('f2e059c2-4483-4046-b99b-1fc533f7f0e8',NULL,'S00003','Thank you for your payment of Rs.1000.00.','94718334539','Incoming','2015-07-03 21:17:16');
INSERT INTO `message` (`id`, `product_code`, `supplier_id`, `message`, `contact_number`, `message_type`, `msg_date`) VALUES ('fadfd706-41c4-4bd3-a5f7-6a989b50de64',NULL,'S00003','Hello Mr. :Anura de Silva(Supplier ID S00003).\nWe would like to order 1000 Panadol Box(Product Code P0001).\nPlease be kind to send the confirmation with your suplier ID & the product code.\nThank you.\nEraj Pharmaceuticals ','0771580939','Outgoing','2015-07-03 08:25:32');
/*!40000 ALTER TABLE `message` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `transaction`
--

LOCK TABLES `transaction` WRITE;
/*!40000 ALTER TABLE `transaction` DISABLE KEYS */;
INSERT INTO `transaction` (`transaction_id`, `customer_id`, `supplier_id`, `date`, `total`, `transaction_type`, `payment_method`) VALUES ('0a067a17-d810-4f76-bc74-a1b4f760238d','C00001',NULL,'2015-07-04 00:00:00',3250,'SALES','CASH');
INSERT INTO `transaction` (`transaction_id`, `customer_id`, `supplier_id`, `date`, `total`, `transaction_type`, `payment_method`) VALUES ('138c8b50-9825-453b-b6be-80d89ad496a4',NULL,'S00001','2015-06-28 00:00:00',150000,'PURCHASE','CASH');
INSERT INTO `transaction` (`transaction_id`, `customer_id`, `supplier_id`, `date`, `total`, `transaction_type`, `payment_method`) VALUES ('155ed5d4-6065-4f02-a13a-43d5b241872a','C00001',NULL,'2015-07-02 00:00:00',122500,'SALES','CASH');
INSERT INTO `transaction` (`transaction_id`, `customer_id`, `supplier_id`, `date`, `total`, `transaction_type`, `payment_method`) VALUES ('215c03ba-8194-40b2-870c-0088c6d45ec6',NULL,'S00001','2015-06-28 00:00:00',135000,'PURCHASE','CASH');
INSERT INTO `transaction` (`transaction_id`, `customer_id`, `supplier_id`, `date`, `total`, `transaction_type`, `payment_method`) VALUES ('334aa95e-f433-4112-8d95-8cfb26058ca1','C00002',NULL,'2015-06-28 00:00:00',156800,'SALES','CASH');
INSERT INTO `transaction` (`transaction_id`, `customer_id`, `supplier_id`, `date`, `total`, `transaction_type`, `payment_method`) VALUES ('4a14d588-3ae9-414a-9d3b-8bf27c79b216','C00001',NULL,'2015-06-30 00:00:00',196000,'SALES','CASH');
INSERT INTO `transaction` (`transaction_id`, `customer_id`, `supplier_id`, `date`, `total`, `transaction_type`, `payment_method`) VALUES ('4b58b2ce-beb1-4060-994a-808515e0aed7','C00001',NULL,'2015-06-28 00:00:00',24750,'SALES','CASH');
INSERT INTO `transaction` (`transaction_id`, `customer_id`, `supplier_id`, `date`, `total`, `transaction_type`, `payment_method`) VALUES ('5e61b74a-dd09-44e5-9471-3253c8af7b8d','C00001',NULL,'2015-06-28 00:00:00',29400,'SALES','CASH');
INSERT INTO `transaction` (`transaction_id`, `customer_id`, `supplier_id`, `date`, `total`, `transaction_type`, `payment_method`) VALUES ('5f2b8afb-4232-4882-9395-dc8dd3ca33fe','C00003',NULL,'2015-07-02 00:00:00',49000,'SALES','CASH');
INSERT INTO `transaction` (`transaction_id`, `customer_id`, `supplier_id`, `date`, `total`, `transaction_type`, `payment_method`) VALUES ('62a81940-f38f-4aca-9692-f69f40e953b5','C00003',NULL,'2015-07-03 00:00:00',166600,'SALES','CASH');
INSERT INTO `transaction` (`transaction_id`, `customer_id`, `supplier_id`, `date`, `total`, `transaction_type`, `payment_method`) VALUES ('637ea9c7-d28f-4fa2-b012-2f01eaafb773',NULL,'S00002','2015-07-04 00:00:00',100000,'PURCHASE','CASH');
INSERT INTO `transaction` (`transaction_id`, `customer_id`, `supplier_id`, `date`, `total`, `transaction_type`, `payment_method`) VALUES ('646c7966-68c4-4842-9a07-03e31cb9e569',NULL,'S00001','2015-06-28 00:00:00',150000,'PURCHASE','CASH');
INSERT INTO `transaction` (`transaction_id`, `customer_id`, `supplier_id`, `date`, `total`, `transaction_type`, `payment_method`) VALUES ('6b895f04-13a3-4572-a50f-caaa95292733',NULL,'S00002','2015-07-04 00:00:00',500000,'PURCHASE','CASH');
INSERT INTO `transaction` (`transaction_id`, `customer_id`, `supplier_id`, `date`, `total`, `transaction_type`, `payment_method`) VALUES ('710f561b-50ec-4bfb-98d1-37dc4149357f',NULL,'S00002','2015-06-28 00:00:00',215000,'PURCHASE','CASH');
INSERT INTO `transaction` (`transaction_id`, `customer_id`, `supplier_id`, `date`, `total`, `transaction_type`, `payment_method`) VALUES ('e01b5ed0-5c61-447d-8990-081434dd0a01',NULL,'S00001','2015-06-28 00:00:00',25000,'PURCHASE','CASH');
/*!40000 ALTER TABLE `transaction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `transaction_detail`
--

LOCK TABLES `transaction_detail` WRITE;
/*!40000 ALTER TABLE `transaction_detail` DISABLE KEYS */;
INSERT INTO `transaction_detail` (`transaction_detail_id`, `product_code`, `transaction_id`, `unit_price`, `discount`, `exp_date`, `quantity`) VALUES ('0bae41c7-7b9e-45c8-8508-5e75c8c26d7a','P00002','62a81940-f38f-4aca-9692-f69f40e953b5',200,2,NULL,850);
INSERT INTO `transaction_detail` (`transaction_detail_id`, `product_code`, `transaction_id`, `unit_price`, `discount`, `exp_date`, `quantity`) VALUES ('11d3c5a9-06e4-49a3-9c8e-81523bdcd755','P00010','6b895f04-13a3-4572-a50f-caaa95292733',100,NULL,'2016-06-30 00:00:00',3000);
INSERT INTO `transaction_detail` (`transaction_detail_id`, `product_code`, `transaction_id`, `unit_price`, `discount`, `exp_date`, `quantity`) VALUES ('1ddd848e-f650-45fe-ab7b-f9bb6eb3c892','P00005','710f561b-50ec-4bfb-98d1-37dc4149357f',140,NULL,'2018-02-28 00:00:00',1000);
INSERT INTO `transaction_detail` (`transaction_detail_id`, `product_code`, `transaction_id`, `unit_price`, `discount`, `exp_date`, `quantity`) VALUES ('3676dc1b-522e-4737-ba7e-5ad6d60974a0','P00001','215c03ba-8194-40b2-870c-0088c6d45ec6',5,NULL,'2016-11-30 00:00:00',2000);
INSERT INTO `transaction_detail` (`transaction_detail_id`, `product_code`, `transaction_id`, `unit_price`, `discount`, `exp_date`, `quantity`) VALUES ('3ed2da22-6e67-4cab-98c8-31866078b636','P00006','710f561b-50ec-4bfb-98d1-37dc4149357f',75,NULL,'2017-05-31 00:00:00',1000);
INSERT INTO `transaction_detail` (`transaction_detail_id`, `product_code`, `transaction_id`, `unit_price`, `discount`, `exp_date`, `quantity`) VALUES ('4062444c-68ba-485a-aa25-483ceaf02151','P00004','138c8b50-9825-453b-b6be-80d89ad496a4',150,NULL,'2017-02-28 00:00:00',1000);
INSERT INTO `transaction_detail` (`transaction_detail_id`, `product_code`, `transaction_id`, `unit_price`, `discount`, `exp_date`, `quantity`) VALUES ('64036573-8d3e-4146-8aee-bdb170061168','P00007','155ed5d4-6065-4f02-a13a-43d5b241872a',350,0,NULL,350);
INSERT INTO `transaction_detail` (`transaction_detail_id`, `product_code`, `transaction_id`, `unit_price`, `discount`, `exp_date`, `quantity`) VALUES ('716b41a4-69ee-4aff-90ad-ded304c569ad','P00008','6b895f04-13a3-4572-a50f-caaa95292733',200,NULL,'2016-06-30 00:00:00',1000);
INSERT INTO `transaction_detail` (`transaction_detail_id`, `product_code`, `transaction_id`, `unit_price`, `discount`, `exp_date`, `quantity`) VALUES ('938deb03-ba11-43d5-b00d-03917dfd2306','P00004','4a14d588-3ae9-414a-9d3b-8bf27c79b216',250,2,NULL,800);
INSERT INTO `transaction_detail` (`transaction_detail_id`, `product_code`, `transaction_id`, `unit_price`, `discount`, `exp_date`, `quantity`) VALUES ('977faeac-4e57-4d4b-bf1a-d971945c718d','P00008','4b58b2ce-beb1-4060-994a-808515e0aed7',55,0,NULL,450);
INSERT INTO `transaction_detail` (`transaction_detail_id`, `product_code`, `transaction_id`, `unit_price`, `discount`, `exp_date`, `quantity`) VALUES ('99c670ee-9081-4ddb-9ea2-4b32f6d51bbd','P00008','0a067a17-d810-4f76-bc74-a1b4f760238d',65,0,NULL,50);
INSERT INTO `transaction_detail` (`transaction_detail_id`, `product_code`, `transaction_id`, `unit_price`, `discount`, `exp_date`, `quantity`) VALUES ('9c668b7f-498f-482d-a950-9ad01a0502f2','P00005','334aa95e-f433-4112-8d95-8cfb26058ca1',200,2,NULL,800);
INSERT INTO `transaction_detail` (`transaction_detail_id`, `product_code`, `transaction_id`, `unit_price`, `discount`, `exp_date`, `quantity`) VALUES ('a3b14b66-5323-4cd9-bf59-ab7017b173b7','P00003','637ea9c7-d28f-4fa2-b012-2f01eaafb773',50,NULL,'2017-03-08 00:00:00',2000);
INSERT INTO `transaction_detail` (`transaction_detail_id`, `product_code`, `transaction_id`, `unit_price`, `discount`, `exp_date`, `quantity`) VALUES ('b940bc47-e2f0-436b-bc10-d65237dc1364','P00002','646c7966-68c4-4842-9a07-03e31cb9e569',150,NULL,'2016-07-31 00:00:00',1000);
INSERT INTO `transaction_detail` (`transaction_detail_id`, `product_code`, `transaction_id`, `unit_price`, `discount`, `exp_date`, `quantity`) VALUES ('c8ade1a7-36b6-4478-b814-8608f8328432','P00005','5e61b74a-dd09-44e5-9471-3253c8af7b8d',200,2,NULL,150);
INSERT INTO `transaction_detail` (`transaction_detail_id`, `product_code`, `transaction_id`, `unit_price`, `discount`, `exp_date`, `quantity`) VALUES ('c9495240-e494-45c7-b060-94e435b3229a','P00007','215c03ba-8194-40b2-870c-0088c6d45ec6',250,NULL,'2017-07-31 00:00:00',500);
INSERT INTO `transaction_detail` (`transaction_detail_id`, `product_code`, `transaction_id`, `unit_price`, `discount`, `exp_date`, `quantity`) VALUES ('d0c51414-c8ab-4ddb-a79b-282c45af56fe','P00007','5f2b8afb-4232-4882-9395-dc8dd3ca33fe',350,0,NULL,140);
INSERT INTO `transaction_detail` (`transaction_detail_id`, `product_code`, `transaction_id`, `unit_price`, `discount`, `exp_date`, `quantity`) VALUES ('f2203e16-b399-4096-939e-8704196f3feb','P00008','e01b5ed0-5c61-447d-8990-081434dd0a01',50,NULL,'2016-10-31 00:00:00',500);

/*!40000 ALTER TABLE `transaction_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`id`, `first_name`, `last_name`, `userid`, `email`, `password`) VALUES ('2f82d26e-0a17-4d86-8620-3f83e1340c87','Administrator','','admin','admin@abc.com','d74ff0ee8da3b9806b18c877dbf29bbde50b5bd8e4dad7a3a725000feb82e8f1');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` (`id`, `user_id`, `role_id`) VALUES ('aabb1444-c02a-4f93-838c-dcd28fbfa26b','2f82d26e-0a17-4d86-8620-3f83e1340c87','fed1f586-6c91-46fc-a3c7-df867c811aca');
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

-- Dump completed on 2014-08-23 15:03:43
