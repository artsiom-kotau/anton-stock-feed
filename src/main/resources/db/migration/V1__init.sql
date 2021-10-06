create table company_profile
(
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

create table financials_as_reported
(
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

create table company_details
(
    id                    serial not null,
    country               VARCHAR(255),
    currency              VARCHAR(255),
    exchange              VARCHAR(255),
    finnhub_industry      VARCHAR(255),
    ipo                   VARCHAR(255),
    logo                  VARCHAR(255),
    market_capitalization VARCHAR(255),
    name                  VARCHAR(255),
    phone                 VARCHAR(255),
    share_outstanding     VARCHAR(255),
    ticker                VARCHAR(255),
    web_url               VARCHAR(255),
    primary key (id)
);

CREATE TABLE basic_financials
(
    id          SERIAL NOT NULL,
    metric      VARCHAR(255),
    metric_type VARCHAR(255),
    series      VARCHAR(255),
    symbol      VARCHAR(255),
        PRIMARY KEY (id)
);