DROP TABLE if exists Address cascade;
DROP TABLE if exists UserAddresses cascade;
DROP TABLE if exists Users cascade;
DROP TABLE if exists t cascade;

CREATE TABLE Address(
    id uuid DEFAULT gen_random_uuid () PRIMARY KEY ,
    city varchar(250),
    country varchar(250),
    zip_code text,
    county varchar(50)
);

CREATE TABLE UserAddresses(
    id uuid DEFAULT gen_random_uuid () PRIMARY KEY ,
    street varchar(50),
    street_number int,
    address uuid,
    constraint FK_UserAddress FOREIGN KEY (address)
    REFERENCES Address(id)
);

CREATE TABLE Users(
    id uuid DEFAULT gen_random_uuid () PRIMARY KEY ,
    first_name varchar(50) not null,
    last_name varchar(50) not null,
    email varchar(50) not null,
    profile_image bytea not null,
    password varchar(50) not null,
    address_id uuid,
    constraint FK_UserAddress FOREIGN KEY (address_id)
    REFERENCES UserAddresses(id)
);

create table t (COUNTRY varchar(50), POSTAL_CODE text, CITY varchar(255), STATE varchar(255), SHORT_STATE varchar(50), COUNTY varchar(50), SHORT_COUNTY text, COMMUNITY varchar(255),
               SHORT_COMUNITY text, LATITUDE text, LONGITUDE text, ACCURACY text);
copy t(COUNTRY, POSTAL_CODE, CITY, STATE, SHORT_STATE, COUNTY, SHORT_COUNTY, COMMUNITY, SHORT_COMUNITY, LATITUDE, LONGITUDE, ACCURACY) from 'C:\Users\Asu\Downloads\allCountriesCSV.csv' CSV HEADER DELIMITER ',';

insert into address (city, country, zip_code, county)
select DISTINCT ON (CITY) CITY, COUNTRY, POSTAL_CODE, COUNTY
from t;

DROP TABLE t;