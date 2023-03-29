-- sqlmigration/V1__create_security_tables.sql

CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    created_at TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    updated_at TIMESTAMP WITHOUT TIME ZONE,
    version NUMERIC DEFAULT 0 NOT NULL,
    username VARCHAR(50) NOT NULL UNIQUE,
    email VARCHAR(70) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL,
    avatar TEXT,
    change_password BOOLEAN DEFAULT true,
    status VARCHAR(3) DEFAULT 'ACT' NOT NULL
);

CREATE TABLE roles (
    id SERIAL PRIMARY KEY,
    created_at TIMESTAMP WITHOUT TIME ZONE,
    updated_at TIMESTAMP WITHOUT TIME ZONE,
    version NUMERIC DEFAULT 0 NOT NULL,
    name VARCHAR(50) NOT NULL UNIQUE,
    status VARCHAR(3) DEFAULT 'ACT' NOT NULL
);

CREATE TABLE user_rol (
    user_id SERIAL NOT NULL,
    rol_id BIGINT NOT NULL,
    PRIMARY KEY (user_id, rol_id),
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (rol_id) REFERENCES roles(id)
);

CREATE TABLE permissions (
    id SERIAL PRIMARY KEY,
    created_at TIMESTAMP WITHOUT TIME ZONE,
    updated_at TIMESTAMP WITHOUT TIME ZONE,
    version NUMERIC DEFAULT 0 NOT NULL,
    name VARCHAR(50) NOT NULL UNIQUE,
    status VARCHAR(3) DEFAULT 'ACT' NOT NULL
);

CREATE TABLE rol_permissions (
    rol_id SERIAL NOT NULL,
    permission_id BIGINT NOT NULL,
    PRIMARY KEY (rol_id, permission_id),
    FOREIGN KEY (rol_id) REFERENCES roles(id),
    FOREIGN KEY (permission_id) REFERENCES permissions(id)
);


INSERT INTO roles (created_at,name, status) VALUES
  (now(),'ROLE_ADMIN', 'ACT'),
  (now(),'ROLE_BUSINESS_MANAGER', 'ACT'),
  (now(),'ROLE_AREA_MANAGER', 'ACT'),
  (now(),'ROLE_TEAM_LEADER', 'ACT'),
  (now(),'ASCESOR', 'ACT');

INSERT INTO permissions (created_at, name, status) VALUES
  (now(),'ALL_PERMISSIONS', 'ACT');

INSERT INTO users (created_at, updated_at, "username", email, "password", status, change_password)
	   VALUES(now(), null, 'Administrador', 'sebastiantravez0@gmail.com',
	  '$2a$10$gRde6y2LNyQwT6rVqem3qugYCqKDwgsqP/N1D2DHWr7tO2jupzLtG', 'ACT'::character varying, false);

INSERT INTO public.user_rol (user_id, rol_id) values
			((select id from users where username = 'Administrador'),
			 (select id from roles where name = 'ROLE_ADMIN'));

INSERT INTO public.rol_permissions (rol_id, permission_id) values
			((select id from roles where name = 'ROLE_ADMIN'),
			 (select id from permissions where name = 'ALL_PERMISSIONS'));
