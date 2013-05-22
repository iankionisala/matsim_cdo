DELIMITER $$

DROP FUNCTION IF EXISTS `func_get_travelled_links` $$
CREATE DEFINER=`root`@`localhost` FUNCTION `func_get_travelled_links`(p_person INT(11), p_timefrom DECIMAL(8,1), p_timeto DECIMAL(8,1)) RETURNS VARCHAR(255)
    DETERMINISTIC
BEGIN

  DECLARE l_record_not_found TINYINT DEFAULT 0;
  DECLARE l_travelled_links VARCHAR(255) DEFAULT "";
  DECLARE l_links INT(11) DEFAULT 0;
  DECLARE l_length DECIMAL(20,12) DEFAULT 0.0;

  DECLARE curEventLog CURSOR FOR SELECT DISTINCT e.link, l.length FROM eventlog e LEFT JOIN links l ON e.link=l.id  WHERE ((e.person=p_person AND e.`time` BETWEEN p_timefrom AND p_timeto) AND l.length IS NOT NULL) ORDER BY e.`time` ASC;
  DECLARE CONTINUE HANDLER FOR NOT FOUND SET l_record_not_found = 1;

  /* opens cursor */
  OPEN curEventLog;

  main_loop:LOOP

    /* fetches every row */
    FETCH curEventLog INTO l_links, l_length;

    IF l_record_not_found = 1 THEN
      LEAVE main_loop;
    END IF;

    /* adds/increments */
    SET l_travelled_links = CONCAT_WS(', ', l_travelled_links,l_links);


  END LOOP main_loop;

  /* closes the cursor */
  CLOSE curEventLog;

  /* strips leading spaces */
  SET l_travelled_links = TRIM(l_travelled_links);

  /* removes the preceding comma character */
  SET l_travelled_links = SUBSTR(l_travelled_links, 2, LENGTH(l_travelled_links));

  RETURN l_travelled_links;

END $$

DELIMITER ;