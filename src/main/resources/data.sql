INSERT INTO Country (id, version, code, name) VALUES (1, 0, '643', 'Российская Федерация');

INSERT INTO Organization (id, version, country_id, name, full_name, inn, kpp, address, phone, is_active)
VALUES (1, 0, 1, 'Tinkoff', 'Tinkoffbank', '7710140679', '773401001', 'Москваезд', '', true);

INSERT INTO Organization (id, version, country_id, name, full_name, inn, kpp, address, phone, is_active)
VALUES (2, 0, 1, 'HCB', 'Homecredit bank', '7735057951', '997950001', '125040,г.Москва,улицаПравды', '', true);

INSERT INTO Office (id, version, organization_id, name, address, phone, is_active)
VALUES (1, 0, 1, 'Москва', 'г. Москва, улица Правды', '', true);

INSERT INTO Office (id, version, organization_id, name, address, phone, is_active)
VALUES (2, 0, 1, 'СПБ', 'г. СПб, улица Балтийская', '', true);

INSERT INTO Office (id, version, organization_id, name, address, phone, is_active)
VALUES (3, 0, 2, 'СПБ', 'г. СПб, улица Южная', '', true);

INSERT INTO Office (id, version, organization_id, name, address, phone, is_active)
VALUES (4, 0, 2, 'Москва', 'г. Москва, улица Волоколамская', '', true);

INSERT INTO Doc_Type (id, version, code, name) VALUES (1, 0, '03', 'Свидетельство о рождении');

INSERT INTO Doc_Type (id, version, code, name) VALUES (2, 0, '07', 'Военный билет');

INSERT INTO Doc_Type (id, version, code, name) VALUES (3, 0, '08', 'Временное удостоверение выданное взамен военного билета');

INSERT INTO Doc_Type (id, version, code, name) VALUES (4, 0, '10', 'Паспорт иностранного гражданина');

INSERT INTO Doc_Type (id, version, code, name) VALUES (5, 0, '11', 'Свидетельство о рассмотрении ходатайства о признании лица беженцем на территории Российской Федерации по существу');

INSERT INTO Doc_Type (id, version, code, name) VALUES (6, 0, '12', 'Вид на жительство в Российской Федерации');

INSERT INTO Doc_Type (id, version, code, name) VALUES (7, 0, '13', 'Удостоверение беженца');

INSERT INTO Doc_Type (id, version, code, name) VALUES (8, 0, '15', 'Разрешение на временное проживание в Российской Федерации ');

INSERT INTO Doc_Type (id, version, code, name) VALUES (9, 0, '18', 'Свидетельство о предоставлении временного убежища на территории Российской Федерации');

INSERT INTO Doc_Type (id, version, code, name) VALUES (10, 0, '21', 'Паспорт гражданина Российской Федерации');

INSERT INTO Doc_Type (id, version, code, name) VALUES (11, 0, '23', 'Свидетельство о рождении, выданное уполномоченным органом иностранного государства');

INSERT INTO Doc_Type (id, version, code, name) VALUES (12, 0, '24', 'Удостоверение личности военнослужащего Российской Федерации');

INSERT INTO Doc_Type (id, version, code, name) VALUES (13, 0, '91', 'Иные документы');

INSERT INTO Doc (id, version, doc_type_id, doc_number, doc_date)
VALUES (1, 0, 10, '5600112233', '1980-01-21');

INSERT INTO Doc (id, version, doc_type_id, doc_number, doc_date)
VALUES (2, 0, 10, '5601112233', '1982-01-21');

INSERT INTO Doc (id, version, doc_type_id, doc_number, doc_date)
VALUES (3, 0, 10, '5602112233', '1983-01-21');

INSERT INTO Doc (id, version, doc_type_id, doc_number, doc_date)
VALUES (4, 0, 10, '5603112233', '1984-01-21');

INSERT INTO Doc (id, version, doc_type_id, doc_number, doc_date)
VALUES (5, 0, 10, '5604112233', '1985-01-21');

INSERT INTO Doc (id, version, doc_type_id, doc_number, doc_date)
VALUES (6, 0, 10, '5605112233', '1986-01-21');

INSERT INTO User (id, version, office_id, doc_id, first_name, second_name, middle_name, position, phone, citizenship_code, is_identified)
VALUES (1, 0, 1, 6, 'Петя', 'Петров', '', 2,'', '', true);

INSERT INTO User (id, version, office_id, doc_id, first_name, second_name, middle_name, position, phone, citizenship_code, is_identified)
VALUES (2, 0, 2, 5, 'Вася', 'Васин', '', 3, '', '', true);

INSERT INTO User (id, version, office_id, doc_id, first_name, second_name, middle_name, position, phone, citizenship_code, is_identified)
VALUES (3, 0, 3, 4, 'Сидор', 'Сидоров', '', 4,'', '', true);

INSERT INTO User (id, version, office_id, doc_id, first_name, second_name, middle_name, position, phone, citizenship_code, is_identified)
VALUES (4, 0, 4, 3, 'Варвара', 'Орлова', '', 5,'', '', false);

INSERT INTO User (id, version, office_id, doc_id, first_name, second_name, middle_name, position, phone, citizenship_code, is_identified)
VALUES (5, 0, 2, 2, 'Ваня', 'Иванов', '', 6,'', '', true);

INSERT INTO User (id, version, office_id, doc_id, first_name, second_name, middle_name, position, phone, citizenship_code, is_identified)
VALUES (6, 0, 1, 1, 'Коля', 'Николаев', '', 7,'', '', true);