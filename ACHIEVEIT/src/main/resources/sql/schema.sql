create database achieveit;

use achieveit;

create table user(
   id bigint NOT NULL AUTO_INCREMENT COMMENT '用户id',
   user_name varchar(120) NOT NULL  DEFAULT '' COMMENT '用户名',
   password varchar(120) NOT NULL  DEFAULT '' COMMENT '密码',
   roles varchar(120) NOT NULL  DEFAULT '' COMMENT '用户角色',
   create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
   change_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更改时间',
   PRIMARY KEY (id),
   UNIQUE INDEX username_index(user_name)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='用户信息表';

create table role(
   id bigint NOT NULL AUTO_INCREMENT COMMENT '角色id',
   role_name varchar(120) NOT NULL  DEFAULT '' COMMENT '角色名',
   description varchar(300) NOT NULL DEFAULT '' COMMENT '角色描述',
   create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
   change_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更改时间',
   PRIMARY KEY (id),
   UNIQUE INDEX role_name_index(role_name)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='角色信息表';

create table permission(
   id bigint NOT NULL AUTO_INCREMENT COMMENT '权限id',
   role_name varchar(120) NOT NULL  DEFAULT '' COMMENT '关联角色名',
   permission_name varchar(120) NOT NULL  DEFAULT '' COMMENT '权限名',
   description varchar(300) NOT NULL DEFAULT '' COMMENT '权限描述',
   create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
   change_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更改时间',
   PRIMARY KEY (id)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='角色信息表';

create table projectInfo(
   id bigint NOT NULL AUTO_INCREMENT COMMENT '项目id',
   creater_id bigint NOT NULL DEFAULT '0' COMMENT '项目创建者id',
   project_name varchar(100) NOT NULL  DEFAULT '' COMMENT '项目名称',
   customer_info varchar(300) NOT NULL  DEFAULT '' COMMENT '客户信息',
   leader varchar(100) NOT NULL  DEFAULT '' COMMENT '项目上级',
   milepost varchar(300) NOT NULL  DEFAULT '' COMMENT '主要里程碑',
   project_function varchar(300) NOT NULL  DEFAULT '' COMMENT '主要功能',
   technology varchar(300) NOT NULL  DEFAULT '' COMMENT '采用技术',
   business_area varchar(300) NOT NULL  DEFAULT '' COMMENT '业务领域',
   schedule_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '预定时间',
   delivery_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '交付时间',
   status int NOT NULL DEFAULT '0' COMMENT '项目状态',
   create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
   change_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更改时间',
   PRIMARY KEY (id),
   INDEX project_name_index(project_name)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='项目信息表';


create table projectFunc(
   id bigint NOT NULL AUTO_INCREMENT COMMENT '功能id',
   project_id bigint NOT NULL DEFAULT '0' COMMENT '项目id',
   function_name varchar(150) NOT NULL DEFAULT '' COMMENT '功能名称',
   person_charge varchar(100) NOT NULL  DEFAULT '' COMMENT '负责人',
   create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
   change_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更改时间',
   PRIMARY KEY (id),
   foreign key (project_id) references projectInfo(id) on delete cascade on update cascade
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='项目功能表';

create table projectSubFunc(
   id bigint NOT NULL AUTO_INCREMENT COMMENT '子功能id',
   func_id bigint NOT NULL DEFAULT '0' COMMENT '关联功能id',
   function_name varchar(150) NOT NULL DEFAULT '' COMMENT '子功能名称',
   person_charge varchar(100) NOT NULL  DEFAULT '' COMMENT '负责人',
   create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
   change_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更改时间',
   PRIMARY KEY (id),
   foreign key (func_id) references projectFunc(id) on delete cascade on update cascade
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='项目子功能表';


#插入项目功能信息
insert into projectFunc(project_id,function_name,person_charge) values
(1,'项目信息','fjm'),
(1,'工时管理','fjm');

#插入项目子功能信息
insert into projectSubFunc(func_id,function_name,person_charge) values
(1,'项目查询','fjm'),
(1,'项目修改','br'),
(1,'项目删除','lxy'),
(2,'工时查询','fjm'),
(2,'工时审核','br');


#插入项目信息
insert into projectInfo(creater_id,project_name,customer_info,leader,milepost,project_function,technology,business_area,status) values
(1,'项目1','老师1','老板1','里程碑1','项目管理1','java1','互联网1',1),
(1,'项目2','老师2','老板2','里程碑2','项目管理2','java2','互联网2',1),
(1,'项目3','老师3','老板3','里程碑3','项目管理3','java3','互联网3',0),
(1,'项目2','老师4','老板2','里程碑4','项目管理4','java4','互联网4',0),
(1,'项目5','老师5','老板2','里程碑5','项目管理5','java5','互联网5',1),
(1,'项目6','老师3','老板6','里程碑6','项目管理6','java6','互联网6',1),
(1,'项目7','老师7','老板7','里程碑7','项目管理7','java1','互联网6',0);



#插入用户信息
insert into user(user_name,password,roles) values ('fjm','123','PM');
insert into user(user_name,password,roles) values ('br','123','');

#插入角色信息
insert into role(role_name,description) values('PS','项目上级');
insert into role(role_name,description) values('CMO','组织级配置管理员');
insert into role(role_name,description) values('EPG','项目改进小组');
insert into role(role_name,description) values('QA','质量监控');
insert into role(role_name,description) values('PM','项目经理');
insert into role(role_name,description) values('AM','项目资产管理员');
insert into role(role_name,description) values('TM','项目成员');

#插入权限信息
insert into permission(role_name,permission_name,description) values ('PS','','');
insert into permission(role_name,permission_name,description) values ('CMO','','');
insert into permission(role_name,permission_name,description) values ('CMO','','');
insert into permission(role_name,permission_name,description) values ('EPG','','');
insert into permission(role_name,permission_name,description) values ('QA','','');
insert into permission(role_name,permission_name,description) values ('PM','personManage','项目组员管理，可添加或者修改');
insert into permission(role_name,permission_name,description) values ('PM','','');
insert into permission(role_name,permission_name,description) values ('PM','','');
insert into permission(role_name,permission_name,description) values ('PM','','');
insert into permission(role_name,permission_name,description) values ('PM','','');
insert into permission(role_name,permission_name,description) values ('PM','','');
insert into permission(role_name,permission_name,description) values ('PM','','');
insert into permission(role_name,permission_name,description) values ('PM','','');
insert into permission(role_name,permission_name,description) values ('AM','','');
insert into permission(role_name,permission_name,description) values ('TM','','');
insert into permission(role_name,permission_name,description) values ('TM','','');
insert into permission(role_name,permission_name,description) values ('TM','','');
insert into permission(role_name,permission_name,description) values ('TM','','');
insert into permission(role_name,permission_name,description) values ('TM','','');
insert into permission(role_name,permission_name,description) values ('TM','','');