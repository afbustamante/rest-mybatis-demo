CREATE TABLE t_role
(
    rol_id   smallint NOT NULL,
    rol_name varchar(20),
    PRIMARY KEY (rol_id)
);

INSERT INTO t_role(rol_id, rol_name) VALUES (1, 'Salesman');
INSERT INTO t_role(rol_id, rol_name) VALUES (2, 'Support');
INSERT INTO t_role(rol_id, rol_name) VALUES (3, 'Manager');
