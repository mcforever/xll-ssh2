--学生基本信息表
CREATE TABLE student
(
id             NUMBER(10) NOT NULL,
sname          VARCHAR2(100) NOT NULL,
password       VARCHAR2(100) NOT NULL,
sex            NUMBER(10) NOT NULL,
birthday       DATE NOT NULL,
orientation    VARCHAR2(200) NOT NULL,
enrollDate     DATE NOT NULL,
telephone      VARCHAR2(100) NOT NULL,
schooling      NUMBER NOT NULL,
studyState     NUMBER NOT NULL,
classid        NUMBER(10) NOT NULL,
deptid         NUMBER(10) NOT NULL,
memo           VARCHAR2(600)
);

ALTER TABLE student
   ADD CONSTRAINT pk_student PRIMARY KEY (id);
ALTER TABLE student
   ADD CONSTRAINT fk_student_deptid foreign KEY (deptid) references department(id);
ALTER TABLE student
   ADD CONSTRAINT fk_student_classid foreign KEY (classid) references classes(id);
   
-- Create sequence
create sequence seq_student_id
minvalue 1
maxvalue 999999999999999999999999999
start with 1
increment by 1
cache 20;
   
COMMENT ON TABLE student IS
'学生基本信息表';
COMMENT ON COLUMN student.id IS
'id';
COMMENT ON COLUMN student.sname IS
'学生姓名';
COMMENT ON COLUMN student.password IS
'密码';
COMMENT ON COLUMN student.sex IS
'性别 0:男,1:女';
COMMENT ON COLUMN student.birthday IS
'出生日期';
COMMENT ON COLUMN student.orientation IS
'政治面貌 1:团员,2:党员,3:其他';
COMMENT ON COLUMN student.enrollDate IS
'入学时间';
COMMENT ON COLUMN student.telephone IS
'联系方式';
COMMENT ON COLUMN student.schooling IS
'学制';
COMMENT ON COLUMN student.studyState IS
'学习状态 0:在读,1:休学';
COMMENT ON COLUMN student.classid IS
'所在班级';
COMMENT ON COLUMN student.deptid IS
'所在院系';
COMMENT ON COLUMN student.memo IS
'备注';