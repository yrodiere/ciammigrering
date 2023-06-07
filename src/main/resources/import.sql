-- CREATE
-- EXTENSION IF NOT EXISTS pgcrypto;

INSERT INTO accounts (id, FIRST_NAME, LAST_NAME, PERSONNUMBER, EMAIL, MIGRATION_STATE, agas_customernumber)
VALUES (nextval('accounts_seq'), 'Mikael', 'Andersson Wigander', '101010-1010',
        'mikael.andersson-wigander@arbetsformedlingen.se', false, '1');

INSERT INTO accounts (id, FIRST_NAME, LAST_NAME, EMAIL, USERNAME, MIGRATION_STATE, PASSWORD, agas_customernumber)
VALUES (nextval('accounts_seq'), 'Justin', 'Case', 'justin.case@acme.com', 'DustinJustin', false,
        '{SSHA}Sj8ybg83UfHrnTsLwuMjBgXC4COynbuJ1MjBmQ==', '2');


INSERT INTO accounts (id, FIRST_NAME, LAST_NAME, PERSONNUMBER, EMAIL, USERNAME, MIGRATION_STATE, agas_customernumber)
VALUES (nextval('accounts_seq'), 'Kalle', 'Kula', '19791231-2452', 'kalle.kula@arbetsformedlingen.se', 'kallekula',
        true, '3');

INSERT INTO accounts (id, FIRST_NAME, LAST_NAME, PERSONNUMBER, EMAIL, MIGRATION_STATE, agas_customernumber)
VALUES (nextval('accounts_seq'), 'Irene', 'Desperation', '19691130-1352', 'irene.desperation@arbetsformedlingen.se',
        false, '4');

INSERT INTO accounts (id, FIRST_NAME, LAST_NAME, EMAIL, USERNAME, MIGRATION_STATE, PASSWORD, agas_customernumber)
VALUES (nextval('accounts_seq'), 'Räksmörgås', 'O`Müller', 'barb.dwyer@acme.com', 'räksmörgås', false,
        '{SSHA}Sj8ybg83UfHrnTsLwuMjBgXC4COynbuJ1MjBmQ==', '5');
