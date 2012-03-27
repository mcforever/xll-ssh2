--成绩表
CREATE TABLE grade
(
id                  NUMBER(10) NOT NULL,
sid                 NUMBER(10) NOT NULL,
cono                NUMBER(10) NOT NULL,
midScore            number(5,2),
finalScore          number(5,2),
memo                VARCHAR2(600)
);


ALTER TABLE grade
   ADD CONSTRAINT pk_grade PRIMARY KEY (id);
ALTER TABLE grade
   ADD CONSTRAINT fk_grade_sid foreign KEY (sid) references student(id);
ALTER TABLE grade
   ADD CONSTRAINT fk_grade_cono foreign KEY (cono) references course(id);
   

-- Create sequence
create sequence seq_grade_id
minvalue 1
maxvalue 999999999999999999999999999
start with 1
increment by 1
cache 20;
   
COMMENT ON TABLE grade IS
'成绩表';
COMMENT ON COLUMN grade.id IS
'id';
COMMENT ON COLUMN grade.sid IS
'学号';
COMMENT ON COLUMN grade.cono IS
'课程ID';
COMMENT ON COLUMN grade.midScore IS
'期中成绩';
COMMENT ON COLUMN grade.finalScore IS
'期末成绩';
COMMENT ON COLUMN grade.memo IS
'备注';