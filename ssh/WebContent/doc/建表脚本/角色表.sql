--创建角色表
CREATE TABLE sysRole
(
id              NUMBER(10) NOT NULL,
roleName        VARCHAR2(100) NOT NULL,
menus         VARCHAR2(600),
memo            VARCHAR2(600)
);


ALTER TABLE sysRole
   ADD CONSTRAINT pk_sysRole PRIMARY KEY (id);
   
COMMENT ON TABLE sysRole IS
'角色表';
COMMENT ON COLUMN sysRole.id IS
'id';
COMMENT ON COLUMN sysRole.roleName IS
'角色名称 1:学生,2:导员,3:讲师,4:管理员';
COMMENT ON COLUMN sysRole.menus IS
'角色所拥有的菜单id,用","分割';
COMMENT ON COLUMN sysRole.memo IS
'备注';

-- Create sequence
create sequence seq_sysrole_id
minvalue 1
maxvalue 999999999999999999999999999
start with 1
increment by 1
cache 20;
