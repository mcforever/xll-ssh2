--sysrole数据脚本
select * from sysrole t;


insert into sysrole (id,rolename,menus,memo)
values 
(seq_sysrole_id.nextval,'学生','1,21,22,23,24,25','没什么权利');
insert into sysrole (id,rolename,menus,memo)
values 
(seq_sysrole_id.nextval,'导员','1,21,22,23,24,25','管理学生');
insert into sysrole (id,rolename,menus,memo)
values 
(seq_sysrole_id.nextval,'讲师','1,21,22,23,24,25','授课，录入成绩');
insert into sysrole (id,rolename,menus,memo)
values 
(seq_sysrole_id.nextval,'管理员','1,21,22,23,24,25','权利最大');

