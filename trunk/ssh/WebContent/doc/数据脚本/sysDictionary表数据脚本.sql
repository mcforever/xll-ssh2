--sysDictionary表数据脚本
select * from sysdictionary t;

insert into sysdictionary (id,datatypecode,datatypedescription,dataid,datadescription)
values
(seq_sysdictionary_id.nextval,'teaPosition','教师职位',0,'导员');
insert into sysdictionary (id,datatypecode,datatypedescription,dataid,datadescription)
values
(seq_sysdictionary_id.nextval,'teaPosition','教师职位',1,'讲师');


insert into sysdictionary (id,datatypecode,datatypedescription,dataid,datadescription)
values
(seq_sysdictionary_id.nextval,'orientation','政治面貌',1,'团员');
insert into sysdictionary (id,datatypecode,datatypedescription,dataid,datadescription)
values
(seq_sysdictionary_id.nextval,'orientation','政治面貌',2,'党员');
insert into sysdictionary (id,datatypecode,datatypedescription,dataid,datadescription)
values
(seq_sysdictionary_id.nextval,'orientation','政治面貌',3,'其他');


insert into sysdictionary (id,datatypecode,datatypedescription,dataid,datadescription)
values
(seq_sysdictionary_id.nextval,'studyState','学习状态',0,'在读');
insert into sysdictionary (id,datatypecode,datatypedescription,dataid,datadescription)
values
(seq_sysdictionary_id.nextval,'studyState','学习状态',1,'休学');


insert into sysdictionary (id,datatypecode,datatypedescription,dataid,datadescription)
values
(seq_sysdictionary_id.nextval,'coutime','课程时间',1,'大一第一学期');
insert into sysdictionary (id,datatypecode,datatypedescription,dataid,datadescription)
values
(seq_sysdictionary_id.nextval,'coutime','课程时间',2,'大一第二学期');
insert into sysdictionary (id,datatypecode,datatypedescription,dataid,datadescription)
values
(seq_sysdictionary_id.nextval,'coutime','课程时间',3,'大二第一学期');
insert into sysdictionary (id,datatypecode,datatypedescription,dataid,datadescription)
values
(seq_sysdictionary_id.nextval,'coutime','课程时间',4,'大二第二学期');
insert into sysdictionary (id,datatypecode,datatypedescription,dataid,datadescription)
values
(seq_sysdictionary_id.nextval,'coutime','课程时间',5,'大三第一学期');
insert into sysdictionary (id,datatypecode,datatypedescription,dataid,datadescription)
values
(seq_sysdictionary_id.nextval,'coutime','课程时间',6,'大三第二学期');
insert into sysdictionary (id,datatypecode,datatypedescription,dataid,datadescription)
values
(seq_sysdictionary_id.nextval,'coutime','课程时间',7,'大四第一学期');
insert into sysdictionary (id,datatypecode,datatypedescription,dataid,datadescription)
values
(seq_sysdictionary_id.nextval,'coutime','课程时间',8,'大四第二学期');


insert into sysdictionary (id,datatypecode,datatypedescription,dataid,datadescription)
values
(seq_sysdictionary_id.nextval,'sex','性别',0,'男');
insert into sysdictionary (id,datatypecode,datatypedescription,dataid,datadescription)
values
(seq_sysdictionary_id.nextval,'sex','性别',1,'女');

