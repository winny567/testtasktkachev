alter table TESTTASKTKACHEV_VEHICLE_PURCHASE_REQUISITION_BANK_LINK add constraint FK_VEHPURREQBAN_ON_VEHICLE_PURCHASE_REQUISITION foreign key (VEHICLE_PURCHASE_REQUISITION_ID) references TESTTASKTKACHEV_VEHICLE_PURCHASE_REQUISITION(CARD_ID);
alter table TESTTASKTKACHEV_VEHICLE_PURCHASE_REQUISITION_BANK_LINK add constraint FK_VEHPURREQBAN_ON_BANK foreign key (BANK_ID) references DF_BANK(ID);