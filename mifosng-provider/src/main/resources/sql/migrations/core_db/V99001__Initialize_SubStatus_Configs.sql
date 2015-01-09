-- This script is a Caritas Specific configuration and cannot be used for other implementations

-- a) For Configurable no. of months for Client Sub-Status Change, add the following system configurations
--         i) Num-Months-WithDeposits-ForGoodStandingSubStatus
--        ii) Num-Months-WithoutDeposits-ForDormancySubStatus
--       iii) Num-Months-WithoutRepayment-ForDefaultSubStatus

INSERT INTO c_configuration (name, value, enabled, description)
	VALUES ('Num-Months-WithDeposits-ForGoodStandingSubStatus', 6, 1,
	'No. of consecutive months with regular deposits - after which a new client becomes Active in Good Standing.');
INSERT INTO c_configuration (name, value, enabled, description)
	VALUES ('Num-Months-WithoutDeposits-ForDormancySubStatus', 3, 1,
	'No. of consecutive months without any deposits - after which a client becomes Dormant.');
INSERT INTO c_configuration (name, value, enabled, description)
	VALUES ('Num-Months-WithoutRepayment-ForDefaultSubStatus', 4, 1,
	'No. of missed repayments on loans- after which a client is marked as Default.');

-- b) Initialize the code value ID for sub-statuses	
-- Pre-requisites:
--     The following 4 sub-statuses have to be defined as code values.
-- 			i. New Client
--         ii. Active in Good Standing
--        iii. Dormant
--         iv. Default

INSERT INTO m_code_value (code_id, code_value, code_description, order_position)
	VALUES (
		(SELECT id FROM m_code WHERE code_name = 'ClientSubStatus'),
		'New Client', 'New Client', 1
	);
INSERT INTO m_code_value (code_id, code_value, code_description, order_position)
	VALUES (
		(SELECT id FROM m_code WHERE code_name = 'ClientSubStatus'),
		'Active in Good Standing', 'Active in Good Standing', 1
	);
INSERT INTO m_code_value (code_id, code_value, code_description, order_position)
	VALUES (
		(SELECT id FROM m_code WHERE code_name = 'ClientSubStatus'),
		'Dormant', 'Dormant', 1
	);
INSERT INTO m_code_value (code_id, code_value, code_description, order_position)
	VALUES (
		(SELECT id FROM m_code WHERE code_name = 'ClientSubStatus'),
		'Default', 'Default', 1
	);
