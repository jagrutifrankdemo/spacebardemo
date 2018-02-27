CREATE DATABASE  IF NOT EXISTS `demo` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `demo`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: demo
-- ------------------------------------------------------
-- Server version	5.7.21-log

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
-- Table structure for table `game`
--

DROP TABLE IF EXISTS `game`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `game` (
  `gameid` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `gamedetails` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`gameid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `game`
--

LOCK TABLES `game` WRITE;
/*!40000 ALTER TABLE `game` DISABLE KEYS */;
INSERT INTO `game` VALUES (1,'game1','game1details'),(2,'game2','details'),(3,'game3','details');
/*!40000 ALTER TABLE `game` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `new_view`
--

DROP TABLE IF EXISTS `new_view`;
/*!50001 DROP VIEW IF EXISTS `new_view`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `new_view` AS SELECT 
 1 AS `uuid`,
 1 AS `userid`,
 1 AS `numbergamesplayed`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `userid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `usernotes` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'name','testing'),(2,'test','testuser'),(3,'name','testing'),(4,'name3','testing');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_login_audit`
--

DROP TABLE IF EXISTS `user_login_audit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_login_audit` (
  `userloginauditid` int(11) NOT NULL,
  `userid` int(11) NOT NULL,
  `logintime` datetime NOT NULL,
  `logout` datetime DEFAULT NULL,
  `uuid` varchar(45) NOT NULL,
  PRIMARY KEY (`userloginauditid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='		';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_login_audit`
--

LOCK TABLES `user_login_audit` WRITE;
/*!40000 ALTER TABLE `user_login_audit` DISABLE KEYS */;
INSERT INTO `user_login_audit` VALUES (1,1,'2018-02-24 15:08:00','2018-02-24 16:08:00','aswerty'),(2,2,'2018-02-24 15:08:00','2018-02-24 16:08:00','erfvgbaw'),(3,3,'2018-02-27 10:00:00',NULL,'dgfgf');
/*!40000 ALTER TABLE `user_login_audit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `user_max_played`
--

DROP TABLE IF EXISTS `user_max_played`;
/*!50001 DROP VIEW IF EXISTS `user_max_played`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `user_max_played` AS SELECT 
 1 AS `id`,
 1 AS `uuid`,
 1 AS `userid`,
 1 AS `numbergamesplayed`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `useraudit`
--

DROP TABLE IF EXISTS `useraudit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `useraudit` (
  `userauditid` int(11) NOT NULL,
  `userid` int(11) NOT NULL,
  `gameid` int(11) NOT NULL,
  `uuid` varchar(45) NOT NULL,
  PRIMARY KEY (`userauditid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `useraudit`
--

LOCK TABLES `useraudit` WRITE;
/*!40000 ALTER TABLE `useraudit` DISABLE KEYS */;
INSERT INTO `useraudit` VALUES (1,2,1,'erfvgbaw'),(2,2,2,'erfvgbaw'),(3,2,3,'erfvgbaw'),(4,2,14,'erfvgbaw'),(5,1,1,'aswerty'),(6,1,2,'aswerty'),(7,3,2,'dgfgf');
/*!40000 ALTER TABLE `useraudit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `userplayedgames`
--

DROP TABLE IF EXISTS `userplayedgames`;
/*!50001 DROP VIEW IF EXISTS `userplayedgames`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `userplayedgames` AS SELECT 
 1 AS `uuid`,
 1 AS `userid`,
 1 AS `numbergamesplayed`*/;
SET character_set_client = @saved_cs_client;

--
-- Final view structure for view `new_view`
--

/*!50001 DROP VIEW IF EXISTS `new_view`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `new_view` AS select `ua`.`uuid` AS `uuid`,`ua`.`userid` AS `userid`,count(`ua`.`uuid`) AS `numbergamesplayed` from (`useraudit` `ua` left join `user_login_audit` `ula` on(((`ua`.`uuid` = `ula`.`uuid`) and (`ula`.`logintime` between (curdate() - interval 7 day) and curdate())))) group by `ua`.`uuid`,`ua`.`userid` order by `numbergamesplayed` desc limit 1 */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `user_max_played`
--

/*!50001 DROP VIEW IF EXISTS `user_max_played`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `user_max_played` AS select `ua`.`userauditid` AS `id`,`ua`.`uuid` AS `uuid`,`ua`.`userid` AS `userid`,count(`ua`.`uuid`) AS `numbergamesplayed` from (`useraudit` `ua` left join `user_login_audit` `ula` on(((`ua`.`uuid` = `ula`.`uuid`) and (`ula`.`logintime` between (curdate() - interval 7 day) and curdate())))) group by `ua`.`uuid`,`ua`.`userid` order by `numbergamesplayed` desc limit 1 */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `userplayedgames`
--

/*!50001 DROP VIEW IF EXISTS `userplayedgames`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `userplayedgames` AS select `ua`.`uuid` AS `uuid`,`ua`.`userid` AS `userid`,count(`ua`.`uuid`) AS `numbergamesplayed` from (`useraudit` `ua` left join `user_login_audit` `ula` on(((`ua`.`uuid` = `ula`.`uuid`) and (`ula`.`logintime` between (curdate() - interval 7 day) and curdate())))) group by `ua`.`uuid`,`ua`.`userid` order by `numbergamesplayed` desc limit 1 */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-02-27 23:40:07
