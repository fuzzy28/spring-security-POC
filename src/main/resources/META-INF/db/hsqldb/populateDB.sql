INSERT INTO m_account VALUES (1, 'Admin', 'Admin','admin','2799e25b5a0ee5ccc7b4f6420aff0b7b01038df860a7f4abfad05af31e2cb8efc750fe20d77f24b6','admin@mail.com','ROLE_ADMIN');
INSERT INTO m_account VALUES (2, 'User', 'User','user','5c1a69bbc5adfeae5b6b7b3bf6f508493b9e14df9e082b75aa1b73ae6ef237e8a6f188f85ade89f8','user@mail.com','ROLE_USER');

INSERT INTO m_account_roles VALUES (1, 'ROLE_ADMIN',1);
INSERT INTO m_account_roles VALUES (2, 'ROLE_USER',1);
INSERT INTO m_account_roles VALUES (3, 'ROLE_USER' ,2);