CREATE TABLE t_user
(
    usr_id         integer      NOT NULL AUTO_INCREMENT,
    usr_first_name varchar(30)  NOT NULL,
    usr_surname    varchar(30)  NOT NULL,
    usr_gender     smallint     NOT NULL,
    usr_email      varchar(100) NOT NULL,
    usr_active     smallint     NOT NULL,
    PRIMARY KEY (usr_id)
);
