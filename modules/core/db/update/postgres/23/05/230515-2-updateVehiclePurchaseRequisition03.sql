alter table TESTTASKTKACHEV_VEHICLE_PURCHASE_REQUISITION add constraint FK_TESTTASKTKACHEV_VEHICLE_PURCHASE_REQUISITION_ON_BANK foreign key (BANK_ID) references DF_BANK(ID);
create index IDX_TESTTASKTKACHEV_VEHICLE_PURCHASE_REQUISITION_ON_BANK on TESTTASKTKACHEV_VEHICLE_PURCHASE_REQUISITION (BANK_ID);