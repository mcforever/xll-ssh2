--教师表
CREATE TABLE teacher
(
id              NUMBER(10) NOT NULL,
teaname         VARCHAR2(100) NOT NULL,
password        VARCHAR2(100) NOT NULL,
teaposition     NUMBER(10) NOT NULL,
deptid          NUMBER(10) NOT NULL,
memo            VARCHAR2(600)
);


ALTER TABLE teacher
   ADD CONSTRAINT pk_teacher PRIMARY KEY (id);
ALTER TABLE teacher
   ADD CONSTRAINT fk_teacher_deptid foreign KEY (deptid) references department(id);
   
-- Create sequence
create sequence seq_teacher_id
minvalue 1
maxvalue 999999999999999999999999999
start with 1
increment by 1
cache 20;

   
COMMENT ON TABLE teacher IS
'教师表';
COMMENT ON COLUMN teacher.id IS
'id';
COMMENT ON COLUMN teacher.teaname IS
'教师姓名';
COMMENT ON COLUMN teacher.password IS
'密码';
COMMENT ON COLUMN teacher.teaposition IS
'教师职位 0:导员,1:讲师';
COMMENT ON COLUMN teacher.deptid IS
'所属学院';
COMMENT ON COLUMN teacher.memo IS
'备注';