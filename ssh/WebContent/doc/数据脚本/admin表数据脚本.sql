--admin表数据脚本
select * from admin t;

insert into admin (id,adminname,password,memo)
values
(seq_admin_id.nextval,'admin','0','admin是管理员');
