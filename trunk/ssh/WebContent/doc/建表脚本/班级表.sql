--班级表
CREATE TABLE classes
(
id                  NUMBER(10) NOT NULL,
cname               VARCHAR2(100) NOT NULL,
createdate          DATE,
teacherid           number(10),
memo                VARCHAR2(600)
);

ALTER TABLE classes
   ADD CONSTRAINT pk_classes PRIMARY KEY (id);
ALTER TABLE classes
   ADD CONSTRAINT fk_classes_teacherid foreign KEY (teacherid) references teacher(id);
   
-- Create sequence
create sequence seq_classes_id
minvalue 1
maxvalue 999999999999999999999999999
start with 1
increment by 1
cache 20;
   
COMMENT ON TABLE classes IS
'班级表';
COMMENT ON COLUMN classes.id IS
'班级id';
COMMENT ON COLUMN classes.cname IS
'班级名称';
COMMENT ON COLUMN classes.createdate IS
'成立时间';
COMMENT ON COLUMN classes.teacherid IS
'导员ID';
COMMENT ON COLUMN classes.memo IS
'备注';