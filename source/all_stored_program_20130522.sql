-- MySQL dump 10.13  Distrib 5.1.53, for Win64 (unknown)
--
-- Host: localhost    Database: matsim
-- ------------------------------------------------------
-- Server version	5.1.53-community-log
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Dumping routines for database 'matsim'
--
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`localhost`*/ /*!50003 FUNCTION `func_get_travelled_length`(p_person INT(11), p_timefrom DECIMAL(8,1), p_timeto DECIMAL(8,1)) RETURNS decimal(18,12)
    DETERMINISTIC
BEGIN

  DECLARE l_record_not_found TINYINT DEFAULT 0;
  DECLARE l_travelled_length DECIMAL(20,12) DEFAULT 0.0;
  DECLARE l_links INT(11) DEFAULT 0;
  DECLARE l_length DECIMAL(20,12) DEFAULT 0.0;

  DECLARE curEventLog CURSOR FOR SELECT DISTINCT e.link, l.length FROM eventlog e LEFT JOIN links l ON e.link=l.id  WHERE ((e.person=p_person AND e.`time` BETWEEN p_timefrom AND p_timeto) AND l.length IS NOT NULL) ORDER BY e.`time` ASC;
  DECLARE CONTINUE HANDLER FOR NOT FOUND SET l_record_not_found = 1;

  
  OPEN curEventLog;

  main_loop:LOOP

    
    FETCH curEventLog INTO l_links, l_length;

    IF l_record_not_found = 1 THEN
      LEAVE main_loop;
    END IF;
    SET l_links = l_links +1;

    
    SET l_travelled_length = l_travelled_length + l_length;


  END LOOP main_loop;

  
  CLOSE curEventLog;

  RETURN l_travelled_length;

END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`localhost`*/ /*!50003 FUNCTION `func_get_travelled_links`(p_person INT(11), p_timefrom DECIMAL(8,1), p_timeto DECIMAL(8,1)) RETURNS mediumtext CHARSET latin1
    DETERMINISTIC
BEGIN

  DECLARE l_record_not_found TINYINT DEFAULT 0;
  DECLARE l_travelled_links MEDIUMTEXT DEFAULT "";
  DECLARE l_links INT(11) DEFAULT 0;
  DECLARE l_length DECIMAL(20,12) DEFAULT 0.0;

  DECLARE curEventLog CURSOR FOR SELECT DISTINCT e.link, l.length FROM eventlog e LEFT JOIN links l ON e.link=l.id  WHERE ((e.person=p_person AND e.`time` BETWEEN p_timefrom AND p_timeto) AND l.length IS NOT NULL) ORDER BY e.`time` ASC;
  DECLARE CONTINUE HANDLER FOR NOT FOUND SET l_record_not_found = 1;

  
  OPEN curEventLog;

  main_loop:LOOP

    
    FETCH curEventLog INTO l_links, l_length;

    IF l_record_not_found = 1 THEN
      LEAVE main_loop;
    END IF;

    
    SET l_travelled_links = CONCAT_WS(', ', l_travelled_links,l_links);


  END LOOP main_loop;

  
  CLOSE curEventLog;

  
  SET l_travelled_links = TRIM(l_travelled_links);

  
  SET l_travelled_links = SUBSTR(l_travelled_links, 2, LENGTH(l_travelled_links));

  RETURN l_travelled_links;

END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`localhost`*/ /*!50003 PROCEDURE `sp_generate_analysis_report`()
BEGIN

DECLARE EXIT HANDLER FOR SQLEXCEPTION ROLLBACK;
DECLARE EXIT HANDLER FOR SQLWARNING ROLLBACK;

START TRANSACTION;
DELETE FROM route;
CALL sp_retrieve_route();
CALL sp_retrieve_links();


DELETE FROM route;


INSERT INTO route (agent, links, distance, timefrom, timeto, timeelapsed, direction) SELECT agent, links, distance, timefrom, timeto, timeelapsed, direction FROM tmproute;

COMMIT;

END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`localhost`*/ /*!50003 PROCEDURE `sp_retrieve_links`()
BEGIN
    DECLARE record_not_found INT DEFAULT 0;
    DECLARE l_agent INT(11);
    DECLARE l_timefrom DECIMAL(8,1);
    DECLARE l_timeto DECIMAL(8,1);
    DECLARE l_links MEDIUMTEXT DEFAULT NULL;
    DECLARE l_distance DECIMAL(15,12) DEFAULT 0.0;
    DECLARE l_timeelapsed DECIMAL(8,1) DEFAULT 0.0;
    DECLARE l_direction VARCHAR(75) DEFAULT NULL;

    DECLARE curRoute CURSOR FOR SELECT agent, links, distance, timefrom, timeto, timeelapsed, direction FROM route;
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET record_not_found = 1;
    DECLARE EXIT HANDLER FOR SQLWARNING ROLLBACK;
    DECLARE EXIT HANDLER FOR SQLEXCEPTION ROLLBACK;

    START TRANSACTION;

      
      DROP TEMPORARY TABLE IF EXISTS `tmproute`;
      CREATE TEMPORARY TABLE `tmproute`(
        agent INT(11) DEFAULT -1,
        links MEDIUMTEXT DEFAULT "",
        distance DECIMAL(18, 12) DEFAULT 0.0,
        timefrom DECIMAL(8,1) DEFAULT 0.0,
        timeto DECIMAL(8,1) DEFAULT 0.0,
        timeelapsed DECIMAL(8,1) DEFAULT 0.0,
        direction VARCHAR(75) DEFAULT NULL) ENGINE=MyISAM;

      
      OPEN curRoute;

      route_loop:LOOP

          FETCH curRoute INTO l_agent, l_links, l_distance, l_timefrom, l_timeto, l_timeelapsed, l_direction;

          IF record_not_found = 1 THEN
            LEAVE route_loop;
          END IF;

          
          INSERT INTO tmproute SET agent = l_agent,
                                   distance = func_get_travelled_length(l_agent, l_timefrom, l_timeto),
                                   timefrom = l_timefrom,
                                   timeto = l_timeto,
                                   timeelapsed = l_timeelapsed,
                                   direction = l_direction,
                                   links = func_get_travelled_links(l_agent, l_timefrom, l_timeto);

      END LOOP route_loop;

      CLOSE curRoute;

    COMMIT;

  END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`localhost`*/ /*!50003 PROCEDURE `sp_retrieve_route`()
BEGIN
  DECLARE agent_record_not_found INT DEFAULT 0;
  DECLARE l_time DECIMAL(8,1);
  DECLARE l_link VARCHAR(255);
  DECLARE l_person INT(11);
  DECLARE l_acttype VARCHAR(255);
  DECLARE m_Pair INT DEFAULT 0; 
  DECLARE m_Qry MEDIUMTEXT DEFAULT NULL;
  DECLARE m_AgentPointer INT(11) DEFAULT 0;
  
  
  DECLARE curAgent CURSOR FOR SELECT `time`, link, person, acttype FROM eventlog WHERE (person BETWEEN 0 AND 45) AND acttype IN ('origin', 'destination') ORDER BY person, `time` ASC;
  DECLARE CONTINUE HANDLER FOR NOT FOUND SET agent_record_not_found = 1;

  
  OPEN curAgent;

  main_loop:LOOP
    
    FETCH curAgent INTO l_time, l_link, l_person, l_acttype;

    
    IF agent_record_not_found = 1 THEN
      LEAVE main_loop;
    END IF;


    IF m_Pair = 0 THEN
       SET @m_timefrom = l_time;
       SET @m_directOne = l_acttype;
      
      SET m_Pair = m_Pair + 1;

    ELSE
      SET @m_person = l_person;
      SET @m_timeto = l_time;
      SET @m_directTwo = l_acttype;
      SET @m_directTwo = CONCAT(@m_directOne, ' to ', @m_directTwo);
      SET @m_elapsedtime = @m_timeto - @m_timefrom;
      PREPARE agentRoute FROM 'INSERT INTO route SET agent=?, timefrom=?, timeto=?, direction=?, timeelapsed=?';
      EXECUTE agentRoute USING @m_person, @m_timefrom, @m_timeto, @m_directTwo, @m_elapsedtime;

      
      SET m_Pair = 0;
      SET @m_timefrom = 0.0;
      SET @m_timeto = 0.0;
      SET @m_elapsedtime = 0.0;
      

    END IF;

  END LOOP main_loop;

END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-05-21 17:45:50
