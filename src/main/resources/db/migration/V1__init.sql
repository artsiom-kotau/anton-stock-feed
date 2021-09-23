create table company_profile (
    id            serial not null,
    currency      varchar(255),
    description   varchar(255),
    displaysymbol varchar(255),
    figi          varchar(255),
    mic           varchar(255),
    symbol        varchar(255),
    type          varchar(255),
    primary key (id)
);

create table financials_as_reported (
    id           serial not null,
    accepteddate varchar(255),
    accessnumber varchar(255),
    cik          varchar(255),
    enddate      varchar(255),
    fileddate    varchar(255),
    form         varchar(255),
    quarter      varchar(255),
    report       varchar(255),
    startdate    varchar(255),
    symbol       varchar(255),
    year         varchar(255),
    primary key (id)
);