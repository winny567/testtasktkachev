insert into SEC_ROLE
(DTYPE, ID, VERSION, CREATE_TS, CREATED_BY, UPDATE_TS, UPDATED_BY, DELETE_TS, DELETED_BY, NAME, LOC_NAME, DESCRIPTION,
 ROLE_TYPE, IS_DEFAULT_ROLE, SYS_TENANT_ID, SECURITY_SCOPE, AD_GROUP_NAME)
values ('10', '38ec9108-5c03-d8fe-ad49-4465d638f566', 1, '2023-05-15 17:56:10', 'admin', '2023-05-15 17:56:10', null,
        null, null, 'manager_salon', 'Менеджер салона', null, 0, null, null, 'GENERIC_UI', null) on conflict do nothing;

insert into SEC_PERMISSION
(ID, VERSION, CREATE_TS, CREATED_BY, UPDATE_TS, UPDATED_BY, DELETE_TS, DELETED_BY, PERMISSION_TYPE, TARGET, VALUE_,
 ROLE_ID)
values ('1a902179-64e8-6184-d193-60db37295e26', 1, '2023-05-15 17:56:10', 'admin', '2023-05-15 17:56:10', null, null,
        null, 20, 'testtasktkachev$Car:delete', 1, '38ec9108-5c03-d8fe-ad49-4465d638f566') on conflict do nothing;

insert into SEC_PERMISSION
(ID, VERSION, CREATE_TS, CREATED_BY, UPDATE_TS, UPDATED_BY, DELETE_TS, DELETED_BY, PERMISSION_TYPE, TARGET, VALUE_,
 ROLE_ID)
values ('68c2c7cd-63ff-5b33-d099-843c36fff29d', 1, '2023-05-15 17:56:10', 'admin', '2023-05-15 17:56:10', null, null,
        null, 20, 'testtasktkachev$VehiclePurchaseRequisition:read', 1,
        '38ec9108-5c03-d8fe-ad49-4465d638f566') on conflict do nothing;

insert into SEC_PERMISSION
(ID, VERSION, CREATE_TS, CREATED_BY, UPDATE_TS, UPDATED_BY, DELETE_TS, DELETED_BY, PERMISSION_TYPE, TARGET, VALUE_,
 ROLE_ID)
values ('47d14f76-7a54-3018-864f-2bd05d683569', 1, '2023-05-15 17:56:10', 'admin', '2023-05-15 17:56:10', null, null,
        null, 20, 'testtasktkachev$Car:read', 1, '38ec9108-5c03-d8fe-ad49-4465d638f566') on conflict do nothing;

insert into SEC_PERMISSION
(ID, VERSION, CREATE_TS, CREATED_BY, UPDATE_TS, UPDATED_BY, DELETE_TS, DELETED_BY, PERMISSION_TYPE, TARGET, VALUE_,
 ROLE_ID)
values ('ba10748c-fbbd-db0e-836a-53a1216365bd', 1, '2023-05-15 17:56:10', 'admin', '2023-05-15 17:56:10', null, null,
        null, 20, 'testtasktkachev$VehiclePurchaseRequisition:create', 1,
        '38ec9108-5c03-d8fe-ad49-4465d638f566') on conflict do nothing;

insert into SEC_PERMISSION
(ID, VERSION, CREATE_TS, CREATED_BY, UPDATE_TS, UPDATED_BY, DELETE_TS, DELETED_BY, PERMISSION_TYPE, TARGET, VALUE_,
 ROLE_ID)
values ('860300b4-aeb9-337b-1a52-6dbfa68a194e', 1, '2023-05-15 17:56:10', 'admin', '2023-05-15 17:56:10', null, null,
        null, 20, 'testtasktkachev$Car:update', 1, '38ec9108-5c03-d8fe-ad49-4465d638f566') on conflict do nothing;

insert into SEC_PERMISSION
(ID, VERSION, CREATE_TS, CREATED_BY, UPDATE_TS, UPDATED_BY, DELETE_TS, DELETED_BY, PERMISSION_TYPE, TARGET, VALUE_,
 ROLE_ID)
values ('2c240a05-f6c6-146d-6a57-aa97dfa53491', 1, '2023-05-15 17:56:10', 'admin', '2023-05-15 17:56:10', null, null,
        null, 20, 'testtasktkachev$VehiclePurchaseRequisition:update', 1,
        '38ec9108-5c03-d8fe-ad49-4465d638f566') on conflict do nothing;

insert into SEC_PERMISSION
(ID, VERSION, CREATE_TS, CREATED_BY, UPDATE_TS, UPDATED_BY, DELETE_TS, DELETED_BY, PERMISSION_TYPE, TARGET, VALUE_,
 ROLE_ID)
values ('4aa3e7bd-b54e-ee42-eb0d-caa984a15248', 1, '2023-05-15 17:56:10', 'admin', '2023-05-15 17:56:10', null, null,
        null, 20, 'testtasktkachev$Car:create', 1, '38ec9108-5c03-d8fe-ad49-4465d638f566') on conflict do nothing;

insert into SEC_PERMISSION
(ID, VERSION, CREATE_TS, CREATED_BY, UPDATE_TS, UPDATED_BY, DELETE_TS, DELETED_BY, PERMISSION_TYPE, TARGET, VALUE_,
 ROLE_ID)
values ('36897a06-932a-dbb2-597a-6e5dd01364cc', 1, '2023-05-15 17:56:10', 'admin', '2023-05-15 17:56:10', null, null,
        null, 20, 'testtasktkachev$VehiclePurchaseRequisition:delete', 1,
        '38ec9108-5c03-d8fe-ad49-4465d638f566') on conflict do nothing;

insert into SEC_ROLE
(DTYPE, ID, VERSION, CREATE_TS, CREATED_BY, UPDATE_TS, UPDATED_BY, DELETE_TS, DELETED_BY, NAME, LOC_NAME, DESCRIPTION,
 ROLE_TYPE, IS_DEFAULT_ROLE, SYS_TENANT_ID, SECURITY_SCOPE, AD_GROUP_NAME)
values ('10', 'bfb4f7b1-96c2-80bc-315e-4037c22a1e74', 1, '2023-05-15 17:56:43', 'admin', '2023-05-15 17:56:43', null,
        null, null, 'operator_bank', 'Оператор банка', null, 0, null, null, 'GENERIC_UI', null) on conflict do nothing;

insert into SEC_PERMISSION
(ID, VERSION, CREATE_TS, CREATED_BY, UPDATE_TS, UPDATED_BY, DELETE_TS, DELETED_BY, PERMISSION_TYPE, TARGET, VALUE_,
 ROLE_ID)
values ('b47389e6-d0b9-5971-ffaf-091c612cdcf8', 1, '2023-05-15 17:56:43', 'admin', '2023-05-15 17:56:43', null, null,
        null, 20, 'testtasktkachev$Car:read', 1, 'bfb4f7b1-96c2-80bc-315e-4037c22a1e74') on conflict do nothing;

insert into SEC_PERMISSION
(ID, VERSION, CREATE_TS, CREATED_BY, UPDATE_TS, UPDATED_BY, DELETE_TS, DELETED_BY, PERMISSION_TYPE, TARGET, VALUE_,
 ROLE_ID)
values ('51924e8b-208e-0623-a735-02183414339f', 1, '2023-05-15 17:56:43', 'admin', '2023-05-15 17:56:43', null, null,
        null, 20, 'testtasktkachev$VehiclePurchaseRequisition:update', 1,
        'bfb4f7b1-96c2-80bc-315e-4037c22a1e74') on conflict do nothing;

insert into SEC_PERMISSION
(ID, VERSION, CREATE_TS, CREATED_BY, UPDATE_TS, UPDATED_BY, DELETE_TS, DELETED_BY, PERMISSION_TYPE, TARGET, VALUE_,
 ROLE_ID)
values ('914ae2dc-3c09-396e-1fe3-fe6a681dcc31', 1, '2023-05-15 17:56:43', 'admin', '2023-05-15 17:56:43', null, null,
        null, 20, 'testtasktkachev$VehiclePurchaseRequisition:delete', 1,
        'bfb4f7b1-96c2-80bc-315e-4037c22a1e74') on conflict do nothing;

insert into SEC_PERMISSION
(ID, VERSION, CREATE_TS, CREATED_BY, UPDATE_TS, UPDATED_BY, DELETE_TS, DELETED_BY, PERMISSION_TYPE, TARGET, VALUE_,
 ROLE_ID)
values ('5c5900fb-28a9-fc8f-ed05-fcbf8a9ed5f5', 1, '2023-05-15 17:56:43', 'admin', '2023-05-15 17:56:43', null, null,
        null, 20, 'testtasktkachev$Car:update', 1, 'bfb4f7b1-96c2-80bc-315e-4037c22a1e74') on conflict do nothing;

insert into SEC_PERMISSION
(ID, VERSION, CREATE_TS, CREATED_BY, UPDATE_TS, UPDATED_BY, DELETE_TS, DELETED_BY, PERMISSION_TYPE, TARGET, VALUE_,
 ROLE_ID)
values ('05ee9474-e457-14b5-df59-31c4403e524e', 1, '2023-05-15 17:56:43', 'admin', '2023-05-15 17:56:43', null, null,
        null, 20, 'testtasktkachev$VehiclePurchaseRequisition:read', 1,
        'bfb4f7b1-96c2-80bc-315e-4037c22a1e74') on conflict do nothing;

insert into SEC_PERMISSION
(ID, VERSION, CREATE_TS, CREATED_BY, UPDATE_TS, UPDATED_BY, DELETE_TS, DELETED_BY, PERMISSION_TYPE, TARGET, VALUE_,
 ROLE_ID)
values ('abd9218f-b2bc-bff1-3391-9f08fcc5ed58', 1, '2023-05-15 17:56:43', 'admin', '2023-05-15 17:56:43', null, null,
        null, 20, 'testtasktkachev$VehiclePurchaseRequisition:create', 1,
        'bfb4f7b1-96c2-80bc-315e-4037c22a1e74') on conflict do nothing;

insert into SEC_ROLE
(DTYPE, ID, VERSION, CREATE_TS, CREATED_BY, UPDATE_TS, UPDATED_BY, DELETE_TS, DELETED_BY, NAME, LOC_NAME, DESCRIPTION,
 ROLE_TYPE, IS_DEFAULT_ROLE, SYS_TENANT_ID, SECURITY_SCOPE, AD_GROUP_NAME)
values ('10', 'ab9d3b76-b3e5-970d-ef7b-fa2c5c0580b8', 1, '2023-05-15 17:57:08', 'admin', '2023-05-15 17:57:08', null,
        null, null, 'master', 'Мастер', null, 0, null, null, 'GENERIC_UI', null) on conflict do nothing;

insert into SEC_PERMISSION
(ID, VERSION, CREATE_TS, CREATED_BY, UPDATE_TS, UPDATED_BY, DELETE_TS, DELETED_BY, PERMISSION_TYPE, TARGET, VALUE_,
 ROLE_ID)
values ('d4be7721-1a0f-c4db-f508-9e14b288f0cf', 1, '2023-05-15 17:57:08', 'admin', '2023-05-15 17:57:08', null, null,
        null, 20, 'testtasktkachev$VehiclePurchaseRequisition:delete', 1,
        'ab9d3b76-b3e5-970d-ef7b-fa2c5c0580b8') on conflict do nothing;

insert into SEC_PERMISSION
(ID, VERSION, CREATE_TS, CREATED_BY, UPDATE_TS, UPDATED_BY, DELETE_TS, DELETED_BY, PERMISSION_TYPE, TARGET, VALUE_,
 ROLE_ID)
values ('ca945b8a-4191-2acc-8c68-f4767aa4d200', 1, '2023-05-15 17:57:08', 'admin', '2023-05-15 17:57:08', null, null,
        null, 20, 'testtasktkachev$VehiclePurchaseRequisition:update', 1,
        'ab9d3b76-b3e5-970d-ef7b-fa2c5c0580b8') on conflict do nothing;

insert into SEC_PERMISSION
(ID, VERSION, CREATE_TS, CREATED_BY, UPDATE_TS, UPDATED_BY, DELETE_TS, DELETED_BY, PERMISSION_TYPE, TARGET, VALUE_,
 ROLE_ID)
values ('d84cd1cb-cda8-dcba-aa60-c891052d99eb', 1, '2023-05-15 17:57:08', 'admin', '2023-05-15 17:57:08', null, null,
        null, 20, 'testtasktkachev$Car:update', 1, 'ab9d3b76-b3e5-970d-ef7b-fa2c5c0580b8') on conflict do nothing;

insert into SEC_PERMISSION
(ID, VERSION, CREATE_TS, CREATED_BY, UPDATE_TS, UPDATED_BY, DELETE_TS, DELETED_BY, PERMISSION_TYPE, TARGET, VALUE_,
 ROLE_ID)
values ('06bce79b-ed2f-240f-0371-cf17b16efb7c', 1, '2023-05-15 17:57:08', 'admin', '2023-05-15 17:57:08', null, null,
        null, 20, 'testtasktkachev$VehiclePurchaseRequisition:read', 1,
        'ab9d3b76-b3e5-970d-ef7b-fa2c5c0580b8') on conflict do nothing;

insert into SEC_PERMISSION
(ID, VERSION, CREATE_TS, CREATED_BY, UPDATE_TS, UPDATED_BY, DELETE_TS, DELETED_BY, PERMISSION_TYPE, TARGET, VALUE_,
 ROLE_ID)
values ('9372a7fe-43e1-2926-d76f-3809358a631b', 1, '2023-05-15 17:57:08', 'admin', '2023-05-15 17:57:08', null, null,
        null, 20, 'testtasktkachev$Car:read', 1, 'ab9d3b76-b3e5-970d-ef7b-fa2c5c0580b8') on conflict do nothing;

insert into SEC_PERMISSION
(ID, VERSION, CREATE_TS, CREATED_BY, UPDATE_TS, UPDATED_BY, DELETE_TS, DELETED_BY, PERMISSION_TYPE, TARGET, VALUE_,
 ROLE_ID)
values ('7dddc9ec-6c9e-89a2-1306-986e2f9fcf55', 1, '2023-05-15 17:57:08', 'admin', '2023-05-15 17:57:08', null, null,
        null, 20, 'testtasktkachev$VehiclePurchaseRequisition:create', 1,
        'ab9d3b76-b3e5-970d-ef7b-fa2c5c0580b8') on conflict do nothing;

