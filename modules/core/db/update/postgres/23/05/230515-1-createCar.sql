create table TESTTASKTKACHEV_CAR (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255),
    ISSUE_DATE date,
    PRICE double precision,
    CAR_TYPE varchar(50),
    --
    primary key (ID)
);