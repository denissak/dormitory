DROP TABLE manager;
DROP TABLE contract;
DROP TABLE work;
DROP TABLE users;
DROP TABLE personal_info;
DROP TABLE room;
DROP TABLE dormitory;


CREATE TABLE IF NOT EXISTS manager
(
    id            SERIAL PRIMARY KEY,
    name          VARCHAR(64) NOT NULL,
    type_document VARCHAR(64) NOT NULL,
    number        VARCHAR(64) NOT NULL,
    date          Date

);

CREATE TABLE IF NOT EXISTS work
(
    id      SERIAL PRIMARY KEY,
    name    VARCHAR(64)  NOT NULL UNIQUE,
    address VARCHAR(256) NOT NULL
);

CREATE TABLE IF NOT EXISTS dormitory
(
    id           SERIAL PRIMARY KEY,
    name         VARCHAR(64)  NOT NULL UNIQUE,
    address      VARCHAR(256) NOT NULL,
    square       DECIMAL      NOT NULL,
    square_live  DECIMAL      NOT NULL,
    start_year   DATE,
    amount_rooms INT          NOT NULL
);

CREATE TABLE IF NOT EXISTS room
(
    id           SERIAL PRIMARY KEY,
    number       VARCHAR(64)  NOT NULL,
    type         VARCHAR(64)  NOT NULL,
    square       DECIMAL(32)  NOT NULL,
    square_live  DECIMAL(32),
    floor        INT          NOT NULL,
    image        VARCHAR(256) NOT NULL,
    amount       INT,
    dormitory_id INT REFERENCES dormitory (id)

);

CREATE TABLE IF NOT EXISTS personal_info
(
    id                 SERIAL PRIMARY KEY,
    firstname          VARCHAR(64)  NOT NULL,
    lastname           VARCHAR(64)  NOT NULL,
    patronymic         VARCHAR(64)  NOT NULL,
    phone_number       VARCHAR(32)  NOT NULL,
    image              VARCHAR(256),
    sex                VARCHAR(16)  NOT NULL,
    birthdate          DATE,
    passport_number    VARCHAR(32)  NOT NULL,
    id_passport_number VARCHAR(32)  NOT NULL,
    passport_issued_by VARCHAR(256) NOT NULL,
    registration       VARCHAR(256) NOT NULL,
    status             VARCHAR(64)  NOT NULL,
    partner            VARCHAR(256),
    children           VARCHAR(512),
    pets               VARCHAR(512),
    bike               INT,
    stroller           INT
);

CREATE TABLE IF NOT EXISTS users
(
    id                    SERIAL PRIMARY KEY,
    login                 VARCHAR(64),
    password              VARCHAR(512),
    personal_info_id      INT REFERENCES personal_info (id),
    room_id               INT REFERENCES room (id),
    workplace_id          INT REFERENCES work (id),
    job_title             VARCHAR(128),
    notes                 VARCHAR(512),
    is_tenant             BOOLEAN NOT NULL,
    date_registration     DATE,
    date_registration_end DATE,
    date_revise           DATE,
    status_employee       VARCHAR NOT NULL
);

CREATE TABLE IF NOT EXISTS contract
(
    id                    SERIAL PRIMARY KEY,
    contract_number       VARCHAR(64) NOT NULL,
    contract_start        DATE        NOT NULL,
    type                  VARCHAR(64) NOT NULL,
    contract_end          DATE,
    contract_registration DATE,
    number_registration   VARCHAR(64),
    contract_petition     DATE,
    user_id               INT REFERENCES users (id)
);