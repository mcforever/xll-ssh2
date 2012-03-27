--course表数据脚本
select * from course t;

insert into course (id,couname,teacherid,coutime,credit)
values
(seq_course_id.nextval,'高等数学',41,8,4);
insert into course (id,couname,teacherid,coutime,credit)
values
(seq_course_id.nextval,'线性代数',42,9,3);
insert into course (id,couname,teacherid,coutime,credit)
values
(seq_course_id.nextval,'大学英语1',43,8,4);
insert into course (id,couname,teacherid,coutime,credit)
values
(seq_course_id.nextval,'大学英语2',43,9,4);
insert into course (id,couname,teacherid,coutime,credit)
values
(seq_course_id.nextval,'大学英语3',43,10,4);
insert into course (id,couname,teacherid,coutime,credit)
values
(seq_course_id.nextval,'大学英语4',43,11,4);
insert into course (id,couname,teacherid,coutime,credit)
values
(seq_course_id.nextval,'JAVA程序基础',44,12,6);
insert into course (id,couname,teacherid,coutime,credit)
values
(seq_course_id.nextval,'JAVA程序高级开发',44,13,6);

