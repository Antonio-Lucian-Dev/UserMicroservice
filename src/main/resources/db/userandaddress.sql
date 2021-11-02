DROP TABLE if exists Address cascade;
DROP TABLE if exists UserAddresses cascade;
DROP TABLE if exists Users cascade;

CREATE TABLE Address(
    id uuid PRIMARY KEY NOT NULL,
    city varchar(50) NOT NULL,
    country varchar(50) not null,
    zip_code int not null,
    street varchar(50),
    street_number int
);

CREATE TABLE UserAddresses(
    id uuid PRIMARY KEY NOT NULL,
    street varchar(50),
    street_number int,
    address uuid,
    constraint FK_UserAddress FOREIGN KEY (address)
    REFERENCES Address(id)
);

CREATE TABLE Users(
    id uuid PRIMARY KEY,
    first_name varchar(50) not null,
    last_name varchar(50) not null,
    email varchar(50) not null,
    profile_image bytea not null,
    password varchar(50) not null,
    address_id uuid,
    constraint FK_UserAddress FOREIGN KEY (address_id)
    REFERENCES Address(id)
);


INSERT INTO Address(id, city, country, zip_code) values('40e6215d-b5c6-4896-987c-f30f3678f608', 'Adjud', 'Romania', 00170);
INSERT INTO Address(id, city, country, zip_code) values('40e6215d-b5c6-4896-987c-f30f3678f609', 'Agas', 'Romania', 607005);
INSERT INTO Address(id, city, country, zip_code) values('40e6215d-b5c6-4896-987c-f30f3678f606', 'Apa Asau', 'Romania', 607021);
INSERT INTO Address(id, city, country, zip_code) values('40e6215d-b5c6-4896-987c-f30f3678f708', 'Asau', 'Romania', 607020);
INSERT INTO Address(id, city, country, zip_code) values('40e6215d-b5c6-4896-987c-f30f3679f608', 'Albele', 'Romania', 607036);
INSERT INTO Address(id, city, country, zip_code) values('40e6225d-b5c6-4896-987c-f30f3678f608', 'Ardeoani', 'Romania', 607015);
INSERT INTO Address(id, city, country, zip_code) values('40e6215d-b5c6-5896-987c-f30f3678f608', 'Antohesti', 'Romania', 607261);
INSERT INTO Address(id, city, country, zip_code) values('40e3215d-b5c6-4896-987c-f30f3678f608', 'Arini', 'Romania', 607196);
INSERT INTO Address(id, city, country, zip_code) values('40e6216d-b5c6-4896-987c-f30f3678f608', 'Bacau', 'Romania', 600408);
INSERT INTO Address(id, city, country, zip_code) values('40e1215d-b5c6-4896-987c-f30f3678f608', 'Bacioiu', 'Romania', 607121);
INSERT INTO Address(id, city, country, zip_code) values('40e6215d-b3c6-4896-987c-f30f3678f608', 'Bahnaseni', 'Romania', 607431);