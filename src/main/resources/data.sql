INSERT INTO User (id, version, first_name, second_name, middle_name, position, phone, doc_name, doc_number, doc_date, citizenship_code, is_identified) 
VALUES (1, 0, 'Петя', 'Петров', '', 2,'', '', '', '', '', true);

INSERT INTO User (id, version, first_name, second_name, middle_name, position, phone, doc_name, doc_number, doc_date, citizenship_code, is_identified) 
VALUES (2, 0, 'Вася', 'Васин', '', 3, '', '', '', '', '', true);

INSERT INTO User (id, version, first_name, second_name, middle_name, position, phone, doc_name, doc_number, doc_date, citizenship_code, is_identified) 
VALUES (3, 0, 'Сидор', 'Сидоров', '', 4,'', '', '', '', '', true);

INSERT INTO User (id, version, first_name, second_name, middle_name, position, phone, doc_name, doc_number, doc_date, citizenship_code, is_identified) 
VALUES (4, 0, 'Варвара', 'Орлова', '', 5,'', '', '', '', '', false);

INSERT INTO User (id, version, first_name, second_name, middle_name, position, phone, doc_name, doc_number, doc_date, citizenship_code, is_identified)
VALUES (5, 0, 'Ваня', 'Иванов', '', 6,'', '', '', '', '', true);

INSERT INTO User (id, version, first_name, second_name, middle_name, position, phone, doc_name, doc_number, doc_date, citizenship_code, is_identified)
VALUES (6, 0, 'Коля', 'Николаев', '', 7,'', '', '', '', '', true);

INSERT INTO Organization (id, version, name, full_name, inn, kpp, address, phone, is_active)
VALUES (1, 0, 'Tinkoff', 'Tinkoff bank', '7710140679', '773401001', 'Москва, 123060, 1-й Волоколамский проезд, д. 10, стр. 1', '', true);

INSERT INTO Organization (id, version, name, full_name, inn, kpp, address, phone, is_active)
VALUES (2, 0, 'HCB', 'Homecredit bank', '7735057951', '997950001', '125040, г. Москва, улица Правды, д. 8, кор.1', '', true);

INSERT INTO Office (id, version, name, address, phone, is_active)
VALUES (1, 0, 'Москва', 'г. Москва, улица Правды', '', true);

INSERT INTO Office (id, version, name, address, phone, is_active)
VALUES (2, 0, 'СПБ', 'г. СПб, улица Балтийская', '', true);

INSERT INTO Office (id, version, name, address, phone, is_active)
VALUES (3, 0, 'СПБ', 'г. СПб, улица Южная', '', true);

INSERT INTO Office (id, version, name, address, phone, is_active)
VALUES (4, 0, 'Москва', 'г. Москва, улица Волоколамская', '', true);

INSERT INTO Doc (name, code) VALUES (03, 'Свидетельство о рождении');

INSERT INTO Doc (name, code) VALUES (07, 'Военный билет');

INSERT INTO Doc (name, code) VALUES (08, 'Временное удостоверение, выданное взамен военного билета');

INSERT INTO Doc (name, code) VALUES (10, 'Паспорт иностранного гражданина');

INSERT INTO Doc (name, code) VALUES (11, 'Свидетельство о рассмотрении ходатайства о признании лица беженцем на территории Российской Федерации по существу');

INSERT INTO Doc (name, code) VALUES (12, 'Вид на жительство в Российской Федерации');

INSERT INTO Doc (name, code) VALUES (13, 'Удостоверение беженца');

INSERT INTO Doc (name, code) VALUES (15, 'Разрешение на временное проживание в Российской Федерации ');

INSERT INTO Doc (name, code) VALUES (18, 'Свидетельство о предоставлении временного убежища на территории Российской Федерации');

INSERT INTO Doc (name, code) VALUES (21, 'Паспорт гражданина Российской Федерации');

INSERT INTO Doc (name, code) VALUES (23, 'Свидетельство о рождении, выданное уполномоченным органом иностранного государства');

INSERT INTO Doc (name, code) VALUES (24, 'Удостоверение личности военнослужащего Российской Федерации');

INSERT INTO Doc (name, code) VALUES (91, 'Иные документы');

INSERT INTO Country (name, code) VALUES (643, 'Российская Федерация');

INSERT INTO Organization_Office (organization_id, office_id) VALUES (1, 1);

INSERT INTO Organization_Office (organization_id, office_id) VALUES (1, 2);

INSERT INTO Organization_Office (organization_id, office_id) VALUES (2, 3);

INSERT INTO Organization_Office (organization_id, office_id) VALUES (2, 4);

INSERT INTO Organization_User (organization_id, user_id) VALUES (1, 6);

INSERT INTO Organization_User (organization_id, user_id) VALUES (1, 5);

INSERT INTO Organization_User (organization_id, user_id) VALUES (1, 4);

INSERT INTO Organization_User (organization_id, user_id) VALUES (2, 1);

INSERT INTO Organization_User (organization_id, user_id) VALUES (2, 2);

INSERT INTO Organization_User (organization_id, user_id) VALUES (2, 3);

INSERT INTO Office_User (office_id, user_id) VALUES (1, 4);

INSERT INTO Office_User (office_id, user_id) VALUES (2, 5);

INSERT INTO Office_User (office_id, user_id) VALUES (1, 6);

INSERT INTO Office_User (office_id, user_id) VALUES (4, 2);

INSERT INTO Office_User (office_id, user_id) VALUES (3, 3);

INSERT INTO Office_User (office_id, user_id) VALUES (4, 1);

INSERT INTO User_Doc (user_id, doc_id) VALUES (1, 21);

INSERT INTO User_Doc (user_id, doc_id) VALUES (2, 21);

INSERT INTO User_Doc (user_id, doc_id) VALUES (3, 21);

INSERT INTO User_Doc (user_id, doc_id) VALUES (4, 21);

INSERT INTO User_Doc (user_id, doc_id) VALUES (5, 21);

INSERT INTO User_Doc (user_id, doc_id) VALUES (6, 21);

INSERT INTO Country_User (user_id, country_id) VALUES (1, 643);

INSERT INTO Country_User (user_id, country_id) VALUES (2, 643);

INSERT INTO Country_User (user_id, country_id) VALUES (3, 643);

INSERT INTO Country_User (user_id, country_id) VALUES (4, 643);

INSERT INTO Country_User (user_id, country_id) VALUES (5, 643);

INSERT INTO Country_User (user_id, country_id) VALUES (6, 643);