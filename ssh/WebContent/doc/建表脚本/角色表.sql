--������ɫ��
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
'��ɫ��';
COMMENT ON COLUMN sysRole.id IS
'id';
COMMENT ON COLUMN sysRole.roleName IS
'��ɫ���� 1:ѧ��,2:��Ա,3:��ʦ,4:����Ա';
COMMENT ON COLUMN sysRole.menus IS
'��ɫ��ӵ�еĲ˵�id,��","�ָ�';
COMMENT ON COLUMN sysRole.memo IS
'��ע';

-- Create sequence
create sequence seq_sysrole_id
minvalue 1
maxvalue 999999999999999999999999999
start with 1
increment by 1
cache 20;
