--�ֵ��
CREATE TABLE sysDictionary
(
id                      NUMBER(10) NOT NULL,
dataTypeCode            VARCHAR2(100) NOT NULL,
dataTypeDescription     VARCHAR2(200) NOT NULL,
dataID                  NUMBER(10) NOT NULL,
dataDescription         VARCHAR2(200) NOT NULL
);


ALTER TABLE sysDictionary
   ADD CONSTRAINT pk_sysDictionary PRIMARY KEY (id);
   
-- Create sequence
create sequence seq_sysdictionary_id
minvalue 1
maxvalue 999999999999999999999999999
start with 1
increment by 1
cache 20;
   
COMMENT ON TABLE sysDictionary IS
'�ֵ��';
COMMENT ON COLUMN sysDictionary.id IS
'id';
COMMENT ON COLUMN sysDictionary.dataTypeCode IS
'�ֶ�code';
COMMENT ON COLUMN sysDictionary.dataTypeDescription IS
'�ֶ�name';
COMMENT ON COLUMN sysDictionary.dataID IS
'ֵ';
COMMENT ON COLUMN sysDictionary.dataDescription IS
'ֵname';