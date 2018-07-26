TRUNCATE table ot_field_type;
TRUNCATE table ot_ticket_type;
TRUNCATE table ot_field_type_value;
TRUNCATE table ot_user;
TRUNCATE table ot_ticket_fields;

insert into ot_field_type(name) values('文本框');
insert into ot_field_type(name) values('下拉框');
insert into ot_field_type(name) values('复选框');
insert into ot_field_type(name) values('单选框');

insert into ot_ticket_type(name) values('需求');
insert into ot_ticket_type(name) values('问题');
insert into ot_ticket_type(name) values('bug');

insert into ot_user(name) values('张三');
insert into ot_user(name) values('李四');
insert into ot_user(name) values('王五');


insert into ot_ticket_fields(ticket_type_id,name,required,default_value,select_id) values((select id from ot_ticket_type where name='需求'),'所属分支',1,'云客服',(select id from ot_field_type where name='下拉框'));
insert into ot_field_type_value(fields_id,value) values((select id from ot_ticket_fields where name='所属分支'),'自运营');
insert into ot_field_type_value(fields_id,value) values((select id from ot_ticket_fields where name='所属分支'),'云客服');

insert into ot_ticket_fields(ticket_type_id,name,required,default_value,select_id) values((select id from ot_ticket_type where name='问题'),'产品模块',1,'电话',(select id from ot_field_type where name='下拉框'));
insert into ot_field_type_value(fields_id,value) values((select id from ot_ticket_fields where name='产品模块'),'报表');
insert into ot_field_type_value(fields_id,value) values((select id from ot_ticket_fields where name='产品模块'),'电话');

insert into ot_ticket_fields(ticket_type_id,name,required,default_value,select_id) values((select id from ot_ticket_type where name='bug'),'权重',1,'1',(select id from ot_field_type where name='下拉框'));
insert into ot_field_type_value(fields_id,value) values((select id from ot_ticket_fields where name='权重'),'1');
insert into ot_field_type_value(fields_id,value) values((select id from ot_ticket_fields where name='权重'),'2');
insert into ot_field_type_value(fields_id,value) values((select id from ot_ticket_fields where name='权重'),'3');
insert into ot_field_type_value(fields_id,value) values((select id from ot_ticket_fields where name='权重'),'4');
insert into ot_field_type_value(fields_id,value) values((select id from ot_ticket_fields where name='权重'),'5');

insert into ot_ticket(create_time,create_user_id,ticket_type_id) values(SYSDATE(),1,1);
insert into ot_ticket(create_time,create_user_id,ticket_type_id) values(SYSDATE(),2,2);
insert into ot_ticket(create_time,create_user_id,ticket_type_id) values(SYSDATE(),3,3);
insert into ot_ticket(create_time,create_user_id,ticket_type_id) values(SYSDATE(),1,2);
insert into ot_ticket(create_time,create_user_id,ticket_type_id) values(SYSDATE(),2,3);
insert into ot_ticket(create_time,create_user_id,ticket_type_id) values(SYSDATE(),3,1);

