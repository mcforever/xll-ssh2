--�˵���
CREATE TABLE sysMenu
(
id               NUMBER(10) NOT NULL,
menuName         VARCHAR2(100) NOT NULL,
url              VARCHAR2(200),
menuIndex        NUMBER(10),
parentMenuID     NUMBER(10)
);


ALTER TABLE sysMenu
   ADD CONSTRAINT pk_sysMenu PRIMARY KEY (id);
   
-- Create sequence
create sequence seq_sysmenu_id
minvalue 1
maxvalue 999999999999999999999999999
start with 1
increment by 1
cache 20;
   
COMMENT ON TABLE sysMenu IS
'�˵���';
COMMENT ON COLUMN sysMenu.id IS
'id';
COMMENT ON COLUMN sysMenu.menuName IS
'�˵�����';
COMMENT ON COLUMN sysMenu.url IS
'url';
COMMENT ON COLUMN sysMenu.menuIndex IS
'�˵����';
COMMENT ON COLUMN sysMenu.parentMenuID IS
'�����˵�';

