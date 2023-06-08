-- begin TESTTASKTKACHEV_CAR_MODEL
create table TESTTASKTKACHEV_CAR_MODEL (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(250),
    CODE varchar(100),
    NOTE varchar(500),
    --
    primary key (ID)
)^
-- end TESTTASKTKACHEV_CAR_MODEL
-- begin TESTTASKTKACHEV_VEHICLE_PURCHASE_REQUISITION
create table TESTTASKTKACHEV_VEHICLE_PURCHASE_REQUISITION (
    CARD_ID uuid,
    --
    BANK_ID uuid,
    IS_PAY_CAR boolean,
    CAR_ID uuid,
    --
    primary key (CARD_ID)
)^
-- end TESTTASKTKACHEV_VEHICLE_PURCHASE_REQUISITION

-- begin TESTTASKTKACHEV_CAR
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
    CAR_MODEL_ID uuid,
    ISSUE_DATE date,
    PRICE double precision,
    CAR_TYPE varchar(50),
    --
    primary key (ID)
)^
-- end TESTTASKTKACHEV_CAR
