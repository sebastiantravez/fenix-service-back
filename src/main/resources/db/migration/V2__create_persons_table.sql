CREATE TABLE persons (
  id SERIAL NOT NULL,
  created_at TIMESTAMP WITHOUT TIME ZONE NOT NULL,
  updated_at TIMESTAMP WITHOUT TIME ZONE,
  version NUMERIC DEFAULT 0 NOT NULL,
  name VARCHAR(150) NOT NULL,
  last_name VARCHAR(150) NOT NULL,
  document VARCHAR(50) NOT NULL,
  status VARCHAR(3) DEFAULT 'ACT' NOT NULL,
  user_id BIGINT,
  CONSTRAINT pk_persons_id PRIMARY KEY (id)
);

ALTER TABLE persons ADD CONSTRAINT fk_user_person FOREIGN KEY (user_id) REFERENCES users(id);

INSERT INTO persons (created_at, updated_at, name, last_name, document, user_id)
	   VALUES(now(), null, 'Administrador', 'Administrador', '0000000000',1);