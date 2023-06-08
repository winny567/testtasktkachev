alter table TESTTASKTKACHEV_CAR rename column car_model_id to car_model_id__u96504 ;
alter table TESTTASKTKACHEV_CAR drop constraint FK_TESTTASKTKACHEV_CAR_ON_CAR_MODEL ;
drop index IDX_TESTTASKTKACHEV_CAR_ON_CAR_MODEL ;
alter table TESTTASKTKACHEV_CAR add column CAR_MODEL_ID uuid ;
