DROP TABLE m_account IF EXISTS;
DROP TABLE m_account_roles IF EXISTS;

CREATE TABLE m_account (
  id         INTEGER IDENTITY PRIMARY KEY,
  first_name VARCHAR(30),
  last_name  VARCHAR(30),
  username	 VARCHAR(30),
  password   VARCHAR(200),
  email   	 VARCHAR(30)
);

CREATE INDEX m_account_last_name ON m_account (last_name);

CREATE TABLE m_account_roles (
  id   INTEGER IDENTITY PRIMARY KEY,
  role VARCHAR(30),
  username VARCHAR(30)
);
CREATE INDEX m_account_roles_role ON m_account_roles (role);