-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: localhost    Database: library
-- ------------------------------------------------------
-- Server version	8.0.26

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `books`
--

DROP TABLE IF EXISTS `books`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `books` (
  `id` int NOT NULL AUTO_INCREMENT,
  `book_name` varchar(25) DEFAULT NULL,
  `category` varchar(25) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `rating` double DEFAULT NULL,
  `copies` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `books`
--

LOCK TABLES `books` WRITE;
/*!40000 ALTER TABLE `books` DISABLE KEYS */;
INSERT INTO `books` VALUES (1,'Ratatouille','comic',1000,8.3,35),(2,'The_graveyard','horror',900,8.5,40),(3,'Dark_places','mystery',1200,8.1,30),(4,'Harry_potter','fantasy',1100,9.2,50),(5,'Batman','comic',1200,9.3,50),(6,'Bhagavad_gita','religion',1150,9.5,100),(7,'one_Piece','adventure',2000,9.9,20),(8,'dororo','horror',3000,8.2,40),(9,'naruto','action',500,8,40),(10,'fairytail','magic',800,9,100),(11,'human_anotomy','anatomy',750,7.6,75),(12,'black_clover','magic',2000,7.5,80),(13,'wonerstruck','comic',655,7.4,50),(14,'game_of_thrones','action',1000,9.6,95),(15,'eclipse','fantasy',900,8.5,20),(16,'pokemon','adventure',3000,8.4,40),(17,'attack on titan','action',2000,7,100),(18,'fruit_basket','romance',350,8.1,40),(19,'demon_slayer','horror',370,8,60),(20,'dark_places','crime',400,7.5,70),(21,'dead_night','romance',800,8.5,90),(22,'the_reversal','crime',450,7.3,80),(23,'radical_acceptance','religion',700,8.4,70),(24,'onara','anatomy',950,7.1,95),(25,'watchmen','comic',1200,9.3,50);
/*!40000 ALTER TABLE `books` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `magazines`
--

DROP TABLE IF EXISTS `magazines`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `magazines` (
  `id` int NOT NULL AUTO_INCREMENT,
  `magazine_name` varchar(25) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `rating` double DEFAULT NULL,
  `copies` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `magazines`
--

LOCK TABLES `magazines` WRITE;
/*!40000 ALTER TABLE `magazines` DISABLE KEYS */;
INSERT INTO `magazines` VALUES (1,'Southern living',1000,8.9,100),(2,'People',1500,9.1,100),(3,'The_pioneer_woman',1100,8.5,900),(4,'Best_friend',1000,9.2,200),(5,'American_history',2000,8.3,500),(6,'Filmfare',300,8.2,3000),(7,'India_Today',500,9,200),(8,'Time',700,8.5,4500),(9,'Economist',500,8.4,3400),(10,'Outlook',800,9,3000),(11,'Forbes_India',650,9.3,2500),(12,'AARP',250,7.9,2000),(13,'AARP_Bulletin',275,8.3,300),(14,'Better_Homes_And_Gardens',225,7,3500),(15,'Game_Informer',900,6.5,3700),(16,'Good_Housekeeping',1000,5.5,3900),(17,'Femina',500,8.3,3500),(18,'Harvard_Business',450,9.2,2500),(19,'Wired',400,8.5,3000),(20,'Readers_Digest',650,8.6,3000),(21,'Family_Circle',1500,6.5,4300),(22,'People',2000,7.5,5700),(23,'Time',3000,4.3,4000),(24,'The_Economist',250,7.5,1700),(25,'The_New_Yorker',100,9.5,4000);
/*!40000 ALTER TABLE `magazines` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-12-05 19:53:21
