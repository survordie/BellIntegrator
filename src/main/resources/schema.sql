CREATE TABLE IF NOT EXISTS User (
	id         			INTEGER  PRIMARY KEY AUTO_INCREMENT,
	version    			INTEGER NOT NULL,
	first_name 			VARCHAR(50) NOT NULL,
	second_name			VARCHAR(50),
	middle_name			VARCHAR(50),
	position			INTEGER NOT NULL,
	phone				VARCHAR (20),
	doc_name			VARCHAR(50),
	doc_number			VARCHAR(50),
	doc_date			DATE,
	citizenship_code	INTEGER,
	is_identified 		BOOLEAN
);

CREATE TABLE IF NOT EXISTS Organization (
	id         INTEGER  PRIMARY KEY AUTO_INCREMENT,
	version    INTEGER NOT NULL,
	name		VARCHAR(50) NOT NULL,
	full_name	VARCHAR(50) NOT NULL,
	inn			VARCHAR(12) NOT NULL,
	kpp			VARCHAR(9) NOT NULL,
	address		VARCHAR(200) NOT NULL,
	phone		VARCHAR(20),
	is_active	BOOLEAN
);

CREATE TABLE IF NOT EXISTS Office (
	id         INTEGER  PRIMARY KEY AUTO_INCREMENT,
	version    INTEGER NOT NULL,
	name		VARCHAR(200) NOT NULL,
	address		VARCHAR(100) NOT NULL,
	phone		VARCHAR(20),
	is_active	BOOLEAN
);

CREATE TABLE IF NOT EXISTS Organization_Office (	
	organization_id	INTEGER NOT NULL,
	office_id		INTEGER NOT NULL
);

CREATE TABLE IF NOT EXISTS Organization_User(	
	organization_id	INTEGER NOT NULL,
	user_id	INTEGER NOT NULL
);

CREATE TABLE IF NOT EXISTS Office_User(	
	office_id	INTEGER NOT NULL,
	user_id		INTEGER NOT NULL
);

CREATE INDEX IX_Organization_Office_Id ON Organization_Office (office_id);
ALTER TABLE Organization_Office ADD FOREIGN KEY (office_id) REFERENCES Office(id);

CREATE INDEX IX_Office_Organization_Id ON Organization_Office (organization_id);
ALTER TABLE Organization_Office ADD FOREIGN KEY (organization_id) REFERENCES Organization(id);