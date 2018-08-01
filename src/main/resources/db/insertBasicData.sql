TRUNCATE table ot_field_type;
TRUNCATE table ot_ticket_type;
TRUNCATE table ot_field_type_value;
TRUNCATE table ot_user;
TRUNCATE table ot_ticket_field;

insert into ot_field_type(name) values('文本框');
insert into ot_field_type(name) values('下拉框');
-- insert into ot_field_type(name) values('复选框');
-- insert into ot_field_type(name) values('单选框');

insert into ot_ticket_type(name) values('需求');
insert into ot_ticket_type(name) values('问题');
insert into ot_ticket_type(name) values('bug');

insert into ot_user(name) values('张三');
insert into ot_user(name) values('李四');
insert into ot_user(name) values('王五');


insert into ot_ticket_field(ticket_type_id,field_name,name,required,default_value,select_id) values((select id from ot_ticket_type where name='需求'),'branch','所属分支',1,'云客服',(select id from ot_field_type where name='下拉框'));
insert into ot_field_type_value(field_id,value) values((select id from ot_ticket_field where name='所属分支'),'自运营');
insert into ot_field_type_value(field_id,value) values((select id from ot_ticket_field where name='所属分支'),'云客服');

insert into ot_ticket_field(ticket_type_id,field_name,name,required,default_value,select_id) values((select id from ot_ticket_type where name='需求'),'module','产品模块',1,'电话',(select id from ot_field_type where name='下拉框'));
insert into ot_field_type_value(field_id,value) values((select id from ot_ticket_field where name='产品模块'),'报表');
insert into ot_field_type_value(field_id,value) values((select id from ot_ticket_field where name='产品模块'),'电话');

insert into ot_ticket_field(ticket_type_id,field_name,name,required,default_value,select_id) values((select id from ot_ticket_type where name='需求'),'weight','权重',1,'1',(select id from ot_field_type where name='下拉框'));
insert into ot_field_type_value(field_id,value) values((select id from ot_ticket_field where name='权重'),'1');
insert into ot_field_type_value(field_id,value) values((select id from ot_ticket_field where name='权重'),'2');
insert into ot_field_type_value(field_id,value) values((select id from ot_ticket_field where name='权重'),'3');
insert into ot_field_type_value(field_id,value) values((select id from ot_ticket_field where name='权重'),'4');
insert into ot_field_type_value(field_id,value) values((select id from ot_ticket_field where name='权重'),'5');

insert into ot_ticket_field(ticket_type_id,field_name,name,required,default_value,select_id) values((select id from ot_ticket_type where name='需求'),'customer','客户',0,null,(select id from ot_field_type where name='文本框'));
insert into ot_ticket_field(ticket_type_id,field_name,name,required,default_value,select_id) values((select id from ot_ticket_type where name='需求'),'title','标题',0,null,(select id from ot_field_type where name='文本框'));
insert into ot_ticket_field(ticket_type_id,field_name,name,required,default_value,select_id) values((select id from ot_ticket_type where name='需求'),'zentaoId','禅道编号',0,null,(select id from ot_field_type where name='文本框'));
insert into ot_ticket_field(ticket_type_id,field_name,name,required,default_value,select_id) values((select id from ot_ticket_type where name='需求'),'planOnlineTime','计划上线时间',0,null,(select id from ot_field_type where name='文本框'));
insert into ot_ticket_field(ticket_type_id,field_name,name,required,default_value,select_id) values((select id from ot_ticket_type where name='需求'),'actualOnlineTime','实际上线时间',0,null,(select id from ot_field_type where name='文本框'));
insert into ot_ticket_field(ticket_type_id,field_name,name,required,default_value,select_id) values((select id from ot_ticket_type where name='需求'),'status','状态',0,null,(select id from ot_field_type where name='下拉框'));
insert into ot_field_type_value(field_id,value) values((select id from ot_ticket_field where name='状态'),'开发中');
insert into ot_field_type_value(field_id,value) values((select id from ot_ticket_field where name='状态'),'计划中');
insert into ot_field_type_value(field_id,value) values((select id from ot_ticket_field where name='状态'),'已完成');
insert into ot_ticket(create_time,create_user_id,ticket_type_id) values(SYSDATE(),(select id from ot_user where name='张三'),(select id from ot_ticket_type where name='需求'));
insert into ot_ticket_value(field_id,ticket_id,value) values(1,1,'自运营');
insert into ot_ticket_value(field_id,ticket_id,value) values(2,1,'报表');
insert into ot_ticket_value(field_id,ticket_id,value) values(3,1,'1');
insert into ot_ticket_value(field_id,ticket_id,value) values(4,1,'衣邦人');
insert into ot_ticket_value(field_id,ticket_id,value) values(5,1,'双11数据恢复');
insert into ot_ticket_value(field_id,ticket_id,value) values(6,1,'746');
insert into ot_ticket_value(field_id,ticket_id,value) values(7,1,'2017-01-01');
insert into ot_ticket_value(field_id,ticket_id,value) values(8,1,'2017-03-03');
insert into ot_ticket_value(field_id,ticket_id,value) values(9,1,'开发中');





-- insert into ot_ticket(create_time,create_user_id,ticket_type_id) values(SYSDATE(),2,2);
-- insert into ot_ticket(create_time,create_user_id,ticket_type_id) values(SYSDATE(),3,3);
-- insert into ot_ticket(create_time,create_user_id,ticket_type_id) values(SYSDATE(),1,2);
-- insert into ot_ticket(create_time,create_user_id,ticket_type_id) values(SYSDATE(),2,3);

-- insert into ot_ticket_field(ticket_type_id,field_name,name,required,default_value,select_id) values((select id from ot_ticket_type where name='bug'),'testComboBox','测试复选框',1,'1',(select id from ot_field_type where name='复选框'));
-- insert into ot_field_type_value(fields_id,value) values((select id from ot_ticket_field where name='测试复选框'),'1');
-- insert into ot_field_type_value(fields_id,value) values((select id from ot_ticket_field where name='测试复选框'),'2');
-- insert into ot_field_type_value(fields_id,value) values((select id from ot_ticket_field where name='测试复选框'),'3');
--
-- insert into ot_ticket_field(ticket_type_id,field_name,name,required,default_value,select_id) values((select id from ot_ticket_type where name='bug'),'testRadios','测试单选框',1,'1',(select id from ot_field_type where name='单选框'));
-- insert into ot_field_type_value(fields_id,value) values((select id from ot_ticket_field where name='测试单选框'),'1');
-- insert into ot_field_type_value(fields_id,value) values((select id from ot_ticket_field where name='测试单选框'),'2');
-- insert into ot_field_type_value(fields_id,value) values((select id from ot_ticket_field where name='测试单选框'),'3');
