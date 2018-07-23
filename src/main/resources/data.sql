INSERT INTO User (id, version, office_id, doc_type_id, doc_id, first_name, second_name, middle_name, position, phone, citizenship_code, is_identified)
VALUES (1, 0, 6, 21, 1, 'Петя', 'Петров', '', 2,'', '', true);

INSERT INTO User (id, version, office_id, doc_type_id, doc_id, first_name, second_name, middle_name, position, phone, citizenship_code, is_identified)
VALUES (2, 0, 5, 21, 2, 'Вася', 'Васин', '', 3, '', '', true);

INSERT INTO User (id, version, office_id, doc_type_id, doc_id, first_name, second_name, middle_name, position, phone, citizenship_code, is_identified)
VALUES (3, 0, 4, 21, 3, 'Сидор', 'Сидоров', '', 4,'', '', true);

INSERT INTO User (id, version, office_id, doc_type_id, doc_id, first_name, second_name, middle_name, position, phone, citizenship_code, is_identified)
VALUES (4, 0, 3, 21, 4, 'Варвара', 'Орлова', '', 5,'', '', false);

INSERT INTO User (id, version, office_id, doc_type_id, doc_id, first_name, second_name, middle_name, position, phone, citizenship_code, is_identified)
VALUES (5, 0, 2, 21, 5, 'Ваня', 'Иванов', '', 6,'', '', true);

INSERT INTO User (id, version, office_id, doc_type_id, doc_id, first_name, second_name, middle_name, position, phone, citizenship_code, is_identified)
VALUES (6, 0, 1, 21, 6, 'Коля', 'Николаев', '', 7,'', '', true);

INSERT INTO Doc (id, version, doc_code, doc_name, doc_number, doc_date)
VALUES (1, 0, '21', 'Паспорт', '56 00 112233', 21011980);

INSERT INTO Doc (id, version, doc_code, doc_name, doc_number, doc_date)
VALUES (2, 0, '21', 'Паспорт', '56 01 112233', 21011981);

INSERT INTO Doc (id, version, doc_code, doc_name, doc_number, doc_date)
VALUES (3, 0, '21', 'Паспорт', '56 02 112233', 21011982);

INSERT INTO Doc (id, version, doc_code, doc_name, doc_number, doc_date)
VALUES (4, 0, '21', 'Паспорт', '56 03 112233', 21011983);

INSERT INTO Doc (id, version, doc_code, doc_name, doc_number, doc_date)
VALUES (5, 0, '21', 'Паспорт', '56 04 112233', 21011984);

INSERT INTO Doc (id, version, doc_code, doc_name, doc_number, doc_date)
VALUES (6, 0, '21', 'Паспорт', '56 05 112233', 21011985);

INSERT INTO Organization (id, version, country_id, name, full_name, inn, kpp, address, phone, is_active)
VALUES (1, 0, 643, 'Tinkoff', 'Tinkoff bank', '7710140679', '773401001', 'Москва, 123060, 1-й Волоколамский проезд, д. 10, стр. 1', '', true);

INSERT INTO Organization (id, version, country_id, name, full_name, inn, kpp, address, phone, is_active)
VALUES (2, 0, 643, 'HCB', 'Homecredit bank', '7735057951', '997950001', '125040, г. Москва, улица Правды, д. 8, кор.1', '', true);

INSERT INTO Office (id, version, organization_id, name, address, phone, is_active)
VALUES (1, 0, 1, 'Москва', 'г. Москва, улица Правды', '', true);

INSERT INTO Office (id, version, organization_id, name, address, phone, is_active)
VALUES (2, 0, 1, 'СПБ', 'г. СПб, улица Балтийская', '', true);

INSERT INTO Office (id, version, organization_id, name, address, phone, is_active)
VALUES (3, 0, 2, 'СПБ', 'г. СПб, улица Южная', '', true);

INSERT INTO Office (id, version, organization_id, name, address, phone, is_active)
VALUES (4, 0, 2, 'Москва', 'г. Москва, улица Волоколамская', '', true);

INSERT INTO Doc_Type (name, code) VALUES (03, 'Свидетельство о рождении');

INSERT INTO Doc_Type (name, code) VALUES (07, 'Военный билет');

INSERT INTO Doc_Type (name, code) VALUES (08, 'Временное удостоверение, выданное взамен военного билета');

INSERT INTO Doc_Type (name, code) VALUES (10, 'Паспорт иностранного гражданина');

INSERT INTO Doc_Type (name, code) VALUES (11, 'Свидетельство о рассмотрении ходатайства о признании лица беженцем на территории Российской Федерации по существу');

INSERT INTO Doc_Type (name, code) VALUES (12, 'Вид на жительство в Российской Федерации');

INSERT INTO Doc_Type (name, code) VALUES (13, 'Удостоверение беженца');

INSERT INTO Doc_Type (name, code) VALUES (15, 'Разрешение на временное проживание в Российской Федерации ');

INSERT INTO Doc_Type (name, code) VALUES (18, 'Свидетельство о предоставлении временного убежища на территории Российской Федерации');

INSERT INTO Doc_Type (name, code) VALUES (21, 'Паспорт гражданина Российской Федерации');

INSERT INTO Doc_Type (name, code) VALUES (23, 'Свидетельство о рождении, выданное уполномоченным органом иностранного государства');

INSERT INTO Doc_Type (name, code) VALUES (24, 'Удостоверение личности военнослужащего Российской Федерации');

INSERT INTO Doc_Type (name, code) VALUES (91, 'Иные документы');

INSERT INTO Country (name, code) VALUES (643, 'Российская Федерация');