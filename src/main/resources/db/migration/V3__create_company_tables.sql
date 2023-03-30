CREATE TABLE country(
    id SERIAL NOT NULL,
    name VARCHAR(150) NOT NULL,
    status VARCHAR(3),
    created_at TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    updated_at TIMESTAMP WITHOUT TIME ZONE,
    CONSTRAINT pk_country_id PRIMARY KEY (id)
);

CREATE TABLE province(
    id SERIAL NOT NULL,
    name VARCHAR(150) NOT NULL,
    country_id SERIAL NOT NULL,
    status VARCHAR(3),
    created_at TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    updated_at TIMESTAMP WITHOUT TIME ZONE,
    CONSTRAINT pk_province_id PRIMARY KEY (id),
    FOREIGN KEY (country_id) REFERENCES country(id)
);

CREATE TABLE city(
    id SERIAL NOT NULL,
    name VARCHAR(150) NOT NULL,
    province_id SERIAL NOT NULL,
    status VARCHAR(3),
    created_at TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    updated_at TIMESTAMP WITHOUT TIME ZONE,
    CONSTRAINT pk_city_id PRIMARY KEY (id),
    FOREIGN KEY (province_id) REFERENCES province(id)
);

CREATE TABLE company (
    id SERIAL NOT NULL,
    name VARCHAR(250) NOT NULL,
    ruc VARCHAR(50) NOT NULL unique,
    address VARCHAR(250) NOT NULL,
    phone VARCHAR(150),
    description VARCHAR(150),
    type_center VARCHAR(50) NOT NULL,
    country_id SERIAL NOT NULL,
    status VARCHAR(3),
    created_at TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    updated_at TIMESTAMP WITHOUT TIME ZONE,
    CONSTRAINT pk_company_id PRIMARY KEY (id),
    FOREIGN KEY (country_id) REFERENCES country(id)
);

CREATE TABLE subsidiary (
    id SERIAL NOT NULL,
    name VARCHAR(250) NOT NULL,
    address VARCHAR(250) NOT NULL,
    emission_point VARCHAR(50) NOT NULL,
    establishment_point VARCHAR(250) NOT NULL,
    phone VARCHAR(150),
    description VARCHAR(150),
    type_center VARCHAR(50) NOT NULL,
    province_id SERIAL NOT NULL,
    status VARCHAR(3),
    created_at TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    updated_at TIMESTAMP WITHOUT TIME ZONE,
    CONSTRAINT pk_subsidiary_id PRIMARY KEY (id),
    FOREIGN KEY (province_id) REFERENCES province(id)
);


INSERT INTO country(id, name, status, created_at, updated_at) VALUES (1, 'ECUADOR', 'ACT', now(), now());

INSERT INTO province(id, name, country_id, status, created_at, updated_at) VALUES (1, 'PICHINCHA', 1, 'ACT', now(), now());

INSERT INTO city(id, name, province_id, status, created_at, updated_at) VALUES (1, 'QUITO', 1, 'ACT', now(), now());

INSERT INTO company(id, name, ruc, address, phone, description, type_center, country_id, status, created_at, updated_at)
values (1, 'FENIX', '1702457896001', 'EL CONDANDO','024784212','EMPRESA', 'MATRIZ',1,'ACT', now(), now())