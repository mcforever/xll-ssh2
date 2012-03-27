--sysmenu表添加数据脚本
select * from sysmenu t;

insert into sysmenu (id,menuname,url,menuindex,parentmenuid)
values
(seq_sysmenu_id.nextval,'学生管理','',1,0);
insert into sysmenu (id,menuname,url,menuindex,parentmenuid)
values
(seq_sysmenu_id.nextval,'教师管理','',2,0);
insert into sysmenu (id,menuname,url,menuindex,parentmenuid)
values
(seq_sysmenu_id.nextval,'班级管理','',3,0);
insert into sysmenu (id,menuname,url,menuindex,parentmenuid)
values
(seq_sysmenu_id.nextval,'课程管理','',4,0);
insert into sysmenu (id,menuname,url,menuindex,parentmenuid)
values
(seq_sysmenu_id.nextval,'系统管理','',5,0);
insert into sysmenu (id,menuname,url,menuindex,parentmenuid)
values
(seq_sysmenu_id.nextval,'成绩管理','',6,0);

insert into sysmenu (id,menuname,url,menuindex,parentmenuid)
values
(seq_sysmenu_id.nextval,'查询学生信息','queryStudentPageAction.html',1,(select t.id from sysmenu t where t.menuname = '学生管理'));

insert into sysmenu (id,menuname,url,menuindex,parentmenuid)
values
(seq_sysmenu_id.nextval,'查询教师信息','queryTeacherPageAction.html',1,(select t.id from sysmenu t where t.menuname = '教师管理'));

insert into sysmenu (id,menuname,url,menuindex,parentmenuid)
values
(seq_sysmenu_id.nextval,'查询班级信息','queryClassesPageAction.html',1,(select t.id from sysmenu t where t.menuname = '班级管理'));

insert into sysmenu (id,menuname,url,menuindex,parentmenuid)
values
(seq_sysmenu_id.nextval,'班级成绩比较','compareClassesPageAction.html',2,(select t.id from sysmenu t where t.menuname = '班级管理'));

insert into sysmenu (id,menuname,url,menuindex,parentmenuid)
values
(seq_sysmenu_id.nextval,'查询课程信息','queryCoursePageAction.html',1,(select t.id from sysmenu t where t.menuname = '课程管理'));
insert into sysmenu (id,menuname,url,menuindex,parentmenuid)
values
(seq_sysmenu_id.nextval,'学生成绩信息','queryGradePageAction.html',1,(select t.id from sysmenu t where t.menuname = '成绩管理'));

