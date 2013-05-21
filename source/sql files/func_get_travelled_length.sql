DELIMITER $$

DROP FUNCTION IF EXISTS `func_get_travelled_length` $$
CREATE DEFINER=`root`@`localhost` FUNCTION `func_get_travelled_length`(p_person INT(11), p_timefrom DECIMAL(8,1), p_timeto DECIMAL(8,1)) RETURNS decimal(18,12)
    DETERMINISTIC
BEGIN

  DECLARE l_record_not_found TINYINT DEFAULT 0;
  DECLARE l_travelled_length DECIMAL(18,10) DEFAULT 0.0;
  DECLARE l_links INT(11) DEFAULT 0;
  DECLARE l_length DECIMAL(18,10) DEFAULT 0.0;

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
    SET l_links = l_links +1;

    /* adds/increments */
    SET l_travelled_length = l_travelled_length + l_length;


  END LOOP main_loop;

  /* closes the cursor */
  CLOSE curEventLog;

  RETURN l_travelled_length;

END $$

DELIMITER ;