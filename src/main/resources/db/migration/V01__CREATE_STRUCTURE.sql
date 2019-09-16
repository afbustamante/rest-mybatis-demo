CREATE TABLE t_role (
  rol_id   smallint(5) NOT NULL,
  rol_name varchar(20),
  PRIMARY KEY (rol_id)
);

CREATE TABLE t_user (
  usr_id         INTEGER      NOT NULL PRIMARY KEY AUTOINCREMENT,
  usr_first_name varchar(30)  NOT NULL,
  usr_surname    varchar(30)  NOT NULL,
  usr_gender     integer(1)   NOT NULL,
  usr_email      varchar(100) NOT NULL UNIQUE,
  usr_active     boolean      NOT NULL
);

CREATE TABLE t_user_role (
  rlu_user_id integer(10) NOT NULL,
  rlu_role_id smallint(5) NOT NULL,
  PRIMARY KEY (rlu_user_id,
               rlu_role_id),
  FOREIGN KEY (rlu_role_id) REFERENCES t_role (rol_id),
  FOREIGN KEY (rlu_user_id) REFERENCES t_user (usr_id)
);
