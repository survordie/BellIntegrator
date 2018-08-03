CREATE TABLE IF NOT EXISTS user (
	id                  INTEGER  PRIMARY KEY AUTO_INCREMENT,
	version    			INTEGER NOT NULL,
	office_id           INTEGER NOT NULL,
	doc_id             VARCHAR(50) NOT NULL,
	first_name 			VARCHAR(50) NOT NULL,
	second_name			VARCHAR(50),
	middle_name			VARCHAR(50),
	position			INTEGER NOT NULL,
	phone				VARCHAR(20),
	citizenship_name    VARCHAR(50),
	citizenship_code	VARCHAR(50),
	is_identified 		BOOLEAN
);

CREATE TABLE IF NOT EXISTS organization (
	id          INTEGER  PRIMARY KEY AUTO_INCREMENT,
	version     INTEGER NOT NULL,
	country_id  VARCHAR(50),
	name		VARCHAR(50) NOT NULL,
	full_name	VARCHAR(50) NOT NULL,
	inn			VARCHAR(12) NOT NULL,
	kpp			VARCHAR(9) NOT NULL,
	address		VARCHAR(200) NOT NULL,
	phone		VARCHAR(20),
	is_active	BOOLEAN
);

CREATE TABLE IF NOT EXISTS office (
	id          INTEGER  PRIMARY KEY AUTO_INCREMENT,
	version     INTEGER NOT NULL,
	organization_id INTEGER NOT NULL,
	name		VARCHAR(200) NOT NULL,
	address		VARCHAR(200) NOT NULL,
	phone		VARCHAR(20),
	is_active   BOOLEAN
);

CREATE TABLE IF NOT EXISTS doc_type (
    id          INTEGER  PRIMARY KEY AUTO_INCREMENT,
    version     INTEGER NOT NULL,
    name        VARCHAR(200),
    code        VARCHAR(3) NOT NULL
);

CREATE TABLE IF NOT EXISTS doc (
	id          INTEGER  PRIMARY KEY AUTO_INCREMENT,
	version     INTEGER NOT NULL,
	doc_type_id VARCHAR(3) NOT NULL,
    doc_number	VARCHAR(50),
    doc_date	DATE
);

CREATE TABLE IF NOT EXISTS country (
    id          INTEGER  PRIMARY KEY AUTO_INCREMENT,
    version     INTEGER NOT NULL,
    name        VARCHAR(100),
    code        VARCHAR(3) NOT NULL
);

CREATE INDEX IX_organization_country_id ON organization(country_id);
ALTER TABLE organization ADD FOREIGN KEY country_id REFERENCES country(id);

CREATE INDEX IX_office_organization_id ON office(organization_id);
ALTER TABLE office ADD FOREIGN KEY organization_id REFERENCES organization(id);

CREATE INDEX IX_user_office_id ON user(office_id);
ALTER TABLE user ADD FOREIGN KEY office_id REFERENCES office(id);

CREATE INDEX IX_user_doc_id ON user(doc_id);
ALTER TABLE user ADD FOREIGN KEY doc_id REFERENCES doc(doc_number);

CREATE INDEX IX_doc_doc_type_id ON doc(doc_type_id);
ALTER TABLE doc ADD FOREIGN KEY doc_type_id REFERENCES doc_type(code);