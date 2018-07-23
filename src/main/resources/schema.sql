CREATE TABLE IF NOT EXISTS User (
	id                  INTEGER  PRIMARY KEY AUTO_INCREMENT,
	version    			INTEGER NOT NULL,
	first_name 			VARCHAR(50) NOT NULL,
	second_name			VARCHAR(50),
	middle_name			VARCHAR(50),
	position			INTEGER NOT NULL,
	phone				VARCHAR (20),
	doc_name			VARCHAR(50),
	doc_number			VARCHAR(50),
	doc_date			DATE,
	citizenship_name    VARCHAR(50),
	citizenship_code	INTEGER,
	is_identified 		BOOLEAN
);

CREATE TABLE IF NOT EXISTS Organization (
	id          INTEGER  PRIMARY KEY AUTO_INCREMENT,
	version     INTEGER NOT NULL,
	name		VARCHAR(50) NOT NULL,
	full_name	VARCHAR(50) NOT NULL,
	inn			VARCHAR(12) NOT NULL,
	kpp			VARCHAR(9) NOT NULL,
	address		VARCHAR(200) NOT NULL,
	phone		VARCHAR(20),
	is_active	BOOLEAN
);

CREATE TABLE IF NOT EXISTS Office (
	id          INTEGER  PRIMARY KEY AUTO_INCREMENT,
	version     INTEGER NOT NULL,
	name		VARCHAR(200) NOT NULL,
	address		VARCHAR(100) NOT NULL,
	phone		VARCHAR(20),
	is_active   BOOLEAN
);

CREATE TABLE IF NOT EXISTS Doc (
    id          INTEGER  PRIMARY KEY AUTO_INCREMENT,
    version     INTEGER NOT NULL,
    name        VARCHAR(200),
    code        INTEGER NOT NULL
);

CREATE TABLE IF NOT EXISTS Country(
    id          INTEGER  PRIMARY KEY AUTO_INCREMENT,
    version     INTEGER NOT NULL,
    name        VARCHAR(100),
    code        INTEGER NOT NULL
)

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

CREATE TABLE IF NOT EXISTS User_Doc(
    user_id     INTEGER NOT NULL,
    doc_id      INTEGER NOT NULL
);

CREATE TABLE IF NOT EXISTS Country_User(
    country_id  INTEGER NOT NULL,
    user_id     INTEGER NOT NULL
);

CREATE INDEX IX_Organization_Office_Id ON Organization_Office (office_id);
ALTER TABLE Organization_Office ADD FOREIGN KEY (office_id) REFERENCES Office(id);

CREATE INDEX IX_Office_Organization_Id ON Organization_Office (organization_id);
ALTER TABLE Organization_Office ADD FOREIGN KEY (organization_id) REFERENCES Organization(id);

CREATE INDEX IX_Office_User_Id ON Office_User (user_id);
ALTER TABLE Office_User ADD FOREIGN KEY (user_id) REFERENCES User(id);

CREATE INDEX IX_User_Office ON Office_User (office_id);
ALTER TABLE Office_User ADD FOREIGN KEY (office_id) REFERENCES Office(id);

CREATE INDEX IX_User_Doc_Id ON User_Doc (doc_id);
ALTER TABLE User_Doc ADD FOREIGN KEY (doc_id) REFERENCES Doc(id);

CREATE INDEX IX_Doc_User_Id ON User_Doc (user_id);
ALTER TABLE User_Doc ADD FOREIGN KEY (user_id) REFERENCES User(id);

CREATE INDEX IX_Country_User_Id ON Country_User (user_id);
ALTER TABLE Country_User ADD FOREIGN KEY (user_id) REFERENCES User(id);

CREATE INDEX IX_User_Country_Id ON Country_User(country_id);
ALTER TABLE Country_User ADD FOREIGN KEY (country_id) REFERENCES Country(id);