--departmet表数据脚本
select * from department t;
insert into department (id,deptname,memo)
values
(seq_department_id.nextval,'软件学院','咱自己的学院，一定要放在第一个');
insert into department (id,deptname,memo)
values
(seq_department_id.nextval,'数信学院','1');
insert into department (id,deptname,memo)
values
(seq_department_id.nextval,'外语学院','2');
insert into department (id,deptname,memo)
values
(seq_department_id.nextval,'物理学院','3');
insert into department (id,deptname,memo)
values
(seq_department_id.nextval,'体育学院','4');
insert into department (id,deptname,memo)
values
(seq_department_id.nextval,'音乐学院','5');
insert into department (id,deptname,memo)
values
(seq_department_id.nextval,'化学学院','6');
