-- Table: public.accounts
-- CREATE
-- EXTENSION IF NOT EXISTS pgcrypto;

DROP TABLE IF EXISTS accounts;

CREATE TABLE IF NOT EXISTS accounts
(
    pisa_uid                   uuid,
    username                   character varying,
    first_name                 character varying,
    last_name                  character varying,
    email                      character varying,
    password                   character varying,
    customernumber             character varying,
    companycustomernumber      character varying,
    customernumberorganisation character varying,
    migration_state            boolean,
    personnumber               character varying,
    id                         INT GENERATED ALWAYS AS IDENTITY,
    agas_customernumber        character varying,
    last_login                 timestamp with time zone,
    imported_timestamp         timestamp with time zone,
    migrated_timestamp         timestamp with time zone,
    primary key (id)
);


INSERT INTO accounts (FIRST_NAME, LAST_NAME, PERSONNUMBER, EMAIL, MIGRATION_STATE, agas_customernumber)
VALUES ('Mikael', 'Andersson Wigander', '101010-1010', 'mikael.andersson-wigander@arbetsformedlingen.se', false, '1');

INSERT INTO accounts (FIRST_NAME, LAST_NAME, EMAIL, USERNAME, MIGRATION_STATE, PASSWORD, agas_customernumber)
VALUES ('Justin', 'Case', 'justin.case@aacme.com', 'DustinJustin', false,
        '{SSHA}Sj8ybg83UfHrnTsLwuMjBgXC4COynbuJ1MjBmQ==', '2');

INSERT INTO accounts (FIRST_NAME, LAST_NAME, PERSONNUMBER, EMAIL, USERNAME, MIGRATION_STATE, agas_customernumber)
VALUES ('Kalle', 'Kula', '19791231-2452', 'kalle.kula@arbetsformedlingen.se', 'kallekula', true, '3');

INSERT INTO accounts (FIRST_NAME, LAST_NAME, PERSONNUMBER, EMAIL, MIGRATION_STATE, agas_customernumber)
VALUES ('Irene', 'Desperation', '19691130-1352', 'irene.desperation@arbetsformedlingen.se', false, '4');

INSERT INTO accounts (FIRST_NAME, LAST_NAME, EMAIL, USERNAME, MIGRATION_STATE, PASSWORD, agas_customernumber)
VALUES ('Räksmörgås', 'O`Müller', 'barb.dwyer@acme.com', 'räksmörgås', false,
        '{SSHA}Sj8ybg83UfHrnTsLwuMjBgXC4COynbuJ1MjBmQ==', '5');