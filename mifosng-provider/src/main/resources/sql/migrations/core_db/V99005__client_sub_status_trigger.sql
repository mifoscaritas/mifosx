SET @OLDTMP_SQL_MODE=@@SQL_MODE, SQL_MODE='';
DELIMITER //
CREATE TRIGGER `client_sub_status_batch_job_trigger` BEFORE UPDATE ON `m_client` FOR EACH ROW BEGIN
	INSERT INTO 
	client_sub_status_change_history(client_id,sub_status,update_date)
	values
		(NEW.id,NEW.sub_status,NOW());END//
DELIMITER ;
