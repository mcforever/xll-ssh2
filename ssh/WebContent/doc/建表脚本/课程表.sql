--课程表
CREATE TABLE course
(
id           NUMBER(10) NOT NULL,
couname      VARCHAR2(100) NOT NULL,
teacherid    NUMBER(10),
coutime      NUMBER(10),
credit       NUMBER(5,2),
memo         VARCHAR2(600)
);


ALTER TABLE course
   ADD CONSTRAINT pk_course PRIMARY KEY (id);
ALTER TABLE course
   ADD CONSTRAINT fk_course_teacherid foreign KEY (teacherid) references teacher(id);
   
-- Create sequence
create sequence seq_course_id
minvalue 1
maxvalue 999999999999999999999999999
start with 1
increment by 1
cache 20;
   
COMMENT ON TABLE course IS
'课程表';
COMMENT ON COLUMN course.id IS
'id';
COMMENT ON COLUMN course.couname IS
'课程名称';
COMMENT ON COLUMN course.teacherid IS
'任课教师ID';
COMMENT ON COLUMN course.coutime IS
'课程时间 学年，学期';
COMMENT ON COLUMN course.credit IS
'学分';
COMMENT ON COLUMN course.memo IS
'备注';