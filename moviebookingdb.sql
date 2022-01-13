-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: moviebookingdb
-- ------------------------------------------------------
-- Server version	8.0.27

DROP DATABASE IF EXISTS MOVIEBOOKINGDB;
CREATE DATABASE MOVIEBOOKINGDB; 
USE MOVIEBOOKINGDB;

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
-- Table structure for table `cancellation`
--

DROP TABLE IF EXISTS `cancellation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cancellation` (
  `TicketID` int NOT NULL,
  `DateCancellation` date DEFAULT NULL,
  `Credit` double DEFAULT NULL,
  PRIMARY KEY (`TicketID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cancellation`
--

LOCK TABLES `cancellation` WRITE;
/*!40000 ALTER TABLE `cancellation` DISABLE KEYS */;
INSERT INTO `cancellation` VALUES (100,'2021-09-14',15.32),(101,'2021-07-03',15.32),(102,'2021-10-10',15.32);
/*!40000 ALTER TABLE `cancellation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seat`
--

DROP TABLE IF EXISTS `seat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `seat` (
  `SeatNumber` int NOT NULL,
  `rowFromFront` int NOT NULL,
  `Location` varchar(45) NOT NULL,
  `TheaterID` int NOT NULL,
  `Status` int DEFAULT '1', 
   Showing int,
  PRIMARY KEY (`SeatNumber`, `TheaterID`, Showing),
  FOREIGN KEY (Showing) REFERENCES showing(showingId)
);
INSERT INTO `seat` VALUES 
(1,1,'Chinook',1,0,1),
(2,1,'Chinook',1,1,1),
(3,1,'Chinook',1,1,1),
(4,1,'Chinook',1,1,1),
(5,1,'Chinook',1,1,1),
(1,1,'Westhills',4,1,2),
(2,1,'Westhills',4,0,2),
(3,1,'Westhills',4,1,2),
(4,1,'Westhills',4,1,2),
(5,1,'Westhills',4,0,2);
--
-- Table structure for table `showing`
--

DROP TABLE IF EXISTS showing;
CREATE TABLE showing (
  ShowingId INT auto_increment,
  MovieName varchar(45) NOT NULL,
  ShowingDate varchar(45), 
  ShowingTime varchar(45),
  Type varchar(45) NOT NULL,
  Genre varchar(45) DEFAULT NULL,
  AgeRating varchar(45) DEFAULT NULL,
  PRIMARY KEY(ShowingId)
);
INSERT INTO showing (MovieName, ShowingDate, ShowingTime, Type, Genre, AgeRating)
VALUES 
("saw", "test", "test", "Released", "horror", "R"),
("saw", "test", "test","Released", "horror", "R"),
("potatofilm", "test", "test","Early", "horror", "R");
-- ("saw", null, null, "Released", "horror", "R"),
-- ("saw", null, null, "Released", "horror", "R"),
-- ("avengers endgame", null, null, "Released", "action", "14A"),
-- ("avengers endgame", null, null, "Released", "action", "14A"),
-- ("avengers endgame", null, null, "Released", "action", "14A"),
-- ("the notebook", null, null, "Released", "romance", "14A"),
-- ("the notebook", null, null, "Released", "romance", "14A"),
-- ("the notebook", null, null, "Released", "romance", "14A"),
-- ("toy story 3", null, null, "Released", "animation", "G"),
-- ("toy story 9", null, null, "Early Release", "animation", "G"),
-- ("toy story 10", null, null, "Early Release", "animation", "G"),
-- ("toy story 11", null, null, "Early Release", "animation", "G"),
-- ("toy story 12", null, null, "Early Release", "animation", "G");

--
-- Dumping data for table `showing`
--

LOCK TABLES `showing` WRITE;
/*!40000 ALTER TABLE `showing` DISABLE KEYS */;
/*!40000 ALTER TABLE `showing` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ticket`
--

DROP TABLE IF EXISTS `ticket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ticket` (
  `TicketID` int NOT NULL,
  `UserID` varchar(45) DEFAULT 'NA',
  `Location` varchar(45) DEFAULT NULL,
  `TheaterID` varchar(45) DEFAULT NULL,
  `SeatNumber` varchar(45) DEFAULT NULL,
  `RowFromFront` int DEFAULT NULL,
  `MovieName` varchar(45) DEFAULT NULL,
  `ShowingDate` varchar(45) DEFAULT NULL,
  `ShowingTime` varchar(45) DEFAULT NULL,
  `Status` varchar(45) DEFAULT NULL,
  `Price` double DEFAULT NULL,
  `Genre` varchar(45) DEFAULT NULL,
  `AgeRating` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`TicketID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ticket`
--

LOCK TABLES `ticket` WRITE;
/*!40000 ALTER TABLE `ticket` DISABLE KEYS */;
INSERT INTO `ticket` VALUES (100,'100','Chinook','100','1',1,'Dune','2021-07-14','12:30:00','Active',15.32,'Thriller','PG13'),
(102,'102','Shawnessy','100','1',1,'Eternals','2021-09-04','08:20:00','Active',15.32,NULL,NULL),
(103,'103','Shawnessy','100','1',1,'Eternals','2021-12-12','08:20:00','Active',15.32,NULL,NULL),
(104,'test1@test','Shawnessy','100','1',1,'Eternals','2021-12-12','08:20:00','Active',15.32,NULL,NULL),
(107,'test1@test','Shawnessy','100','1',1,'Eternals','2021-12-12','08:20:00','Active',15.32,NULL,NULL),
(109,'NA','Shawnessy','100','1',1,'Eternals','2021-12-12','08:20:00','Active',15.32,NULL,NULL);
/*!40000 ALTER TABLE `ticket` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

-- DROP TABLE IF EXISTS `user`;
-- /*!40101 SET @saved_cs_client     = @@character_set_client */;
-- /*!50503 SET character_set_client = utf8mb4 */;
-- CREATE TABLE `user` (
--   `userEmail` int NOT NULL,
--   `password` varchar(45) DEFAULT NULL,
--   `registrationDate` date DEFAULT NULL,
--   PRIMARY KEY (`userEmail`)
-- ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
-- /*!40101 SET character_set_client = @saved_cs_client */;

DROP TABLE IF EXISTS user;
CREATE TABLE user (
  userEmail varchar(100) NOT NULL,
  password varchar(45) DEFAULT NULL,
  registrationDate varchar(45) DEFAULT NULL,
  paymentCardNum varchar(45) DEFAULT NULL,
  name varchar(45) NOT NULL,
  address varchar(45) NOT NULL,
  PRIMARY KEY (userEmail)
);
INSERT INTO user
VALUES 
("test1@test", "123", "2021-12-07", "100200300400", "thomas", "happyland"),
("test2@test", "123", "2021-12-07", "100200300401", "daud", "sadland"),
("test3@test", "123", "2020-12-06", "100200300402", "ziryan", "okland");

DROP TABLE IF EXISTS bank;
CREATE TABLE bank (
  paymentCardNum varchar(45),
  PRIMARY KEY (paymentCardNum)
--   FOREIGN KEY (paymentCardNum) REFERENCES user(paymentCardNum)
);
INSERT INTO bank
VALUES
("100200300400"),
("100200300401"),
("100200300402");




