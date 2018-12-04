-- drop table ot_field_type_value;
-- drop table ot_ticket;
-- drop table ot_user;
-- drop table ot_ticket_field;
-- drop table ot_ticket_type;
-- drop table ot_field_type;
-- drop table ot_ticket_value;
-- drop table ot_attachment;


/*==============================================================*/
/* Table: ot_select_value                                       */
/*==============================================================*/
create table ot_field_type_value
(
   id                   int not null comment '选择值编号' AUTO_INCREMENT,
   field_id            int  not null comment '对象编号',
   value                varchar(255)  not null comment '值',
   primary key (id)
);

/*==============================================================*/
/* Table: ot_ticket                                             */
/*==============================================================*/
create table ot_ticket
(
   id            			int not null comment '工单编号' AUTO_INCREMENT,
   create_time          	datetime  not null comment '创建时间',
   create_user_id			int not null comment '创建用户编号',
   ticket_type_id   		int not null comment '工单类型编号',
   primary key (id)
);

/*==============================================================*/
/* Table: ot_user                                               */
/*==============================================================*/
create table ot_user
(
   id            			int not null comment '用户编号' AUTO_INCREMENT,
   name						varchar(255) not null comment '姓名',
   primary key (id)
);

/*==============================================================*/
/* Table: ot_ticket_field                                       */
/*==============================================================*/
create table ot_ticket_field
(
   id                   int not null comment '对象编号' AUTO_INCREMENT,
   ticket_type_id		    int not null comment '工单类型编号',
   field_name           varchar (255) not null comment '对象字段名',
   name                 varchar(255) not null comment '对象名称',
   required             tinyint not null comment '是否必填' default '0', /* 默认为否 */
   default_value        varchar(255) comment '默认值',
   select_id          	int not null comment '选择类型',
   CONSTRAINT ticketTypeId_name UNIQUE (ticket_type_id,name),
   CONSTRAINT ticketTypeId_fieldName UNIQUE (ticket_type_id,field_name),
   primary key (id)
);

/*==============================================================*/
/* Table: ot_ticket_type                                        */
/*==============================================================*/
create table ot_ticket_type
(
   id                   int not null comment '工单类型编号' AUTO_INCREMENT,
   name                 varchar(255) not null unique comment '工单类型名称',
   primary key (id)
);

/*==============================================================*/
/* Table: ot_field_type                                         */
/*==============================================================*/
create table ot_field_type
(
   id                   int not null comment '选择类型编号' AUTO_INCREMENT,
   name                 varchar(255) not null comment '选择类型名称',
   primary key (id)
);

/*==============================================================*/
/* Table: ot_ticket_value                                       */
/*==============================================================*/
create table ot_ticket_value
(
   id                   int not null comment '数据编号' AUTO_INCREMENT,
   field_id            int not null comment '对象编号',
   ticket_id            int not null comment '工单编号',
   value                varchar(255) comment '值',
   primary key (id)
);

/*==============================================================*/
/* Table: to_attachment                                         */
/*==============================================================*/
create table ot_attachment
(
   id       int not null comment '附件编号' AUTO_INCREMENT,
   ticket_id            int not null comment '工单编号',
   file_name            varchar(255) not null comment '文件名称',
   file_size            int not null comment '文件大小',
   content_type         varchar(255) not null comment '文件类型',
   path                 varchar(255) not null comment '保存路径',
   primary key (id)
);
