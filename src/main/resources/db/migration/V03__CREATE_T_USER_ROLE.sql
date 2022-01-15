CREATE TABLE t_user_role
(
    rlu_user_id integer NOT NULL,
    rlu_role_id smallint NOT NULL,
    PRIMARY KEY (rlu_user_id,
                 rlu_role_id),
    FOREIGN KEY (rlu_role_id) REFERENCES t_role (rol_id),
    FOREIGN KEY (rlu_user_id) REFERENCES t_user (usr_id)
);
