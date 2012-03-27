--ѧ�����ųɼ�
select (g.midscore * 0.5 + g.finalscore * 0.5) * c.credit stusimplescore
from grade g
left join course c on c.id = g.cono;

--ѧ���ܳɼ�
select sum((g.midscore * 0.5 + g.finalscore * 0.5) * c.credit) stuallscore
from grade g
left join course c on c.id = g.cono
group by g.sid;

--ѧ������ѧ��֮��
select sum(c.credit) stuallcredit
from grade g
left join course c on c.id = g.cono
group by g.sid; 

--ѧ��ƽ���ɼ�
select studentid, stuallscore , stuallcredit , stuallscore / stuallcredit as stuavgscore from
(select g.sid as studentid, sum((g.midscore * 0.5 + g.finalscore * 0.5) * c.credit) as stuallscore , sum(c.credit) as stuallcredit , 
sum((g.midscore * 0.5 + g.finalscore * 0.5) * c.credit) / sum(c.credit)
from grade g
left join course c on c.id = g.cono
where g.sid = 4
group by g.sid );
where (stuallscore / stuallcredit) > 75;

--�༶�ɼ�
select * from
classes cla
left join student stu on stu.classid = cla.id;


--����һ���α�
create or replace package sshpackage as
type ssh_cursor is ref cursor;
end;

--��ѧ��ƽ���ɼ��Ĺ���
create or replace procedure pro_stuavgscore(stuid in number , stuavgscore out number , stuallscore out number , stuallcredit out number)
is
begin
select stuallscore/stuallcredit as stuavgscore , stuallscore , stuallcredit from
       (select sum((g.midscore * 0.5 + g.finalscore * 0.5) * c.credit) as stuallscore , sum(c.credit) as stuallcredit , 
       sum((g.midscore * 0.5 + g.finalscore * 0.5) * c.credit) /sum(c.credit)
       from grade g
       left join course c on c.id = g.cono
       where g.sid = stuid);
end;

--��ѧ��ƽ���ɼ��Ĺ���
create or replace procedure pro_stuavgscore(stuid in number ,stu_cursor out sshpackage.ssh_cursor)
is
begin
open stu_cursor for select stuallscore/stuallcredit as stuavgscore , stuallscore , stuallcredit from
       (select sum((g.midscore * 0.5 + g.finalscore * 0.5) * c.credit) as stuallscore , sum(c.credit) as stuallcredit , 
       sum((g.midscore * 0.5 + g.finalscore * 0.5) * c.credit) /sum(c.credit)
       from grade g
       left join course c on c.id = g.cono
       where g.sid = stuid);
end;





