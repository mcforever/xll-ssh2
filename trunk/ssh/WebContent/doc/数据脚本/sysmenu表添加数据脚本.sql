--sysmenu��������ݽű�
select * from sysmenu t;

insert into sysmenu (id,menuname,url,menuindex,parentmenuid)
values
(seq_sysmenu_id.nextval,'ѧ������','',1,0);
insert into sysmenu (id,menuname,url,menuindex,parentmenuid)
values
(seq_sysmenu_id.nextval,'��ʦ����','',2,0);
insert into sysmenu (id,menuname,url,menuindex,parentmenuid)
values
(seq_sysmenu_id.nextval,'�༶����','',3,0);
insert into sysmenu (id,menuname,url,menuindex,parentmenuid)
values
(seq_sysmenu_id.nextval,'�γ̹���','',4,0);
insert into sysmenu (id,menuname,url,menuindex,parentmenuid)
values
(seq_sysmenu_id.nextval,'ϵͳ����','',5,0);
insert into sysmenu (id,menuname,url,menuindex,parentmenuid)
values
(seq_sysmenu_id.nextval,'�ɼ�����','',6,0);

insert into sysmenu (id,menuname,url,menuindex,parentmenuid)
values
(seq_sysmenu_id.nextval,'��ѯѧ����Ϣ','queryStudentPageAction.html',1,(select t.id from sysmenu t where t.menuname = 'ѧ������'));

insert into sysmenu (id,menuname,url,menuindex,parentmenuid)
values
(seq_sysmenu_id.nextval,'��ѯ��ʦ��Ϣ','queryTeacherPageAction.html',1,(select t.id from sysmenu t where t.menuname = '��ʦ����'));

insert into sysmenu (id,menuname,url,menuindex,parentmenuid)
values
(seq_sysmenu_id.nextval,'��ѯ�༶��Ϣ','queryClassesPageAction.html',1,(select t.id from sysmenu t where t.menuname = '�༶����'));

insert into sysmenu (id,menuname,url,menuindex,parentmenuid)
values
(seq_sysmenu_id.nextval,'�༶�ɼ��Ƚ�','compareClassesPageAction.html',2,(select t.id from sysmenu t where t.menuname = '�༶����'));

insert into sysmenu (id,menuname,url,menuindex,parentmenuid)
values
(seq_sysmenu_id.nextval,'��ѯ�γ���Ϣ','queryCoursePageAction.html',1,(select t.id from sysmenu t where t.menuname = '�γ̹���'));
insert into sysmenu (id,menuname,url,menuindex,parentmenuid)
values
(seq_sysmenu_id.nextval,'ѧ���ɼ���Ϣ','queryGradePageAction.html',1,(select t.id from sysmenu t where t.menuname = '�ɼ�����'));

