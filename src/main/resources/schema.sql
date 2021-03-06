CREATE TABLE IF NOT EXISTS Country (
    id          BIGINT  PRIMARY KEY AUTO_INCREMENT,
    version     INTEGER NOT NULL,
    name        VARCHAR(100),
    code        VARCHAR(3) NOT NULL
);

CREATE TABLE IF NOT EXISTS Organization (
	id          BIGINT  PRIMARY KEY AUTO_INCREMENT,
	version     INTEGER NOT NULL,
	country_id  BIGINT NOT NULL,
	name		VARCHAR(50) NOT NULL,
	full_name	VARCHAR(50) NOT NULL,
	inn			VARCHAR(12) NOT NULL,
	kpp			VARCHAR(9) NOT NULL,
	address		VARCHAR(200) NOT NULL,
	phone		VARCHAR(20),
	is_active	BOOLEAN
);

CREATE TABLE IF NOT EXISTS Office (
	id          BIGINT  PRIMARY KEY AUTO_INCREMENT,
	version     INTEGER NOT NULL,
	organization_id BIGINT NOT NULL,
	name		VARCHAR(200) NOT NULL,
	address		VARCHAR(200) NOT NULL,
	phone		VARCHAR(20),
	is_active   BOOLEAN
);

CREATE TABLE IF NOT EXISTS Doc_Type (
    id          BIGINT  PRIMARY KEY AUTO_INCREMENT,
    version     INTEGER NOT NULL,
    name        VARCHAR(200),
    code        VARCHAR(3) NOT NULL
);

CREATE TABLE IF NOT EXISTS Doc (
	id          BIGINT  PRIMARY KEY AUTO_INCREMENT,
	version     INTEGER NOT NULL,
	doc_type_id BIGINT NOT NULL,
	user_id     BIGINT NOT NULL,
    doc_number	VARCHAR(50),
    doc_date	DATE
);

CREATE TABLE IF NOT EXISTS User (
	id                  BIGINT  PRIMARY KEY AUTO_INCREMENT,
	version    			INTEGER NOT NULL,
	office_id           BIGINT NOT NULL,
	first_name 			VARCHAR(50) NOT NULL,
	second_name			VARCHAR(50),
	middle_name			VARCHAR(50),
	position			VARCHAR(50) NOT NULL,
	phone				VARCHAR(20),
	is_identified 		BOOLEAN
);

CREATE INDEX IX_Organization_country_id ON Organization(country_id);
ALTER TABLE Organization ADD FOREIGN KEY (country_id) REFERENCES Country(id);

CREATE INDEX IX_Office_organization_id ON Office(organization_id);
ALTER TABLE Office ADD FOREIGN KEY (organization_id) REFERENCES Organization(id);

CREATE INDEX IX_User_office_id ON User(office_id);
ALTER TABLE User ADD FOREIGN KEY (office_id) REFERENCES Office(id);

CREATE INDEX IX_Doc_user_id ON Doc(user_id);
ALTER TABLE Doc ADD FOREIGN KEY (user_id) REFERENCES User(id);

CREATE INDEX IX_Doc_doc_type_id ON Doc(doc_type_id);
ALTER TABLE Doc ADD FOREIGN KEY (doc_type_id) REFERENCES Doc_Type(id);