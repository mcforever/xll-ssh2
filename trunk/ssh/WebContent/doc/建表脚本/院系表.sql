--����Ժϵ��
CREATE TABLE department
(
id         NUMBER(10) NOT NULL,
deptname   VARCHAR2(100) NOT NULL,
memo       VARCHAR2(600)
);


ALTER TABLE department
   ADD CONSTRAINT pk_department PRIMARY KEY (id);

-- Create sequence
create sequence seq_department_id
minvalue 1
maxvalue 999999999999999999999999999
start with 1
increment by 1
cache 20;
   
COMMENT ON TABLE department IS
'Ժϵ��';
COMMENT ON COLUMN department.id IS
'id';
COMMENT ON COLUMN department.deptname IS
'ѧԺ����';
COMMENT ON COLUMN department.memo IS
'��ע';