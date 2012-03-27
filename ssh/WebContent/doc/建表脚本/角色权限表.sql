--��ɫȨ�ޱ�
CREATE TABLE roleLimit
(
id          NUMBER(10) NOT NULL,
roleid      NUMBER(10) NOT NULL,
menuid      NUMBER(10) NOT NULL,
memo        VARCHAR2(600)
);


ALTER TABLE roleLimit
   ADD CONSTRAINT pk_roleLimit PRIMARY KEY (id);
ALTER TABLE roleLimit
   ADD CONSTRAINT fk_roleLimit_roleid foreign KEY (roleid) references sysRole(id);
ALTER TABLE roleLimit
   ADD CONSTRAINT fk_roleLimit_menuid foreign KEY (menuid) references Sysmenu(id);
   
   
-- Create sequence
create sequence seq_rolelimit_id
minvalue 1
maxvalue 999999999999999999999999999
start with 1
increment by 1
cache 20;

   
COMMENT ON TABLE roleLimit IS
'��ɫ��';
COMMENT ON COLUMN roleLimit.id IS
'id';
COMMENT ON COLUMN roleLimit.roleid IS
'��ɫid';
COMMENT ON COLUMN roleLimit.menuid IS
'�˵�id';
COMMENT ON COLUMN roleLimit.memo IS
'��ע';