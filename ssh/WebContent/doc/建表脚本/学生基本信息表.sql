--ѧ��������Ϣ��
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
'ѧ��������Ϣ��';
COMMENT ON COLUMN student.id IS
'id';
COMMENT ON COLUMN student.sname IS
'ѧ������';
COMMENT ON COLUMN student.password IS
'����';
COMMENT ON COLUMN student.sex IS
'�Ա� 0:��,1:Ů';
COMMENT ON COLUMN student.birthday IS
'��������';
COMMENT ON COLUMN student.orientation IS
'������ò 1:��Ա,2:��Ա,3:����';
COMMENT ON COLUMN student.enrollDate IS
'��ѧʱ��';
COMMENT ON COLUMN student.telephone IS
'��ϵ��ʽ';
COMMENT ON COLUMN student.schooling IS
'ѧ��';
COMMENT ON COLUMN student.studyState IS
'ѧϰ״̬ 0:�ڶ�,1:��ѧ';
COMMENT ON COLUMN student.classid IS
'���ڰ༶';
COMMENT ON COLUMN student.deptid IS
'����Ժϵ';
COMMENT ON COLUMN student.memo IS
'��ע';