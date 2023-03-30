CREATE TABLE country(
    id SERIAL NOT NULL,
    name VARCHAR(150) NOT NULL,
    status VARCHAR(3) DEFAULT 'ACT',
    created_at TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    updated_at TIMESTAMP WITHOUT TIME ZONE,
    CONSTRAINT pk_country_id PRIMARY KEY (id)
);

CREATE TABLE province(
    id SERIAL NOT NULL,
    name VARCHAR(150) NOT NULL UNIQUE ,
    country_id SERIAL NOT NULL,
    status VARCHAR(3) DEFAULT 'ACT',
    created_at TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    updated_at TIMESTAMP WITHOUT TIME ZONE,
    CONSTRAINT pk_province_id PRIMARY KEY (id),
    FOREIGN KEY (country_id) REFERENCES country(id)
);

CREATE TABLE city(
    id SERIAL NOT NULL,
    name VARCHAR(150) NOT NULL UNIQUE,
    province_id SERIAL NOT NULL,
    status VARCHAR(3) DEFAULT 'ACT',
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
    company_id SERIAL NOT NULL,
    province_id SERIAL NOT NULL,
    status VARCHAR(3),
    created_at TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    updated_at TIMESTAMP WITHOUT TIME ZONE,
    CONSTRAINT pk_subsidiary_id PRIMARY KEY (id),
    FOREIGN KEY (province_id) REFERENCES province(id),
    FOREIGN KEY (company_id) REFERENCES company(id)
);

ALTER TABLE subsidiary ADD CONSTRAINT ck_unique_subsidiary_points UNIQUE (emission_point, establishment_point);

INSERT INTO country(id, name, status, created_at, updated_at) VALUES (1, 'ECUADOR', 'ACT', now(), now());

INSERT INTO company(id, name, ruc, address, phone, description, type_center, country_id, status, created_at, updated_at)
values (1, 'FENIX', '1702457896001', 'EL CONDANDO','024784212','EMPRESA', 'MATRIZ',1,'ACT', now(), now())