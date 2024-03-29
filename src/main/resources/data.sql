INSERT INTO `authority` (`id`, `name`) VALUES
(1, 'COMPANY_CREATE'),
(2, 'COMPANY_READ'),
(3, 'COMPANY_UPDATE'),
(4, 'COMPANY_DELETE'),
(5, 'DEPARTMENT_CREATE'),
(6, 'DEPARTMENT_READ'),
(7, 'DEPARTMENT_UPDATE'),
(8, 'DEPARTMENT_DELETE'),
(9, 'ADS_READ'),
(10, 'ADS_WRITE'),
(11, 'ADS_SLOTS_READ'),
(12, 'READ_MESSAGES'),
(13, 'READ_WRITE_MESSAGES'),
(14, 'READ_ORDERS'),
(15, 'READ_PAYMENTS'),
(16, 'READ_WRITE_PAYMENTS'),
(17, 'READ_PRODUCTS'),
(18, 'READ_WRITE_PRODUCTS'),
(19, 'READ_SHIPPING'),
(20, 'READ_WRITE_SHIPPING'),
(21, 'READ_SLIDE'),
(22, 'READ_WRITE_SLIDE');


INSERT INTO oauth_client_details(CLIENT_ID, RESOURCE_IDS, CLIENT_SECRET, SCOPE, AUTHORIZED_GRANT_TYPES, AUTHORITIES, ACCESS_TOKEN_VALIDITY, REFRESH_TOKEN_VALIDITY)
 VALUES ('spring-security-oauth2-read-client', 'resource-server-rest-api',
 /*spring-security-oauth2-read-client-password1234*/'$2a$04$WGq2P9egiOYoOFemBRfsiO9qTcyJtNRnPKNBl5tokP7IP.eZn93km',
 'read', 'password,authorization_code,refresh_token,implicit', 'USER', 10800, 2592000);
INSERT INTO oauth_client_details(CLIENT_ID, RESOURCE_IDS, CLIENT_SECRET, SCOPE, AUTHORIZED_GRANT_TYPES, AUTHORITIES, ACCESS_TOKEN_VALIDITY, REFRESH_TOKEN_VALIDITY)
 VALUES ('spring-security-oauth2-read-write-client', 'resource-server-rest-api',
 /*spring-security-oauth2-read-write-client-password1234*/'$2a$04$soeOR.QFmClXeFIrhJVLWOQxfHjsJLSpWrU1iGxcMGdu.a5hvfY4W',
 'read,write', 'password,authorization_code,refresh_token,implicit', 'USER', 10800, 2592000);


INSERT INTO `user` (`user_name`, `password`, `account_expired`, `account_locked`, `credentials_expired`, `id`, `enabled`) VALUES
('admin@gmail.com', '$2a$08$qvrzQZ7jJ7oy2p/msL4M0.l83Cd0jNsX6AJUitbgRXGzge4j035ha', 0, 0, 0, 1, 1),
('reader', '$2a$08$dwYz8O.qtUXboGosJFsS4u19LHKW7aCQ0LXXuNlRfjjGKwj5NfKSe', 0, 0, 0, 2, 1),
('modifier', '$2a$08$kPjzxewXRGNRiIuL4FtQH.mhMn7ZAFBYKB3ROz.J24IX8vDAcThsG', 0, 0, 0, 3, 1),
('reader2', '$2a$08$vVXqh6S8TqfHMs1SlNTu/.J25iUCrpGBpyGExA.9yI.IlDRadR6Ea', 0, 0, 0, 4, 1);


INSERT INTO `user_authorities` (`user_id`, `authority_id`) VALUES
(1, 1),
(1, 2),
(1, 3),
(1, 4),
(1, 5),
(1, 6),
(1, 7),
(1, 8),
(1, 9),
(1, 10),
(1, 11),
(1, 12),
(1, 13),
(1, 14),
(1, 15),
(1, 16),
(1, 17),
(1, 18),
(1, 19),
(1, 20),
(1, 21),
(1, 22),
(2, 2),
(2, 6),
(3, 3),
(3, 7),
(4, 9);