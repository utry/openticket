/*==============================================================*/
/* Table: ot_select_value                                       */
/*==============================================================*/
create table ot_field_type_value
(
   id                   int not null comment '状态编号' AUTO_INCREMENT,
   fields_id            int  not null comment '对象编号',
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
   user_id       			int comment '用户编号',
   status               	int  not null comment '状态编号',
   title          			varchar(255)  not null comment '工单标题',
   description  			text comment '工单描述',
   primary key (id)
);

/*==============================================================*/
/* Table: ot_ticket_fields                                      */
/*==============================================================*/
create table ot_ticket_fields
(
   id                   int not null comment '对象编号' AUTO_INCREMENT,
   name                 varchar(255) not null comment '对象名称',
   required             tinyint not null comment '是否必填' default '0', /* 默认为否 */
   default_value        varchar(255) comment '默认值',
   select_id          	int not null comment '选择类型',
   primary key (id)
);
/*==============================================================*/
/* Table: ot_field_type                                      */
/*==============================================================*/
create table ot_field_type
(
   id                   int not null comment '选择类型编号' AUTO_INCREMENT,
   name                 varchar(255) not null comment '选择类型名称',
   primary key (id)
);

/*==============================================================*/
/* Table: ot_ticket_status                                      */
/*==============================================================*/
create table ot_ticket_status
(
   id                   int not null comment '状态编号' AUTO_INCREMENT,
   name                 varchar(255) not null comment '状态名称',
   primary key (id)
);

/*==============================================================*/
/* Table: ot_ticket_value                                       */
/*==============================================================*/
create table ot_ticket_value
(
   id                   int not null comment '数据编号' AUTO_INCREMENT,
   fields_id            int not null comment '对象编号',
   ticket_id            int not null comment '工单编号',
   value                varchar(255) comment '值',
   primary key (id)
);

/*==============================================================*/
/* Table: to_attachments                                        */
/*==============================================================*/
create table ot_attachments
(
   id       int not null comment '附件编号' AUTO_INCREMENT,
   ticket_id            int not null comment '工单编号',
   file_name            varchar(255) not null comment '文件名称',
   file_size            int not null comment '文件大小',
   content_type         varchar(255) not null comment '文件类型',
   path                 varchar(255) not null comment '保存路径',
   primary key (id)
);
