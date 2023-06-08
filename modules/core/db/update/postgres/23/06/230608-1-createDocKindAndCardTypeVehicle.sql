insert into TS_CARD_TYPE
(ID, CREATE_TS, CREATED_BY, NAME, DISCRIMINATOR, DOC_KIND_ID, DOC_TEMPLATE_ID, FIELDS_XML)
values ('2c66ba9e-f527-408c-94fc-4baa98d5e8bb', '2023-04-26 21:02:26', 'system', 'testtasktkachev$VehiclePurchaseRequisition', 2100, null, null, '<?xml version="1.0" encoding="UTF-8"?>
<fields>
  <field name="date" inDocKind="true" required="false" visible="true" signed="false" />
  <field name="docCategory" inDocKind="true" required="false" visible="true" signed="false" />
  <field name="owner" inDocKind="true" required="false" visible="true" signed="false" />
  <field name="department" inDocKind="true" required="false" visible="true" signed="false" />
  <field name="comment" inDocKind="true" required="false" visible="true" signed="false" />
  <field name="finishDatePlan" inDocKind="true" required="false" visible="true" signed="false" />
  <field name="resolution" inDocKind="true" required="false" visible="true" signed="false" />
  <field name="number" inDocKind="true" required="false" visible="true" signed="false" />
  <field name="organization" inDocKind="true" required="false" visible="true" signed="false" />
  <field name="parentCard" inDocKind="true" required="false" visible="true" signed="false" />
  <field name="theme" inDocKind="true" required="false" visible="true" signed="false" />
</fields>
') on conflict do nothing;

insert into DF_NUMERATOR
(ID, VERSION, CREATE_TS, CREATED_BY, UPDATE_TS, UPDATED_BY, DELETE_TS, DELETED_BY, CODE, LOC_NAME, SCRIPT, NUMERATOR_FORMAT, SCRIPT_ENABLED, PERIODICITY, NUMBER_INITIAL_VALUE)
values ('6e4424bb-8f82-446f-86d6-ff6ccb006137', 1, '2023-04-26 21:02:26', 'system', null, null, null, null, 'VehiclePurchaseRequisitionNumerator', '65af577f-dbcb-8caf-adb2-aaaf362e438e', null, 'VPR[number]', false, 'Y', 1) on conflict do nothing;;

insert into SYS_CATEGORY
(DISCRIMINATOR, ID, VERSION, CREATE_TS, CREATED_BY, UPDATE_TS, UPDATED_BY, DELETE_TS, DELETED_BY, NAME, ENTITY_TYPE, IS_DEFAULT, LOCALE_NAMES, SPECIAL)
values (1, 'c6a5ed80-11e3-4500-a380-be484ed2717f', 3, '2023-04-26 21:02:26', 'system', '2023-05-18 19:04:11', 'admin', null, null, 'Заявка на закупку автомобиля', 'testtasktkachev$VehiclePurchaseRequisition', false, null, null) on conflict do nothing;;
insert into DF_DOC_KIND
(CATEGORY_ID, DOC_TYPE_ID, CODE, DESCRIPTION, NUMERATOR_ID, NUMERATOR_TYPE, FIELDS_XML, PREFIX, CATEGORY_ATTRS_PLACE, USE_ALL_PROCS, PORTAL_PUBLISH_ALLOWED, CREATE_ONLY_BY_TEMPLATE, DISABLE_ADD_PROCESS_ACTORS, AVAILABLE_TO_CREATE_ON_MOB_CL, ORGANIZATION_ID, TAB_NAME)
values ('c6a5ed80-11e3-4500-a380-be484ed2717f', '2c66ba9e-f527-408c-94fc-4baa98d5e8bb', null, null, '6e4424bb-8f82-446f-86d6-ff6ccb006137', 1, null, null, 1, false, false, false, false, true, null, 'Доп. поля') on conflict do nothing;;
