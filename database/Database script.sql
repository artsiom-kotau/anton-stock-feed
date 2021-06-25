CREATE DATABASE stockfeed;
CREATE TABLE company_profile (
id serial not null,
currency varchar(100),
description varchar(100),
displaysymbol varchar(100),
figi varchar(100),
mic varchar(100),
symbol varchar(100),
type varchar(100));