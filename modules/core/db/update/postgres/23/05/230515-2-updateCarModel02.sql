alter table TESTTASKTKACHEV_CAR_MODEL rename column car_id to car_id__u43448 ;
alter table TESTTASKTKACHEV_CAR_MODEL drop constraint FK_TESTTASKTKACHEV_CAR_MODEL_ON_CAR ;
drop index IDX_TESTTASKTKACHEV_CAR_MODEL_ON_CAR ;
