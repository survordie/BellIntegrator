INSERT INTO User (id, version, first_name, second_name, middle_name, position, phone, doc_name, doc_number, doc_date, citizenship_code, is_identified) 
VALUES (1, 0, 'Пётр', 'Петров', '', 2,'', '', '', '', '', true);

INSERT INTO User (id, version, first_name, second_name, middle_name, position, phone, doc_name, doc_number, doc_date, citizenship_code, is_identified) 
VALUES (2, 0, 'Вася', 'Васин', '', 3, '', '', '', '', '', true);

INSERT INTO User (id, version, first_name, second_name, middle_name, position, phone, doc_name, doc_number, doc_date, citizenship_code, is_identified) 
VALUES (3, 0, 'Сидор', 'Сидоров', '', 4,'', '', '', '', '', true);

INSERT INTO User (id, version, first_name, second_name, middle_name, position, phone, doc_name, doc_number, doc_date, citizenship_code, is_identified) 
VALUES (4, 0, 'Варвара', 'Орлова', '', 5,'', '', '', '', '', false);

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

INSERT INTO Organization_Office (organization_id, office_id) VALUES (1, 1);

INSERT INTO Organization_Office (organization_id, office_id) VALUES (1, 2);

INSERT INTO Organization_Office (organization_id, office_id) VALUES (2, 3);

INSERT INTO Organization_Office (organization_id, office_id) VALUES (2, 4);

INSERT INTO Organization_User (organization_id, user_id) VALUES (1, 4);

INSERT INTO Organization_User (organization_id, user_id) VALUES (1, 3);

INSERT INTO Organization_User (organization_id, user_id) VALUES (1, 1);

INSERT INTO Organization_User (organization_id, user_id) VALUES (2, 1);

INSERT INTO Organization_User (organization_id, user_id) VALUES (2, 2);

INSERT INTO Organization_User (organization_id, user_id) VALUES (2, 4);

INSERT INTO Office_User (office_id, user_id) VALUES (1, 4);

INSERT INTO Office_User (office_id, user_id) VALUES (2, 2);

INSERT INTO Office_User (office_id, user_id) VALUES (1, 1);

INSERT INTO Office_User (office_id, user_id) VALUES (4, 2);

INSERT INTO Office_User (office_id, user_id) VALUES (3, 4);

INSERT INTO Office_User (office_id, user_id) VALUES (4, 1);