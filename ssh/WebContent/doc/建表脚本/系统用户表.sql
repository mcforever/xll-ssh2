--系统用户表
CREATE TABLE sysUser
(
ID NUMBER(10) NOT NULL,
userName VARCHAR2(100) NOT NULL,
userLevel NUMBER(10) NOT NULL,
password VARCHAR2(200),
memo VARCHAR2(600)
);


ALTER TABLE sysUser
   ADD CONSTRAINT pk_sysUser PRIMARY KEY (id);
   
-- Create sequence
create sequence seq_sysuser_id
minvalue 2012000000
maxvalue 999999999999999999999999999
start with 2012000000
increment by 1
cache 20;
   
COMMENT ON TABLE sysUser IS
'系统用户表';
COMMENT ON COLUMN sysUser.id IS
'用户ID';
COMMENT ON COLUMN sysUser.userName IS
'用户名称';
COMMENT ON COLUMN sysUser.userLevel IS
'用户级别 0:学生,1:老师';
COMMENT ON COLUMN sysUser.password IS
'登录密码';
COMMENT ON COLUMN sysUser.memo IS
'备注';

insert into sysuser(id,username,userlevel,password) values(seq_sysuser_id.nextval,'laiyang',0,'laiyang');
insert into sysuser(id,username,userlevel,password) values(seq_sysuser_id.nextval,'gyhou',0,'gyhou');
insert into sysuser(id,username,userlevel,password) values(seq_sysuser_id.nextval,'lfzhang',1,'lfzhang');