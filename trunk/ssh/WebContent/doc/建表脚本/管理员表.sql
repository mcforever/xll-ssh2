--创建管理员表
CREATE TABLE admin
(
id                 NUMBER(10) NOT NULL,
adminname          VARCHAR2(100) NOT NULL,
password           VARCHAR2(100),
memo               VARCHAR2(600)
);


ALTER TABLE admin
   ADD CONSTRAINT pk_admin PRIMARY KEY (id);
-- Create sequence
create sequence seq_admin_id
minvalue 1
maxvalue 999999999999999999999999999
start with 1
increment by 1
cache 20;
   
COMMENT ON TABLE admin IS
'管理员表';
COMMENT ON COLUMN admin.id IS
'id';
COMMENT ON COLUMN admin.adminname IS
'管理员名称';
COMMENT ON COLUMN admin.password IS
'管理员密码';
COMMENT ON COLUMN admin.memo IS
'备注';